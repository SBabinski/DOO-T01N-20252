package model;

import java.math.BigDecimal;

public class RegistroDeVendas {

	// private int ID;
	private int quantidade;
	private BigDecimal valor;

	public RegistroDeVendas(int quantidade, BigDecimal valor) {
		// this.ID = ID++;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public RegistroDeVendas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public int getID() { return ID; }
	 * 
	 * public void setID(int iD) { ID = iD; }
	 * 
	 * public void addID() { this.ID++; }
	 */

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
