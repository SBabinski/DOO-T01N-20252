import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Clientes> clientes = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();

        int escolha;
        do {
            System.out.println(" Esolha uma opção: ");
            System.out.println(" [1] - Cadastrar Clientes ");
            System.out.println(" [2] - Cadastrar Livros ");
            System.out.println(" [3] - Cadastrar Livros Raros ");
            System.out.println(" [4] - Buscar Livro por Título ");
            System.out.println(" [5] - Buscar Livro por Autor ");
            System.out.println(" [6] - Realizar Empréstimo ");
            System.out.println(" [7] - Realizar Devolução ");
            System.out.println(" [8] - Saindo do programa");

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    Clientes cliente = new Clientes();
                    cliente.cadastrarC();
                    clientes.add(cliente);
                    break;

                case 2:
                    Livro livro = new Livro();
                    livro.cadastrarL();
                    livros.add(livro);
                    break;

                case 3:
                    LivroRaro livrosr = new LivroRaro();
                    livrosr.cadastrarLR();
                    livros.add(livrosr);
                    break;

                case 4:
                BuscaTitulo btitulo = new BuscaTitulo();
                btitulo.buscarTitulo(livros);
                    break;

                case 5:
                BuscaAutor bautor = new BuscaAutor();
                bautor.buscarAutor(livros);
                    break;

                case 6:
                    Emprestimo emprestimo = new Emprestimo();
                    emprestimo.emprestarL(livros);
                    break;

                case 7:
                    Devolucao devolucao = new Devolucao();
                    devolucao.devolverL(livros);
                    break;

                case 8:
                    System.out.println("Saindo do programa... ");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente! \n");

            }
        }
        while (escolha != 8);
    }

}
