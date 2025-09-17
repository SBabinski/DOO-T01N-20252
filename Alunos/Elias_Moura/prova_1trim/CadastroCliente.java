public class CadastroCliente {
    private String nome, CPF;
    private int senha;
 

public void CadastroCliente(String nome, String CPF,int senha){
    this.nome = nome;
    this.CPF = CPF;
    this.senha = senha;

}

public String getNome(){
    return nome;
 }

public String getCPF(){
    return CPF;
} 


public int getSenha(){
    return senha;
}


}
