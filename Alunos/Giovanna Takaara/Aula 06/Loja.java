import java.util.ArrayList;

public class Loja {
        String nomeFantasia;
        String razaoSocial;
        String cnpj;
        String cidade;
        String bairro;
        String rua;
        ArrayList<Vendedor> vendedores;
        ArrayList<Cliente> clientes;


        public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
            this.nomeFantasia = nomeFantasia;
            this.razaoSocial = razaoSocial;
            this.cnpj = cnpj;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.vendedores = new ArrayList<>();
            this.clientes = new ArrayList<>();
        }

        public void adicionarVendedor(Vendedor v) {
            vendedores.add(v);
        }

        public void adicionarCliente(Cliente c) {
            clientes.add(c);
        }

        public void contarClientes() {
            System.out.println("Quantidade de clientes: " + clientes.size());
        }

        public void contarVendedores() {
            System.out.println("Quantidade de vendedores: " + vendedores.size());
        }

        public void apresentarloja() {
            System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cnpj);
            System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
        }
}
