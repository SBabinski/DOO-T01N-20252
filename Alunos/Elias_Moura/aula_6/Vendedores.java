public class Vendedores {
  private  String nome;
  private  String cpf;
  private  int matricula;
  private  int loja;
  private  String endereco;
    

public Vendedores(String nome, int matricula, String cpf){
    this.nome = nome;
    this.matricula = matricula;
    this.cpf = cpf;
    this.loja = loja;
    this.endereco = endereco;
}

public String getNome(){
    return nome;

}

public int getMatricula(){
    return matricula;
}

public String getCpf(){
    return cpf;
}

public int getLoja(){
    return loja;
}

public String getEndereco(){
    return endereco;
}



@Override
public String toString(){
    return String.format("Nome: %s | Matrícula: %d | CPF: %s| Loja: %d| Endereço", nome, matricula, cpf,loja, endereco);
    
}


}
