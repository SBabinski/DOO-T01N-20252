import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    public static ArrayList<Cliente> listaClientes = new ArrayList();
    public static ArrayList<Livro> listaLivros = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void cadastroCliente(){
      Cliente c1 = new Cliente();
      System.out.println("Fale seu nome");
      String nome = scanner.nextLine();
      c1.setNome(nome);
      System.out.println("Fale sua idade");
      int idade = scanner.nextInt();
      c1.setIdade(idade);
      System.out.println("Fale seu endereco");
      String endereco = scanner.nextLine();
      c1.setEndereco(endereco);
      listaClientes.add(c1);
    }

    public static void cadastroLivro(){
      Livro l1 = new Livro();
      System.out.println("Fale o nome do livro");
      String nome = scanner.nextLine();
      l1.setNome(nome);
      System.out.println("Fale o nome do autor");
      String autor = scanner.nextLine();
      l1.setAutor(autor);
      System.out.println("Fale a edicao");
      String edicao = scanner.nextLine();
      l1.setEdicao(edicao);
      System.out.println("Fale o ano");
      String ano = scanner.nextLine();
      l1.setAno(ano);
      l1.setDisponivel(true);
      listaLivros.add(l1);
    }

    public static void cadastroLivroRaro(){
      LivroRaro l2 = new LivroRaro();
      System.out.println("Fale o nome do livro");
      String nome = scanner.nextLine();
      l2.setNome(nome);
      System.out.println("Fale o nome do autor");
      String autor = scanner.nextLine();
      l2.setAutor(autor);
      System.out.println("Fale a edicao");
      String edicao = scanner.nextLine();
      l2.setEdicao(edicao);
      System.out.println("Fale o ano");
      String ano = scanner.nextLine();
      l2.setAno(ano);
      System.out.println("Fale a descrição de porque o livro é raro");
      String descricao = scanner.nextLine();
      l2.setDescricao(descricao);
      l2.setDisponivel(false);
      listaLivros.add(l2);
    }

    public static void procurarLivroNome(){
        System.out.println("Fale o nome do livro");
        String nomeProcurado = scanner.nextLine();
        for (Livro l : listaLivros){
        if (l.getNome().equals(nomeProcurado)){
            l.apresentarLivro();
            break;
        }
        }
    }

    public static void procurarLivroAutor(){
        System.out.println("Fale o nome do autor");
        String autorProcurado = scanner.nextLine();
        for (Livro l : listaLivros){
        if (l.getAutor().equals(autorProcurado)){
            l.apresentarLivro();
            break;
        }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;
        while (opcao != 7){
            System.out.println("[1]Cadastrar cliente");
            System.out.println("[2]Cadastrar livro");
            System.out.println("[3]Buscar livro por nome");
            System.out.println("[4]Buscar livro por autor");
            System.out.println("[5]Realizar emprestimo");
            System.out.println("[6]Realizar devolução");
            System.out.println("[7]Fechar programa");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastroCliente();
                    break;
                case 2:
                    int opcaoLivro = 0;
                    System.out.println("[1]Cadastro de livro normal");
                    System.out.println("[2]Cadastro de livro raro");
                    opcaoLivro = scanner.nextInt();
                    switch (opcaoLivro) {
                        case 1:
                            cadastroLivro();
                            break;
                        case 2:
                            cadastroLivroRaro();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    break;
                case 3:
                    procurarLivroNome();
                    break;
                case 4:
                    procurarLivroAutor();
                    break;
                default:
                    break;
            }
        }
    

    }
}