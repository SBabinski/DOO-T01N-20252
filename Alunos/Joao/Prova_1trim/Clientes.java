import java.util.Scanner;

public class Clientes {

    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    Scanner scanner = new Scanner(System.in);

    public void cadastrarC(){

        System.out.println("Digite o nome do cliente: ");
        nome= scanner.nextLine();

        System.out.println("Digite a idade do cliente: ");
        idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a cidade do cliente: ");
        cidade = scanner.nextLine();

        System.out.println("Digite o bairro do cliente: ");
        bairro = scanner.nextLine();

        System.out.println("Digite a rua do cliente: ");
        rua = scanner.nextLine();

        System.out.println(" Clientes cadastrados com sucesso! \n");

         }
    }

