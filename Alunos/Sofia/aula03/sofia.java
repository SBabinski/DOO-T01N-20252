import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Venda {
    int quantidade;
    double precoUnitario;
    double valorTotal;
    double desconto;

    public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade +
                ", Preço Unitário: R$ " + precoUnitario +
                ", Valor Total: R$ " + valorTotal +
                ", Desconto aplicado: R$ " + desconto;
    }
}

public class sofia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Venda> registroVendas = new ArrayList<>();

        int opcao;

        do {
            // Menu principal
            System.out.println("\n===== Calculadora da Dona Gabrielinha =====");
            System.out.println("[1] - Calcular Preço Total (com desconto)");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:

                    System.out.print("Digite a quantidade de plantas: ");
                    int quantidade = sc.nextInt();

                    System.out.print("Digite o preço unitário da planta: ");
                    double precoUnitario = sc.nextDouble();

                    double valorTotal = quantidade * precoUnitario;
                    double desconto = 0;

                    if (quantidade > 10) {
                        desconto = valorTotal * 0.05;
                        valorTotal -= desconto;
                        System.out.println("Desconto especial de 5% aplicado!");
                    }

                    System.out.println("O valor final da compra é: R$ " + valorTotal);

                    registroVendas.add(new Venda(quantidade, precoUnitario, valorTotal, desconto));
                    break;

                case 2:

                    System.out.print("Digite o valor pago pelo cliente: ");
                    double valorPago = sc.nextDouble();

                    System.out.print("Digite o valor total da compra: ");
                    double valorCompra = sc.nextDouble();

                    double troco = valorPago - valorCompra;

                    if (troco < 0) {
                        System.out.println("Valor pago insuficiente! Falta R$ " + (-troco));
                    } else {
                        System.out.println("O troco a ser dado é: R$ " + troco);
                    }
                    break;

                case 3:

                    System.out.println("\n===== Registro de Vendas =====");
                    if (registroVendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada até o momento.");
                    } else {
                        for (Venda v : registroVendas) {
                            System.out.println(v);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo da calculadora... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 4);

        sc.close();
    }
}
