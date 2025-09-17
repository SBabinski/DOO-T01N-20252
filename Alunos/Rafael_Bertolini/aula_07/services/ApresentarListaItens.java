package services;

import java.util.List;

import model.Item;

public class ApresentarListaItens {

	public void geraDescricao(CadastroItens cadItens) {

		List<Item> listItens = cadItens.chamaListaDeItens();

		if (listItens.isEmpty()) {
			System.out.println("A lista de itens esta vazia.");
			return;
		}

		for (Item item : listItens) {

			System.out.println("ID: " + item.getId() + " | Nome: " + item.getNome() + " | Descrição: " + item.getTipo()
					+ " | Valor: " + item.getValor());

		}

	}

}
