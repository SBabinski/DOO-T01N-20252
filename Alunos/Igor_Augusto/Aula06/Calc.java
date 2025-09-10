import java.util.Scanner;
import java.util.ArrayList;
public class Calc {

    static  Scanner sc = new Scanner(System.in);
    static int precoTotal = 0, troco = 0, quantidade = 0, planta = 0, dinheiro = 0, opcao = 0;
    static int BAMBU = 10, ORQUIDIA = 15, CACTO = 20;
    static boolean desconto = false;

    public static int calculoVenda(int planta, int quantidade) {
       int precoTotal = planta * quantidade;
       return precoTotal;
    }

    public static int calculoTroco(int precoTotal, int dinheiro) {
        int troco = dinheiro - precoTotal;
        return troco; 
    }

    public static int escolhaPlanta(int planta, int BAMBU, int ORQUIDIA, int CACTO) {
        System.out.println("Selecione a sua planta");
        System.out.println("1 - Bambu");
        System.out.println("2 - Orquidia");
        System.out.println("3 - Cacto");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                planta = BAMBU;
                break;
            case 2:
                planta = ORQUIDIA;
                break;
            case 3:
                planta = CACTO;
                break;
            default:
            System.out.println("Opção inválida!");
                break;
        }
        return planta;
    }

    public static int informeQuantidade(int quantidade) {
       System.out.println("Informe quantas plantas irá comprar");
       quantidade = sc.nextInt();
       return quantidade;
    }

    public static int calculoDesconto(int planta, int quantidade) {
        int precoTotal = planta * quantidade;
        int valor_desc = (int) (precoTotal * 0.05);
        precoTotal = precoTotal - valor_desc;
        return precoTotal;
    }

    public static void main(String[] args) {
       
        ArrayList<String> listaVendas = new ArrayList<>();
        
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();


        Loja l1 = new Loja("MyPlant São Paulo", "MyPlant LTDA",
         "12.345.678/0001-99", "São Paulo", "Centro", "Rua das flores");  
        l1.apresentar();

        Cliente c1 = new Cliente("João", 30, "São Paulo",
         "Centro", "Rua das Flores");
        c1.apresentar();

        Vendedor v1 = new Vendedor("Carlos", 20, l1, "São Paulo",
         "Centro", "Rua das flores", 1500.00);
        v1.apresentar();

        double[] salarios = {1500, 1600, 1700};

        v1.setSalarioRecebido(salarios);
        System.out.println("Média de salários: " + v1.calcularMedia());
        System.out.println("Bonus: " + v1.calcularBonus());
        l1.listaClientes.add(c1);
        
        l1.listaVendedores.add(v1);
        
        l1.contarClientes();
        l1.contarVendedores();
        
        while(opcao != 4) {
            System.out.println("Selecione a sua opção:");
            System.out.println("1 - Calculo");
            System.out.println("2 - Calculo de troco");
            System.out.println("3 - Historico de vendas");
            System.out.println("4 - Sair");
            opcao = sc.nextInt();
            switch (opcao){
            case 1:
                planta = escolhaPlanta(planta, BAMBU, ORQUIDIA, CACTO);
                quantidade = informeQuantidade(quantidade);
                if (quantidade >= 10) {
                    precoTotal = calculoDesconto(planta, quantidade);
                    desconto = true;
                } else {
                    precoTotal = calculoVenda(planta, quantidade);
                }
                System.out.println("O preco total é " + precoTotal);
                listaVendas.add("Valor total: " + precoTotal + " Quantidade: " + quantidade + " Desconto: " + desconto);
                break;
            case 2:
                System.out.println("Informe o seu dinheiro");
                int dinheiro = sc.nextInt();
                int troco = calculoTroco(precoTotal, dinheiro);
                System.out.println("O troco é de " + troco);
                break;
            case 3:
                System.out.println(listaVendas);
                break;
            case 4: 
                System.out.println("Obrigado pela compra!");
                break;
            default: 
                System.out.println("Opção inválida!");
                break;
            }
        }
        

        
    }

}
