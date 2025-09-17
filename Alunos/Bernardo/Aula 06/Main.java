import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja("Planta & Cia", "My Plant", "12.345.678/0001-99", "Cascavel", "Neva", "Cuiabá");

        Cliente cliente1 = new Cliente("Ana", 30, "Cascavel", "Centro", "Recife");
        Cliente cliente2 = new Cliente("Cleber", 45, "Cascavel", "Coqueiral", "Natal");

        loja.getClientes().add(cliente1); 
        loja.getClientes().add(cliente2);

        Vendedor vendedor1 = new Vendedor("Bernardo", 21, loja, "Cascavel", "Coqueiral", "João de Mattos", 3100);
        Vendedor vendedor2 = new Vendedor("Paula", 26, loja, "Cascavel", "Centro", "Paraná", 3250);

        loja.getVendedores().add(vendedor1);
        loja.getVendedores().add(vendedor2);

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
    } 
}