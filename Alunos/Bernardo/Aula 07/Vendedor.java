import java.text.DecimalFormat;

public class Vendedor extends Funcionario {
    static DecimalFormat df = new DecimalFormat("0.00");

    public Vendedor(String nome, int idade, Loja loja, Endereco endereco, float salarioBase) {
        super(nome, idade, loja, endereco, salarioBase);
        this.salarioRecebido.add(salarioBase);
        this.salarioRecebido.add(salarioBase + 500);
        this.salarioRecebido.add(salarioBase + 370);
    }

    @Override
    public void calcularBonus() {
        float bonus = salarioBase * 0.2f;
        System.out.println("Bônus salarial (Vendedor): R$" + df.format(bonus));
    }
}
