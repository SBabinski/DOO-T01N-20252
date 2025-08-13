import java.util.Scanner;

public class Calculadora {
    static Scanner scanner = new Scanner(System.in);
    public static void calcularTotal() {
        System.out.println("Digite o valor da planta:");
        float valorPlanta = scanner.nextFloat();
        System.out.println("Digite a quantidade vendida dessa planta:");
        float quantidade = scanner.nextInt();
        float totalCompra = valorPlanta * quantidade;
        System.out.println("Valor total da compra: " + totalCompra);
    }

    public static void calcularTroco() {
            System.out.println("Digite o valor recebido pelo cliente:");
            float pagamento = scanner.nextFloat();
            System.out.println("Digite o valor total da compra:");
            float valorTotal = scanner.nextFloat();
            float valorTroco = pagamento - valorTotal;
            if (valorTroco < 0) {
                valorTroco = valorTroco*(-1);
            }
            System.out.println("Troco a ser dado para o cliente: " + valorTroco);
    }

    public static void main (String[] args) {
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("[1] Calcular preço total");
            System.out.println("[2] Calcular troco");
            System.out.println("[3] Sair");
            System.out.print("Digite uma opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    calcularTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Essa não é uma opção válida!");
            }
        }
    }
}