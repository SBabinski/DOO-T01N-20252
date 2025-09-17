import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("1 - Cadastro de Clientes.");
            System.out.println("2 - Cadstro de Livros.");
            System.out.println("3 - Buscar livro por título.");
            System.out.println("4 - Buscar livro por autor.");
            System.out.println("5 - Realizar Empréstimo.");
            System.out.println("6 - Realizar Devolução.");
            System.out.println("7 - Sair.");
            System.out.println("Digite uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Clientes c = new Clientes();
                    c.cadastrarCliente();
                    c.exibirClientes();
                    break;

                case 2:
                    Livro l = new Livro();
                    l.cadastrarLivro();
                    l.exibirLivros();
                    break;


                case 3:
                    Livro l1 = new Livro();
                    l1.buscatitulo();
                    break;

                case 4:
                    Livro l2 = new Livro();
                    l2.buscaautor();
                    break;
            }

        } while (opcao != 7) ;
    }
}
