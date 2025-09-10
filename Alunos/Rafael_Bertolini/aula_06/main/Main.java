package main;

import java.math.BigDecimal;
import java.util.Scanner;

import model.RegistroDeVendas;
import model.Valores;
import model.ValoresTroco;
import services.ApresentarCalcularMedia;
import services.ApresentarClientes;
import services.ApresentarLoja;
import services.CadastroDeClientes;
import services.CadastroVendedores;
import services.Calculo;
import services.CalculoBonusVendedores;
import services.ContaClientes;
import services.ContaVendedores;
import services.FazendoRegistroDasVendas;
import services.FiltroVendas;
import services.Troco;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// DateTimeFormatter formatandoADataDaVenda =
		// DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Valores valores = new Valores();
		ValoresTroco valoresTroco = new ValoresTroco();
		FazendoRegistroDasVendas registroVendasLista = new FazendoRegistroDasVendas();
		FiltroVendas chamandoFiltroDeVendas = new FiltroVendas();
		CadastroVendedores chamandoCadastroDeVendedores = new CadastroVendedores();
		ApresentarCalcularMedia chamandoCalculoDeMediaDosVendedores = new ApresentarCalcularMedia();
		CalculoBonusVendedores chamandoOCalculoDeBonusParaOsVendedores = new CalculoBonusVendedores();
		CadastroDeClientes cadastroDeClientes = new CadastroDeClientes();
		ApresentarClientes apresentarClientes = new ApresentarClientes();
		ContaClientes contaClientes = new ContaClientes();
		ContaVendedores contaVendedores = new ContaVendedores();
		ApresentarLoja loja = new ApresentarLoja();

		int numeroDeVendasNaListaTotal = 1;

		while (true) {
			System.out.println(" ");
			System.out.println("Bem-vindo ao MENU!");
			System.out.println("[0] Registro de vendas.");
			System.out.println("[1] Calcular preço total.");
			System.out.println("[2] Calcular troco.");
			System.out.println("[3] Registrar venda.");
			System.out.println("[4] Cadastrar vendedor.");
			System.out.println("[5] Cadastrar cliente.");
			System.out.println("[6] Lista de clientes.");
			System.out.println("[7] Saber salario dos vendedores com bonus.");
			System.out.println("[8] Média salarial dos vendedores.");
			System.out.println("[9] Contador de quantos vendedores e clientes exitem na loja");
			System.out.println("[10] Detalhes da Loja.");
			System.out.println("[11] Sair");
			int escolha = scan.nextInt();
			scan.nextLine();

			switch (escolha) {

			case 0:

				System.out.println("Selecione qual opção você deseja:");
				System.out.println("[1] - Ver todas as vendas.");
				System.out.println("[2] - Filtrar vendas pelo dia.");
				System.out.println("[3] - Filtrar vendas pelo mês.");
				int escolhaDaOpcaoNoRegistroDeVendas = scan.nextInt();

				switch (escolhaDaOpcaoNoRegistroDeVendas) {

				case 1:
					for (RegistroDeVendas listaVendas : registroVendasLista.printaVendaNaTela()) {

						if (listaVendas.getQuantidade() >= 10) {
							System.out.println("Número da venda: " + numeroDeVendasNaListaTotal++ + " | Quantidade: "
									+ listaVendas.getQuantidade() + " | Valor: " + listaVendas.getValor()
									+ "\n Data em que a venda foi registrada: " + listaVendas.getDataDaVenda()
									+ " | Possui desconto?: SIM!" + "\n");
						} else {
							System.out.println("Número da venda: " + numeroDeVendasNaListaTotal++ + " | Quantidade: "
									+ listaVendas.getQuantidade() + " | Valor: " + listaVendas.getValor()
									+ "\n Data em que a venda foi registrada: " + listaVendas.getDataDaVenda()
									+ " | Possui desconto?: NAO!" + "\n");
						}
					}
					break;

				case 2:
					System.out.println("Informe de qual mes voce quer saber o dia da venda:");
					int mesParaFiltroDeDia = scan.nextInt();
					scan.nextLine();
					System.out.println("Informe qual dia você deseja saber as vendas.");
					int diaFiltradoParaSaberAsVendas = scan.nextInt();
					scan.nextLine();

					if (diaFiltradoParaSaberAsVendas > 0 && diaFiltradoParaSaberAsVendas < 32) {

						chamandoFiltroDeVendas.filtrandoVendaPorDia(mesParaFiltroDeDia, diaFiltradoParaSaberAsVendas,
								registroVendasLista);
						break;

					} else {

						System.out.println("Dia invalido!");
						break;

					}

				case 3:

					System.out.println("Informe o ano do mês que você deseja saber as vendas.");
					int anoParaSaberOMesDoFiltro = scan.nextInt();
					scan.nextLine();
					System.out.println("Informe qual mês você deseja saber as vendas.");
					int mesFiltradoParaSaberAsVendas = scan.nextInt();
					scan.nextLine();

					if (mesFiltradoParaSaberAsVendas > 0 && mesFiltradoParaSaberAsVendas < 12) {

						chamandoFiltroDeVendas.filtrandoVendaPorMes(anoParaSaberOMesDoFiltro,
								mesFiltradoParaSaberAsVendas, registroVendasLista);

					} else {

						System.out.println("Mês invalido!");
						break;

					}

				}// fim do case dentro do registro de vendas

				break;

			case 1:

				System.out.println("Qual a quantidade de plantas?");
				int quantidade = scan.nextInt();
				scan.nextLine();
				System.out.println("Qual valor unitario da planta?");
				BigDecimal valor = scan.nextBigDecimal();
				valores.setQuantidade(quantidade);
				valores.setValor(valor);

				Calculo calculo = new Calculo();
				BigDecimal total = calculo.valorTotal(valores);
				System.out.println("O preço total foi de: " + total + "R$");
				break;

			case 2:

				System.out.println("Qual o valor total do produto?");
				BigDecimal valorTotalProduto = scan.nextBigDecimal();
				System.out.println("Qual valor pago pelo cliente?");
				BigDecimal valorPagoPeloCliente = scan.nextBigDecimal();
				valoresTroco.setValorPago(valorPagoPeloCliente);
				valoresTroco.setValorTotal(valorTotalProduto);

				Troco troco = new Troco();
				BigDecimal resultadoFinalDoTroco = troco.resultadoDoTroco(valoresTroco);
				System.out.println("O troco deve ser: " + resultadoFinalDoTroco + "R$");
				break;

			case 3:

				System.out.println("Qual a quantidade de plantas?");
				int quantidadeVenda = scan.nextInt();
				System.out.println("Qual valor unitario da planta?");
				BigDecimal valorVenda = scan.nextBigDecimal();

				// LocalDate dataNaHoraDoRegistroDaVenda = LocalDate.now();
				// String dataNaHoraDoRegistroDaVendaFormatado =
				// dataNaHoraDoRegistroDaVenda.format(formatandoADataDaVenda);

				registroVendasLista.adicionaVendaAListaDeVenda(quantidadeVenda, valorVenda);
				System.out.println("Venda registrada!");

				break;

			case 4:

				chamandoCadastroDeVendedores.cadastrandoVendedores();
				break;

			case 5:

				cadastroDeClientes.cadastrandoCliente();

				break;

			case 6:

				apresentarClientes.apresentarseClientes(cadastroDeClientes);

				break;

			case 7:

				chamandoOCalculoDeBonusParaOsVendedores
						.apresentarseCalculoBonusDeVendedores(chamandoCadastroDeVendedores);

				break;

			case 8:

				chamandoCalculoDeMediaDosVendedores.apresentarseMediaVendedor();

				break;

			case 9:

				contaClientes.contaClientes(cadastroDeClientes);
				contaVendedores.contaVendedores(chamandoCadastroDeVendedores);

				break;

			case 10:

				loja.apresentaLoja();

				break;

			case 11:

				return;

			default:
				System.out.println("Opcao invalida");
				break;

			}
		}
	}
}
