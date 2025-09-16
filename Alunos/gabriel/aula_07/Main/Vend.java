

public class Vend  extends Pessoa {
    // Atributos da classe Vendedor
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private double[] salarioRecebido;
    
    // Construtor da classe
    public Vend(String nome, int idade, String loja, Endereço  endereço , double salarioBase) {
        super(nome, idade, endereço);
        this.loja = loja;
       
        this.salarioBase = salarioBase;
        // Inicializa o array de salários com 3 valores
        this.salarioRecebido = new double[3];
        this.salarioRecebido[0] = 2500.0;
        this.salarioRecebido[1] = 2800.0;
        this.salarioRecebido[2] = 3000.0;
    }
    
    // Método apresentarse - printa nome, idade e Loja
    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
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
    
    // Getters e Setters para acessar os atributos
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getLoja() {
        return loja;
    }
    
    public void setLoja(String loja) {
        this.loja = loja;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getRua() {
        return rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
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
