package model;

public class Clientes extends Endereço {

	private String nome;
	private int idade;

	public Clientes(String nome, int idade, String estado, String cidade, String bairro, int numero,
			String complemento) {
		super(estado, cidade, bairro, numero, complemento);
		this.nome = nome;
		this.idade = idade;
	}

	public Clientes() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
