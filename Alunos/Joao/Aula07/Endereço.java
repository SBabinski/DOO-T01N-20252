import java.util.Scanner;

public class Endereço {
     String estado;
     String cidade;
     String bairro;
     int numero;
     String complemento;

    Scanner scanner = new Scanner(System.in);

   public void Logradouro(){

       System.out.println(" Digite o estado: ");
       estado = scanner.nextLine();

       System.out.println(" Digite a cidade: ");
       cidade = scanner.nextLine();

       System.out.println(" Digite o bairro: ");
       bairro = scanner.nextLine();

       System.out.println(" Digite o número: Nº");
       numero = scanner.nextInt();

       scanner.nextLine();

       System.out.println(" Digite o complemento: \n");
       complemento = scanner.nextLine();

       System.out.println("Logradouro: " + bairro + " | " + cidade + " | " + estado + " | " + numero +
               " | " + complemento);
     }
}
