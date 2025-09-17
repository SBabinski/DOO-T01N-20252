package calculadora;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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

  public static void testarEntidades() {
    System.out.println("\n--- Testando Entidades ---");
    
    Endereco enderecoVendedor = new Endereco();
    enderecoVendedor.estado = "SP";
    enderecoVendedor.cidade = "São Paulo";
    enderecoVendedor.bairro = "Centro";
    enderecoVendedor.rua = "Rua das Flores";
    enderecoVendedor.numero = 123;
    enderecoVendedor.complemento = "Loja 1";

    Vendedor vendedorNovo = new Vendedor();
    vendedorNovo.nome = "Joao da Silva";
    vendedorNovo.idade = 32;
    vendedorNovo.loja = "My Plant - Centro";
    vendedorNovo.salarioBase = 2500.00;
    vendedorNovo.endereco = enderecoVendedor;
    vendedorNovo.salarioRecebido[0] = 2700.50;
    vendedorNovo.salarioRecebido[1] = 2650.00;
    vendedorNovo.salarioRecebido[2] = 2780.75;
    
    System.out.println("\n== Testando Vendedor ==");
    vendedorNovo.apresentarse();
    vendedorNovo.calcularMedia();
    vendedorNovo.calcularBonus();

    Endereco enderecoCliente = new Endereco();
    enderecoCliente.estado = "RJ";
    enderecoCliente.cidade = "Rio de Janeiro";
    enderecoCliente.bairro = "Jardim Botânico";
    enderecoCliente.rua = "Avenida das Palmeiras";
    enderecoCliente.numero = 456;
    enderecoCliente.complemento = "Apto 101";

    Cliente clienteNovo = new Cliente();
    clienteNovo.nome = "Maria Oliveira";
    clienteNovo.idade = 25;
    clienteNovo.endereco = enderecoCliente;
    
    System.out.println("\n== Testando Cliente ==");
    clienteNovo.apresentarse();
    
    Endereco enderecoGerente = new Endereco();
    enderecoGerente.estado = "SP";
    enderecoGerente.cidade = "São Paulo";
    enderecoGerente.bairro = "Centro";
    enderecoGerente.rua = "Avenida Principal";
    enderecoGerente.numero = 789;
    enderecoGerente.complemento = "Escritório Central";
    
    Gerente gerenteNovo = new Gerente();
    gerenteNovo.nome = "Carlos Andrade";
    gerenteNovo.idade = 45;
    gerenteNovo.loja = "My Plant - Matriz";
    gerenteNovo.salarioBase = 7000.00;
    gerenteNovo.endereco = enderecoGerente;
    gerenteNovo.salarioRecebido[0] = 7200.00;
    gerenteNovo.salarioRecebido[1] = 7350.50;
    gerenteNovo.salarioRecebido[2] = 7100.25;

    System.out.println("\n== Testando Gerente ==");
    gerenteNovo.apresentarse();
    gerenteNovo.calcularMedia();
    gerenteNovo.calcularBonus();
  }
  
  public static void criarPedido() {
      System.out.println("\n--- Criando Pedido com Dados Fictícios ---");

      Cliente cliente = new Cliente();
      cliente.nome = "Sandra Gomes";
      cliente.idade = 29;

      Vendedor vendedor = new Vendedor();
      vendedor.nome = "Pedro Costa";
      vendedor.loja = "My Plant - Online";
      
      Item item1 = new Item();
      item1.id = 1;
      item1.nome = "Samambaia";
      item1.tipo = "Planta de interior";
      item1.valor = 45.00;

      Item item2 = new Item();
      item2.id = 2;
      item2.nome = "Orquídea";
      item2.tipo = "Flor";
      item2.valor = 75.50;

      Item item3 = new Item();
      item3.id = 3;
      item3.nome = "Vaso de Cerâmica";
      item3.tipo = "Acessório";
      item3.valor = 25.00;
      
      List<Item> itensPedido = new ArrayList<>(Arrays.asList(item1, item2, item3));

      ProcessoPedido processador = new ProcessoPedido();
      Pedido pedido = processador.processar(1, cliente, vendedor, vendedor.loja, itensPedido);

      System.out.println("\n== Descrição do Pedido Gerado ==");
      pedido.gerarDescricaoVenda();
  }

  public static void main(String[] args) {
    int escolha;

    do {
      System.out.println("\n===== MENU My Plant =====");
      System.out.println("[1] - Calcular Preço Total de Venda");
      System.out.println("[2] - Calcular Troco");
      System.out.println("[3] - Armazenar Venda por Data");
      System.out.println("[4] - Testar Entidades (Cliente, Vendedor, Gerente)");
      System.out.println("[5] - Criar Pedido");
      System.out.println("[6] - Sair");
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
          testarEntidades();
          break;
        case 5:
          criarPedido();
          break;
        case 6:
          System.out.println("saindo...");
          break;

        default:
          System.out.println("comando invalido");
          break;
      }
    } while (escolha != 6);
  }
}






