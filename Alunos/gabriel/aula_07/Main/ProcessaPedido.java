
    import java.time.LocalDate;
import java.util.List;

public class ProcessaPedido {

    // Método principal: cria um pedido a partir dos dados
    public Pedido processar(int id, String cliente, String vendedor, String loja,
                            List<Item> itens, LocalDate dataVencimentoReserva) {

        LocalDate localDate;
        Pedido pedido = new Pedido(id,cliente,vendedor,loja,LocalDate.now(), dataVencimentoReserva);
                
    

        // adiciona itens recebidos
        for (Item item : itens) {
            pedido.adicionarItem(item);
        }

        // confirma pagamento se reserva ainda válida
        if (confirmarPagamento(pedido)) {
            pedido.setDataPagamento(LocalDate.now());
            System.out.println("Pagamento confirmado para o pedido #" + id);
        } else {
            System.out.println("Pagamento NÃO confirmado (reserva vencida) para o pedido #" + id);
        }

        return pedido;
    }

    // Método privado: só a classe usa
    private boolean confirmarPagamento(Pedido pedido) {
        LocalDate hoje = LocalDate.now();
        return !hoje.isAfter(pedido.getDataVencimentoReserva());
    }
}


