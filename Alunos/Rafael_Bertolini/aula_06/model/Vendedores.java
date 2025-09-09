package model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Vendedores {

	private String nome;
	private Integer idade;
	private String loja;
	private String cidade;
	private String bairro;
	private String rua;
	private BigDecimal salarioBase;
	private ArrayList<Double> salarioRecebido = new ArrayList<>();

	public Vendedores(String nome, Integer idade, String loja, String cidade, String barro, String rua,
			BigDecimal salarioBase) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.loja = loja;
		this.cidade = cidade;
		this.bairro = barro;
		this.rua = rua;
		this.salarioBase = salarioBase;
		salarioRecebido = new ArrayList<>();

	}

	public Vendedores() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBarro() {
		return bairro;
	}

	public void setBarro(String barro) {
		this.bairro = barro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public BigDecimal getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(BigDecimal salarioBase) {
		this.salarioBase = salarioBase;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public ArrayList<Double> getSalarioRecebido() {
		return salarioRecebido;
	}

	public void setSalarioRecebido(ArrayList<Double> salarioRecebido) {
		this.salarioRecebido = salarioRecebido;
	}

	public double calcularMedia() {

		double somaParaMedia = 0;
		for (Double dafdadf : salarioRecebido) {
			somaParaMedia += dafdadf;
		}
		return somaParaMedia / salarioRecebido.size();
	}
	
}
