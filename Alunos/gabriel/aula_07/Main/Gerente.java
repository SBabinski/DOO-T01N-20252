import java.util.ArrayList;
import java.util.List;

public class Gerente extends Pessoa {
    private String loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Gerente(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, double[] salariosRecebidos) {
        super(nome, idade, new Endereço("", cidade, bairro, rua, 0, ""));
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        for (double salario : salariosRecebidos) {
            this.salarioRecebido.add(salario);
        }
    }

    public void apresentarse() {
        System.out.println("Nome: " + super.nome + ", Idade: " + super.idade + ", Loja: " + loja);
        System.out.print("Endereço: ");
        super.endereco.apresentarLogradouro();
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }

    public static void main(String[] args) {
        double[] salarios = {5000.0, 5500.0, 6000.0};
        Gerente gerente1 = new Gerente("Carlos Silva", 40, "Loja Centro", "Curitiba", "Centro", "Rua XV", 5000, salarios);

        gerente1.apresentarse();
        System.out.println("Média dos salários: " + gerente1.calcularMedia());
        System.out.println("Bônus: " + gerente1.calcularBonus());
    }
}



