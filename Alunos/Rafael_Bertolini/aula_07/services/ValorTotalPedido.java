package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Pedido;

public class ValorTotalPedido {

	public void retornaValorTotalDosPedidos(CadastroPedido cp) {

		List<Pedido> listaDePedidos = cp.listaDePedidos();

		for (Pedido pedido : listaDePedidos) {
			List<Item> listaDeItensEmPedidos = pedido.getListaItens();

			BigDecimal soma = new BigDecimal("0");
			for (Item item : listaDeItensEmPedidos) {
				soma = soma.add(item.getValor());
			}

			System.out.println("ID: " + pedido.getId() + " | Total: " + soma);

		}

	}

}
