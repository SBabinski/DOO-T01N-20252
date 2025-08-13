import java.util.Scanner;

public class CalculadoraLoja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Calculadora da Dona Gabrielinha ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("digite a quantidade da planta: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("digite o preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = quantidade * precoUnitario;
                    System.out.printf("o preço total da venda é: R$ %.2f\n", precoTotal);
                    break;
                case 2:
                    System.out.print("Digite o valor total da compra: ");
                    double valorTotalCompra = scanner.nextDouble();
                    System.out.print("digite o valor pago pelo cliente: ");
                    double valorPago = scanner.nextDouble();
                    double troco = valorPago - valorTotalCompra;
                    System.out.printf("O troco a ser dado é: R$ %.2f\n", troco);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha 1, 2 ou 3.");
            }
        } while (opcao != 3); 

        System.out.println("Obrigada por usar a calculadora!");
        scanner.close();
    }
}