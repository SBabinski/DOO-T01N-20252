import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calculadora {
    static Scanner scanner = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0.00");
    static ArrayList<Venda> vendas = new ArrayList<>();

    public static void calcularTotal() {
        System.out.println("\nDigite o valor da planta:");
        float valorPlanta = scanner.nextFloat();
        System.out.println("Digite a quantidade vendida dessa planta:");
        int quantidade = scanner.nextInt();
        float totalCompra = valorPlanta * quantidade;

        if (quantidade > 10) {
            System.out.println("Valor total da compra: R$ " + df.format(totalCompra));
            System.out.println("Valor com desconto de 5%: R$ " + df.format(totalCompra * 0.95f));
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
            System.out.println("Cliente precisar pagar mais R$ " + df.format(valorTroco));
        } else {
            System.out.println("Troco a ser dado para o cliente: R$ " + df.format(valorTroco));
        }
    }
 
    public static void registroDeVendas() {
        if (vendas.isEmpty()){
            System.out.println("\nNão há nenhuma venda registrada!");
        } else {
            System.out.println("\n===== Registro de Vendas =====");
            for (int i = 0; i <vendas.size(); i++) {
                Venda venda = vendas.get(i);
                System.out.println("["+ (i+1) + "] " + venda);
                System.out.println("=========================");
            }
        }
    }

    public static void buscarVenda() {
        if (vendas.isEmpty()) {
            System.out.println("\nNão há nenhuma venda registrada!");
        } else {
            System.out.println("\nDigite a data da venda:");
            String dataVenda = scanner.nextLine();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate busca = LocalDate.parse(dataVenda, fmt);
            boolean encontrou = false;

            System.out.println("\n===== Vendas em " + busca.format(fmt) + " =====\n");
            for (int i = 0; i < vendas.size(); i++) {
                Venda venda = vendas.get(i);
                if (venda.getData().equals(busca)) {
                    System.out.println("[" + i+1 +"] " + venda);
                    System.out.println("=========================");
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhuma venda registrada na data informada!");
            }
        }
    }

    public static void main (String[] args) {
        while (true) {
            System.out.println("\n===== MENU ===========");
            System.out.println("[1] Calcular preço total");
            System.out.println("[2] Calcular troco");
            System.out.println("[3] Registro de vendas");
            System.out.println("[4] Buscar venda");
            System.out.println("[5] Sair");
            System.out.println("========================");
            System.out.print("Digite uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
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
                    buscarVenda();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Essa não é uma opção válida!");
            }
        }
    }
}