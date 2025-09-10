package calculadora;

public class vendedor {

    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    double[] salarioRecebido = new double[3];

    public void apresentarse() {
        System.out.println("------------------------------------");
        System.out.println("Nome do vendedor: " + this.nome);
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
        System.out.printf("A media dos ultimos salarios e: R$ %.2f\n", media);
    }

    public void calcularBonus() {
        double bonus = this.salarioBase * 0.2;
        System.out.printf("O bonus do vendedor e de: R$ %.2f\n", bonus);
    }
}