package calculadora;

public class Vendedor extends Funcionario {

    @Override
    public void calcularBonus() {
        double bonus = this.salarioBase * 0.2;
        System.out.printf("O bônus do vendedor é de: R$ %.2f\n", bonus);
    }
}