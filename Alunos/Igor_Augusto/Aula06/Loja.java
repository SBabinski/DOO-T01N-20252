import java.util.ArrayList;
public class Loja {
    
    public String nomeFantasia;
    public String razaoSocial;
    public String cnpj;
    public String cidade;
    public String bairro;
    public String rua;

    public ArrayList<Vendedor> listaVendedores;
    public ArrayList<Cliente> listaClientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade,
     String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.listaVendedores = new ArrayList<Vendedor>();
        this.listaClientes = new ArrayList<Cliente>();
    }
   
    public void apresentar() {
        System.out.println("Loja \n Nome Fantasia: " + nomeFantasia + "\n CNPJ: " + cnpj +
         "\n Endereço: " + rua + ", " + bairro + " - " + cidade);
    }

    public void adicionarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
    }

    public void adicionarVendedor(Vendedor vendedor) {
        this.listaVendedores.add(vendedor);
    }


    public void contarClientes() {
        System.out.println("Quantidade de clientes: " + listaClientes.size());
    }

    public void contarVendedores() {
        System.out.println("Quantidade de vendedores: " + listaVendedores.size());
    }
    
    public String getNome(){
        return nomeFantasia;
    }

    @Override
    public String toString() {
        apresentar();
        return super.toString();
    }
}
