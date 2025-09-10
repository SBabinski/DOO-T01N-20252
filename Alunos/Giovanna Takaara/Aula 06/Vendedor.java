import java.util.ArrayList;

public class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    ArrayList<Double> salarioRecebido = new ArrayList<>();


   public Vendedor (String nome, int idade, String loja, String cidade, String bairro, String rua,
    double salarioBase) {

        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;

        salarioRecebido.add (2000.00);
        salarioRecebido.add (2100.00);
        salarioRecebido.add (2200.00);
   }
   public void apresentarVendedor() {
       System.out.println("Vendedor: " + nome + "\nIdade: " + idade + "\nLoja: " + loja);
   }

   public double calcularmedia() {
       double soma = 0;
        for (int i = 0; i < salarioRecebido.size(); i++) {
            soma += salarioRecebido.get(i);
        }
        return soma / salarioRecebido.size();
   }
   public double calcularBonus(){
       return salarioBase * 0.2;
   }
}
