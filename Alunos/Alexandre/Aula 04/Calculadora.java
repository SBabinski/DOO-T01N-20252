import java.util.ArrayList;
import java.util.Scanner;

class Venda {
    int quantidade;
    double valorTotal;
    double desconto;
    int dia;
    int mes;

    Venda(int q, double v, double d, int dia, int mes) {
        quantidade = q;
        valorTotal = v;
        desconto = d;
        this.dia = dia;
        this.mes = mes;
    }
}

public class Calculadora {
    static ArrayList<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Nova Venda");
            System.out.println("2 - Ver Registro de Vendas");
            System.out.println("3 - Total de Vendas em um Dia");
            System.out.println("4 - Total de Vendas em um Mes");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();

            if (opcao == 0)
                break;

            if (opcao == 1) {
                System.out.println("Dia da venda");
                int dia = scanner.nextInt();
                System.out.println("Mes da venda");
                int mes = scanner.nextInt();
                System.out.println("Quantidade");
                int q = scanner.nextInt();
                System.out.println("Preco unitario");
                double preco = scanner.nextDouble();

                double total = q * preco;
                double desconto = (q > 10) ? total * 0.05 : 0;
                double valorPagar = total - desconto;

                registroVendas.add(new Venda(q, valorPagar, desconto, dia, mes));

                System.out.println("Valor a pagar: " + valorPagar);
            }

            if (opcao == 2) {
                if (registroVendas.isEmpty()) {
                    System.out.println("Nenhuma venda registrada.");
                } else {
                    for (Venda v : registroVendas) {
                        System.out.println("Dia " + v.dia + "/" + v.mes +
                                " Qtd " + v.quantidade +
                                " Valor " + v.valorTotal +
                                " Desc " + v.desconto);
                    }
                }
            }

            if (opcao == 3) {
                System.out.println("Informe o dia:");
                int diaBusca = scanner.nextInt();
                System.out.println("Informe o mes:");
                int mesBusca = scanner.nextInt();

                int totalVendas = 0;
                for (Venda v : registroVendas) {
                    if (v.dia == diaBusca && v.mes == mesBusca)
                        totalVendas++;
                }
                System.out.println("Total de vendas em " + diaBusca + "/" + mesBusca + ": " + totalVendas);
            }

            if (opcao == 4) {
                System.out.println("Informe o mes:");
                int mesBusca = scanner.nextInt();

                int totalVendasMes = 0;
                for (Venda v : registroVendas) {
                    if (v.mes == mesBusca)
                        totalVendasMes++;
                }
                System.out.println("Total de vendas no mes " + mesBusca + ": " + totalVendasMes);
            }
        }

        scanner.close();
    }
}
