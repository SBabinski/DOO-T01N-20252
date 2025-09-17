import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listaQuant = new ArrayList<>();
        ArrayList<Float> listaValorUni = new ArrayList<>();
        ArrayList<Double> listaDescont = new ArrayList<>();
        ArrayList<Double> listaValorTot = new ArrayList<>();
        ArrayList<Integer> listaMes = new ArrayList<>();
        ArrayList<Integer> listadia = new ArrayList<>();
        Loja loja = new Loja("My plant", "My plant Ltda", "12.345.678/0001-55", "Cascavel", "Centro", "AV.Brasil");

        int opcao;
        do {
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Calcular preço total.");
            System.out.println("2 - Calcular troco.");
            System.out.println("3 - Registro de Vendas.");
            System.out.println("4 - Consulta por data.");
            System.out.println("5 - Cadastrar Cliente.");
            System.out.println("6 - Ver Vendendor.");
            System.out.println("7 - Gerenciar Loja.");
            System.out.println("8 - Ver Gerente.");
            System.out.println("9 - Endereço.");
            System.out.println("10 - Item.");
            System.out.println("11 - Cadastrar Pedido.");
            System.out.println("12 - Processa Pedido.");
            System.out.println("13332323 - Processa Pedido.");
            System.out.println("14 - Sair.");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("\nDigite a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();
                    if (quantidade >= 10) {
                        System.out.println("Parabéns, agora você tem 5% de desconto no valor total da sua compra! ");
                    }

                    System.out.println("\nDigite o valor unitário: ");
                    float valor = scanner.nextFloat();
                    float total = (float)quantidade * valor;
                    double desconto = (double)total * 0.05;
                    double valortotal = (double)total - desconto;
                    if (quantidade < 10) {
                        System.out.println("O valor total é: " + total);
                    } else {
                        System.out.println("O valor total com desconto é: " + valortotal);
                    }

                    System.out.println("\nDigite o mês da venda (1-12): ");
                    int mes = scanner.nextInt();
                    System.out.println(" Digite o dia da venda: ");
                    int dia = scanner.nextInt();
                    listaQuant.add(quantidade);
                    listaValorUni.add(valor);
                    listaDescont.add(desconto);
                    listaValorTot.add(valortotal);
                    listadia.add(dia);
                    listaMes.add(mes);
                    break;
                case 2:
                    System.out.println("\nDigite o valor total recebido: ");
                    float valorrecebido = scanner.nextFloat();
                    System.out.println("\nDigite o total da compra: ");
                    float valorcompra = scanner.nextFloat();
                    float troco = valorrecebido - valorcompra;
                    System.out.println("Troco: " + troco);
                    break;
                case 3:
                    if (listaQuant.isEmpty()) {
                        System.out.println("\nNenhuma venda registrada.");
                    } else {
                        for(int i = 0; i < listaQuant.size(); ++i) {
                            System.out.println("\nVenda: " + (i + 1) + "\nData: " + String.valueOf(listadia.get(i)) + "/" + String.valueOf(listaMes.get(i)) + "\nQuantidade: " + String.valueOf(listaQuant.get(i)) + "\nUnitário: " + String.valueOf(listaValorUni.get(i)) + "\nDesconto: " + String.valueOf(listaDescont.get(i)) + "\nTotal: " + String.valueOf(listaValorTot.get(i)));
                        }
                    }
                    break;
                case 4:
                    if (listaQuant.isEmpty()) {
                        System.out.println("\nNenhuma venda registrada.");
                    } else {
                        System.out.println("\nDigite o mês (1-12): ");
                        int mesc = scanner.nextInt();
                        System.out.println("\nDigite o dia (ou 0 para buscar o mês inteiro):  ");
                        int diac = scanner.nextInt();
                        double soma = (double)0.0F;

                        for(int i = 0; i < listaQuant.size(); ++i) {
                            if ((Integer)listaMes.get(i) == mesc && (diac == 0 || (Integer)listadia.get(i) == diac)) {
                                soma += (Double)listaValorTot.get(i);
                            }
                        }

                        if (diac == 0) {
                            System.out.println("\nTotal de vendas no mês " + mesc + ": " + soma);
                        } else {
                            System.out.println("\nTotal de vendas em " + diac + "/" + mesc + ": " + soma);
                        }
                    }
                case 5:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCli();
                    loja.adicionarCliente(cliente);

                case 6:
                    Vendedor vendedor = new Vendedor();
                    vendedor.cadastrarVend();
                    loja.adicionarVendedor(vendedor);

                case 7:
                    loja.apresentarloja();
                    loja.contarVendedores();
                    loja.contarClientes();
                    System.out.println("\n--- Vendedores ---");

                    for(int i = 0; i < loja.vendedores.size(); ++i) {
                        Vendedor v = (Vendedor)loja.vendedores.get(i);
                        v.apresentarVendedor();
                        System.out.println("Média salários: " + v.calcularmedia());
                        System.out.println("Bônus: " + v.calcularBonus());
                    }

                    System.out.println("\n--- Clientes ---");

                    for(int i = 0; i < loja.clientes.size(); ++i) {
                        Cliente c = (Cliente)loja.clientes.get(i);
                        c.apresentarCliente();
                    }
                    break;

                case 8:
                  Gerente gerente = new Gerente();
                    gerente.cadastrarGerente();
                    gerente.calcularMedia();
                    gerente.calcularBonus();


                case 9:
                    Endereço end = new Endereço();
                    end.Logradouro();

                case 10:
                    Item item = new Item();
                    item.descricaop();

                case 11:
                    Pedido pedido = new Pedido();
                    pedido.cadastrarPedido();
                    pedido.gerarDescVenda();
                    break;

                case 12:
                    ProcessaPedido processap = new ProcessaPedido();
                    processap.testeProcessar();
                    break;

                case 13:

                    break;

                case 14:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }
        } while(opcao != 14);

    }
}
