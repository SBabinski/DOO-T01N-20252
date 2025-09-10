public class Cliente extends Pessoa {
    public Cliente() {
        super();
    }

    public Cliente(String nome, int idade) {
        this.nome = nome;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
   }
}


