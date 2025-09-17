package services;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.Item;
import model.Pedido;

public class ApresentarPedidos {

	public void apresentandoPedidos(CadastroPedido cp, ValorTotalPedido vtp) {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Pedido> listaPedidos = cp.listaDePedidos();

		for (Pedido pedido : listaPedidos) {
			List<Item> listaDeItensEmPedidos = pedido.getListaItens();

			BigDecimal soma = new BigDecimal("0");
			for (Item item : listaDeItensEmPedidos) {
				soma = soma.add(item.getValor());
			}

			String data = pedido.getDataCriacao().format(format);

			System.out.println("ID: " + pedido.getId() + "| Data: " + data + " | Total: " + soma);

		}

	}

}
