import java.util.ArrayList;

public class Gerente extends Pessoa {
    private Loja loja;
    private double salarioBase;
    private ArrayList<Double> salariosRecebidos;

    public Gerente() {
        super();
        this.salariosRecebidos = new ArrayList<>();
        this.salariosRecebidos.add(5000.0);
        this.salariosRecebidos.add(5200.0);
        this.salariosRecebidos.add(5500.0);
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public ArrayList<Double> getSalariosRecebidos() {
        return salariosRecebidos;
    }

    public void setSalariosRecebidos(ArrayList<Double> salariosRecebidos) {
        this.salariosRecebidos = salariosRecebidos;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("Loja: " + (this.loja != null ? this.loja.getNomeFantasia() : "Nenhuma loja associada"));
    }

    public double calcularMedia() {
        double somaSalarios = 0.0;
        for (Double salario : this.salariosRecebidos) {
            somaSalarios += salario;
        }
        return (somaSalarios / this.salariosRecebidos.size());
    }

    public double calcularBonus() {
        return (this.salarioBase * 0.35);
    }
}
