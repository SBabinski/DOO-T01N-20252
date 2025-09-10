import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        final int CAPACIDADE = 100;
       
        double[][] vendas = new double[CAPACIDADE][4];
        int vendasCadastradas = 0;

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n=== Calculadora da Dona Gabrielinha (Switch + Matriz) ===");
            System.out.println("[1] Calcular Total (com 5% se quantidade > 10)");
            System.out.println("[2] Registrar Venda");
            System.out.println("[3] Calcular Troco (considera desconto)");
            System.out.println("[4] Listar Vendas");
            System.out.println("[5] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1: {
                    
                    System.out.print("Quantidade (>=0): ");
                    int qtd = sc.nextInt();
                    while (qtd < 0) {
                        System.out.print("Não pode negativo. Digite de novo: ");
                        qtd = sc.nextInt();
                    }

                    System.out.print("Preço unitário (use ponto, ex.: 12.90): R$ ");
                    double unit = sc.nextDouble();
                    while (unit < 0) {
                        System.out.print("Não pode negativo. Digite de novo: R$ ");
                        unit = sc.nextDouble();
                    }

                    double bruto = qtd * unit;
                    double desc = 0.0;
                    if (qtd > 10) {
                        desc = bruto * 0.05; 
                    }
                    double total = bruto - desc;

                    System.out.printf("Bruto: R$ %.2f%n", bruto);
                    System.out.printf("Desconto: R$ %.2f%n", desc);
                    System.out.printf("Total a pagar: R$ %.2f%n", total);
                    break;
                }

                case 2: {
                    
                    if (vendasCadastradas == CAPACIDADE) {
                        System.out.println("Limite de vendas atingido.");
                        break;
                    }

                    System.out.print("Quantidade (>=0): ");
                    int qtd = sc.nextInt();
                    while (qtd < 0) {
                        System.out.print("Não pode negativo. Digite de novo: ");
                        qtd = sc.nextInt();
                    }

                    System.out.print("Preço unitário (use ponto, ex.: 12.90): R$ ");
                    double unit = sc.nextDouble();
                    while (unit < 0) {
                        System.out.print("Não pode negativo. Digite de novo: R$ ");
                        unit = sc.nextDouble();
                    }

                    double bruto = qtd * unit;
                    double desc = 0.0;
                    if (qtd > 10) {
                        desc = bruto * 0.05;
                    }
                    double total = bruto - desc;

                    
                    vendas[vendasCadastradas][0] = qtd;
                    vendas[vendasCadastradas][1] = unit;
                    vendas[vendasCadastradas][2] = desc;
                    vendas[vendasCadastradas][3] = total;
                    vendasCadastradas = vendasCadastradas + 1;

                    System.out.println("✅ Venda registrada!");
                    System.out.printf("Bruto: R$ %.2f | Desc: R$ %.2f | Total: R$ %.2f%n",
                            bruto, desc, total);
                    break;
                }

                case 3: {
                   
                    System.out.print("Quantidade (>=0): ");
                    int qtd = sc.nextInt();
                    while (qtd < 0) {
                        System.out.print("Não pode negativo. Digite de novo: ");
                        qtd = sc.nextInt();
                    }

                    System.out.print("Preço unitário (use ponto, ex.: 12.90): R$ ");
                    double unit = sc.nextDouble();
                    while (unit < 0) {
                        System.out.print("Não pode negativo. Digite de novo: R$ ");
                        unit = sc.nextDouble();
                    }

                    double bruto = qtd * unit;
                    double desc = 0.0;
                    if (qtd > 10) {
                        desc = bruto * 0.05;
                    }
                    double total = bruto - desc;
                    System.out.printf("Total a pagar: R$ %.2f%n", total);

                    System.out.print("Valor recebido: R$ ");
                    double recebido = sc.nextDouble();
                    while (recebido < 0) {
                        System.out.print("Não pode negativo. Digite de novo: R$ ");
                        recebido = sc.nextDouble();
                    }

                    double troco = recebido - total;
                    if (troco < 0) {
                        System.out.printf("Faltam R$ %.2f%n", -troco);
                    } else {
                        System.out.printf("Troco: R$ %.2f%n", troco);
                    }
                    break;
                }

                case 4: {
                    // Listar vendas da matriz
                    if (vendasCadastradas == 0) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        System.out.println("--- Vendas ---");
                        int i = 0;
                        while (i < vendasCadastradas) {
                            System.out.printf(
                                "#%d | Qtd: %d | Unit: R$ %.2f | Desc: R$ %.2f | Total: R$ %.2f%n",
                                (i + 1),
                                (int) vendas[i][0],
                                vendas[i][1],
                                vendas[i][2],
                                vendas[i][3]
                            );
                            i = i + 1;
                        }
                    }
                    break;
                }

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
