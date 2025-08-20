import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Venda> vendas = new ArrayList<>(); //prosseguir daqui

    public static void calcularTotal() {
        System.out.println("\nDigite o valor da planta:");
        float valorPlanta = scanner.nextFloat();
        System.out.println("Digite a quantidade vendida dessa planta:");
        int quantidade = scanner.nextInt();
        float totalCompra = valorPlanta * quantidade;

        DecimalFormat df = new DecimalFormat("0.00");

        if (quantidade > 10) {
            System.out.println("Valor total da compra: R$ " + df.format(totalCompra / 0.95f));
            System.out.println("Valor com desconto de 5%: R$ " + df.format(totalCompra));
        } else {
            System.out.println("Valor total da compra: R$ " + df.format(totalCompra));     
        }

        Venda venda = new Venda(valorPlanta, quantidade);
        vendas.add(venda);
    }
    
    public static void calcularTroco() {
        System.out.println("\nDigite o valor recebido pelo cliente:");
        float pagamento = scanner.nextFloat();
        System.out.println("Digite o valor total da compra:");
        float valorTotal = scanner.nextFloat();
        float valorTroco = pagamento - valorTotal;
        if (valorTroco < 0) {
            valorTroco = valorTroco*(-1);
            System.out.printf("Cliente precisar pagar mais R$ %.2f\n", valorTroco);
        } else {
            System.out.printf("Troco a ser dado para o cliente: R$ %.2f\n", valorTroco);
        }
    }

    public static void registroDeVendas() {
        if (vendas.isEmpty()){
            System.out.println("\nNão há nenhuma venda registrada!");
        } else {
            System.out.println("\n===== Registro de Vendas =====");
            for (int i = 0; i <vendas.size(); i++) {
                Venda venda = vendas.get(i);
                System.out.printf("[%d] %s\n", i+1, venda);
            }
        }

    }
    public static void main (String[] args) {
        while (true) {
            System.out.println("\n===== MENU ===========");
            System.out.println("[1] Calcular preço total");
            System.out.println("[2] Calcular troco");
            System.out.println("[3] Registro de vendas");
            System.out.println("[4] Sair");
            System.out.println("========================");
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
                    registroDeVendas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Essa não é uma opção válida!");
            }
        }
    }
}
