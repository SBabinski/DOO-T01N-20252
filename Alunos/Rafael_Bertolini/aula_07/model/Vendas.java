package model;

import java.math.BigDecimal;

public class Vendas {

	// private int ID;
	private int quantidade;
	private BigDecimal valor;
	private String dataDaVenda;

	public Vendas(int quantidade, BigDecimal valor, String dataDaVenda) {
		// this.ID = ID++;
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDaVenda = dataDaVenda;
	}

	public Vendas() {
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

	public String getDataDaVenda() {
		return dataDaVenda;
	}

	public void setDataDaVenda(String dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}
}
