import java.util.Scanner;
import java.util.ArrayList;

import aula_06.Vendedor.Vend;
import aula_06.Cliente.Client;


class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;
}



class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
}

class Venda {
    int quantidade;
    double precoUnitario;
    double valorFinal;
    int dia;
    int mes;
    int ano;

    public Venda(int quantidade, double precoUnitario, double valorFinal, int dia, int mes, int ano) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorFinal = valorFinal;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
}

public class Main {

    public static void main(String[] args) {
        ArrayList<Venda> vendas = new ArrayList<>();
        ArrayList<Vend> vendedores = new ArrayList<>();
        ArrayList<Client> clientes = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        double precototal = 0.0; // Inicializa precototal antes do loop
        double totaltroco = 0.0;
        double totaldsc = 0.0;
        double devendo = 0.0;
        double desconto = 0.0;
        double valorFinal = 0.0;
        int dia = 0;
        int mes = 0;
        int ano = 0;

        while (opcao != 5) {

            System.out.println("---- menu da caclculadora da veia ----");
            System.out.println("1 - Venda");
            System.out.println("2 - troco");
            System.out.println("3 - Relatório vendas");
            System.out.println("4 - Buscar Venda");
            System.out.println("5 - Cadastrar vendedor");
            System.out.println("6 - Cadastrar cliente");
            System.out.println("7 - Listar vendedores");
            System.out.println("8 - Listar clientes");
            System.out.println("9 - Sair");
            System.out.print("Digite a opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    System.out.println("Digite o dia da venda:");
                    dia = scanner.nextInt();
                    System.out.println("Digite o mês da venda:");
                    mes = scanner.nextInt();
                    System.out.println("Digite o ano da venda:");
                    ano = scanner.nextInt();

                    System.out.println("digite quantas plantas deseja comprar");

                    System.out.println();

                    System.out.println("se comprar +10  vc ganha desconto de 5%");

                    System.out.println();

                    int quantidade = scanner.nextInt();

                    System.out.println("digite o preco unitario da planta");

                    double precounitario = scanner.nextDouble();

                    precototal = quantidade * precounitario;

                    if (quantidade > 10) {

                        desconto = precototal * 0.05;

                        System.out.println("desconto é");
                        System.out.printf("%.2f%n", desconto);
                        System.out.println();

                        System.out.println("total com 5% de desconto é:");
                        System.out.println();
                        totaldsc = precototal - desconto;
                        System.out.println(totaldsc);
                        valorFinal = totaldsc;
                    } else {

                        System.out.println("total é:");
                        System.out.println();
                        System.out.println(precototal);
                        valorFinal = precototal;
                    }

                    vendas.add(new Venda(quantidade, precounitario, valorFinal, dia, mes, ano));

                    break;

                case 2:
                    System.out.println("digite o valor pago do cliente da compra");
                    double troco = scanner.nextInt();

                    System.out.println("o valor da compra é de ");
                    System.out.println(valorFinal);

                    if (troco > valorFinal) {
                        System.out.println("valor do troco é:");
                        totaltroco = troco - valorFinal;
                        System.out.println();
                        System.out.printf("%.2f%n", totaltroco);
                    } else if (troco < valorFinal) {
                        devendo = troco - valorFinal;
                        System.out.println();
                        System.out.println("esta faltando o valor de ");
                        System.out.printf("%.2f%n", devendo);

                    }

                case 3:
                    System.out.println("Lista de vendas:");
                    double valuetotal = 0;
                    for (Venda v : vendas) {
                        System.out.printf("Qtd: %d, Preço Unitário: %.2f, Dia: %d, Mês: %d, Ano: %d, Total: %.2f%n",
                                v.quantidade, v.precoUnitario, v.dia, v.mes, v.ano, v.valorFinal);
                        valuetotal += v.valorFinal;
                    }
                    System.out.println("\na quantidade de vendas é : " + vendas.size());
                    System.out.println("\nValor total das vendas: " + valuetotal);

                    break;
                case 4:
                    System.out.println("\ndigite um mes e um dia desse mes para buscar a venda");
                    mes = scanner.nextInt();
                    dia = scanner.nextInt();
                    boolean found = false;
                    for (Venda v : vendas) {
                        if (v.mes == mes && v.dia == dia) {
                            System.out.printf("Qtd: %d, Preço Unitário: %.2f, Dia: %d, Mês: %d, Ano: %d, Total: %.2f%n",
                                    v.quantidade, v.precoUnitario, v.dia, v.mes, v.ano, v.valorFinal);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Nenhuma venda encontrada para o mês e dia informados.");
                    }

                    break;

                case 5:
                    System.out.println("Digite o nome do vendedor:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a idade do vendedor:");
                    int idade = scanner.nextInt();
                    System.out.println("Digite a loja do vendedor:");
                    String loja = scanner.nextLine();
                    System.out.println("Digite a cidade do vendedor:");
                    String cidade = scanner.nextLine();
                    System.out.println("Digite o bairro do vendedor:");
                    String bairro = scanner.nextLine();
                    System.out.println("Digite a rua do vendedor:");
                    String rua = scanner.nextLine();
                    System.out.println("Digite o salario base do vendedor:");
                    double salarioBase = scanner.nextDouble();
                    vendedores.add(new Vend(nome, idade, loja, cidade, bairro, rua, salarioBase));
                    break;

                case 6:
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.nextLine();
                    System.out.println("Digite a idade do cliente:");
                    int idadeCliente = scanner.nextInt();
                    scanner.nextLine(); // Consumir o \n pendente após nextInt()
                    System.out.println("Digite a cidade do cliente:");
                    String cidadeCliente = scanner.nextLine();
                    System.out.println("Digite o bairro do cliente:");
                    String bairroCliente = scanner.nextLine();
                    System.out.println("Digite a rua do cliente:");
                    String ruaCliente = scanner.nextLine();
                    clientes.add(new Client(nomeCliente, idadeCliente, cidadeCliente, bairroCliente, ruaCliente));
                    break;

                case 7:
                    System.out.println("Lista de vendedores:");
                    for (Vend v : vendedores) {
                        System.out.println(
                                "Nome: " + v.getNome() + ", Idade: " + v.getIdade() + ", Loja: " + v.getLoja());
                    }
                    break;

                case 8:
                    System.out.println("Lista de clientes:");
                    for (Client c : clientes) {
                        System.out.println("Nome: " + c.getNome() + ", Idade: " + c.getIdade() + ", Cidade: "
                                + c.getCidade() + ", Bairro: " + c.getBairro() + ", Rua: " + c.getRua());
                    }
                    break;

                case 9:
                    System.out.println("Encerrando Programa");
                    break;
            }
        }

        scanner.close();
    }

}/*  */