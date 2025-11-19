import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = JsonService.carregarUsuario();

        if (usuario == null) {
            System.out.print("Digite seu nome: ");
            usuario = new Usuario(sc.nextLine());
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Buscar série");
            System.out.println("2. Ver listas");
            System.out.println("3. Salvar e sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1 -> buscarSerie(usuario, sc);
                case 2 -> mostrarListas(usuario);
                case 3 -> {
                    JsonService.salvarUsuario(usuario);
                    System.out.println("Dados salvos. Até mais, " + usuario.getNome() + "!");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void buscarSerie(Usuario usuario, Scanner sc) {
        System.out.print("Digite o nome da série: ");
        String nome = sc.nextLine();
        List<Serie> resultados = TVMazeService.buscarSerie(nome);

        for (int i = 0; i < resultados.size(); i++) {
            System.out.println("\n[" + (i+1) + "] " + resultados.get(i));
        }

        System.out.print("\nEscolha o número da série para adicionar (Digite 0 para cancelar): ");
        int escolha = sc.nextInt(); sc.nextLine();

        if (escolha > 0 && escolha <= resultados.size()) {
            Serie s = resultados.get(escolha-1);
            System.out.println("1. Favoritas | 2. Já assistidas | 3. Desejo assistir");
            int lista = sc.nextInt(); sc.nextLine();
            switch (lista) {
                case 1 -> usuario.adicionarSerie(usuario.getFavoritas(), s);
                case 2 -> usuario.adicionarSerie(usuario.getAssistidas(), s);
                case 3 -> usuario.adicionarSerie(usuario.getDesejoAssistir(), s);
            }
            System.out.println("Adicionada com sucesso!");
        }
    }

    private static void mostrarListas(Usuario u) {
        System.out.println("\n=== MINHAS LISTAS ===");
        System.out.println("\nFavoritas: " + u.getFavoritas());
        System.out.println("\nAssistidas: " + u.getAssistidas());
        System.out.println("\nDesejo assistir: " + u.getDesejoAssistir());
    }
}
