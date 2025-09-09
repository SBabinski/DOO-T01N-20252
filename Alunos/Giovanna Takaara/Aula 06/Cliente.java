public class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    public Cliente (String nome, int idade, String cidade, String bairro,String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarCliente() {
        System.out.println("Cliente: " + nome + "\nIdade: " + idade + "\nEndereço: " + rua + " - " +
                bairro + " - " + cidade);
    }
}
