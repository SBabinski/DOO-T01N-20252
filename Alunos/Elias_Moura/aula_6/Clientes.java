public class Clientes {
    private String nome , cpf;
    private String endereco, telefone;


public Clientes(String nome, String cpf, String endereco, String telefone){
    this.nome = nome;
    this.cpf = cpf;
    this.endereco = endereco;
    this.telefone = telefone; 
}    

public String getNome(){
    return nome;

}

public String getCpf(){
    return cpf;

}

public String getEndereco(){
    return endereco;

}

public String getTelefone(){
    return telefone;
}

 @Override

public String toString(){
    return String.format("Nome: %s | CPF: %s | Telefone: %s | Endereço: %s",
                         nome, cpf, telefone, endereco);
}

}
