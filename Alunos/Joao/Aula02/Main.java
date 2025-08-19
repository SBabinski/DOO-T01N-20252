import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        do {
            System.out.println(" Esolha uma opção: ");
            System.out.println(" [1] - Calcular Preço Total ");
            System.out.println(" [2] - Calcular Troco ");
            System.out.println(" [3] - Sair ");
                escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Digite a quantidade de plantas: \n");
                    int quantidade = scanner.nextInt();

                    System.out.println("Digite o preço unitáro da planta: \n");
                    float valor = scanner.nextFloat();

                    float valortotal = quantidade * valor;

                    System.out.println("O valor total da compra é: \n" + valortotal);
                    break;

                case 2:
                    System.out.println("Digite o valor recebido: \n");
                    float valorcliente = scanner.nextFloat();

                    System.out.println("Digite o valor total da compra: \n");
                    float total = scanner.nextFloat();

                    float trocototal = valorcliente - total;

                    System.out.println("Troco a devolver: \n" + trocototal);
                    break;

                case 3:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");


            }

        }
        while (escolha != 3);
    }
}