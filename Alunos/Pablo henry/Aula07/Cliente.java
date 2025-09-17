package calculadora;

public class Cliente extends Pessoa {
    
    @Override
    public void apresentarse() {
        System.out.println("------------------------------------");
        System.out.println("Nome do cliente: " + this.nome);
        System.out.println("Idade: " + this.idade);
        this.endereco.apresentarLogradouro();
        System.out.println("------------------------------------");
    }
}