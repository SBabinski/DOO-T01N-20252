import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vendas> vendas = new ArrayList<>();
        ArrayList<Vend> vendedores = new ArrayList<>();
        ArrayList<Client> clientes = new ArrayList<>();
        ArrayList<Item> itens = new ArrayList<>();
        ArrayList<Gerente> gerentes = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 12) {
            System.out.println("---- Menu da Calculadora da Veia ----");
            System.out.println("1 - Venda");
            System.out.println("2 - Troco");
            System.out.println("3 - Relatório de vendas");
            System.out.println("4 - Buscar venda");
            System.out.println("5 - Cadastrar vendedor");
            System.out.println("6 - Cadastrar cliente");
            System.out.println("7 - Listar vendedores");
            System.out.println("8 - Listar clientes");
            System.out.println("9 - Cadastrar item");
            System.out.println("10 - Cadastrar gerente");
            System.out.println("11 - Criar pedido");
            System.out.println("12 - Sair");
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Digite o dia da venda:");
                    int dia = scanner.nextInt();
                    System.out.println("Digite o mês da venda:");
                    int mes = scanner.nextInt();
                    System.out.println("Digite o ano da venda:");
                    int ano = scanner.nextInt();

                    System.out.println("Digite quantas plantas deseja comprar:");
                    int quantidade = scanner.nextInt();

                    System.out.println("Se comprar mais de 10 unidades, ganha desconto de 5%");
                    System.out.println("Digite o preço unitário da planta:");
                    double precoUnitario = scanner.nextDouble();

                    double precoTotal = quantidade * precoUnitario;
                    double desconto = (quantidade > 10) ? precoTotal * 0.05 : 0;
                    double valorFinal = precoTotal - desconto;

                    if (desconto > 0) {
                        System.out.printf("Desconto: %.2f%n", desconto);
                    }
                    System.out.printf("Total da venda: %.2f%n", valorFinal);

                    vendas.add(new Vendas(quantidade, precoUnitario, valorFinal, dia, mes, ano));
                    break;

                case 2:
                    System.out.println("Digite o valor pago pelo cliente:");
                    double pago = scanner.nextDouble();

                    if (vendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada ainda.");
                        break;
                    }

                    double ultimaVenda = vendas.get(vendas.size() - 1).valorFinal;
                    if (pago > ultimaVenda) {
                        System.out.printf("Troco: %.2f%n", pago - ultimaVenda);
                    } else if (pago < ultimaVenda) {
                        System.out.printf("Valor faltante: %.2f%n", ultimaVenda - pago);
                    } else {
                        System.out.println("Pagamento exato, sem troco.");
                    }
                    break;

                case 3:
                    System.out.println("=== Relatório de vendas ===");
                    double valorTotalVendas = 0;
                    for (Vendas v : vendas) {
                        System.out.printf("Qtd: %d, Preço Unitário: %.2f, Data: %02d/%02d/%d, Total: %.2f%n",
                                v.quantidade, v.precoUnitario, v.dia, v.mes, v.ano, v.valorFinal);
                        valorTotalVendas += v.valorFinal;
                    }
                    System.out.printf("Quantidade de vendas: %d%n", vendas.size());
                    System.out.printf("Valor total das vendas: %.2f%n", valorTotalVendas);
                    break;

                case 4:
                    System.out.println("Digite o mês e o dia para buscar a venda:");
                    int mesBusca = scanner.nextInt();
                    int diaBusca = scanner.nextInt();
                    boolean encontrado = false;
                    for (Vendas v : vendas) {
                        if (v.mes == mesBusca && v.dia == diaBusca) {
                            System.out.printf("Qtd: %d, Preço Unitário: %.2f, Data: %02d/%02d/%d, Total: %.2f%n",
                                    v.quantidade, v.precoUnitario, v.dia, v.mes, v.ano, v.valorFinal);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Nenhuma venda encontrada para a data informada.");
                    }
                    break;

                case 5:
                    scanner.nextLine(); // limpar buffer
                    System.out.println("Digite o nome do vendedor:");
                    String nomeVendedor = scanner.nextLine();
                    System.out.println("Digite a idade:");
                    int idadeVendedor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite a loja:");
                    String lojaVendedor = scanner.nextLine();
                    System.out.println("Digite o estado:");
                    String estadoV = scanner.nextLine();
                    System.out.println("Digite a cidade:");
                    String cidadeV = scanner.nextLine();
                    System.out.println("Digite o bairro:");
                    String bairroV = scanner.nextLine();
                    System.out.println("Digite a rua:");
                    String ruaV = scanner.nextLine();
                    System.out.println("Digite o número:");
                    int numeroV = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o complemento:");
                    String complementoV = scanner.nextLine();
                    Endereço enderecoV = new Endereço(estadoV, cidadeV, bairroV, ruaV, numeroV, complementoV);
                    System.out.println("Digite o salário base:");
                    double salarioBaseV = scanner.nextDouble();
                    scanner.nextLine();

                    vendedores.add(new Vend(nomeVendedor, idadeVendedor, lojaVendedor, enderecoV, salarioBaseV));
                    System.out.println("✅ Vendedor cadastrado com sucesso!");
                    break;

                case 6:
                    scanner.nextLine();
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.nextLine();
                    System.out.println("Digite a idade:");
                    int idadeCliente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite a cidade:");
                    String cidadeCliente = scanner.nextLine();
                    System.out.println("Digite o bairro:");
                    String bairroCliente = scanner.nextLine();
                    System.out.println("Digite a rua:");
                    String ruaCliente = scanner.nextLine();

                    clientes.add(new Client(nomeCliente, idadeCliente, cidadeCliente, bairroCliente, ruaCliente));
                    System.out.println("✅ Cliente cadastrado com sucesso!");
                    break;

                case 7:
                    System.out.println("=== Lista de Vendedores ===");
                    for (Vend v : vendedores) {
                        System.out.println("Nome: " + v.getNome() + ", Idade: " + v.getIdade() + ", Loja: " + v.getLoja());
                    }
                    break;

                case 8:
                    System.out.println("=== Lista de Clientes ===");
                    for (Client c : clientes) {
                        System.out.println("Nome: " + c.getNome() + ", Idade: " + c.getIdade() +
                                ", Cidade: " + c.getCidade() + ", Bairro: " + c.getBairro() + ", Rua: " + c.getRua());
                    }
                    break;

                case 9:
                    scanner.nextLine();
                    System.out.println("=== Cadastro de Item ===");
                    System.out.print("Digite o id do item: ");
                    int idItem = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do item: ");
                    String nomeItem = scanner.nextLine();
                    System.out.print("Digite o tipo: ");
                    String tipoItem = scanner.nextLine();
                    System.out.print("Digite o valor: ");
                    double valorItem = scanner.nextDouble();

                    Item novoItem = new Item(idItem, nomeItem, tipoItem, valorItem);
                    itens.add(novoItem);
                    System.out.println("✅ Item cadastrado com sucesso!");
                    break;

                case 10:
                    scanner.nextLine();
                    System.out.println("Digite o nome do gerente:");
                    String nomeGerente = scanner.nextLine();
                    System.out.println("Digite a idade:");
                    int idadeGerente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite a loja:");
                    String lojaGerente = scanner.nextLine();
                    System.out.println("Digite a cidade:");
                    String cidadeGerente = scanner.nextLine();
                    System.out.println("Digite o bairro:");
                    String bairroGerente = scanner.nextLine();
                    System.out.println("Digite a rua:");
                    String ruaGerente = scanner.nextLine();
                    System.out.println("Digite o salário base:");
                    double salarioBaseGerente = scanner.nextDouble();

                    double[] salariosRecebidos = {3000.0, 3200.0, 3500.0};
                    Gerente gerente = new Gerente(nomeGerente, idadeGerente, lojaGerente, cidadeGerente, bairroGerente, ruaGerente, salarioBaseGerente, salariosRecebidos);
                    gerentes.add(gerente);

                    gerente.apresentarse();
                    System.out.printf("Média dos salários: %.2f%n", gerente.calcularMedia());
                    System.out.printf("Bônus: %.2f%n", gerente.calcularBonus());
                    break;

                case 11:
                    
                    Client clienteFake = new Client("João Silva", 30, "São Paulo", "Centro", "Rua A");
                    Vend vendedorFake = new Vend("Maria Souza", 28, "Loja 1",
                            new Endereço("SP", "São Paulo", "Centro", "Rua B", 100, "Apto 1"), 2000.0);
                    Item item1 = new Item(1, "Planta Pothos", "Ornamental", 50.0);
                    Item item2 = new Item(2, "Planta Samambaia", "Ornamental", 40.0);

                    Pedido pedidoFake = new Pedido(1, new Date(), new Date(),
                            new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000),
                            clienteFake, vendedorFake, "Loja 1", new Item[]{item1, item2});

                    System.out.println("✅ Pedido criado com sucesso!");
                    pedidoFake.gerarDescricaoVenda();
                    System.out.printf("Valor total do pedido: %.2f%n", pedidoFake.calcularValorTotal());
                    break;

                case 12:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
