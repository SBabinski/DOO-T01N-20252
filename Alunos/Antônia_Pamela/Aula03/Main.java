import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao =0;
        double total, totalDaCompra,desconto;
        double troco, recebido;

        List<Integer>ListaDeCompra = new ArrayList<>();
        List<Double>Total = new ArrayList<>();
        List<Double>Desconto = new ArrayList<>();

        System.out.print("CALCULADORA DE PREÇOS");


        while(opcao !=4){
            System.out.print("\n=== MENU ===\n");
            System.out.print("[1]- Calcular preço total \n");
            System.out.print("[2]- Calcular Troco \n");
            System.out.print("[3]- Registro das Vendas \n");
            System.out.print("[4]- Sair \n");
            System.out.print("Escolha uma opição \n");
            opcao = scanner.nextInt();

            if(opcao == 1){
                desconto = 0;
                System.out.print("Digite a quantidade de planta:");
                int quantidade = scanner.nextInt();

                System.out.print("digite o valor unitario de cada planta (10,50 ou 10.50)");
                String precoStr = scanner.next().replace(",", ".");
                 double preco = Double.parseDouble(precoStr);

                 total = quantidade * preco;

                 if(quantidade>10){
                    desconto = total* 0.05;
                    total -= desconto;
                 System.out.printf("Desconto de 5%% aplicado:R$ %.2f \n",desconto);
                 }


                 ListaDeCompra.add(quantidade);
                 Total.add(total);
                 Desconto.add(desconto);
                 System.err.printf("Preço totaç da compra> R$ %.2f \n", total);

            }
            else if (opcao == 2) {
                System.out.print("Digite o valor recebido do cliente");
                String recebidoStr = scanner.next().replace(",", ".");
                recebido =Double.parseDouble(recebidoStr);

                System.out.print("digite o valor da compra ");
                  String totalStr = scanner.next().replace(",", ".");
                   totalDaCompra =  Double.parseDouble(totalStr);

                 troco = recebido - totalDaCompra;

                 if (troco < 0 ){
                     System.out.printf("valor insuficiente falta R$ %.2f \n",-troco);
                 }else {
                     System.out.printf("troco para ser devolvido R$ %.2f \n", troco);
                 }
            } else if (opcao ==3) {
                if(ListaDeCompra.isEmpty()){
                    System.out.println("Não há registros de compra até o momento");

                } else{
                    System.out.println("*Resgistrar Venda Dia*");
                    for (int i = 0; i < ListaDeCompra.size(); i++){
                        System.err.printf("vendas %d:| quantidade:%d | total:R$ %.2f | desconto: R$ %.2F\n",
                        i + 1,
                        ListaDeCompra.get(i),
                        Total.get(i),
                        Desconto.get(i));
                        
                    }
                }



            }else if(opcao == 4){
                System.out.print("Sistema encerrado");
            }else {
                System.out.printf("Tente Novamente");
            }
    
        }

        scanner.close();
    }
}