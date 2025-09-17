import java.util.Scanner;

public class Item {

    int id;
    String nome;
    String tipo;
    int valor;

    Scanner scanner = new Scanner (System.in);

    public void Item(){

        System.out.println(" Digite o id do item: ");
        id = scanner.nextInt();

        scanner.nextLine();

        System.out.println(" Digite o nome do item: ");
        nome = scanner.nextLine();

        System.out.println(" Digite o tipo do item: ");
        tipo = scanner.nextLine();

        System.out.println(" Digite o valor do item: ");
        valor = scanner.nextInt();
    }

    public int getValor(){
        return valor;
    }

    public void gerarDesc(){
        System.out.println("\n Nome: " + nome + " | " + "Id: " + id + " | " + "Tipo: " + tipo +
                " | " + " Valor: R$" + valor );
    }

}
