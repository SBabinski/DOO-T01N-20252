import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> quantlista = new ArrayList<>();
        ArrayList<Float> valorunlista = new ArrayList<>();
        ArrayList<Double> desclista = new ArrayList<>();
        ArrayList<Double> valorfimlista = new ArrayList<>();

        int escolha;
        do {
            System.out.println(" Esolha uma opção: ");
            System.out.println(" [1] - Calcular Preço Total ");
            System.out.println(" [2] - Calcular Troco ");
            System.out.println(" [3] - Registro de Vendas");
            System.out.println(" [4] - Sair ");
                escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite a quantidade de plantas: \n");
                    int quantidade = scanner.nextInt();

                    if (quantidade >= 10){
                        System.out.println("Parabéns!! Você ganhou um desconto de 5% no valor total da sua compra! \n");
                    }

                    System.out.println("Digite o preço unitáro da planta: \n");
                    float valor = scanner.nextFloat();

                    double valortotal = quantidade * valor;

                    double valordesconto = valortotal * 0.05;

                    double totalcdesc = valortotal - valordesconto;

                    if (quantidade < 10) {
                        System.out.println("O valor total da compra é: R$ \n" + valortotal);
                    } else {
                        System.out.println("O valor total da compra com o desconto é: R$ " + totalcdesc);
                    }
                    quantlista.add(quantidade);
                    valorunlista.add(valor);
                    desclista.add(valordesconto);
                    valorfimlista.add(totalcdesc);

                    break;

                case 2:
                    System.out.println("Digite o valor recebido: \n");
                    float valorcliente = scanner.nextFloat();

                    System.out.println("Digite o valor total da compra: \n");
                    float total = scanner.nextFloat();

                    float trocototal = valorcliente - total;

                    System.out.println("Troco a devolver: \n" + trocototal);
                    break;

                case 3:
                    if (quantlista.isEmpty()){
                        System.out.println("Nenhuma venda registrada.");
                    } else{
                        for (int i = 0; i < quantlista.size(); i++) {
                            System.out.println("\n Venda: " + (i + 1)  + "\nQuantidade: " +
                                    quantlista.get(i) + " | Unitário: R$ " + valorunlista.get(i) +
                                    " | Desconto: R$ " + desclista.get(i) + " | Total: R$ " + valorfimlista.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");


            }

        }
        while (escolha != 3);
    }
}