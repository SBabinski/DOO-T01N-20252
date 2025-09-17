import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja("Planta & Cia", "My Plant", "12.345.678/0001-99", "Cascavel", "Neva", "Cuiabá");

        Endereco enderecoCliente1 = new Endereco("PR", "Cascavel", "Centro", "123", "Ap 01");
        Endereco enderecoCliente2 = new Endereco("PR", "Cascavel", "Coqueiral", "456", "Casa");

        Cliente cliente1 = new Cliente("Ana", 30, enderecoCliente1);
        Cliente cliente2 = new Cliente("Cleber", 45, enderecoCliente2);

        loja.getClientes().add(cliente1);
        loja.getClientes().add(cliente2);

        Endereco enderecoVendedor1 = new Endereco("PR", "Cascavel", "Coqueiral", "789", "Casa");
        Endereco enderecoVendedor2 = new Endereco("PR", "Cascavel", "Centro", "321", "Ap 12");

        Vendedor vendedor1 = new Vendedor("Bernardo", 21, loja, enderecoVendedor1, 3100);
        Vendedor vendedor2 = new Vendedor("Paula", 26, loja, enderecoVendedor2, 3250);

        loja.getVendedores().add(vendedor1);
        loja.getVendedores().add(vendedor2);

        Endereco enderecoGerente = new Endereco("PR", "Cascavel", "Neva", "654", "Sala 2");
        Gerente gerente = new Gerente("Roberto", 40, loja, enderecoGerente, 5000);

        System.out.println("\n===== LOJA =====");
        loja.contarClientes();
        loja.apresentarSe();
        loja.contarVendedores();

        System.out.println("\n===== CLIENTES =====");
        for (Cliente c : loja.getClientes()) {
            c.apresentarSe();
        }

        System.out.println("\n===== VENDEDORES =====");
        for (Vendedor v : loja.getVendedores()) {
            v.apresentarSe();
            v.calcularMedia();
            v.calcularBonus();
        }

        System.out.println("\n===== GERENTE =====");
        gerente.apresentarSe();
        gerente.calcularMedia();
        gerente.calcularBonus();

        System.out.println("\n===== PEDIDOS =====");
        ProcessaPedido processador = new ProcessaPedido();

        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Vaso de Cerâmica", "Decoração", 80));
        itens.add(new Item(2, "Planta Samambaia", "Planta", 120));

        Pedido pedido1 = processador.processar(1, cliente1, vendedor1, loja, itens);
        pedido1.gerarDescricaoVenda();
    }
}
