package model;

import java.math.BigDecimal;

public class ValoresTroco {

	private BigDecimal valorTotal;
	private BigDecimal valorPago;
	public ValoresTroco(BigDecimal valorTotal, BigDecimal valorPago) {
		super();
		this.valorTotal = valorTotal;
		this.valorPago = valorPago;
	}
	public ValoresTroco() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getValorPago() {
		return valorPago;
	}
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	
	
	
}
