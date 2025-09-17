import java.util.ArrayList;
import java.util.Date;

public class ProcessaPedido {

    public void processar(Pedido pedido) {
        System.out.println("Processando pedido...");

        if (confirmarPagamento(pedido)) {
            System.out.println("Pedido confirmado!");
            System.out.println("Descrição do pedido:");
            pedido.gerarDescVenda();
        } else {
            System.out.println("Pedido não confirmado: a reserva está vencida!");
        }
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();
        if (pedido.dtVencReserva != null && dataAtual.before(pedido.dtVencReserva)) {
            pedido.dtpagamento = dataAtual;
            return true;
        } else {
            return false;
        }
    }

    public void testeProcessar() {

        Item item1 = new Item();
        item1.id = 1;
        item1.nome = "Produto A";
        item1.tipo = "Comum";
        item1.valor = 100;

        Item item2 = new Item();
        item2.id = 2;
        item2.nome = "Produto B";
        item2.tipo = "Comum";
        item2.valor = 200;

        ArrayList<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);

        Cliente cliente = new Cliente();
        cliente.nome = "Joaquim";
        cliente.idade = 30;

        Vendedor vendedor = new Vendedor();
        vendedor.nome = "Carlos";
        vendedor.idade = 40;
        vendedor.salbase = 2000;


        Pedido pedido = new Pedido();
        pedido.id = 1;
        pedido.cliente = cliente;
        pedido.vendedor = vendedor;
        pedido.itens = itens;
        pedido.dtcriacao = new Date();
        pedido.dtVencReserva = new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000); // 2 dias depois

        // Processando
        processar(pedido);
    }
}
