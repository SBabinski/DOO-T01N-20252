import java.util.ArrayList;
import java.util.Date;

public class ProcessaPedido {
    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        Date agora = new Date();
        Date vencimento = new Date(agora.getTime() + (2 * 24 * 60 * 60 * 1000));
        Pedido pedido = new Pedido(id, agora, null, vencimento, cliente, vendedor, loja, itens);
        confirmarPagamento(pedido);
        return pedido;
    }

    private void confirmarPagamento(Pedido pedido) {
        Date agora = new Date();
        if (agora.before(pedido.getDataVencimentoReserva())) {
            pedido.setDataPagamento(agora);
            System.out.println("Pagamento confirmado!");
        } else {
            System.out.println("Reserva vencida, pagamento não confirmado.");
        }
    }
}
