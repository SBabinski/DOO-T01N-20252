package aula_02;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        double precototal = 0.0; // Inicializa precototal antes do loop
        double totaltroco = 0.0;
        double devendo = 0.0;
        while (opcao != 3) {

            System.out.println("---- menu da caclculadora da veia ----");
            System.out.println("1 - calcular preco total");
            System.out.println("2 - calcular troco");
            System.out.println("3 - sair");
            System.out.print("Digite a opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("digite quantas plantas deseja comprar");
                    int quantidade = scanner.nextInt();

                    System.out.println("digite o preco unitario da planta");
                    double precounitario = scanner.nextDouble();

                    System.out.println("o total fica ");
                    precototal = quantidade * precounitario;
                    System.out.println(precototal);
                    break;

                case 2:
                    System.out.println("digite o valor pago do cliente da compra");
                    double troco = scanner.nextInt();

                    System.out.println("o valor da compra é de ");
                    System.out.println(precototal);

                    ;

                    if (troco > precototal) {
                        System.out.printf("valor do troco seria de:");
                        totaltroco = precototal - troco;
                        System.out.println(totaltroco);
                        break;
                    }

                    else {

                        devendo = troco - precototal;
                        System.out.println("esta faltando um valor de");
                        System.out.println(devendo);
                        break;
                    }

                case 3:
                    System.out.println("Encerrando Programa");
                    break;

            }
        }
        scanner.close();
    }

}