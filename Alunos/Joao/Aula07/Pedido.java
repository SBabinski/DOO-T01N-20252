import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    int id;
    Date dtcriacao;
    Date dtpagamento;
    Date dtVencReserva;
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

        dtcriacao = new Date();
        dtVencReserva = new Date();

        cliente = new Cliente();
        cliente.cadastrarCliente();

        vendedor = new Vendedor();
        vendedor.cadastrarVendedor();

        loja = new Loja ("", "", "", "", "");

        System.out.println("Quantos itens deseja adicionar? ");
        int qntItens = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < qntItens; i++) {
            Item item = new Item();
            item.Item();
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
       System.out.println("Pedido criado em: " + dtcriacao);
       System.out.println("Cliente: " + cliente.nome);
       System.out.println("Vendedor: " + vendedor.nome);
       System.out.println("loja: " + loja.nomeFantasia);
       System.out.println("Total do pedido: R$" + calcVtotal());
   }
}
