import java.util.ArrayList;
import java.util.Date;

public class ProcessaPedido {

    public void processar(Pedido pedido) {
        System.out.println("Processando pedido");

        if (confirmPagamento(pedido)) {
            System.out.println("Pedido confirmado!");
            System.out.println("Descrição do pedido:");
            pedido.gerarDescVenda();
        } else {
            System.out.println("Pedido não confirmado: a reserva está vencida!");
        }
    }

    private boolean confirmPagamento(Pedido pedido) {
        Date dataAtual = new Date();
        if (pedido.dataVencReserva != null && dataAtual.before(pedido.dataVencReserva)) {
            pedido.datapagamento = dataAtual;
            return true;
        } else {
            return false;
        }
    }

    public void testeProcessar() {

        Item item1 = new Item();
        item1.id = 1;
        item1.nomep = "Produto X";
        item1.tipo = "Comum";
        item1.valor = 1000;

        Item item2 = new Item();
        item2.id = 2;
        item2.nomep = "Produto Y";
        item2.tipo = "Comum";
        item2.valor = 600;

        ArrayList<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);

        Cliente cliente = new Cliente();
        cliente.nome = "Manuela";
        cliente.idade = 29;

        Vendedor vendedor = new Vendedor();
        vendedor.nome = "Marianne";
        vendedor.idade = 40;
        vendedor.salarioBase = 2000;


        Pedido pedido = new Pedido();
        pedido.id = 1;
        pedido.cliente = cliente;
        pedido.vendedor = vendedor;
        pedido.itens = itens;
        pedido.datacriacao = new Date();
        pedido.dataVencReserva = new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000); // 2 dias depois

        processar(pedido);
    }
}
