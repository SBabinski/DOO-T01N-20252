package services;

import java.math.BigDecimal;

import model.Valores;

public class Calculo {

	public BigDecimal ValorTotal(Valores valores) {
		return valores.getValor().multiply(BigDecimal.valueOf(valores.getQuantidade()));
	}
	
}
