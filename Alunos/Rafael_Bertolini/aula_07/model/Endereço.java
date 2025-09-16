package model;

public class Endereço {

	private String estado;
	private String cidade;
	private String bairro;
	private int numero;
	private String complemento;

	public Endereço(String estado, String cidade, String bairro, int numero, String complemento) {
		super();
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
	}

	public Endereço() {
		super();

	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Estado = " + estado + ", Cidade = " + cidade + ", Bairro = " + bairro + ", Numero = " + numero
				+ ", Complemento = " + complemento;
	}

	
	
}
