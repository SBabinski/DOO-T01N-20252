package services;

import model.Loja;

public class ApresentarLoja {

	Loja loja = new Loja();

	public void apresentaLoja() {

		System.out.println("Nome da loja: " + loja.getNomeFantasia() + " | CNPJ: " + loja.getCnpj());
		System.out.println("-- Endereço da Loja --");
		System.out.println("Endereço: " + loja);

	}

}
