import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("Cadastre 2 livros comuns:");
        for (int i = 0; i < 2; i++) biblioteca.cadastrarLivroComum(sc);

        System.out.println("Cadastre 2 livros raros:");
        for (int i = 0; i < 2; i++) biblioteca.cadastrarLivroRaro(sc);

        int opcao;
        do {
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Buscar livro por titulo");
            System.out.println("4 - Buscar livro por autor");
            System.out.println("5 - Realizar emprestimo");
            System.out.println("6 - Realizar devolucao");
            System.out.println("7 - Verificar disponibilidade");
            System.out.println("8 - Consultar acervo");
            System.out.println("0 - Sair");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1: biblioteca.cadastrarCliente(sc); break;
                case 2: biblioteca.cadastrarLivro(sc); break;
                case 3: biblioteca.buscarLivroTitulo(sc); break;
                case 4: biblioteca.buscarLivroAutor(sc); break;
                case 5: biblioteca.emprestarLivro(sc); break;
                case 6: biblioteca.devolverLivro(sc); break;
                case 7: biblioteca.verificarDisponibilidade(sc); break;
                case 8: biblioteca.consultarAcervo(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opcao invalida");
            }
        } while (opcao != 0);

        sc.close();
    }
}
