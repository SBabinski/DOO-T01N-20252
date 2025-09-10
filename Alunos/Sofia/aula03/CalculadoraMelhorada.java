package Alunos.Sofia.aula03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe que representa uma Venda
class Venda {
    private int quantidade;
    private double precoUnitario;
    private double valorFinal;
    private double descontoAplicado;

    public Venda(int quantidade, double precoUnitario, double valorFinal, double descontoAplicado) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorFinal = valorFinal;
        this.descontoAplicado = descontoAplicado;
    }

    @Override
    public String toString() {
        return "Venda {" +
                "quantidade=" + quantidade +
                ", preço unitário=R$ " + precoUnitario +
                ", desconto aplicado=R$ " + descontoAplicado +
                ", valor final=R$ " + valorFinal +
                '}';
    }
}

public class CalculadoraMelhorada {

    private static final double DESCONTO_ESPECIAL = 0.05; // 5%
    private static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    exibirRegistroVendas();
                    break;
                case 4:
                    System.out.println("✅ Saindo... Obrigada por usar a calculadora!");
                    break;
                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Calculadora da Dona Gabrielinha ===");
        System.out.println("[1] - Calcular Preço Total (com desconto se aplicável)");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Exibir Registro de Vendas");
        System.out.println("[4] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double valorTotal = quantidade * precoUnitario;
        double desconto = 0;

        if (quantidade > 10) {
            desconto = valorTotal * DESCONTO_ESPECIAL;
            valorTotal -= desconto;
            System.out.println("🎉 Desconto especial de 5% aplicado!");
        }

        System.out.println("💰 Valor final da compra é: R$ " + valorTotal);

        // Registrar a venda
        Venda venda = new Venda(quantidade, precoUnitario, valorTotal, desconto);
        registroVendas.add(venda);
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor pago pelo cliente: ");
        double valorPago = scanner.nextDouble();

        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scanner.nextDouble();

        double troco = valorPago - valorCompra;

        if (troco < 0) {
            System.out.println("⚠️ Valor insuficiente! Ainda faltam R$ " + (-troco));
        } else {
            System.out.println("💵 Troco a ser devolvido: R$ " + troco);
        }
    }

    private static void exibirRegistroVendas() {
        System.out.println("\n=== Registro de Vendas ===");
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada ainda.");
        } else {
            for (Venda venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }
}
