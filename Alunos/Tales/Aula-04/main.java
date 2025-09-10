import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int CAPACIDADE = 100;

     
        double[][] vendas = new double[CAPACIDADE][4];
   
        int[] diasVenda = new int[CAPACIDADE];
        int[] mesesVenda = new int[CAPACIDADE];

        int vendasCadastradas = 0;

       
        int[][] numVendasPorDia = new int[13][32];
        int[][] itensPorDia = new int[13][32];
        double[][] faturamentoPorDia = new double[13][32];

        int opcao = 0;
        while (opcao != 7) {
            System.out.println("\n=== Calculadora da Dona Gabrielinha (Switch + Matriz) ===");
            System.out.println("[1] Calcular Total (com 5% se quantidade > 10)");
            System.out.println("[2] Registrar Venda");
            System.out.println("[3] Calcular Troco (considera desconto)");
            System.out.println("[4] Listar Vendas");
            System.out.println("[5] Consultar Total por Dia (mês e dia)");
            System.out.println("[6] Consultar Total do Mês (resumo do mês)");
            System.out.println("[7] Sair");
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

                
                    System.out.print("Mês da venda (1-12): ");
                    int mes = sc.nextInt();
                    while (mes < 1 || mes > 12) {
                        System.out.print("Valor inválido. Informe o mês (1-12): ");
                        mes = sc.nextInt();
                    }

                    System.out.print("Dia da venda (1-31): ");
                    int dia = sc.nextInt();
                    while (dia < 1 || dia > 31) {
                        System.out.print("Valor inválido. Informe o dia (1-31): ");
                        dia = sc.nextInt();
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
                    diasVenda[vendasCadastradas] = dia;
                    mesesVenda[vendasCadastradas] = mes;
                    vendasCadastradas = vendasCadastradas + 1;

                    numVendasPorDia[mes][dia] += 1;     
                    itensPorDia[mes][dia] += qtd;       
                    faturamentoPorDia[mes][dia] += total; 
              

                    System.out.println("✅ Venda registrada!");
                    System.out.printf("Data: %02d/%02d | Bruto: R$ %.2f | Desc: R$ %.2f | Total: R$ %.2f%n",
                            dia, mes, bruto, desc, total);
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
                    if (vendasCadastradas == 0) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        System.out.println("--- Vendas ---");
                        int i = 0;
                        while (i < vendasCadastradas) {
                            System.out.printf(
                                "#%d | Data: %02d/%02d | Qtd: %d | Unit: R$ %.2f | Desc: R$ %.2f | Total: R$ %.2f%n",
                                (i + 1),
                                diasVenda[i],
                                mesesVenda[i],
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

                case 5: { 
                    System.out.print("Mês (1-12): ");
                    int mes = sc.nextInt();
                    while (mes < 1 || mes > 12) {
                        System.out.print("Valor inválido. Informe o mês (1-12): ");
                        mes = sc.nextInt();
                    }

                    System.out.print("Dia (1-31): ");
                    int dia = sc.nextInt();
                    while (dia < 1 || dia > 31) {
                        System.out.print("Valor inválido. Informe o dia (1-31): ");
                        dia = sc.nextInt();
                    }

                    int qVendas = numVendasPorDia[mes][dia];
                    int qItens = itensPorDia[mes][dia];
                    double fat = faturamentoPorDia[mes][dia];

                    System.out.println("--- Totais do dia ---");
                    System.out.printf("Data: %02d/%02d%n", dia, mes);
                    System.out.printf("Número de vendas: %d%n", qVendas);
                    System.out.printf("Itens vendidos: %d%n", qItens);
                    System.out.printf("Faturamento: R$ %.2f%n", fat);
                    if (qVendas == 0) {
                        System.out.println("(Sem movimento neste dia)");
                    }
                    break;
                }

                case 6: { // Consultar total do mês
                    System.out.print("Mês (1-12): ");
                    int mes = sc.nextInt();
                    while (mes < 1 || mes > 12) {
                        System.out.print("Valor inválido. Informe o mês (1-12): ");
                        mes = sc.nextInt();
                    }

                    int totalVendasMes = 0;
                    int totalItensMes = 0;
                    double totalFatMes = 0.0;

                    for (int d = 1; d <= 31; d++) {
                        totalVendasMes += numVendasPorDia[mes][d];
                        totalItensMes += itensPorDia[mes][d];
                        totalFatMes += faturamentoPorDia[mes][d];
                    }

                    System.out.println("--- Resumo do mês ---");
                    System.out.printf("Mês: %02d%n", mes);
                    System.out.printf("Número de vendas no mês: %d%n", totalVendasMes);
                    System.out.printf("Itens vendidos no mês: %d%n", totalItensMes);
                    System.out.printf("Faturamento no mês: R$ %.2f%n", totalFatMes);

                    if (totalVendasMes == 0) {
                        System.out.println("(Sem movimento neste mês)");
                    } else {
                        System.out.println("\nDias com movimento:");
                        for (int d = 1; d <= 31; d++) {
                            int qV = numVendasPorDia[mes][d];
                            if (qV > 0) {
                                System.out.printf(" - %02d/%02d | Vendas: %d | Itens: %d | Fat: R$ %.2f%n",
                                        d, mes, qV, itensPorDia[mes][d], faturamentoPorDia[mes][d]);
                            }
                        }
                    }
                    break;
                }

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
