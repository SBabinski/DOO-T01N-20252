public class Vendedor {
    
    public String nome;

    public int idade;

    public Loja loja;

    public String cidade;

    public String bairro;

    public String rua;
    
    public double salarioBase;

    public double[] salarioRecebido;

    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro,
     String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double [] {};
    }

    public Loja getLoja() {
        return loja;
    }

    public void apresentar(){
        System.out.println("Vendedor \n Nome: " + nome + "\n Idade: " + idade + "\n Loja: " + loja.getNome());
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

    public void setSalarioRecebido(double[] novoSalarioRecebido){
        this.salarioRecebido = novoSalarioRecebido;
    }
}
