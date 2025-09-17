import java.util.ArrayList;

public class Gerente extends Pessoa {
    String loja;
    double salarioBase;
    ArrayList<Double> salariosRecebidos = new ArrayList<>();

    public Gerente(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        salariosRecebidos.add(salarioBase);
        salariosRecebidos.add(salarioBase * 1.2);
        salariosRecebidos.add(salarioBase * 0.8);
    }

    @Override
    public void apresentarse() {
        System.out.println("Gerente: " + nome + " | Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double s : salariosRecebidos)
            soma += s;
        return soma / salariosRecebidos.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
