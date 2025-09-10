package calculadora;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class calc {
  static Scanner scan = new Scanner(System.in);
  static List<Float> listaVendas = new ArrayList<>();
  static double[][] lucros = new double[12][31];
  static float[][] vendas = new float[12][31];
  static float quantVendas;
  static float finalValue;

  public static void soma() {
    System.out.println("Quantidade de plantas vendidas?");
    quantVendas = scan.nextFloat();
    System.out.println("Valor de cada planta?");
    float preco = scan.nextFloat();

    float precoFinal = quantVendas * preco;
    float precoDesconto = (float) (precoFinal - (precoFinal * 0.05));

    if (quantVendas >= 10) {
      System.out.println("O preco das plantas com desconto de 5% foi de: " + precoDesconto);
      System.out.println("Venda realizada no sistema");
      listaVendas.add(precoDesconto);
      finalValue = precoDesconto;
    } else {
      System.out.println("O preco das plantas vendidas foi de R$" + precoFinal);
      System.out.println("Venda realizada no sistema");
      listaVendas.add(precoFinal);
      finalValue = precoFinal;
    }
  }

  public static void troco() {
    System.out.println("Valor pago pelo cliente");
    float valorCliente = scan.nextFloat();
    System.out.println("valor da compra");
    float valorDaCompra = scan.nextFloat();

    System.out.println("O troco do cliente sera de R$" + (valorCliente - valorDaCompra));
  }

  public static void armazenamentoDezMil() {
    while (true) {
      System.out.println("Digite o numero do mes 1 a 12 ou 0 para sair:");
      int mes = scan.nextInt();
      if (mes == 0)
        break;
      if (mes < 1 || mes > 12) {
        System.out.println("mes invalido");
        continue;
      }

      System.out.println("Digite o numero do dia 1 a 31:");
      int dia = scan.nextInt();
      if (dia < 1 || dia > 31) {
        System.out.println("dia invalido");
        continue;
      }

      lucros[mes - 1][dia - 1] = finalValue;
      vendas[mes - 1][dia - 1] = quantVendas;

      System.out.printf("Registrado: Dia %02d/%02d → R$ %.2f em %.0f vendas\n\n",
          dia, mes, finalValue, quantVendas);
    }
  }

  public static void gerenciarEntidades() {
      System.out.println("\n--- Gerenciamento ---");
      System.out.println("[1] - Cadastrar e testar Vendedor");
      System.out.println("[2] - Cadastrar e testar Cliente");
      System.out.print("Escolha uma opçao: ");
      int escolha = scan.nextInt();
      
      switch(escolha) {
          case 1:
              vendedor vendedorNovo = new vendedor();
              vendedorNovo.nome = "Joao da Silva";
              vendedorNovo.idade = 32;
              vendedorNovo.loja = "My Plant - Centro";
              vendedorNovo.cidade = "Cidade Fictícia";
              vendedorNovo.bairro = "Centro";
              vendedorNovo.rua = "Rua das Flores, 123";
              vendedorNovo.salarioBase = 2500.00;
              
              vendedorNovo.salarioRecebido[0] = 2700.50;
              vendedorNovo.salarioRecebido[1] = 2650.00;
              vendedorNovo.salarioRecebido[2] = 2780.75;
              
              System.out.println("\n== Testando Vendedor ==");
              vendedorNovo.apresentarse();
              vendedorNovo.calcularMedia();
              vendedorNovo.calcularBonus();
              break;
              
          case 2:
              cliente clienteNovo = new cliente();
              clienteNovo.nome = "Maria Oliveira";
              clienteNovo.idade = 25;
              clienteNovo.cidade = "Cidade Fictícia";
              clienteNovo.bairro = "Jardim das Plantas";
              clienteNovo.rua = "Avenida das Arvores, 456";
              
              System.out.println("\n== Testando Cliente ==");
              clienteNovo.apresentarse();
              break;
              
          default:
              System.out.println("Opção invalida!");
              break;
      }
  }

  public static void main(String[] args) {
    int escolha;

    do {
      System.out.println("\n===== MENU My Plant =====");
      System.out.println("[1] - Calcular Preço Total de Venda");
      System.out.println("[2] - Calcular Troco");
      System.out.println("[3] - Armazenar Venda por Data");
      System.out.println("[4] - Gerenciar Vendedores e Clientes");
      System.out.println("[5] - Sair");
      System.out.print("Escolha uma opção: ");

      escolha = scan.nextInt();

      switch (escolha) {
        case 1:
          soma();
          break;
        case 2:
          troco();
          break;
        case 3:
          armazenamentoDezMil();
          break;
        case 4:
          gerenciarEntidades();
          break;
        case 5:
          System.out.println("saindo...");
          break;

        default:
          System.out.println("comando invalido");
          break;

      }
    } while (escolha != 5);
  }
}