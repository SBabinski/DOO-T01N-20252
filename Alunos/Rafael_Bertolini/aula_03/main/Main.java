package main;

import java.math.BigDecimal;
import java.util.Scanner;

import model.RegistroDeVendas;
import model.Valores;
import model.ValoresTroco;
import services.Calculo;
import services.FazendoRegistroDasVendas;
import services.Troco;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Valores valores = new Valores();
		ValoresTroco valoresTroco = new ValoresTroco();
		FazendoRegistroDasVendas registroVendasLista = new FazendoRegistroDasVendas();
		
		int idContador = 1;

		while (true) {
			System.out.println("Bem-vindo ao MENU!");
			System.out.println("[0] Registro de vendas.");
			System.out.println("[1] Calcular preço total.");
			System.out.println("[2] Calcular troco.");
			System.out.println("[3] Registrar venda.");
			System.out.println("[4] Sair");
			int escolha = scan.nextInt();

			switch (escolha) {

			case 0:

				for (RegistroDeVendas listaVendas : registroVendasLista.printaVendaNaTela()) {

					if (listaVendas.getQuantidade() >= 10) {
						System.out.println("ID: " + idContador++ + " | Quantidade: " + listaVendas.getQuantidade()
								+ " | Valor: " + listaVendas.getValor() + " | Possui desconto?: SIM!");
					} else {
						System.out.println("ID: " + idContador++ + " | Quantidade: " + listaVendas.getQuantidade()
								+ " | Valor: " + listaVendas.getValor() + " | Possui desconto?: NAO!");
					}
				}

				break;

			case 1:

				System.out.println("Qual a quantidade de plantas?");
				int quantidade = scan.nextInt();
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

				registroVendasLista.adicionaVendaAListaDeVenda(quantidadeVenda, valorVenda);
				System.out.println("Venda registrada!");

				break;

			case 4:

				return;

			default:
				System.out.println("Opcao invalida");
				break;

			}
		}
	}
}
