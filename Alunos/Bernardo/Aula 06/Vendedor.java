import java.text.DecimalFormat;
import java.util.ArrayList;

public class Vendedor {
    static DecimalFormat df = new DecimalFormat("0.00");
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private float salarioBase;
    private ArrayList<Float> salarioRecebido = new ArrayList<>();

    public Vendedor() {}

    public Vendedor (String nome, int idade, Loja loja, String cidade, String bairro, String rua, float salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();

        this.salarioRecebido.add(salarioBase);
        this.salarioRecebido.add(salarioBase + 500);
        this.salarioRecebido.add(salarioBase + 370);
    }

    public void apresentarSe() {
        System.out.println("\nNome: " + nome + 
                           "\nIdade: " + idade +
                           "\nLoja: " + loja.getNomeFantasia());
    }

    public void calcularMedia() {
        float soma = 0;
        for (Float s : salarioRecebido) {
            soma += s;
        }
        float media = soma / salarioRecebido.size();
        System.out.println("Média dos salários: R$" + df.format(media));
    }
   
    public void calcularBonus() {
        float bonus = (float) (salarioBase * 0.2);
        System.out.println("Bônus salarial: R$" + df.format(bonus));
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    } 

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public ArrayList<Float> getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(ArrayList<Float> salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

}