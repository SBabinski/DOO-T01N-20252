package calculadora;

public class cliente {
    
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    public void apresentarse() {
        System.out.println("------------------------------------");
        System.out.println("Nome do cliente: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("------------------------------------");
    }
}