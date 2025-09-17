import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    int id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    ArrayList<Item> itens = new ArrayList<>();

    public Pedido(int id, Cliente cliente, Vendedor vendedor, Loja loja, Date dataVencimentoReserva) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.dataCriacao = new Date();
        this.dataVencimentoReserva = dataVencimentoReserva;
    }

    public void adicionarItem(Item i) {
        itens.add(i);
    }

    public double calcularValorTotal() {
        double soma = 0;
        for (Item i : itens)
            soma += i.valor;
        return soma;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido " + id + " criado em " + dataCriacao + " | Total: " + calcularValorTotal());
    }
}
