import java.util.Scanner;
import java.util.ArrayList;

//Segundo ela, seria ótimo poder salvar a quantidade de vendas totais em um 
//dia de um mês. Ela também gostaria de buscar a quantidade de vendas total pelo mês e dia.

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

public class Calculadora {

    public static void main(String[] args) {
        ArrayList<Venda> vendas = new ArrayList<>();

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
            System.out.println("5 - sair");
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
                    System.out.println("Encerrando Programa");
                    break;
            }
        }
    
        scanner.close();
    }


}/*  */