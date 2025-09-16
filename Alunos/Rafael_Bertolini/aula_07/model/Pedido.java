package model;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

	private int id;
	private LocalDate dataCriacao;
	private LocalDate dataPagamento;
	private LocalDate dataVencimentoReserva;
	private String cliente;
	private String vendedor;
	private String loja;
	private List<Item> listaItens;

	public Pedido(int id, LocalDate dataCriacao, LocalDate dataPagamento, LocalDate dataVencimentoReserva, String cliente,
			String vendedor, String loja, List<Item> listaItens) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.dataPagamento = dataPagamento;
		this.dataVencimentoReserva = dataVencimentoReserva;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.loja = loja;
		this.listaItens = listaItens;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public LocalDate getDataVencimentoReserva() {
		return dataVencimentoReserva;
	}

	public void setDataVencimentoReserva(LocalDate dataVencimentoReserva) {
		this.dataVencimentoReserva = dataVencimentoReserva;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public List<Item> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

}
