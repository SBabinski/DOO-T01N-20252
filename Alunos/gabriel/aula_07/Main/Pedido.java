
  import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDate dataCriacao;
    private LocalDate dataPagamento;
    private LocalDate dataVencimentoReserva;
    private String cliente;
    private String vendedor;
    private String loja;
    private List<Item> itens;

    public Pedido(int id, LocalDate dataCriacao, LocalDate dataVencimentoReserva,
                  String cliente, String vendedor, String loja) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = new ArrayList<>();
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

    // Getters e Setters opcionais para dataPagamento
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Pedido(LocalDate dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
    }

    public LocalDate getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    
    
        
        
    }



