import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome da loja:");
        String nomeFantasia = sc.nextLine();
        System.out.println("Razao social:");
        String razaoSocial = sc.nextLine();
        System.out.println("CNPJ:");
        String cnpj = sc.nextLine();
        System.out.println("Cidade da loja:");
        String cidadeLoja = sc.nextLine();
        System.out.println("Bairro da loja:");
        String bairroLoja = sc.nextLine();
        System.out.println("Rua da loja:");
        String ruaLoja = sc.nextLine();

        Loja loja = new Loja(nomeFantasia, razaoSocial, cnpj, cidadeLoja, bairroLoja, ruaLoja);

        System.out.println("Quantos vendedores deseja cadastrar?");
        int qtdVendedores = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < qtdVendedores; i++) {
            System.out.println("Nome do vendedor:");
            String nome = sc.nextLine();
            System.out.println("Idade do vendedor:");
            int idade = sc.nextInt();
            sc.nextLine();
            System.out.println("Cidade:");
            String cidade = sc.nextLine();
            System.out.println("Bairro:");
            String bairro = sc.nextLine();
            System.out.println("Rua:");
            String rua = sc.nextLine();
            System.out.println("Salario base:");
            double salario = sc.nextDouble();
            sc.nextLine();
            Vendedor v = new Vendedor(nome, idade, nomeFantasia, cidade, bairro, rua, salario);
            loja.adicionarVendedor(v);
        }

        System.out.println("Quantos clientes deseja cadastrar?");
        int qtdClientes = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < qtdClientes; i++) {
            System.out.println("Nome do cliente:");
            String nome = sc.nextLine();
            System.out.println("Idade:");
            int idade = sc.nextInt();
            sc.nextLine();
            System.out.println("Cidade:");
            String cidade = sc.nextLine();
            System.out.println("Bairro:");
            String bairro = sc.nextLine();
            System.out.println("Rua:");
            String rua = sc.nextLine();
            Cliente c = new Cliente(nome, idade, cidade, bairro, rua);
            loja.adicionarCliente(c);
        }

        loja.apresentarse();
        System.out.println("Total de vendedores: " + loja.contarVendedores());
        System.out.println("Total de clientes: " + loja.contarClientes());

        System.out.println("\n-- Vendedores --");
        for (Vendedor v : loja.vendedores) {
            v.apresentarse();
            System.out.println("Media Salarial: " + v.calcularMedia());
            System.out.println("Bonus: " + v.calcularBonus());
        }

        System.out.println("\n-- Clientes --");
        for (Cliente c : loja.clientes) {
            c.apresentarse();
        }

        sc.close();
    }
}
