import java.util.ArrayList;

    public class Loja {
        String nomeFantasia;
        String razaoSocial;
        String cnpj;
        String cidade;
        String bairro;
        String rua;
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        public Loja(String nomeFantasia, String cnpj, String rua, String cidade, String bairro) {
            this.nomeFantasia = nomeFantasia;
            this.razaoSocial = nomeFantasia;
            this.cnpj = cnpj;
            this.rua = rua;
            this.cidade = cidade;
            this.bairro = bairro;
        }

        public void addVendedor(Vendedor vendedor) {
            vendedores.add(vendedor);
        }

        public void addCliente(Cliente cliente) {
            clientes.add(cliente);
        }

        public int contarClientes() {
            return clientes.size();
        }

        public int contarVendedores() {
            return vendedores.size();
        }

        public void apresentarSe() {
            System.out.println("Loja: " + nomeFantasia + " | CNPJ: " + cnpj + " | Endereço: " + rua +
                    ", " + bairro + ", " + cidade);
        }
    }


