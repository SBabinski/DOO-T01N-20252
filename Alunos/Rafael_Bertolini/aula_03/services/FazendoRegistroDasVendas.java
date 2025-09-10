package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.RegistroDeVendas;
import model.Valores;

public class FazendoRegistroDasVendas {

	List<RegistroDeVendas> listaVendas = new ArrayList<>();
	Valores valores = new Valores();

	public void adicionaVendaAListaDeVenda(int quantidade, BigDecimal valor) {

		BigDecimal valorGeral;

		if (quantidade >= 10) {

			valorGeral = valor.multiply(BigDecimal.valueOf(quantidade)).multiply(new BigDecimal("0.95"));

		} else {

			valorGeral = valor.multiply(BigDecimal.valueOf(quantidade));

		}

		RegistroDeVendas novaVenda = new RegistroDeVendas(quantidade, valorGeral);
		listaVendas.add(novaVenda);

	}

	public List<RegistroDeVendas> printaVendaNaTela() {
		return listaVendas;
	}

}
