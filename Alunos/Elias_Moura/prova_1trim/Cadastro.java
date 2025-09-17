public class Cadastro {
    private String nome;
    private int livro;
    private double colecao;
    private int autor;
    

public Cadastro(String nome, int livro, double colecao, int altor ){
  
  this.nome = nome;
  this.livro = livro;
  this.colecao = colecao;
  this.autor = autor;
}

public String getNome(){
    return nome;
}

public int getLivro(){
    return livro;

}

public double getColecao(){
    return colecao;

}



}
