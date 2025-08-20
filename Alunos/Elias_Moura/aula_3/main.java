import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao =0;
        double total, totalDaCompra, Descontos;
        double troco, recebido;

     // melhorias da calculadora quadros das listas das nova funcionalidade

    List<Integer>listaQuantidadeComprada = new ArrayList<>();
    List<Double>listaOtotal = new ArrayList<>();
    List<Double>listaDescontos = new ArrayList<>();

        System.out.print("CALCULADORA DE PREÇOS");




        while(opcao !=4){
            System.out.print("\n=== MENU ===\n");
            System.out.print("[1]- Calcular preço total \n");
            System.out.print("[2]- Calcular Troco \n");
            System.out.print("[3]- Registro das Vendas \n");
            System.out.print("[4]- sair\n");
            System.out.print("Escolha uma opição \n");
            opcao = scanner.nextInt();

            if (opcao ==1){
                Descontos = 0;
                System.out.print("Digite a quantidade de planta:");
                int quantidade = scanner.nextInt();

                System.out.print("digite o valor unitario de cada planta (10,50 ou 10.50)");
                String precoStr = scanner.next().replace(",", ".");
                 double preco = Double.parseDouble(precoStr);

                 total = quantidade * preco;
              if (quantidade >10) {
                  Descontos = total * 0.05;
                total -= Descontos;
                System.out.printf("o desconto de 5%% aplicado:R$ %.2f\n",Descontos);

              }
                 //listas dos registro 

                 listaQuantidadeComprada.add(quantidade);
                 listaOtotal.add(total);
                 listaDescontos.add(Descontos);

                 System.out.printf("preço total da compra: R$ %.2f \n",total);


            } else if (opcao == 2) {
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

                }else if(opcao == 3 ){
                    if (listaQuantidadeComprada.isEmpty()) {
                    System.out.println("nao a compras registradas ate o momento");
        
                }else{
                   System.out.println("=== Registrar vendas ===");
                  
                     for (int i = 0; i < listaQuantidadeComprada.size(); i++) {
                        System.out.printf("vendas %d: quantidade:%d | total:R$ %.2f | Desconto: R$ %.2f\n",
                                 i + 1,
                                 listaQuantidadeComprada.get(i),
                                 listaOtotal.get(i),
                                 listaDescontos.get(i));
                      } 
                    }
                } else if (opcao ==4) {
                   System.out.print("sistema encerado");

               }else {
                System.out.print("opição invalida tente novamete");
            }


        }

        scanner.close();
    }
}