package model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Vendedores extends Endereço {

	private String nome;
	private Integer idade;
	private String loja;
//	private Endereço endereço;
	private BigDecimal salarioBase;
	private ArrayList<Double> salarioRecebido = new ArrayList<>();

	public Vendedores(String nome, Integer idade, String loja, String estado, String cidade, String bairro, int numero, String complemento, BigDecimal salarioBase) {
		super(estado, cidade, bairro, numero, complemento);
		this.nome = nome;
		this.idade = idade;
		this.loja = loja;
		//this.endereço = endereço;
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

	public BigDecimal getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(BigDecimal salarioBase) {
		this.salarioBase = salarioBase;
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
