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

        Loja loja = new Loja ("My plant", "My plant Ltda",
                "12.345.678/0001-55", "Cascavel", "Centro", "AV.Brasil");


        int opcao;

        do {
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Calcular preço total.");
            System.out.println("2 - Calcular troco.");
            System.out.println("3 - Registro de Vendas.");
            System.out.println("4 - Consulta por data.");
            System.out.println("5 - Cadastrar Cliente.");
            System.out.println("6 - Cadastrar Vendendor.");
            System.out.println("7 - Gerenciar Loja.");
            System.out.println("8 - Sair.");
            opcao = scanner.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("\nDigite a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();

                    if (quantidade >= 10) {
                        System.out.println("Parabéns, agora você tem 5% de desconto no valor total " +
                                "da sua compra! ");
                    }

                    System.out.println("\nDigite o valor unitário: ");
                    float valor = scanner.nextFloat();

                    float total = quantidade * valor;
                    double desconto = total * 0.05;
                    double valortotal = total - desconto;

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
                    listaValorUni.add (valor);
                    listaDescont.add(desconto);
                    listaValorTot.add (valortotal);
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
                        for (int i =0; i < listaQuant.size(); i++) {
                            System.out.println("\nVenda: " + (i+1) + "\nData: " + listadia.get(i) + "/" +
                            listaMes.get(i) + "\nQuantidade: " + listaQuant.get(i) + "\nUnitário: " +
                            listaValorUni.get(i) + "\nDesconto: " + listaDescont.get(i) + "\nTotal: " +
                            listaValorTot.get(i));
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

                        double soma = 0;
                        for (int i = 0; i < listaQuant.size(); i++) {
                            if (listaMes.get(i) == mesc) {
                                if (diac == 0 || listadia.get(i) == diac) {
                                    soma += listaValorTot.get(i);
                                }
                            }
                        }

                        if (diac == 0) {
                            System.out.println("\nTotal de vendas no mês " + mesc + ": " + soma);
                        } else {
                            System.out.println("\nTotal de vendas em " + diac + "/" + mesc + ": " + soma);
                        }
                    }

                case 5:
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nomeC = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeC = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeC = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairroC = scanner.nextLine();
                    System.out.print("Rua: ");
                    String ruaC = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeC, idadeC, cidadeC, bairroC, ruaC);
                    loja.adicionarCliente(cliente);

                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 6:
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nomeV = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeV = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeV = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairroV = scanner.nextLine();
                    System.out.print("Rua: ");
                    String ruaV = scanner.nextLine();
                    System.out.print("Salário Base: ");
                    double salarioBaseV = scanner.nextDouble();
                    scanner.nextLine();

                    Vendedor vendedor = new Vendedor(nomeV, idadeV, loja.nomeFantasia,
                            cidadeV, bairroV, ruaV, salarioBaseV);
                    loja.adicionarVendedor(vendedor);

                    System.out.println("Vendedor cadastrado com sucesso!");
                    break;

                case 7:
                    loja.apresentarloja();
                    loja.contarVendedores();
                    loja.contarClientes();

                    System.out.println("\nVendedores: ");
                    for (int i = 0; i < loja.vendedores.size(); i++) {
                        Vendedor v = loja.vendedores.get(i);
                        v.apresentarVendedor();
                        System.out.println("Média salários: " + v.calcularmedia());
                        System.out.println("Bônus: " + v.calcularBonus());
                    }

                    System.out.println("\nClientes: ");
                    for (int i = 0; i < loja.clientes.size(); i++) {
                        Cliente c = loja.clientes.get(i);
                        c.apresentarCliente();
                    }
                    break;

                case 8:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção Inválida.");
           }
        }
        while (opcao != 8);
    }
    }
