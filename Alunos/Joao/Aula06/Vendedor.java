import java.util.ArrayList;

public class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salbase;
    ArrayList<Double> salrecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro,
                    String rua, double salbase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salbase = salbase;
        salrecebido.add (1900.00);
        salrecebido.add (2000.00);
        salrecebido.add (2100.00);
    }

    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcmedia() {
        double soma = 0;
        for (int i = 0; i < salrecebido.size(); i++) {
            soma += salrecebido.get(i);
        }
     return soma /salrecebido.size();
  }

  public double calcbonus(){
    return salbase * 0.2;
  }
}
