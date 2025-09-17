package Alunos.Sofia.aula07;

import java.util.*;

class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", " + numero + " - " + bairro + ", " + cidade + "/" + estado
                           + (complemento != null ? " (" + complemento + ")" : ""));
    }
}

class Pessoa {
    protected String nome;
    protected int idade;
    protected Endereco endereco;

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentar() {
        System.out.println("Nome: " + nome + " | Idade: " + idade);
        endereco.apresentarLogradouro();
    }
}

class Gerente extends Pessoa {
    private String loja;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Gerente(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();

    
        salarioRecebido.add(5000.0);
        salarioRecebido.add(5200.0);
        salarioRecebido.add(5100.0);
    }

    public void apresentarSe() {
        System.out.println("Gerente: " + nome + " | Idade: " + idade + " | Loja: " + loja);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Item {
    private int id;
    private String nome;
    private String tipo;
    private double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("Item #" + id + " - " + nome + " (" + tipo + ") - R$ " + valor);
    }

    public double getValor() {
        return valor;
    }
}


class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Pessoa cliente;
    private Pessoa vendedor;
    private String loja;
    private ArrayList<Item> itens;

    public Pedido(int id, Date dataCriacao, Date dataVencimentoReserva, Pessoa cliente, Pessoa vendedor, String loja) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularValorTotal() {
        return itens.stream().mapToDouble(Item::getValor).sum();
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido #" + id + " criado em " + dataCriacao +
                " | Valor total: R$ " + calcularValorTotal());
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}

class ProcessaPedido {

    public Pedido processar(int id, Pessoa cliente, Pessoa vendedor, String loja) {
        Date agora = new Date();
        Date vencimento = new Date(agora.getTime() + (3 * 24 * 60 * 60 * 1000));

        Pedido pedido = new Pedido(id, agora, vencimento, cliente, vendedor, loja);
        pedido.adicionarItem(new Item(1, "Camisa Polo", "Vestuário", 120.0));
        pedido.adicionarItem(new Item(2, "Calça Jeans", "Vestuário", 200.0));

        confirmarPagamento(pedido);

        return pedido;
    }

    private void confirmarPagamento(Pedido pedido) {
        Date agora = new Date();
        if (agora.before(pedido.getDataVencimentoReserva())) {
            pedido.setDataPagamento(agora);
            System.out.println("Pagamento confirmado para o pedido!");
        } else {
            System.out.println("Reserva vencida! Pagamento não confirmado.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "Rua A", 100, "Ap 12");
        Gerente gerente = new Gerente("Gabrielinha", 30, endereco, "MyPlant Center", 5000.0);

        gerente.apresentarSe();
        System.out.println("Média de salários: " + gerente.calcularMedia());
        System.out.println("Bônus: " + gerente.calcularBonus());

        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(101, gerente, gerente, "MyPlant Center");

        pedido.gerarDescricaoVenda();
    }
}

