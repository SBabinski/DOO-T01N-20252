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

        Loja mloja = new Loja("My Plants", "12.345.678/0001-55", "Av. Brasil" ,
                "Cascavel", "FAG");
        int escolha;
        do {
            System.out.println(" Esolha uma opção: ");
            System.out.println(" [1] - Calcular Preço Total ");
            System.out.println(" [2] - Calcular Troco ");
            System.out.println(" [3] - Registro de Vendas ");
            System.out.println(" [4] - Registrar vendas do dia/mês ");
            System.out.println(" [5] - Consultar vendas do dia/mês ");
            System.out.println(" [6] - Cadastrar Vendedores ");
            System.out.println(" [7] - Cadastrar Clientes ");
            System.out.println(" [8] - Mostrar dados cadastrados");
            System.out.println(" [9] - Sair ");

            escolha = scanner.nextInt();
            scanner.nextLine();



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

                        System.out.println("Digite o nome do vendedor: ");
                        String nomeV = scanner.nextLine();

                        System.out.println("Digite a idade do vendedor: ");
                        int idadeV = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digite a loja do vendedor: ");
                        String lojaV = scanner.nextLine();

                        System.out.println("Digite a cidade do vendedor: ");
                        String cidadeV = scanner.nextLine();

                        System.out.println("Digite o bairro do vendedor: ");
                        String bairroV = scanner.nextLine();

                        System.out.println("Digite a rua do vendedor: ");
                        String ruaV = scanner.nextLine();

                        System.out.println("Digite o salário base do vendedor: ");
                        double salbaseV = Double.parseDouble(scanner.nextLine());

                        Vendedor v = new Vendedor(nomeV, idadeV, lojaV, cidadeV, bairroV, ruaV, salbaseV);
                        mloja.addVendedor(v);

                    System.out.println("Vendedores cadastrados com sucesso!");
                    break;

                case 7:

                        System.out.println("Digite o nome do cliente: ");
                        String nomeC= scanner.nextLine();

                        System.out.println("Digite a idade do cliente: ");
                        int idadeC = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite a cidade do cliente: ");
                        String cidadeC = scanner.nextLine();

                        System.out.println("Digite o bairro do cliente: ");
                        String bairroC = scanner.nextLine();

                        System.out.println("Digite a rua do cliente: ");
                        String ruaC = scanner.nextLine();

                        Cliente c = new Cliente(nomeC, idadeC, cidadeC, bairroC, ruaC);
                        mloja.addCliente(c);

                    System.out.println("Clientes cadastrados com sucesso!");
                    break;

                case 8:
                    mloja.apresentarSe();

                    System.out.println("\nVendedores: ");
                    for (int i = 0; i < mloja.vendedores.size(); i++) {
                        Vendedor vend = mloja.vendedores.get(i);
                        vend.apresentarse();
                        System.out.println("Média salários recebidos: " + vend.calcmedia());
                        System.out.println("Bônus: " + vend.calcbonus());
                    }

                    System.out.println("\nClientes: ");
                    for (int i = 0; i < mloja.clientes.size(); i++) {
                        Cliente cli = mloja.clientes.get(i);
                        cli.apresentarse();
                    }
                    break;
                case 9:
                    System.out.println("Saindo do programa... ");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");

            }
        }
        while (escolha != 9);
    }
}