public class Item {
    private int id;
    private String nome;
    private String tipo;
    private float valor;

    public Item(int id, String nome, String tipo, float valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("Item " + id + ": " + nome + " | Tipo: " + tipo + " | Valor: R$" + valor);
    }

    public float getValor() {
        return valor;
    }
}
