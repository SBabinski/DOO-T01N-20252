package calculadora;
import java.util.Scanner;

public class calc {
	static Scanner scan= new Scanner(System.in);
	
	public static void soma() {
		System.out.println("Quantidade de plantas vendidas?");
		float quantVendas = scan.nextFloat();
		System.out.println("Valor de cada planta?");
		float preco = scan.nextFloat();
		
		System.out.println("O preco das plantas vendidas foi de R$" + (quantVendas * preco));
		
	}
	
	
	public static void troco() {
		System.out.println("Valor pago pelo cliente");
		float valorCliente = scan.nextFloat();
		System.out.println("valor da compra");
		float valorDaCompra = scan.nextFloat();
		
		System.out.println("O troco do cliente sera de R$" + (valorDaCompra - valorCliente));
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println("\n===== MENU =====");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = scan.nextInt();
		switch(escolha) {
			case 1:
				soma();
				break;
			case 2:
				troco();
				break;
			case 3:
				System.out.println("saindo...");
				break;
			default:
				System.out.println("comando invalido");
				break;
		}
		
		

	}

}
