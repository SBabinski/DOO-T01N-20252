public class Produto {

  private String nome;
  private int quantidade;
  private double unidade;

 
public Produto(String nome, int quantidade, double unidade){
    this.nome = nome;
    this.quantidade = quantidade;
    this.unidade = unidade;
}

public String getNome(){
    return nome;
}   

public int getQuantidade(){
    return quantidade;
}

public double getUnidade(){
    return unidade;
  
}
 static class CalculadoraProduto {
    public static double calcularTotal(Produto produto){
    return produto.getQuantidade() * produto.getUnidade();
    }  
}


/// calcula a função 2 parte dos trocos 

public double  calculaTroco(double valordaEntrada) {
  double total = quantidade * unidade;
  return valordaEntrada - total;
    
}

}


