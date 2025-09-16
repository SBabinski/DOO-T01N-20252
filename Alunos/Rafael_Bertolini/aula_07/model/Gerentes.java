package model;

import java.math.BigDecimal;

public class Gerentes extends Vendedores {

	public Gerentes(String nome, Integer idade, String loja, String estado, String cidade, String bairro, int numero,
			String complemento, BigDecimal salarioBase) {
		super(nome, idade, loja, estado, cidade, bairro, numero, complemento, salarioBase);

	}

	public Gerentes() {
		super();
	}

	public double calcularMedia() {

		double somaParaMedia = 0;
		for (Double salario : getSalarioRecebido()) {
			somaParaMedia += salario;
		}
		return somaParaMedia / getSalarioRecebido().size();

	}

}
