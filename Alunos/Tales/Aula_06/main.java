

public class main {
    public static void main(String[] args) {

        Endereco endLoja   = new Endereco("Floripa", "Centro", "Rua das Palmeiras, 100");
        Endereco endAna    = new Endereco("Floripa", "Trindade", "Rua A");
        Endereco endBruno  = new Endereco("Floripa", "Estreito", "Rua B");
        Endereco endCarla  = new Endereco("Floripa", "Kobrasol", "Rua C");
        Endereco endDaniel = new Endereco("Floripa", "Centro", "Rua D");
        Endereco endElisa  = new Endereco("Floripa", "Trindade", "Rua E");

        Loja myPlant = new Loja(
            "My Plant",           
            "My Plant LTDA",    
            "12.345.678/0001-90",
            endLoja,               
            null,                 
            null                
        );


        Vendedor v1 = new Vendedor(
            "Ana", 28, myPlant, endAna,
            3000.0,
            new double[]{3000.0, 3200.0, 3100.0} 
        );

        Vendedor v2 = new Vendedor(
            "Bruno", 32, myPlant, endBruno,
            3500.0,
            new double[]{3500.0, 3500.0, 3600.0} 
        );

        Cliente c1 = new Cliente("Carla", 40, endCarla);
        Cliente c2 = new Cliente("Daniel", 25, endDaniel);
        Cliente c3 = new Cliente("Elisa", 31, endElisa);

        myPlant.setVendedores(new Vendedor[]{ v1, v2 });
        myPlant.setClientes(new Cliente[]{ c1, c2, c3 });

        myPlant.apresentarse();
        System.out.println("Qtde de clientes: " + myPlant.contarClientes());
        System.out.println("Qtde de vendedores: " + myPlant.contarVendedores());
        System.out.println();

        v1.apresentarse();
        System.out.println("Média de salários: " + v1.calcularMedia());
        System.out.println("Bônus: " + v1.calcularBonus());
        System.out.println();

        v2.apresentarse();
        System.out.println("Média de salários: " + v2.calcularMedia());
        System.out.println("Bônus: " + v2.calcularBonus());
        System.out.println();

        c1.apresentarse();
        c2.apresentarse();
        c3.apresentarse();
    }
}

class Endereco {
    String cidade;
    String bairro;
    String rua;

    Endereco(String cidade, String bairro, String rua) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    @Override
    public String toString() {
        return rua + ", " + bairro + ", " + cidade;
    }
}


class Vendedor {
    String nome;
    int idade;
    Loja loja;            
    Endereco endereco;    
    double salarioBase;
    double[] salarioRecebido; 

    Vendedor(String nome, int idade, Loja loja, Endereco endereco,
             double salarioBase, double[] salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;

        if (salarioRecebido == null || salarioRecebido.length < 3) {
            this.salarioRecebido = new double[]{salarioBase, salarioBase, salarioBase};
        } else {
            this.salarioRecebido = salarioRecebido;
        }
    }

    void apresentarse() {
        String nomeLoja = (loja != null) ? loja.getNomeFantasia() : "Sem loja";
        System.out.println("Vendedor: " + nome + " | Idade: " + idade + " | Loja: " + nomeLoja);
    }

    double calcularMedia() {
        double soma = 0.0;
        for (double s : salarioRecebido) soma += s;
        return soma / salarioRecebido.length;
    }

    double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente {
    String nome;
    int idade;
    Endereco endereco;

    Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

  
    void apresentarse() {
        System.out.println("Cliente: " + nome + " | Idade: " + idade);
    }
}


class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    Endereco endereco;     
    Vendedor[] vendedores; 
    Cliente[] clientes;    

    Loja(String nomeFantasia, String razaoSocial, String cnpj,
         Endereco endereco, Vendedor[] vendedores, Cliente[] clientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    int contarClientes() {
        return (clientes == null) ? 0 : clientes.length;
    }

    int contarVendedores() {
        return (vendedores == null) ? 0 : vendedores.length;
    }

    void apresentarse() {
        System.out.println(
            "Loja: " + nomeFantasia +
            " | CNPJ: " + cnpj +
            " | Endereço: " + (endereco != null ? endereco.toString() : "sem endereço")
        );
    }

    String getNomeFantasia() {
        return nomeFantasia;
    }

    void setVendedores(Vendedor[] vendedores) {
        this.vendedores = vendedores;
    }

    void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }
}