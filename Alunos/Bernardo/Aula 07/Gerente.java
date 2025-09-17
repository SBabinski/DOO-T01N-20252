import java.text.DecimalFormat;

public class Gerente extends Funcionario {
    static DecimalFormat df = new DecimalFormat("0.00");

    public Gerente(String nome, int idade, Loja loja, Endereco endereco, float salarioBase) {
        super(nome, idade, loja, endereco, salarioBase);
        this.salarioRecebido.add(salarioBase);
        this.salarioRecebido.add(salarioBase + 800);
        this.salarioRecebido.add(salarioBase + 1200);
    }

    @Override
    public void calcularBonus() {
        float bonus = salarioBase * 0.35f;
        System.out.println("Bônus salarial (Gerente): R$" + df.format(bonus));
    }
}
