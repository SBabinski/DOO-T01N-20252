import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Vendas {
   public int dia;
   public int mes;
   public int quantidade;
   public double total;
   public double descontos;
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao =0;
        double total, totalDaCompra, descontos;
        double troco, recebido;
  
     String[] nomesMeses={
       "","jan", "fev", "mar", "abr", "mai","jun",
      "jul","ago","set","out","nov","dez"
      };



     // melhorias da calculadora quadros das listas das nova funcionalidade
    List<Vendas>vendas = new ArrayList<>();
    List<Integer>listaQuantidadeComprada = new ArrayList<>();
    List<Double>listaOtotal = new ArrayList<>();
    List<Double>listaDescontos = new ArrayList<>();

        System.out.print("CALCULADORA DE PREÇOS");
   
       while(opcao !=6){
            System.out.print("\n=== MENU ===\n");
            System.out.print("[1]- Calcular preço total \n");
            System.out.print("[2]- Calcular Troco \n");
            System.out.print("[3]- Registro das Vendas \n");
            System.out.print("[4]- consulta de todas as vendas por dia\n");
            System.out.print("[5]- consultar todas as vendas do mes\n");
            System.out.print("[6]- sair\n");
            System.out.print("Escolha uma opição \n");
            opcao = scanner.nextInt();

            if (opcao ==1){
                descontos = 0;
  
                System.out.print("informe o dia que esta vendendo\n");      
                  int dia = scanner.nextInt();

             int mes;
            do{
               System.out.print("informe o numero do mes das vendas de 1 ate 12 \n");
               mes = scanner.nextInt();
            if (mes <1 || mes > 12) {
             System.out.print("Mes invalido digite somente entre 1 e 12 \n");
               }
             } while (mes < 1 || mes > 12);

           
                System.out.print("Digite a quantidade de planta:\n");
                  int quantidade = scanner.nextInt();

                System.out.print("digite o valor unitario de cada planta (10,50 ou 10.50)\n");
                String precoStr = scanner.next().replace(",", ".");
                 double preco = Double.parseDouble(precoStr);

                 total = quantidade * preco;

              if (quantidade >10) {
                  descontos = total * 0.05;
                total -= descontos;
                System.out.printf("o desconto de 5%% aplicado:R$ %.2f\n",descontos);

              }
  
                Vendas venda = new Vendas();
                venda.dia = dia;
                venda.mes = mes;
                venda.quantidade = quantidade;
                venda.total = total;
                venda.descontos = descontos; 
                
                vendas.add(venda);
                System.out.printf("preço totoal das compras R$ %2f \n",total);


            } else if (opcao == 2) {
                System.out.print("Digite o valor recebido do cliente \n");
                String recebidoStr = scanner.next().replace(",", ".");
                recebido =Double.parseDouble(recebidoStr);

                System.out.print("digite o valor da compra \n");
                  String totalStr = scanner.next().replace(",", ".");
                   totalDaCompra =  Double.parseDouble(totalStr);

                 troco = recebido - totalDaCompra;

                 if (troco < 0 ){
                     System.out.printf("valor insuficiente falta R$ %.2f \n",-troco);
                 }else {
                     System.out.printf("troco para ser devolvido R$ %.2f \n", troco);
                 }

                }else if(opcao == 3 ){
                    if (vendas.isEmpty()) {
                    System.out.println("nao a compras registradas ate o momento\n");
        
                }else{
                   System.out.println("=== Registrar vendas ===");
                  
                     for (int i = 0; i < vendas.size(); i++) {
                        Vendas ven = vendas.get(i);
                        System.out.printf("vendas %d:data: %02d/%s| quantidade: %d | total:R$ %.2f | Desconto: R$ %.2f\n",
                                 i + 1,
                                  ven.dia,
                                  nomesMeses[ven.mes],
                                  ven.quantidade,
                                  ven.total,
                                  ven.descontos);


                                
                      } 
                    }
                }else if (opcao == 4 ) {
                    System.out.print("digite o dia \n");
                      int dia = scanner.nextInt();

                    System.out.print("digite o mes \n");  
                      int mes = scanner.nextInt();
           
                  int totalVendas = 0;
                   
                    for(Vendas ven : vendas){
                        if (ven.dia == dia && ven.mes == mes) {
                            totalVendas += 1;
                        }
                    }
                   System.out.printf("total das vendas do dia foi de %02d/%s: %d \n ", dia,nomesMeses[mes],totalVendas); 

                }else if (opcao == 5 ) {
                    System.out.print("digite o mes \n");
                    int mes = scanner.nextInt();
                    
                    if (mes < 1 || mes > 12) {
                        System.out.println("mes esta invalido digite de 1 ate 12 por favor !\n");
                        continue;
                    }

                  int totalVendas = 0;
                    for(Vendas van :vendas){
                        if (van.mes == mes) {
                            totalVendas +=1;
                        }
                      
                    }
                        System.out.printf("Total de vendas no mês %s: %d \n", nomesMeses[mes], totalVendas); 
    
                }else if (opcao ==6) {
                   System.out.print("sistema encerado\n");

               }else {
                System.out.print("opição invalida tente novamete \n");
            }


        }

        scanner.close();
    }
}