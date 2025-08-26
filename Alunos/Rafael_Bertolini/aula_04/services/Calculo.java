package services;

import java.math.BigDecimal;

import model.Valores;

public class Calculo {

	public BigDecimal valorTotal(Valores valores) {

		BigDecimal valorComDescontoOuNao;

		if (valores.getQuantidade() >= 10) {

			valorComDescontoOuNao = valores.getValor().multiply(BigDecimal.valueOf(valores.getQuantidade()))
					.multiply(new BigDecimal("0.95"));
			// Multiplicar BigDecimal por 0.x aplica desconto (0.95 = 5% desconto, 0.50 =
			// 50% desconto)
			// OBS: O valor deve estar entre ""
			// o new bigdecimal("0.95") dentro do multiply e porque precisa de um objeto
			// bigdecimal, so string nao funcionaria

		} else {

			valorComDescontoOuNao = valores.getValor().multiply(BigDecimal.valueOf(valores.getQuantidade()));

		}

		return valorComDescontoOuNao;
	}

}
