package services;

import java.math.BigDecimal;

import model.ValoresTroco;

public class Troco {

	public BigDecimal ResultadoDoTroco(ValoresTroco troco) {
		
		BigDecimal valortroco = troco.getValorTotal().subtract(troco.getValorPago());
		return valortroco;
	}
	
}
