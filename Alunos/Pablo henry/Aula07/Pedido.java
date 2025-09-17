package calculadora;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    int id;
    LocalDate dataCriacao;
    LocalDate dataPagamento;
    LocalDate dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    String loja;
    List<Item> itens;

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.valor;
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("------------------------------------");
        System.out.println("Pedido criado em: " + dataCriacao);
        System.out.printf("Valor total: R$ %.2f\n", calcularValorTotal());
        System.out.println("Vencimento da reserva: " + dataVencimentoReserva);
        System.out.println("------------------------------------");
    }
}