import java.util.ArrayList;
import java.util.List;

public class Gerente  extends Pessoa {
    private String nome;
    private int idade;
    private String loja;
    private double salarioBase;
    private List<Double> salarioRecebido;
    private Endereço endereco; // composição

    public Gerente(String nome, int idade, String loja, double salarioBase, Endereço endereco) {
      
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;

        this.salarioRecebido = new ArrayList<>();
        this.salarioRecebido.add(salarioBase);
        this.salarioRecebido.add(salarioBase + 500);
        this.salarioRecebido.add(salarioBase + 1000);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
        System.out.print("Endereço: ");
        endereco.apresentarLogradouro(); // agora delega para Endereco
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
        Endereço end1 = new Endereço("PR", "Curitiba", "Centro", "Rua XV", 123, "Sala 4");
        Gerente gerente1 = new Gerente("Carlos Silva", 40, "Loja Centro", 5000, end1);

        gerente1.apresentarse();
        System.out.println("Média dos salários: " + gerente1.calcularMedia());
        System.out.println("Bônus: " + gerente1.calcularBonus());
    }
}



