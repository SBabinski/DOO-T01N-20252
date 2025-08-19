import java.util.Scanner;
public class Calc {

    
    int preco_total, troco, quantidade, planta, dinheiro;
    
    public static int calculo_venda(int planta, int quantidade){
       int preco_total = planta * quantidade;
       return preco_total;
    }

    public static int calculo_troco(int preco_total, int dinheiro){
        int troco = dinheiro - preco_total;
        return troco; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bambu = 10, orquidia = 15, cacto = 20;
        int planta = 0, quantidade;
        System.out.println("Selecione a sua planta");
        System.out.println("1 - Bambu");
         System.out.println("2 - Orquidia");
          System.out.println("3 - Cacto");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                planta = bambu;
                break;
            case 2:
                planta = orquidia;
                break;
            case 3:
                planta = cacto;
                break;
            default:
            System.out.println("Opção inválida!");
                break;
        }
        
       System.out.println("Informe quantas plantas irá comprar");
       quantidade = sc.nextInt();
        
        int preco_total;
        preco_total = calculo_venda(planta, quantidade);
        opcao = 0;
        while(opcao != 3){
            System.out.println("Selecione a sua opção:");
            System.out.println("1 - Calculo");
            System.out.println("2 - Calculo de troco");
            System.out.println("3 - Sair");
            opcao = sc.nextInt();
            switch (opcao){
            case 1:
                System.out.println("O preco total é " + preco_total);
                break;
            case 2:
                System.out.println("Informe o seu dinheiro");
                int dinheiro = sc.nextInt();
                int troco = calculo_troco(preco_total, dinheiro);
                System.out.println("O troco é de " + troco);
                break;
            case 3: 
                System.out.println("Obrigado pela compra!");
                break;
            default: 
                System.out.println("Opção inválida!");
                break;
            }
        }
        

        
    }

}
