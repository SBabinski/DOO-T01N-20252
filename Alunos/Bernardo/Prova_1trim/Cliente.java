package Alunos.Bernardo.Prova_1trim;

public class Cliente {
    private String nome;
    private String cpf;
    private float divida;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, float divida) {
        this.nome = nome;
        this.cpf = cpf;
        this.divida = divida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getDivida() {
        return divida;
    }

    public void setDivida(float divida) {
        this.divida = divida;
    }

    public void multar(double valor) {
        this.divida += valor;
    }

    @Override
    public String toString() {
        return nome + "CPF: " + cpf + "\nDívida: R$ " + String.format("%.2f", divida);
    }
}