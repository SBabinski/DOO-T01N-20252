import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Calcular preço total.");
            System.out.println("2 - Calcular troco.");
            System.out.println("3 - Sair.");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a quantidade de plantas: \n");
                    int quantidade = scanner.nextInt();

                    System.out.println("Digite o valor unitário: \n");
                    float valor = scanner.nextFloat();

                    float total = quantidade * valor;
                    System.out.println("O valor total é: \n" + total);
                    break;

                case 2:
                    System.out.println("Digite o valor total recebido: \n");
                    float valorrecebido = scanner.nextFloat();

                    System.out.println("Digite o total da compra: \n");
                    float valorcompra = scanner.nextFloat();

                    float troco = valorrecebido - valorcompra;
                    System.out.println("Troco: " + troco);
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção Inválida.");
           }
        }
        while (opcao != 3);
    }
    }
