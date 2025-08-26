import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Venda {
    private float valorPlanta;
    private int quantidade;
    private float totalCompra;
    private LocalDate data;
    static DecimalFormat df = new DecimalFormat();

    public Venda (float valorPlanta, int quantidade) {
        this.valorPlanta = valorPlanta;
        this.quantidade = quantidade;
        this.totalCompra = valorPlanta * quantidade;
        this.data = LocalDate.now();
        if (quantidade > 10){
            this.totalCompra = this.totalCompra * 0.95f;
        }
    }

    public LocalDate getData() {
        return data;
    }

    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Quantidade vendida: " + quantidade +
                "\nValor da venda: R$ " + df.format(totalCompra) +
                "\nData da venda: " + data.format(fmt);
    }
}