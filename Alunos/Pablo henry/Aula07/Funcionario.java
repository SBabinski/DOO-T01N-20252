package calculadora;

public abstract class Funcionario extends Pessoa {
    String loja;
    double salarioBase;
    double[] salarioRecebido = new double[3];

    @Override
    public void apresentarse() {
        System.out.println("------------------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Trabalha na loja: " + this.loja);
        System.out.println("------------------------------------");
    }

    public void calcularMedia() {
        double somaSalarios = 0;
        for (int i = 0; i < salarioRecebido.length; i++) {
            somaSalarios += salarioRecebido[i];
        }
        double media = somaSalarios / salarioRecebido.length;
        System.out.printf("A média dos últimos salários é: R$ %.2f\n", media);
    }

    public abstract void calcularBonus();
}