package aula_06;

public class Vendedor {



    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private double[] salarioRecebido;

    public Vendedor() {

    }

    public Vendedor(String nome, int idade, String loja) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
    }

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;

        // pelo menos 3 valores fixos de salários recebidos
        this.salarioRecebido = new double[] { 2500.0, 2600.0, 2550.0 };
    }

    // Método que apresenta o funcionário
    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Loja: " + loja);
    }

    // Método que calcula média dos salários recebidos
    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    // Método que calcula o bônus
    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
