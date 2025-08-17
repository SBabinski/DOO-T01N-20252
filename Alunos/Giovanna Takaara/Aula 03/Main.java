import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> listaQuant = new ArrayList<>();
        ArrayList<Float> listaValorUni = new ArrayList<>();
        ArrayList<Double> listaDescont = new ArrayList<>();
        ArrayList<Double> listaValorTot = new ArrayList<>();

        int opcao;

        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Calcular preço total.");
            System.out.println("2 - Calcular troco.");
            System.out.println("3 - Registro de Vendas.");
            System.out.println("4 - Sair.");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a quantidade de plantas: \n");
                    int quantidade = scanner.nextInt();

                    if (quantidade >= 10) {
                        System.out.println("Parabéns, agora você tem 5% de desconto no valor total " +
                                "da sua compra! \n");
                    }

                    System.out.println("Digite o valor unitário: \n");
                    float valor = scanner.nextFloat();

                    float total = quantidade * valor;
                    double desconto = total * 0.05;
                    double valortotal = total - desconto;

                    if (quantidade < 10) {
                        System.out.println("O valor total é: \n" + total);
                    } else {
                        System.out.println("O valor total com desconto é: \n" + valortotal);
                    }
                    listaQuant.add(quantidade);
                    listaValorUni.add (valor);
                    listaDescont.add(desconto);
                    listaValorTot.add (valortotal);

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
                    if (listaQuant.isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (int i =0; i < listaQuant.size(); i++) {
                            System.out.println("\nVenda: " + (i+1) + "\nQuantidade: " + listaQuant.get(i) +
                                    " Unitário: " + listaValorUni.get(i) + " Desconto: " +
                                    listaDescont.get(i) + " Total: " + listaValorTot.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção Inválida.");
           }
        }
        while (opcao != 3);
    }
    }
