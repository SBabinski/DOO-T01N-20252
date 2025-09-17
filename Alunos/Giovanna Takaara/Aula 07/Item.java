import java.util.Scanner;

public class Item {
    Scanner scanner = new Scanner(System.in);

    int id;
    String nomep;
    String tipo;
    double valor;

public void descricaop() {
    System.out.println("Digite o id do produto: ");
    id = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Digite o nome do produto: ");
    nomep = scanner.nextLine();
    System.out.println("Digite o tipo  do produto: ");
    tipo = scanner.nextLine();
    System.out.println("Digite o valor do produto: ");
    valor = scanner.nextDouble();

    System.out.println("Nome do produto: " + nomep + "\nO id é: " + id + "\nTipo: " + tipo +
    "\nValor: " + valor);
    }
    public int getValor(){
    return valor;
    }

}
