import java.util.*;

public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI(new Scanner(System.in));
        UserDataStore store = new UserDataStore("userdata.json");
        UserData user = store.loadOrCreate(ui);

        TvMazeClient api = new TvMazeClient();

        while (true) {
            ui.line();
            ui.println("Usuário: " + user.getUsername());
            ui.println("== Menu ==");
            ui.println("1) Buscar séries por nome");
            ui.println("2) Minhas listas");
            ui.println("3) Trocar nome/apelido do usuário");
            ui.println("0) Sair");
            int op = ui.askInt("Opção: ");

            try {
                switch (op) {
                    case 1 -> buscarSeries(ui, api, user, store);
                    case 2 -> gerenciarListas(ui, api, user, store);
                    case 3 -> {
                        String novo = ui.askLine("Novo nome/apelido: ");
                        user.setUsername(novo.trim().isEmpty() ? "Usuário" : novo.trim());
                        store.save(user);
                        ui.println("Atualizado.");
                    }
                    case 0 -> {
                        ui.println("Até mais!");
                        return;
                    }
                    default -> ui.println("Opção inválida.");
                }
            } catch (Exception e) {
                ui.error("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    private static void buscarSeries(ConsoleUI ui, TvMazeClient api, UserData user, UserDataStore store) {
        String termo = ui.askLine("Digite o nome da série: ").trim();
        if (termo.isEmpty()) {
            ui.println("Termo vazio.");
            return;
        }
        var resultados = api.searchShows(termo);
        if (resultados.isEmpty()) {
            ui.println("Nenhum resultado.");
            return;
        }
        ui.println("Resultados:");
        for (int i = 0; i < resultados.size(); i++) {
            var s = resultados.get(i);
            ui.println((i + 1) + ") " + s.basicLine());
        }
        int idx = ui.askInt("Escolha (0 para cancelar): ");
        if (idx <= 0 || idx > resultados.size()) return;

        ShowInfo escolhido = resultados.get(idx - 1);
        // atualiza detalhe por ID (garante campos completos)
        var detalhe = api.getShowById(escolhido.id());
        if (detalhe != null) escolhido = detalhe;

        ui.line();
        ui.println(escolhido.fullDetails());

        ui.println("Ações:");
        ui.println("1) Adicionar/Remover dos FAVORITOS");
        ui.println("2) Adicionar/Remover de JÁ ASSISTIDAS");
        ui.println("3) Adicionar/Remover de DESEJO ASSISTIR");
        ui.println("0) Voltar");
        int ac = ui.askInt("Opção: ");
        switch (ac) {
            case 1 -> toggleInList(ui, user.getFavorites(), escolhido.id(), "Favoritos");
            case 2 -> toggleInList(ui, user.getWatched(), escolhido.id(), "Já assistidas");
            case 3 -> toggleInList(ui, user.getWatchlist(), escolhido.id(), "Desejo Assistir");
            default -> {}
        }
        store.save(user);
    }

    private static void toggleInList(ConsoleUI ui, Set<Integer> set, int id, String nomeLista) {
        if (set.contains(id)) {
            set.remove(id);
            ui.println("Removido de " + nomeLista + ".");
        } else {
            set.add(id);
            ui.println("Adicionado a " + nomeLista + ".");
        }
    }

    private static void gerenciarListas(ConsoleUI ui, TvMazeClient api, UserData user, UserDataStore store) {
        while (true) {
            ui.line();
            ui.println("== Minhas listas ==");
            ui.println("1) Favoritos (" + user.getFavorites().size() + ")");
            ui.println("2) Já assistidas (" + user.getWatched().size() + ")");
            ui.println("3) Desejo assistir (" + user.getWatchlist().size() + ")");
            ui.println("0) Voltar");
            int op = ui.askInt("Opção: ");
            if (op == 0) return;

            Set<Integer> target;
            String nomeLista;
            if (op == 1) { target = user.getFavorites(); nomeLista = "Favoritos"; }
            else if (op == 2) { target = user.getWatched(); nomeLista = "Já assistidas"; }
            else if (op == 3) { target = user.getWatchlist(); nomeLista = "Desejo assistir"; }
            else { ui.println("Opção inválida."); continue; }

            var shows = api.fetchManyByIds(target);
            if (shows.isEmpty()) {
                ui.println("Lista vazia.");
                continue;
            }

            // Ordenação
            ui.println("Ordenar por: 1) Nome  2) Nota  3) Estado  4) Data de estreia");
            int ord = ui.askInt("Opção: ");
            shows.sort(switch (ord) {
                case 2 -> ShowInfo.BY_RATING_DESC;
                case 3 -> ShowInfo.BY_STATUS_PT;
                case 4 -> ShowInfo.BY_PREMIERE_ASC;
                default -> ShowInfo.BY_NAME_ASC;
            });

            // Exibe
            for (int i = 0; i < shows.size(); i++) {
                ui.println((i + 1) + ") " + shows.get(i).basicLine());
            }
            ui.println("Ações: 1) Ver detalhes  2) Remover item  0) Voltar");
            int ac = ui.askInt("Opção: ");
            if (ac == 1) {
                int idx = ui.askInt("Número do item: ");
                if (idx > 0 && idx <= shows.size()) {
                    ui.line();
                    ui.println(shows.get(idx - 1).fullDetails());
                }
            } else if (ac == 2) {
                int idx = ui.askInt("Número do item: ");
                if (idx > 0 && idx <= shows.size()) {
                    int id = shows.get(idx - 1).id();
                    target.remove(id);
                    store.save(user);
                    ui.println("Removido de " + nomeLista + ".");
                }
            } else if (ac == 0) {
                // volta ao menu de listas
            }
        }
    }
}
