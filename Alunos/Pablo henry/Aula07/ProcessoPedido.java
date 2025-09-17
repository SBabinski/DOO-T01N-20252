package calculadora;

import java.time.LocalDate;
import java.util.List;

public class ProcessoPedido {

    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {
        Pedido novoPedido = new Pedido();
        novoPedido.id = id;
        novoPedido.cliente = cliente;
        novoPedido.vendedor = vendedor;
        novoPedido.loja = loja;
        novoPedido.itens = itens;
        novoPedido.dataCriacao = LocalDate.now();
        novoPedido.dataVencimentoReserva = novoPedido.dataCriacao.plusDays(3);
        
        System.out.println("Testando confirmação de pagamento...");
        if (confirmarPagamento(novoPedido)) {
            novoPedido.dataPagamento = LocalDate.now();
            System.out.println("Pagamento confirmado. Reserva válida.");
        } else {
            System.out.println("Pagamento não confirmado. Reserva vencida.");
        }

        return novoPedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        LocalDate hoje = LocalDate.now();
        return !hoje.isAfter(pedido.dataVencimentoReserva);
    }
}