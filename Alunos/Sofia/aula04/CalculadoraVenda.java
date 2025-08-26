import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculadoraVenda {

    private static Map<String, Integer> vendasPorData = new HashMap<>();

    public static void registrarVenda(int mes, int dia, int quantidade) {
        String chave = mes + "-" + dia;
        vendasPorData.put(chave, vendasPorData.getOrDefault(chave, 0) + quantidade);
        System.out.println("Venda registrada com sucesso!");
    }

    public static void buscarVenda(int mes, int dia) {
        String chave = mes + "-" + dia;
        int total = vendasPorData.getOrDefault(chave, 0);
        System.out.println("Total de vendas em " + dia + "/" + mes + ": " + total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU CALCULADORA DE VENDAS ===");
            System.out.println("1 - Registrar venda");
            System.out.println("2 - Buscar venda por data");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o mês (número): ");
                    int mes = sc.nextInt();
                    System.out.print("Digite o dia: ");
                    int dia = sc.nextInt();
                    System.out.print("Digite a quantidade de vendas: ");
                    int quantidade = sc.nextInt();
                    registrarVenda(mes, dia, quantidade);
                    break;
                case 2:
                    System.out.print("Digite o mês (número): ");
                    mes = sc.nextInt();
                    System.out.print("Digite o dia: ");
                    dia = sc.nextInt();
                    buscarVenda(mes, dia);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}

