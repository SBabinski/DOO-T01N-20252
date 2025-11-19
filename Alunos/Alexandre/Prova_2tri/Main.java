package DOO-T01N-20252. Alunos.Alexandre.Prova_2tri;

import java.util.*;

public class Main {

    private Scanner scanner;
    private Usuario usuario;
    private TvMazeService apiService;
    private PersistenciaService persistenciaService;

    public Main() {
        this.scanner = new Scanner(System.in);
        this.apiService = new TvMazeService();
        this.persistenciaService = new PersistenciaService();
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.iniciar();
    }

    public void iniciar() {
        try {
            carregarOuCriarUsuario();
            menuPrincipal();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro fatal no sistema: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Encerrando sistema...");
            if (usuario != null)
                persistenciaService.salvarUsuario(usuario);
        }
    }

    private void carregarOuCriarUsuario() {
        this.usuario = persistenciaService.carregarUsuario();
        if (this.usuario == null) {
            System.out.println("Bem-vindo! Nenhum dado salvo encontrado.");
            System.out.print("Digite seu nome ou apelido: ");
            String nome = scanner.nextLine();
            this.usuario = new Usuario(nome);
        } else {
            System.out.println("Bem-vindo de volta, " + usuario.getNome() + "!");
        }
    }

    private void menuPrincipal() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Buscar Série na TVMaze");
            System.out.println("2. Ver Meus Favoritos");
            System.out.println("3. Ver Já Assistidas");
            System.out.println("4. Ver Quero Assistir");
            System.out.println("0. Sair e Salvar");
            System.out.print("Opção: ");

            String opcao = scanner.nextLine();

            try {
                switch (opcao) {
                    case "1":
                        buscarSeries();
                        break;
                    case "2":
                        gerenciarLista("Favoritos", usuario.getFavoritos());
                        break;
                    case "3":
                        gerenciarLista("Assistidas", usuario.getAssistidas());
                        break;
                    case "4":
                        gerenciarLista("Quero Assistir", usuario.getQuerAssistir());
                        break;
                    case "0":
                        rodando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro durante a operação: " + e.getMessage());
            }
        }
    }

    private void buscarSeries() {
        System.out.print("Digite o nome da série: ");
        String termo = scanner.nextLine();

        try {
            List<Serie> resultados = apiService.buscarSeries(termo);
            if (resultados.isEmpty()) {
                System.out.println("Nenhuma série encontrada.");
                return;
            }

            System.out.println("\nResultados encontrados:");
            for (int i = 0; i < resultados.size(); i++) {
                System.out.println(
                        (i + 1) + ". " + resultados.get(i).getName() + " (" + resultados.get(i).getDataEstreia() + ")");
            }

            System.out.print("Selecione o número da série para ver detalhes (ou 0 para voltar): ");
            int escolha = Integer.parseInt(scanner.nextLine());

            if (escolha > 0 && escolha <= resultados.size()) {
                Serie selecionada = resultados.get(escolha - 1);
                System.out.println(selecionada);
                menuAdicionarListas(selecionada);
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número.");
        } catch (Exception e) {
            System.out.println("Erro ao buscar na API: " + e.getMessage());
        }
    }

    private void menuAdicionarListas(Serie serie) {
        System.out.println("\nO que deseja fazer com esta série?");
        System.out.println("1. Adicionar aos Favoritos");
        System.out.println("2. Adicionar às Já Assistidas");
        System.out.println("3. Adicionar às Quero Assistir");
        System.out.println("0. Voltar");
        System.out.print("Opção: ");

        String op = scanner.nextLine();
        switch (op) {
            case "1":
                adicionarSeNaoExiste(usuario.getFavoritos(), serie, "Favoritos");
                break;
            case "2":
                adicionarSeNaoExiste(usuario.getAssistidas(), serie, "Assistidas");
                break;
            case "3":
                adicionarSeNaoExiste(usuario.getQuerAssistir(), serie, "Quero Assistir");
                break;
            case "0":
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void adicionarSeNaoExiste(List<Serie> lista, Serie serie, String nomeLista) {
        if (lista.contains(serie)) {
            System.out.println("Esta série já está na lista " + nomeLista + ".");
        } else {
            lista.add(serie);
            System.out.println("Adicionado a " + nomeLista + " com sucesso!");
            persistenciaService.salvarUsuario(usuario);
        }
    }

    private void gerenciarLista(String nomeLista, List<Serie> lista) {
        if (lista.isEmpty()) {
            System.out.println("\nSua lista de " + nomeLista + " está vazia.");
            return;
        }

        boolean gerenciar = true;
        while (gerenciar) {
            System.out.println("\n--- Lista: " + nomeLista + " ---");
            lista.forEach(
                    s -> System.out.println("- " + s.getName() + " [" + s.getNota() + "] (" + s.getStatus() + ")"));

            System.out.println("\nOpções:");
            System.out.println("1. Ordenar Lista");
            System.out.println("2. Ver Detalhes de uma Série");
            System.out.println("3. Remover Série");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            String op = scanner.nextLine();
            switch (op) {
                case "1":
                    menuOrdenacao(lista);
                    break;
                case "2":
                    System.out.print("Digite o nome exato da série para ver detalhes: ");
                    String nomeDetalhe = scanner.nextLine();
                    lista.stream()
                            .filter(s -> s.getName().equalsIgnoreCase(nomeDetalhe))
                            .findFirst()
                            .ifPresentOrElse(System.out::println,
                                    () -> System.out.println("Série não encontrada na lista."));
                    break;
                case "3":
                    System.out.print("Digite o nome exato da série para remover: ");
                    String nomeRemover = scanner.nextLine();
                    boolean removeu = lista.removeIf(s -> s.getName().equalsIgnoreCase(nomeRemover));
                    if (removeu) {
                        System.out.println("Removido com sucesso.");
                        persistenciaService.salvarUsuario(usuario);
                    } else {
                        System.out.println("Série não encontrada.");
                    }
                    break;
                case "0":
                    gerenciar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void menuOrdenacao(List<Serie> lista) {
        System.out.println("Ordenar por:");
        System.out.println("1. Ordem Alfabética (Nome)");
        System.out.println("2. Nota Geral (Maior para menor)");
        System.out.println("3. Estado (Status)");
        System.out.println("4. Data de Estreia");
        System.out.print("Escolha: ");
        String op = scanner.nextLine();

        switch (op) {
            case "1":
                lista.sort(Comparator.comparing(Serie::getName));
                break;
            case "2":
                lista.sort(Comparator.comparing(Serie::getNota).reversed());
                break;
            case "3":
                lista.sort(Comparator.comparing(Serie::getStatus));
                break;
            case "4":
                lista.sort(Comparator.comparing(Serie::getDataEstreia));
                break;
            default:
                System.out.println("Ordenação inválida.");
        }
        System.out.println("Lista reordenada!");
    }
}