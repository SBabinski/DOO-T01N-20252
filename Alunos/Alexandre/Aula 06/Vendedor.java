import java.util.ArrayList;

public class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    ArrayList<Double> salariosRecebidos;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();
        this.salariosRecebidos.add(salarioBase);
        this.salariosRecebidos.add(salarioBase * 1.1);
        this.salariosRecebidos.add(salarioBase * 0.9);
    }

    public void apresentarse() {
        System.out.println("Vendedor: " + nome + " | Idade: " + idade + " | Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double s : salariosRecebidos)
            soma += s;
        return soma / salariosRecebidos.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
