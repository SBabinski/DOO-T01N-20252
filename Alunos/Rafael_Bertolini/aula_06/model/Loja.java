package model;

public class Loja {

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String cidade;
	private String bairro;
	private String rua;

	public Loja() {
		super();
		this.nomeFantasia = "MyPlant";
		this.razaoSocial = "MyPlant Comércio e Distribuição de Plantas LTDA";
		this.cnpj = "45.987.321/0001-12";
		this.cidade = "Alagoinha";
		this.bairro = "Alagoinhazinha";
		this.rua = "Alagoinhazinhainha";
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

}
