package services;

import model.Vendedores;

public class ApresentarCalcularMedia {

	Vendedores v = new Vendedores();

	public void apresentarseMediaVendedor() {

		v.getSalarioRecebido().add(2500.0);
		v.getSalarioRecebido().add(2100.0);
		v.getSalarioRecebido().add(2400.0);

		System.out.println("Média dos salários: " + v.calcularMedia());

	}
}
