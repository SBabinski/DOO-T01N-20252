import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);

        ArrayList<Vendas> vendas = new ArrayList<>();
        ArrayList<Vendedores> listvendedores = new ArrayList<>();
        ArrayList<Clientes> clientes = new ArrayList<>();

     int opcao;       

       do {
        System.out.println("\n==== Bem vindo a Calculadora ======\n");
        System.out.println("[1] - calcular preço total \n");
        System.out.println("[2] - calcular troco \n");
        System.out.println("[3] - Registro de vendas \n");
        System.out.println("[4] - consulta as vendas por dia \n");
        System.out.println("[5] - consultar todas as vendas do mes \n");
        System.out.println("[6] - vendedores \n");
        System.out.println("[7] - clientes  \n");
        System.out.println("[8] - lojas filiais \n");
        System.out.println("[9] - sair do sistema \n");
      
    
        opcao = scanner.nextInt();
    
        switch(opcao){


            /// calcula preço total 
            case 1:
              scanner.nextLine();
              System.out.println("Nome do produto \n");
              String nome = scanner.nextLine();

              System.out.println("Quantidade \n");
              int quantidade = scanner.nextInt();

              System.out.println("Preço unitario do produto \n");
              double unidade = scanner.nextDouble();

              Produto produto = new Produto(nome, quantidade, unidade);
              double total = Produto. CalculadoraProduto.calcularTotal(produto);
        
              System.out.printf("Total a pagar %d unidade de %s R$ %.2f \n",quantidade, nome, total); 
              break;

             /// calcula a parte de troco
             
            case 2:
              scanner.nextLine();

              System.out.println("Digite o nome do produto \n");
              String nomeProduto = scanner.nextLine();

              System.out.println("Quantidade \n");
              int quantidadeProduto = scanner.nextInt();

              System.out.println("Preço da unidade \n");
              double precounidade = scanner.nextDouble();

              Produto produtoTroco = new Produto(nomeProduto, quantidadeProduto, precounidade);
              double totalCompra = Produto.CalculadoraProduto.calcularTotal(produtoTroco);

              System.out.printf("total a pagar e de R$ %.2f ", totalCompra);

              System.out.print("Valor da entrada do cliente \n");
              double valordaEntrada = scanner.nextDouble();

              double troco = produtoTroco.calculaTroco(valordaEntrada);

              if (troco > 0) {
                 System.out.println("valor e insuficiente para pagar a compra das plantas \n");

              }else{
                System.out.printf("troco do dinheiro para devolver R$ %.2f \n", troco);
              }

              break;
   
              /// Parte das vendas tanto dia quanto mes 
              
            case 3:
              scanner.nextLine();

              System.out.print("Nome da planta vendida");
               nome = scanner.nextLine();

              System.out.print("digite a quantidade ");
               quantidade = scanner.nextInt();

              System.out.print("preço da unidade");
              double preco = scanner.nextDouble();

              System.out.print("digite o dia vendido de 1 a 31");
              int dia = scanner.nextInt();
              
              System.out.print("digite o mes da venda de 1 ate 12");
              int mes = scanner.nextInt();

              System.out.print("digite o ano da venda");
              int ano = scanner.nextInt();


              Vendas novaVenda = new Vendas(nome, quantidade, preco,dia, mes, ano);
              vendas.add(novaVenda);

              System.out.println("venda registrada com sucesso");

              break;

            case 4:
              System.out.println("Consultar vendas por dia \n");

              System.out.print("Informe o dia da venda \n");
              int diaConsultar = scanner.nextInt();
     
              System.out.print("Informe o mes da venda de 1 a 12 \n");
              int mesConsulter = scanner.nextInt();
              
              System.out.print("Informe o ano ");
              int anoConsultar = scanner.nextInt();

              double totalDia = 0;
              boolean encontrou = false;

              for(Vendas v: vendas){
                  if (v.getDia() == diaConsultar && v.getMes() == mesConsulter && v.getAno() == anoConsultar) {
                      System.out.println(v);
                      totalDia += v.getTotal();
                      encontrou = true;
                   }

              }if (!encontrou) {
                
                System.out.println("Nao a vendas encontrada nessa data ");
                
              }else{
                System.out.printf("Total vendido em %02d/%02d/%d: R$%.2f%n", diaConsultar, mesConsulter, anoConsultar, totalDia);
              }
              
              break;

            case 5:
              System.out.println("Consultar todas as vendas do mes \n");

              System.out.print("Informe o mes de 1 a 12 ");
              mesConsulter =scanner.nextInt();

              System.out.print("Informe o ano das vendas");
              anoConsultar = scanner.nextInt();

              double totalMes = 0;
              encontrou = false;
            
              System.out.printf("vendas emcontrada do " + String.format("%02d/%d", mesConsulter, anoConsultar + ":"));

              for(Vendas v: vendas){
                if (v.getMes() == mesConsulter && v.getAno() == anoConsultar) {
                  System.out.println(v);
                  totalMes += v.getTotal();
                  encontrou =true;
                }
              }if (!encontrou) {
                System.out.println("Nao a vendas nesse mes ou ano ");
                
              }else{
                System.out.printf("Total de vendas no mês: R$%.2f\\n" + totalMes);

              }

              break;

            case 6:
              scanner.nextLine(); // linpa o sistema 

              System.out.println("Cadastro dos Vendedores \n");

              System.out.print("Digite o seu nome \n");
              String nomeVendedor = scanner.nextLine();

              System.out.print("Digite sua Matricula \n");
              int matricula = scanner.nextInt();
   
              scanner.nextLine(); 

              System.out.print("CPF informe somente o numero dele \n");
              String cpf = scanner.nextLine();

              Vendedores novoVendedor = new Vendedores(nomeVendedor, matricula, cpf);
              listvendedores.add(novoVendedor); 

              break;

            case 7:
              System.out.println("cadastro de loja");
              
              System.out.print("Informe o numero da loja filial");
              int lojaConsultar = scanner.nextInt();

               encontrou = false;
               int totalVendedores = 0;
      
                 for(Vendedores v: listvendedores){
                  if (v.getLoja() == lojaConsultar) {
                    System.out.println(v);
                    encontrou = true;
                    totalVendedores ++;
                    
                  }

                 }if (!encontrou) {
                   System.out.println("Nao foi encontrado nenhuma loja e nem vendedor " + lojaConsultar);

                 }else{
                    System.out.println("total de vendedores na loja e lojas  " + lojaConsultar +":"+totalVendedores);
                 }
                
              break;

            case 8:
             scanner.nextLine();

              System.out.println("cadastro de clientes \n");

              System.out.print("Nome do Cliente \n");
              String nomeCliente = scanner.nextLine();

              System.out.print("Informe seu CPF \n");
              String cpfCliente = scanner.nextLine();

              System.out.print("Informe seu telefone");
              String telefoneCliente = scanner.nextLine();

              System.out.print("Informe seu endereso");
              String enderecoCliente = scanner.nextLine();

             Clientes novoCliente = new Clientes(nomeCliente, cpfCliente, enderecoCliente, telefoneCliente);
             clientes.add(novoCliente);


              System.out.println("Cliente cadastrado com sucesso \n");
              System.out.println(novoCliente);

              break;

            case 9:
              System.out.println("Sair do cistema  \n");
             


              break;

            default:
              System.out.println("opção invalida Tente novamente \n");

        }
           System.out.println(); 

       }while (opcao !=9); 
        
       
       
       scanner.close();

       
    }
}
