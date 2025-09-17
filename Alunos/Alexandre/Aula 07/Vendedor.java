import java.util.ArrayList;

public class Vendedor extends Pessoa {
    String loja;
    double salarioBase;
    ArrayList<Double> salariosRecebidos = new ArrayList<>();

    public Vendedor(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        salariosRecebidos.add(salarioBase);
        salariosRecebidos.add(salarioBase * 1.1);
        salariosRecebidos.add(salarioBase * 0.9);
    }

    @Override
    public void apresentarse() {
        System.out.println("Vendedor: " + nome + " | Loja: " + loja);
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
