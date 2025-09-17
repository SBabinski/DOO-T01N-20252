import java.util.Scanner;

public class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

Scanner scanner = new Scanner(System.in);

public Cliente(){
}

public void cadastrarCli(){

    System.out.print("Nome: ");
    nome = scanner.nextLine();
    System.out.print("Idade: ");
    idade = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Cidade: ");
    cidade = scanner.nextLine();
    System.out.print("Bairro: ");
    bairro = scanner.nextLine();
    System.out.print("Rua: ");
    rua = scanner.nextLine();

    System.out.println("Cliente cadastrado com sucesso!");
}

public void apresentarCliente() {

    System.out.println("Cliente: " + nome + "\nIdade: " + idade + "\nEndereço: " + rua + " - " +
            bairro + " - " + cidade);
}
}