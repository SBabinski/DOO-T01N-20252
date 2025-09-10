


public class Loja {
    // Atributos da classe Loja
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private Vend[] vendedores;
    private Client[] clientes;
    
    // Construtor da classe
    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new Vend[10]; // Array com capacidade para 10 vendedores
        this.clientes = new Client[50]; // Array com capacidade para 50 clientes
    }
    
    // Método contarClientes - mostra a quantidade de clientes
    public int contarClientes() {
        int count = 0;
        for (Client cliente : clientes) {
            if (cliente != null) {
                count++;
            }
        }
        return count;
    }
    
    // Método contarVendedores - mostra a quantidade de vendedores
    public int contarVendedores() {
        int count = 0;
        for (Vend vendedor : vendedores) {
            if (vendedor != null) {
                count++;
            }
        }
        return count;
    }
    
    // Método apresentarse - printa nomeFantasia, cnpj e endereco
    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
    
    // Método para adicionar vendedor
    public void adicionarVendedor(Vend vendedor) {
        for (int i = 0; i < vendedores.length; i++) {
            if (vendedores[i] == null) {
                vendedores[i] = vendedor;
                break;
            }
        }
    }
    
    // Método para adicionar cliente
    public void adicionarCliente(Client cliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                break;
            }
        }
    }
    
    // Getters e Setters para acessar os atributos
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
    
    public Vend[] getVendedores() {
        return vendedores;
    }
    
    public void setVendedores(Vend[] vendedores) {
        this.vendedores = vendedores;
    }
    
    public Client[] getClientes() {
        return clientes;
    }
    
    public void setClientes(Client[] clientes) {
        this.clientes = clientes;
    }
}
