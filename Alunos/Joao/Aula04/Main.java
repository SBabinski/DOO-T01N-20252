import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> quantLista = new ArrayList<>();
        ArrayList<Float> valorunLista = new ArrayList<>();
        ArrayList<Double> descLista = new ArrayList<>();
        ArrayList<Double> valorfimLista = new ArrayList<>();
        ArrayList<Integer> diaLista = new ArrayList<>();
        ArrayList<Integer> mesLista = new ArrayList<>();
        ArrayList<Integer> vendaslista = new ArrayList<>();

        int escolha;
        do {
            System.out.println(" Esolha uma opção: ");
            System.out.println(" [1] - Calcular Preço Total ");
            System.out.println(" [2] - Calcular Troco ");
            System.out.println(" [3] - Registro de Vendas ");
            System.out.println(" [4] - Registrar vendas do dia/mês ");
            System.out.println(" [5] - Consultar vendas do dia/mês ");
            System.out.println(" [6] - Sair ");
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
                    quantLista.add(quantidade);
                    valorunLista.add(valor);
                    descLista.add(valordesconto);
                    valorfimLista.add(totalcdesc);

                    break;

                case 2:
                    System.out.println("Digite o valor recebido: \n");
                    float valorCliente = scanner.nextFloat();

                    System.out.println("Digite o valor total da compra: \n");
                    float total = scanner.nextFloat();

                    float trocoTotal = valorCliente - total;

                    System.out.println("Troco a devolver: \n" + trocoTotal);
                    break;

                case 3:
                    if (quantLista.isEmpty()){
                        System.out.println("Nenhuma venda registrada.");
                    } else{
                        for (int i = 0; i < quantLista.size(); i++) {
                            System.out.println("\n Venda: " + (i + 1)  + "\nQuantidade: " +
                                    quantLista.get(i) + " | Unitário: R$ " + valorunLista.get(i) +
                                    " | Desconto: R$ " + descLista.get(i) + " | Total: R$ " + valorfimLista.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite o mês (número): ");
                    int mes = scanner.nextInt();

                    System.out.println("Digite o dia: ");
                    int dia = scanner.nextInt();

                    System.out.println("Digite a quantidade de vendas desse dia: ");
                    int qtdVendas = scanner.nextInt();

                    mesLista.add(mes);
                    diaLista.add(dia);
                    vendaslista.add(qtdVendas);

                    System.out.println("Vendas registradas com sucesso para " + dia + "/" + mes + "!");

                    break;

                case 5:
                    System.out.println("Digite o mês (número): ");
                    int mesConsulta = scanner.nextInt();

                    System.out.println("Digite o dia: ");
                    int diaConsulta = scanner.nextInt();

                    int totalfinal = 0;
                    for (int i = 0; i < mesLista.size(); i++) {
                        if (mesLista.get(i) == mesConsulta && diaLista.get(i) == diaConsulta) {
                            totalfinal += vendaslista.get(i);
                        }
                    }

                    System.out.println("Total de vendas em " + diaConsulta + "/" + mesConsulta + ": " + totalfinal);
                    break;

                case 6:
                    System.out.println("Saindo do programa... ");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");

            }
        }
        while (escolha != 6);
    }
}