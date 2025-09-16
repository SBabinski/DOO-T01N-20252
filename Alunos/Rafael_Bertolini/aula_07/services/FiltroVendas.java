package services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Vendas;

public class FiltroVendas {

	// FazendoRegistroDasVendas teste = new FazendoRegistroDasVendas();
	DateTimeFormatter mostrandoProSistemaQualFormataçãoDeDataFoiUsada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public void filtrandoVendaPorDia(int mesParaDiaFiltro, int diaDesejadoParaFiltro,
			FazendoRegistroDasVendas listaParaOFor) {

		int vendasFeitasFiltrandoPorDia = 1;

		for (Vendas listaVendas : listaParaOFor.printaVendaNaTela()) {

			LocalDate tirandoFormataçãoDaData = LocalDate.parse(listaVendas.getDataDaVenda(),
					mostrandoProSistemaQualFormataçãoDeDataFoiUsada);
			// Converte a data que está como String em um objeto LocalDate para
			// permitir comparações e manipulações

			if (tirandoFormataçãoDaData.getDayOfMonth() == diaDesejadoParaFiltro
					&& tirandoFormataçãoDaData.getMonthValue() == mesParaDiaFiltro) {

				if (listaVendas.getQuantidade() >= 10) {
					System.out.println("Número da venda: " + vendasFeitasFiltrandoPorDia++ + " | Quantidade: "
							+ listaVendas.getQuantidade() + " | Valor: " + listaVendas.getValor()
							+ "\n Data em que a venda foi registrada: " + listaVendas.getDataDaVenda()
							+ " | Possui desconto?: SIM!" + "\n");
				} else {
					System.out.println("Número da venda: " + vendasFeitasFiltrandoPorDia++ + " | Quantidade: "
							+ listaVendas.getQuantidade() + " | Valor: " + listaVendas.getValor()
							+ "\n Data em que a venda foi registrada: " + listaVendas.getDataDaVenda()
							+ " | Possui desconto?: NAO!" + "\n");
				}

			} else {

				System.out.println("O dia nao contem nenhuma venda registrada! \n");
				break;

			}
		}
	}

	public void filtrandoVendaPorMes(int anoParaSaberOMesDoFiltro, int mesDesejadoParaFiltro,
			FazendoRegistroDasVendas listaParaOForFiltroMes) {

		int vendasFeitasFiltrandoPorMes = 1;

		for (Vendas listaVendas : listaParaOForFiltroMes.printaVendaNaTela()) {

			LocalDate tirandoFormataçãoDaDataParaFiltroMes = LocalDate.parse(listaVendas.getDataDaVenda(),
					mostrandoProSistemaQualFormataçãoDeDataFoiUsada);
			// Converte a data que está como String em um objeto LocalDate para
			// permitir comparações e manipulações

			if (tirandoFormataçãoDaDataParaFiltroMes.getMonthValue() == mesDesejadoParaFiltro
					&& tirandoFormataçãoDaDataParaFiltroMes.getYear() == anoParaSaberOMesDoFiltro) {

				if (listaVendas.getQuantidade() >= 10) {
					System.out.println("Número da venda: " + vendasFeitasFiltrandoPorMes++ + " | Quantidade: "
							+ listaVendas.getQuantidade() + " | Valor: " + listaVendas.getValor()
							+ "\n Data em que a venda foi registrada: " + listaVendas.getDataDaVenda()
							+ " | Possui desconto?: SIM!" + "\n");
				} else {
					System.out.println("Número da venda: " + vendasFeitasFiltrandoPorMes++ + " | Quantidade: "
							+ listaVendas.getQuantidade() + " | Valor: " + listaVendas.getValor()
							+ "\n Data em que a venda foi registrada: " + listaVendas.getDataDaVenda()
							+ " | Possui desconto?: NAO!" + "\n");
				}

			} else {

				System.out.println("O mês nao contem nenhuma venda registrada! \n");
				break;

			}
		}

	}
}
