import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Storage storage = new Storage("usuario_series.json");
        Usuario usuario = null;
        try {
            usuario = storage.carregarUsuario();
        } catch (IOException e) {
            System.out.println("Erro ao carregar usuário: " + e.getMessage());
        }

        if (usuario == null) {
            System.out.print("Nenhum usuário salvo encontrado. Digite seu nome: ");
            String nome = in.nextLine().trim();
            if (nome.isEmpty()) nome = "Usuário";
            usuario = new Usuario(nome);
            System.out.println("Criado usuário: " + usuario.nome);
        } else {
            System.out.println("Usuário carregado: " + usuario.nome);
        }

        List<Serie> ultimoResultado = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("=== Menu ===");
            System.out.println("1) Buscar série");
            System.out.println("2) Ver listas (Favoritos / Já assistidas / Quero assistir)");
            System.out.println("0) Sair (salva automaticamente)");
            System.out.print("Escolha: ");
            String op = in.nextLine().trim();

            switch (op) {
                case "1":
                    System.out.print("Termo de busca: ");
                    String termo = in.nextLine().trim();
                    if (termo.isEmpty()) {
                        System.out.println("Termo vazio.");
                        break;
                    }
                    try {
                        ultimoResultado = TvMazeApi.buscarSerie(termo);
                        if (ultimoResultado == null || ultimoResultado.isEmpty()) {
                            System.out.println("Nenhuma série encontrada para: " + termo);
                        } else {
                            System.out.println("Resultados:");
                            for (int i = 0; i < ultimoResultado.size(); i++) {
                              Serie s = ultimoResultado.get(i);
                              System.out.printf("%2d) %s (%s)%n", i+1, s.getName(), s.getPremiered());
                            }
                            System.out.print("\nDigite o índice para ver detalhes (ou ENTER para voltar): ");
                            String escolha = in.nextLine().trim();
                            if (!escolha.isEmpty()) {
                                try {
                                    int indice = Integer.parseInt(escolha) - 1; // converte 1-based para 0-based
                                    if (indice >= 0 && indice < ultimoResultado.size()) {
                                        Serie sel = ultimoResultado.get(indice);
                                        System.out.println("\n=== Detalhes da série ===");
                                        System.out.println("Nome: " + sel.getName());
                                        System.out.println("Idioma: " + (sel.getLanguage() == null || sel.getLanguage().isEmpty() ? "-" : sel.getLanguage()));
                                        System.out.println("Gêneros: " + (sel.getGenres().isEmpty() ? "-" : String.join(", ", sel.getGenres())));
                                        System.out.println("Nota geral: " + (sel.getRating() >= 0 ? String.valueOf(sel.getRating()) : "-"));
                                        System.out.println("Estado: " + (sel.getStatus() == null || sel.getStatus().isEmpty() ? "-" : sel.getStatus()));
                                        System.out.println("Data de estreia: " + (sel.getPremiered() == null || sel.getPremiered().isEmpty() ? "-" : sel.getPremiered()));
                                        System.out.println("Data de término: " + (sel.getEnded() == null || sel.getEnded().isEmpty() ? "-" : sel.getEnded()));
                                        System.out.println("Emissora: " + (sel.getNetworkName() == null || sel.getNetworkName().isEmpty() ? "-" : sel.getNetworkName()));

                                        System.out.println("\nColocar em qual lista?");
                                        System.out.println("1) Favoritos");
                                        System.out.println("2) Já assistidas");
                                        System.out.println("3) Quero assistir");
                                        System.out.println("0) Nenhuma");
                                        System.out.print("Escolha: ");
                                        String lista = in.nextLine().trim();
                                        switch (lista) {
                                            case "1":
                                                usuario.favoritos.add(sel);
                                                System.out.println("Adicionado a Favoritos.");
                                                break;
                                            case "2":
                                                usuario.assistidas.add(sel);
                                                System.out.println("Adicionado a Já assistidas.");
                                                break;
                                            case "3":
                                                usuario.desejos.add(sel);
                                                System.out.println("Adicionado a Quero assistir.");
                                                break;
                                            default:
                                                System.out.println("Nenhuma lista selecionada.");
                                        }
                                    } else {
                                        System.out.println("Índice fora do intervalo.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Entrada inválida.");
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Erro na busca: " + e.getMessage());
                    }
                    break;

                case "2":
                    while (true) {
                        System.out.println("\nVer listas:");
                        System.out.println("1) Favoritos");
                        System.out.println("2) Já assistidas");
                        System.out.println("3) Quero assistir");
                        System.out.println("0) Voltar");
                        System.out.print("Escolha: ");
                        String opcaoLista = in.nextLine().trim();
                        List<Serie> lista = null;
                        String titulo = "";
                        switch (opcaoLista) {
                            case "1": lista = usuario.favoritos; titulo = "Favoritos"; break;
                            case "2": lista = usuario.assistidas; titulo = "Já assistidas"; break;
                            case "3": lista = usuario.desejos; titulo = "Quero assistir"; break;
                            case "0": lista = null; break;
                            default: System.out.println("Opção inválida."); continue;
                        }
                        if (lista == null) break;
                        System.out.println("Lista: " + titulo + " (" + usuario.nome + ")");
                        if (lista.isEmpty()) {
                            System.out.println("(vazio)");
                            continue;
                        }
                        System.out.println("Escolha a ordenação ao entrar:");
                        System.out.println("1) Ordem alfabética do nome");
                        System.out.println("2) Nota geral (decrescente)");
                        System.out.println("3) Estado da série (já concluída, ainda transmitindo, cancelada)");
                        System.out.println("4) Data de estreia");
                        System.out.print("Escolha: ");
                        String criterioOrdenacao = in.nextLine().trim();
                        switch (criterioOrdenacao) {
                            case "1": lista.sort((a,b) -> a.getName().compareToIgnoreCase(b.getName())); break;
                            case "2": lista.sort((a,b) -> Double.compare(b.getRating(), a.getRating())); break;
                            case "3": lista.sort((a,b) -> {
                                int pa = statusPriority(a.getStatus());
                                int pb = statusPriority(b.getStatus());
                                if (pa != pb) return Integer.compare(pa,pb);
                                return a.getName().compareToIgnoreCase(b.getName());
                            }); break;
                            case "4": lista.sort((a,b) -> {
                                String pa = a.getPremiered()==null?"":a.getPremiered();
                                String pb = b.getPremiered()==null?"":b.getPremiered();
                                return pa.compareTo(pb);
                            }); break;
                            default: System.out.println("Critério inválido. Mantendo ordem atual.");
                        }

                            for (int i = 0; i < lista.size(); i++) {
                                Serie s = lista.get(i);
                                System.out.println("\n--- (" + (i+1) + ") " + s.getName() + " ---");
                            System.out.println("Nome: " + s.getName());
                            System.out.println("Idioma: " + (s.getLanguage() == null || s.getLanguage().isEmpty() ? "-" : s.getLanguage()));
                            System.out.println("Gêneros: " + (s.getGenres().isEmpty() ? "-" : String.join(", ", s.getGenres())));
                            System.out.println("Nota geral: " + (s.getRating() >= 0 ? String.valueOf(s.getRating()) : "-"));
                            System.out.println("Estado: " + (s.getStatus() == null || s.getStatus().isEmpty() ? "-" : s.getStatus()));
                            System.out.println("Data de estreia: " + (s.getPremiered() == null || s.getPremiered().isEmpty() ? "-" : s.getPremiered()));
                            System.out.println("Data de término: " + (s.getEnded() == null || s.getEnded().isEmpty() ? "-" : s.getEnded()));
                            System.out.println("Emissora: " + (s.getNetworkName() == null || s.getNetworkName().isEmpty() ? "-" : s.getNetworkName()));
                        }

                        System.out.print("\nComandos: r<#> remover, m<#> mover, ENTER voltar. Ex: r2 ou m1\nComando: ");
                        String cmd = in.nextLine().trim();
                        if (cmd.isEmpty()) continue;
                        if (cmd.startsWith("r")) {
                            String num = cmd.substring(1).trim();
                            try {
                                int idx = Integer.parseInt(num) - 1; 
                                if (idx >= 0 && idx < lista.size()) {
                                    Serie remS = lista.remove(idx);
                                    System.out.println("Removido: " + remS.getName());
                                    try { storage.salvarUsuario(usuario); System.out.println("Salvo automaticamente."); } catch (IOException ex) { System.out.println("Erro ao salvar: " + ex.getMessage()); }
                                } else System.out.println("Índice inválido.");
                            } catch (NumberFormatException e) { System.out.println("Entrada inválida."); }
                            continue;
                        }
                        if (cmd.startsWith("m")) {
                            String num = cmd.substring(1).trim();
                            try {
                                int idx = Integer.parseInt(num) - 1; 
                                if (idx >= 0 && idx < lista.size()) {
                                    Serie s = lista.get(idx);
                                    System.out.println("Mover para qual lista? 1) Favoritos 2) Já assistidas 3) Quero assistir 0) Cancelar");
                                    String dest = in.nextLine().trim();
                                    if (dest.equals("0")) { System.out.println("Cancelado."); continue; }
                                    List<Serie> destList = null;
                                    switch (dest) {
                                        case "1": destList = usuario.favoritos; break;
                                        case "2": destList = usuario.assistidas; break;
                                        case "3": destList = usuario.desejos; break;
                                        default: destList = null; break;
                                    }
                                    if (destList == null) { System.out.println("Destino inválido."); continue; }
                                    destList.add(s);
                                    lista.remove(idx);
                                    System.out.println("Movido " + s.getName());
                                    try { storage.salvarUsuario(usuario); System.out.println("Salvo automaticamente."); } catch (IOException ex) { System.out.println("Erro ao salvar: " + ex.getMessage()); }
                                } else System.out.println("Índice inválido.");
                            } catch (NumberFormatException e) { System.out.println("Entrada inválida."); }
                            continue;
                        }
                        
                        try {
                            int idx = Integer.parseInt(cmd) - 1; 
                            if (idx >= 0 && idx < lista.size()) {
                                Serie sel = lista.get(idx);
                                System.out.println("\n=== Detalhes da série ===");
                                System.out.println("Nome: " + sel.getName());
                                System.out.println("Idioma: " + (sel.getLanguage() == null || sel.getLanguage().isEmpty() ? "-" : sel.getLanguage()));
                                System.out.println("Gêneros: " + (sel.getGenres().isEmpty() ? "-" : String.join(", ", sel.getGenres())));
                                System.out.println("Nota geral: " + (sel.getRating() >= 0 ? String.valueOf(sel.getRating()) : "-"));
                                System.out.println("Estado: " + (sel.getStatus() == null || sel.getStatus().isEmpty() ? "-" : sel.getStatus()));
                                System.out.println("Data de estreia: " + (sel.getPremiered() == null || sel.getPremiered().isEmpty() ? "-" : sel.getPremiered()));
                                System.out.println("Data de término: " + (sel.getEnded() == null || sel.getEnded().isEmpty() ? "-" : sel.getEnded()));
                                System.out.println("Emissora: " + (sel.getNetworkName() == null || sel.getNetworkName().isEmpty() ? "-" : sel.getNetworkName()));
                                System.out.println("\nDeseja mover (m), remover (r) ou voltar (ENTER)?");
                                String a = in.nextLine().trim();
                                if (a.equalsIgnoreCase("r")) {
                                    lista.remove(idx);
                                    System.out.println("Removido.");
                                    try { storage.salvarUsuario(usuario); System.out.println("Salvo automaticamente."); } catch (IOException ex) { System.out.println("Erro ao salvar: " + ex.getMessage()); }
                                } else if (a.equalsIgnoreCase("m")) {
                                    System.out.println("Mover para qual lista? 1) Favoritos 2) Já assistidas 3) Quero assistir");
                                    String dest = in.nextLine().trim();
                                    List<Serie> destList = null;
                                    switch (dest) {
                                        case "1": destList = usuario.favoritos; break;
                                        case "2": destList = usuario.assistidas; break;
                                        case "3": destList = usuario.desejos; break;
                                        default: destList = null; break;
                                    }
                                    if (destList == null) { System.out.println("Destino inválido."); continue; }
                                    destList.add(sel);
                                    lista.remove(idx);
                                    System.out.println("Movido.");
                                    try { storage.salvarUsuario(usuario); System.out.println("Salvo automaticamente."); } catch (IOException ex) { System.out.println("Erro ao salvar: " + ex.getMessage()); }
                                }
                            } else System.out.println("Índice inválido.");
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida.");
                        }
                    }
                    break;

                

                case "0":
                    try {
                        storage.salvarUsuario(usuario);
                        System.out.println("Usuário salvo. Saindo...");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar antes de sair: " + e.getMessage());
                    }
                    in.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static int statusPriority(String status) {
        if (status == null) return 3;
        String s = status.toLowerCase();
        
        if (s.contains("ended")) return 0;
        if (s.contains("running")) return 1;
        if (s.contains("cancel")) return 2;
        return 3;
    }
}
