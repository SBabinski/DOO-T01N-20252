import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Calcular Preco Total");
            System.out.println("2 - Calcular Troco");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a quantidade da planta: ");
                    int quantidade = sc.nextInt();
                    System.out.print("Digite o preco unitario: ");
                    double preco = sc.nextDouble();
                    double total = quantidade * preco;
                    System.out.println("Preco total da compra: " + total);
                    break;

                case 2:
                    System.out.print("Digite o valor pago pelo cliente: ");
                    double valorPago = sc.nextDouble();
                    System.out.print("Digite o valor total da compra: ");
                    double valorCompra = sc.nextDouble();
                    double troco = valorPago - valorCompra;
                    if (troco < 0) {
                        System.out.println("Valor pago insuficiente. Falta " + Math.abs(troco));
                    } else {
                        System.out.println("Troco a ser dado: " + troco);
                    }
                    break;

                case 3:
                    System.out.println("Encerrando a calculadora");
                    break;

                default:
                    System.out.println("Opcao invalida");
            }
        } while (opcao != 3);

        sc.close();
    }
}