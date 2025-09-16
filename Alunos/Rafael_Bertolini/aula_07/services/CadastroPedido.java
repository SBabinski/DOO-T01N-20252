package services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Clientes;
import model.Item;
import model.Loja;
import model.Pedido;
import model.Vendedores;

public class CadastroPedido {

	ProcessaPedidoConcreto pd = new ProcessaPedidoConcreto();
	static Scanner scan = new Scanner(System.in);
	Loja loja = new Loja();
	List<Pedido> listaDePedidos = new ArrayList<>();

	public void cadastrandoPedido(CadastroItens itens, CadastroDeClientes clientes, CadastroVendedores vendedores,
			int ID) {

		DateTimeFormatter avisandoSistemaDoFormatoDaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataDoPedido = LocalDate.now();

		List<Item> listaItensPedido = itens.chamaListaDeItens();
		List<Clientes> listaClientes = clientes.chamaListaDeClientes();
		List<Vendedores> listaVendedores = vendedores.printaVendedoresNaTela();

		if (listaClientes.isEmpty()) {
			System.out.println("Não existe clientes para registrar um pedido.");
			return;
		}

		if (listaVendedores.isEmpty()) {
			System.out.println("Não existe vendedores para registrar um pedido.");
			return;
		}

		if (listaItensPedido.isEmpty()) {
			System.out.println("Não existe Itens registrados para fazer um pedido.");
			return;
		}

		System.out.println("Qual será a data de pagamento prevista? (Digite em dia/mês/ano");
		String dataPagamentoPrevista = scan.nextLine();
		LocalDate dataPagamento = LocalDate.parse(dataPagamentoPrevista, avisandoSistemaDoFormatoDaData);

		System.out.println("Qual data de vencimento da reserva? (Digite em dia/mês/ano");
		String dataVencimentoReserva = scan.nextLine();
		LocalDate dataVencimento = LocalDate.parse(dataVencimentoReserva, avisandoSistemaDoFormatoDaData);
		System.out.println();

		int numeroCliente = 1;
		System.out.println("Clientes:");
		for (Clientes cliente : listaClientes) {
			System.out.println("[" + numeroCliente + "]" + " | Nome: " + cliente.getNome());
			numeroCliente++;
		}
		System.out.println("Qual cliente você deseja registrar o pedido?");
		int escolhaCliente = scan.nextInt();
		scan.nextLine();
		String clienteSelecionado = listaClientes.get(escolhaCliente - 1).getNome();

		int numeroVendedor = 1;
		System.out.println("Vendedores:");
		for (Vendedores vendedor : listaVendedores) {
			System.out.println("[" + numeroVendedor + "]" + " | Nome: " + vendedor.getNome());
			numeroVendedor++;
		}
		System.out.println("Qual vendedor está registrando o pedido?");
		int escolhaVendedor = scan.nextInt();
		scan.nextLine();
		String vendedorSelecionado = listaVendedores.get(escolhaVendedor - 1).getNome();

		String nomeDaLoja = loja.getNomeFantasia();

		int contMostraListaItem = 1;
		for (Item item : listaItensPedido) {
			System.out.println("[" + contMostraListaItem + "]" + "| Nome do Item: " + item.getNome());
			contMostraListaItem++;
		}

		List<Item> itensEscolhidos = new ArrayList<>();

		while (true) {

			System.out.println("Qual item deseja selecionar pelo número? (Digite 0 para sair)");
			int escolhaItem = scan.nextInt();
			scan.nextLine();
			if (escolhaItem == 0) {
				break;
			}

			Item itemEscolhido = listaItensPedido.get(escolhaItem - 1);
			itensEscolhidos.add(itemEscolhido);

			System.out.println("Deseja adicionar outro item? (S/N)");
			String continuar = scan.nextLine();
			if (continuar.equalsIgnoreCase("N")) {
				break;
			}

		}

		System.out.println("Pedido cadastrado!");

		Pedido novoPedido = new Pedido(ID, dataDoPedido, dataPagamento, dataVencimento, clienteSelecionado,
				vendedorSelecionado, nomeDaLoja, itensEscolhidos);
		
		if (pd.processar(novoPedido)) {
		    listaDePedidos.add(novoPedido);
		}


	}

	public List<Pedido> listaDePedidos() {
		return listaDePedidos;
	}
	
}
