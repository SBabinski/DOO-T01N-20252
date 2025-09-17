import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Funcionario {
    protected String nome;
    protected int idade;
    protected Loja loja;
    protected Endereco endereco;
    protected float salarioBase;
    protected ArrayList<Float> salarioRecebido = new ArrayList<>();

    static DecimalFormat df = new DecimalFormat("0.00");

    public Funcionario(String nome, int idade, Loja loja, Endereco endereco, float salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
    }

    public void apresentarSe() {
        System.out.println("\nNome: " + nome + 
                           "\nIdade: " + idade +
                           "\nLoja: " + loja.getNomeFantasia());
    }

    public void calcularMedia() {
        float soma = 0;
        for (Float s : salarioRecebido) {
            soma += s;
        }
        float media = soma / salarioRecebido.size();
        System.out.println("Média dos salários: R$" + df.format(media));
    }

    public abstract void calcularBonus();
}
