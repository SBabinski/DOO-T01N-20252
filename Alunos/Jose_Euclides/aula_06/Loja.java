

import java.util.ArrayList;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
        System.out.println("Endereço: " + (this.endereco != null ? this.endereco.toString() : "Endereço não informado"));
    }

}


