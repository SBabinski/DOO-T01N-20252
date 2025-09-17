import java.util.Date;

public class ProcessaPedido {
    public Pedido processar(int id, Cliente c, Vendedor v, Loja l) {
        Date vencimento = new Date(System.currentTimeMillis() + 86400000);
        Pedido p = new Pedido(id, c, v, l, vencimento);
        p.adicionarItem(new Item(1, "Notebook", "Eletronico", 3500));
        p.adicionarItem(new Item(2, "Mouse", "Acessorio", 150));
        confirmarPagamento(p);
        return p;
    }

    private void confirmarPagamento(Pedido p) {
        Date agora = new Date();
        if (agora.before(p.dataVencimentoReserva)) {
            p.dataPagamento = agora;
            System.out.println("Pagamento confirmado para pedido " + p.id);
        } else {
            System.out.println("Reserva vencida, nao foi possivel confirmar pagamento.");
        }
    }
}
