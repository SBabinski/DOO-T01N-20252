import java.util.ArrayList;
import java.util.Scanner;

class Venda {
    int quantidade;
    double valorTotal;
    double desconto;

    Venda(int q, double v, double d) {
        quantidade = q;
        valorTotal = v;
        desconto = d;
    }
}

public class Calculadora {
    static ArrayList<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Nova Venda");
            System.out.println("2 - Ver Registro de Vendas");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();
            if (opcao == 0)
                break;
            if (opcao == 1) {
                System.out.println("Quantidade");
                int q = scanner.nextInt();
                System.out.println("Preco unitario");
                double preco = scanner.nextDouble();
                double total = q * preco;
                double desconto = 0;
                if (q > 10)
                    desconto = total * 0.05;
                double valorPagar = total - desconto;
                System.out.println("Valor a pagar " + valorPagar);
                registroVendas.add(new Venda(q, valorPagar, desconto));
            }
            if (opcao == 2) {
                for (Venda v : registroVendas) {
                    System.out.println("Qtd " + v.quantidade + " Valor " + v.valorTotal + " Desc " + v.desconto);
                }
            }
        }
        scanner.close();
    }
}
