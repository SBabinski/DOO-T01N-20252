package services;

import java.util.List;

import model.Vendedores;

public class ContaVendedores {

	public void contaVendedores(CadastroVendedores chamaListaVendedores) {

		List<Vendedores> listaDeVendedoresParaCont = chamaListaVendedores.printaVendedoresNaTela();
		int cont = 0;

		if (listaDeVendedoresParaCont.isEmpty()) {

			System.out.println("Não existe vendedor cadastrado no sistema da loja MyPlant");

		} else {

			System.out.println("A seguir, o nome de todos vendedores registrados: ");
			System.out.println(" ");

			for (Vendedores listaVendedores : listaDeVendedoresParaCont) {

				System.out.println("Nome: " + listaVendedores.getNome());
				cont++;

			}
		}

		System.out.println(" ");
		System.out.println("O numero total de vendedores é de: " + cont);

	}

}
