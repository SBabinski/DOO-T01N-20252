
public class Vend extends Pessoa {
    // Atributos específicos da classe Vendedor
    private String loja;
    private double salarioBase;
    private double[] salarioRecebido;

    // Construtor da classe
    public Vend(String nome, int idade, String loja, Endereço endereço, double salarioBase) {
        super(nome, idade, endereço);
        this.loja = loja;
        this.salarioBase = salarioBase;
        // Inicializa o array de salários com 3 valores
        this.salarioRecebido = new double[3];
        this.salarioRecebido[0] = 2500.0;
        this.salarioRecebido[1] = 2800.0;
        this.salarioRecebido[2] = 3000.0;
    }

    public Vend() {
        super();
    }

    // Método apresentarse - printa nome, idade e Loja
    public void apresentarse() {
        System.out.println("Nome: " + super.nome);
        System.out.println("Idade: " + super.idade);
        System.out.println("Loja: " + loja);
    }

    // Método calcularMedia - calcula a média dos salários
    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    // Método calcularBonus - calcula bônus baseado no salário base
    public double calcularBonus() {
        return salarioBase * 0.2;
    }

    // Getters e Setters específicos da classe Vendedor
    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    // Métodos para acessar atributos da classe pai
    public String getNome() {
        return super.nome;
    }

    public int getIdade() {
        return super.idade;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(double[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }
}
