package services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Vendas;
import model.Valores;

public class FazendoRegistroDasVendas {

	DateTimeFormatter formatandoADataDaVenda = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	List<Vendas> listaVendas = new ArrayList<>();
	Valores valores = new Valores();

	public void adicionaVendaAListaDeVenda(int quantidade, BigDecimal valor) {

		BigDecimal valorGeral;

		if (quantidade >= 10) {

			valorGeral = valor.multiply(BigDecimal.valueOf(quantidade)).multiply(new BigDecimal("0.95"));

		} else {

			valorGeral = valor.multiply(BigDecimal.valueOf(quantidade));

		}

		String dataDaVendaFormatado = LocalDate.now().format(formatandoADataDaVenda);

		Vendas novaVenda = new Vendas(quantidade, valorGeral, dataDaVendaFormatado);
		listaVendas.add(novaVenda);

	}

	public List<Vendas> printaVendaNaTela() {
		return listaVendas;
	}

}
