package Alunos.Sofia.aula06;

import java.util.ArrayList;
import java.util.List;

class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    List<Double> salarioRecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;

        this.salarioRecebido.add(salarioBase);
        this.salarioRecebido.add(salarioBase * 1.1);
        this.salarioRecebido.add(salarioBase * 0.9);
    }

    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double s : salarioRecebido) {
            soma += s;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarse() {
        System.out.println("Cliente: " + nome + ", Idade: " + idade);
    }
}

class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;

    List<Vendedor> vendedores = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void adicionaVendedor(Vendedor v) {
        vendedores.add(v);
    }

    public void adicionaCliente(Cliente c) {
        clientes.add(c);
    }

    public void contarClientes() {
        System.out.println("Total de clientes: " + clientes.size());
    }

    public void contarVendedores() {
        System.out.println("Total de vendedores: " + vendedores.size());
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + " | CNPJ: " + cnpj +
                " | Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

public class MyPlantApp {
    public static void main(String[] args) {

        Loja myPlant = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-90", "São Paulo", "Centro",
                "Rua das Flores");

        Vendedor v1 = new Vendedor("Carlos", 30, "My Plant", "São Paulo", "Centro", "Rua das Flores", 2000);
        Vendedor v2 = new Vendedor("Ana", 25, "My Plant", "São Paulo", "Centro", "Rua das Palmeiras", 2500);

        Cliente c1 = new Cliente("João", 40, "São Paulo", "Vila Mariana", "Rua Azul");
        Cliente c2 = new Cliente("Maria", 35, "São Paulo", "Moema", "Rua Verde");

        myPlant.adicionaVendedor(v1);
        myPlant.adicionaVendedor(v2);
        myPlant.adicionaCliente(c1);
        myPlant.adicionaCliente(c2);

        myPlant.apresentarse();
        myPlant.contarClientes();
        myPlant.contarVendedores();

        v1.apresentarse();
        System.out.println("Média dos salários de " + v1.nome + ": " + v1.calcularMedia());
        System.out.println("Bônus de " + v1.nome + ": " + v1.calcularBonus());

        c1.apresentarse();
    }
}
