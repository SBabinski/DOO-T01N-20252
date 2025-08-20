public class Venda {
    private float valorPlanta;
    private int quantidade;
    private float totalCompra;

    public Venda (float valorPlanta, int quantidade) {
        this.valorPlanta = valorPlanta;
        this.quantidade = quantidade;
        this.totalCompra = valorPlanta * quantidade;
        if (quantidade > 10){
            this.totalCompra = this.totalCompra * 0.95f;
        }
    }

    public String toString() {
        return "Quantidade vendida: " + quantidade +
                "\nValor da venda: R$ " + String.format("%.2f", totalCompra);
    }
}