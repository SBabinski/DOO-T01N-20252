
        
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cadastro> cadastroArrayList = new ArrayList<>();

        int opcao = 0;

        System.out.println("Bem-vindo à biblioteca!");

        do {
            System.out.println("\n======== Menu da Biblioteca ======");
            System.out.println("[1] - Emprestar livros");
            System.out.println("[2] - Devolver livro");
            System.out.println("[3] - Cadastrar livros");
            System.out.println("[4] - Pesquisar por título");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); //limpa o menu

     switch(opcao) {
                case 1:
                 System.out.println("Digite o nome do livro para emprestar:");
                 String nomeEmprestimo = scanner.nextLine();
                 boolean encontrado = false;

                 for (Cadastro c : cadastroArrayList) {
                    if (c.getTitulo().equalsIgnoreCase(nomeEmprestimo)) {
                      if (instanceof) {
                       System.out.println("Este livro é raro e não pode ser emprestado \n");

                   } else if (c.isEmprestado()) {
                     System.out.println("Este livro já está emprestado\n");
                  } else {
                    c.setemprestado(true);
                   System.out.println("Livro emprestado \n ");
                     }
                   encontrado = true;
                   break;

                case 2:
                    System.out.println("Digite o nome do livro que voce esta devolvendo");
                    String devolucao = scanner.nextLine();
                    System.out.println(" Livro" + devolucao);
                    break;

                case 3:
                    System.out.print("Nome do livro: ");
                     String titulo = scanner.nextLine();

                     System.out.print("Autor do livro: ");
                     String autor = scanner.nextLine();

                     System.out.print("É um livro raro? (s/n): ");
                     String raro = scanner.nextLine();

                     CadastroLivro livro;
                   if (raro.equalsIgnoreCase("s")) {
                      System.out.print("Motivo da raridade: ");
                      String motivo = scanner.nextLine();

                      livro = Livrosraros(titulo, autor, motivo,);
                    } else {
                      livro = new CadastroLivro(titulo, autor,);
                    }
                     cadastroArrayList.add(livro);
                     System.out.println("Livro cadastrado com sucesso!");
                      break;
                    

                 case 4:
                    System.out.println("Digite o nome do livro para pesquisar:");
                    String pesquisa = scanner.nextLine();

                    boolean achou = false;
                    for (Cadastro c : cadastroArrayList) {
                     if (c.getNome().equalsIgnoreCase(pesquisa)) {
                        System.out.println("Livro encontrado: " + c.getNome());
                        achou = true;

                        break;
                        }
                    }

                    if (!achou) {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("sistema encerado");
                    break;

                default:
                    System.out.println("Tente outra opicao");
                    break;
                
            }
        }
     }

   }
 }
}