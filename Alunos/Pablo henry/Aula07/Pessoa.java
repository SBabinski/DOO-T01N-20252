package calculadora;

public abstract class Pessoa {
    String nome;
    int idade;
    Endereco endereco;

    public void apresentarse() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
    }
}