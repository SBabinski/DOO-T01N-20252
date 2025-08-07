package model;

import java.math.BigDecimal;

public class Valores {

	private int quantidade;
	private BigDecimal valor;
	public Valores(int quantidade, BigDecimal valor) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public Valores() {
			
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
}
