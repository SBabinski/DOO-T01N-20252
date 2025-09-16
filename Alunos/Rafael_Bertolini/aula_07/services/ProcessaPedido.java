package services;

import java.time.LocalDate;

import model.Pedido;

public abstract class ProcessaPedido {

	public boolean processar(Pedido pedido) {
		if (confirmarPagamento(pedido)) {
			System.out.println("Pedido do ID " + pedido.getId() + " foi aprovado!");
			return true;
		} else {
			System.out.println("Pedido não foi aprovado por conta da reserva vencida!");
			return false;
		}
	}



	private boolean confirmarPagamento(Pedido pedido) {
		LocalDate hoje = LocalDate.now();
		return !hoje.isAfter(pedido.getDataVencimentoReserva());
	}

}
