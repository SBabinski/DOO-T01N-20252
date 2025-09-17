import java.util.Scanner;

public class Cliente {

    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

 Scanner scanner = new Scanner(System.in);

    public Cliente() {}

    public void cadastrarCliente(){
        System.out.println("Digite o nome do cliente: ");
        String nomeC= scanner.nextLine();

        System.out.println("Digite a idade do cliente: ");
        int idadeC = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a cidade do cliente: ");
        String cidadeC = scanner.nextLine();

        System.out.println("Digite o bairro do cliente: ");
        String bairroC = scanner.nextLine();

        System.out.println("Digite a rua do cliente: ");
        String ruaC = scanner.nextLine();

        System.out.println("Clientes cadastrados com sucesso!");
    }

public void apresentarse(){
    System.out.println("Nome: " + nome + " | Idade: " + idade);
  }

}