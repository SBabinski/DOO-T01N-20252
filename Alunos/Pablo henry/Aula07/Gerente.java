package calculadora;

public class Gerente extends Funcionario {

    @Override
    public void calcularBonus() {
        double bonus = this.salarioBase * 0.35;
        System.out.printf("O bônus do gerente é de: R$ %.2f\n", bonus);
    }
}