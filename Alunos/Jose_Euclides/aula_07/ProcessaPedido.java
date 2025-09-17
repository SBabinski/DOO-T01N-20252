import java.util.Date;

public class ProcessaPedido {
    
    public void processar(int id, Cliente cliente, Vendedor vendedor, Loja loja) {
        Pedido pedido = new Pedido();
        
        pedido.setId(id);
        pedido.setDataCriacao(new Date());
        pedido.setCliente(cliente);
        pedido.setVendedor(vendedor);
        pedido.setLoja(loja);
        
        Date dataVencimento = new Date();
        dataVencimento.setTime(dataVencimento.getTime() + (30 * 24 * 60 * 60 * 1000L));
        pedido.setDataVencimentoReserva(dataVencimento);
        
        Item item1 = new Item(1, "Planta Decorativa", "Decoração", 25.50);
        Item item2 = new Item(2, "Vaso Cerâmico", "Utensílio", 15.00);
        Item item3 = new Item(3, "Adubo Orgânico", "Cuidado", 8.75);
        
        pedido.getItens().add(item1);
        pedido.getItens().add(item2);
        pedido.getItens().add(item3);
        
        if (confirmarPagamento(pedido)) {
            pedido.setDataPagamento(new Date());
            System.out.println("Pedido processado com sucesso!");
            pedido.gerarDescricaoVenda();
        } else {
            System.out.println("Não foi possível processar o pedido. Reserva vencida.");
        }
    }
    
    private boolean confirmarPagamento(Pedido pedido) {
        Date hoje = new Date();
        return hoje.before(pedido.getDataVencimentoReserva());
    }
}
