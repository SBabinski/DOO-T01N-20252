package calculadora;

public class Item {
    int id;
    String nome;
    String tipo;
    double valor;

    public void gerarDescricao() {
        System.out.println("ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: R$ " + String.format("%.2f", valor));
    }
}