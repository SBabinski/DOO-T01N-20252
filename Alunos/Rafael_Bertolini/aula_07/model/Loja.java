package model;

public class Loja extends Endereço {

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;

	public Loja() {
		super("Parana", "Cascavel", "Centro", 123, "Próximo a catedral");
		this.nomeFantasia = "MyPlant";
		this.razaoSocial = "MyPlant Comércio e Distribuição de Plantas LTDA";
		this.cnpj = "45.987.321/0001-12";

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

}
