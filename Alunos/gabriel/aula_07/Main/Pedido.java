
  import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Client cliente;
    private Vend vendedor;
    private String loja;
    private List<Item> itens;

    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
                  Client cliente, Vend vendedor, String loja, Item[] itensArray) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = new ArrayList<>();
        for (Item item : itensArray) {
            this.itens.add(item);
        }
    }

    public Pedido(int id2, String cliente2, String vendedor2, String loja2, LocalDate now,
            LocalDate dataVencimentoReserva2) {
        //TODO Auto-generated constructor stub
    }

    // Adicionar item ao pedido
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    // Calcular valor total do pedido
    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    // Gerar descrição da venda
    public void gerarDescricaoVenda() {
        System.out.println("Pedido #" + id +
                " | Criado em: " + dataCriacao +
                " | Valor total: R$ " + calcularValorTotal());
    }

    // Getters e Setters
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }
    

    public int getId() {
        return id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public Client getCliente() {
        return cliente;
    }

    public Vend getVendedor() {
        return vendedor;
    }

    public String getLoja() {
        return loja;
    }

    public List<Item> getItens() {
        return itens;
    }
}



