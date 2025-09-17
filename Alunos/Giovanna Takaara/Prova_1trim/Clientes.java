import java.util.ArrayList;
import java.util.Scanner;

public class Clientes {
    Scanner scanner = new Scanner(System.in);

    String nomeCliente;
    String cpf;
    int idade;
    int telefone;
    String email;

    static ArrayList<Clientes> cliente = new ArrayList<>();

    public void cadastrarCliente() {

        System.out.println("Digite o nome do Cliente: ");
        this.nomeCliente = scanner.nextLine();
        System.out.println("Digite o cpf do Cliente: ");
        this.cpf = scanner.nextLine();
        System.out.println("Digite o email do Cliente: ");
        this.email = scanner.nextLine();
        System.out.println("Digite a idade do Cliente: ");
        this.idade = scanner.nextInt();
        System.out.println("Digite o telefone do Cliente: ");
        this.telefone = scanner.nextInt();
        scanner.nextLine();
        cliente.add(this);

    }

    public void exibirClientes() {
        if (cliente.isEmpty()) {
            System.out.println("Sem clientes");
        } else {
            for (int i = 0; i < cliente.size(); i++) {
                System.out.println("Cliente " + (i + 1) + ": ");
                System.out.println(cliente.get(i));
            }
        }
    }
    public String toString() {
        return "Nome: " + nomeCliente + "\nCpf: " + cpf + "\nIdade: " + idade + "\nTelefone" +
                telefone + "\nEmail: " + email;
    }
}