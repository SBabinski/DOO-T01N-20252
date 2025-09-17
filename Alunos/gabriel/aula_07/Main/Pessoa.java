public class Pessoa {
    protected String nome;    // protected: visível em subclasse no mesmo pacote ou subclasses
    protected int idade;
    protected Endereço endereco;

    public Pessoa() {
        super();
    }

    public Pessoa(String nome, int idade, Endereço endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
        System.out.print("Endereço: ");
        if (endereco != null) {
            endereco.apresentarLogradouro();
        } else {
            System.out.println("Endereço não informado.");
        }
    }
}


