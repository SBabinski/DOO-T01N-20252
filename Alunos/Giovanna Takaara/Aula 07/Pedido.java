import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    int id;
    Date datacriacao;
    Date datapagamento;
    Date dataVencReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    ArrayList<Item> itens = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Pedido(){
        cadastrarPedido();
    }

    public void cadastrarPedido(){

        System.out.println(" Digite o ID do item: ");
        id = scanner.nextInt();

        scanner.nextLine();

        datacriacao = new Date();
        dataVencReserva = new Date();

        cliente = new Cliente();
        cliente.cadastrarCli();

        vendedor = new Vendedor();
        vendedor.cadastrarVend();

        loja = new Loja ("", "", "", "", "", "");

        System.out.println("Quantos itens deseja adicionar? ");
        int qntItens = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < qntItens; i++) {
            Item item = new Item();
            item.descricaop();
            itens.add(item);
        }
    }

    public double calcVtotal(){
        double total = 0;
        for (Item item : itens){
            total += item.getValor();
        }
        return total;
    }

    public void gerarDescVenda(){
        System.out.println("Pedido ID: " + id);
        System.out.println("Pedido criado em: " + datacriacao);
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("Vendedor: " + vendedor.nome);
        System.out.println("loja: " + loja.nomeFantasia);
        System.out.println("Total do pedido: R$" + calcVtotal());
    }
}
