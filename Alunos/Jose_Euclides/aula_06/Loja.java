

import java.util.ArrayList;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade; 
    private String bairro; 
    private String rua; 
    private Vendedor[] vendedores;
    private Cliente[] clientes;

    public Loja() {
        super();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Vendedor[] getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedor[] vendedores) {
        this.vendedores = vendedores;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public void contarClientes() {
        System.out.println("A quantidade de Clientes da loja é: " + this.clientes.length);
    }

    public void contarVendedores() {
        System.out.println("A quantidade de Vendedores da loja é: " + this.vendedores.length);
    }

    public void apresentarSe() {
        System.out.println("Razão Social: " + this.nomeFantasia);
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("Rua: " + this.rua);
        System.out.println("Bairro: " + this.bairro);
        System.out.println("Cidade: " + this.cidade);
    }

}


