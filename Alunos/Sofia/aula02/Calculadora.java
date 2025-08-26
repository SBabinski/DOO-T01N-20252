

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            // Menu
            System.out.println("\n=== Calculadora da Dona Gabrielinha ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // Cálculo do Preço Total
                    System.out.print("Digite a quantidade de plantas: ");
                    int quantidade = sc.nextInt();
                    System.out.print("Digite o preço unitário da planta: ");
                    double precoUnitario = sc.nextDouble();
                    double precoTotal = quantidade * precoUnitario;
                    System.out.println("💰 Preço total da venda: R$ " + precoTotal);
                    break;

                case 2:
                    // Cálculo do Troco
                    System.out.print("Digite o valor pago pelo cliente: ");
                    double valorPago = sc.nextDouble();
                    System.out.print("Digite o valor total da compra: ");
                    double valorCompra = sc.nextDouble();
                    double troco = valorPago - valorCompra;
                    if (troco < 0) {
                        System.out.println("⚠️ Valor insuficiente! Ainda faltam R$ " + (-troco));
                    } else {
                        System.out.println("💵 Troco a ser devolvido: R$ " + troco);
                    }
                    break;

                case 3:
                    System.out.println("✅ Saindo... Obrigada por usar a calculadora!");
                    break;

                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);

        sc.close();
    }
}
