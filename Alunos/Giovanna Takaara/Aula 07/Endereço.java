
import java.util.Scanner;

public class Endereço {
    Scanner scanner = new Scanner(System.in);
    String estado;
    String cidade;
    String bairro;
    int numero;
    String complemento;

    public void Logradouro() {
        System.out.println("Digite o estado: ");
        estado = scanner.nextLine();

        System.out.println("Digite a cidade: ");
        cidade = scanner.nextLine();

        System.out.println("Digite o bairro: ");
        bairro = scanner.nextLine();

        System.out.println("Digite o numero: ");
        numero = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite o complemento: ");
        complemento = scanner.nextLine();

        System.out.println("Seu logradouro: " + bairro + ", " + numero + ", (" + complemento +
        "), " + cidade + " - " + estado);
    }
}
