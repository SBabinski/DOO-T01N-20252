package calculadora;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class calc {
	static Scanner scan= new Scanner(System.in);
	static List<Float> listaVendas = new ArrayList<>();
	

	public static void soma() {
		
		System.out.println("Quantidade de plantas vendidas?");
		float quantVendas = scan.nextFloat();
		System.out.println("Valor de cada planta?");
		float preco = scan.nextFloat();
		
		float precoFinal = quantVendas * preco;
		float precoDesconto = (float) (precoFinal -(precoFinal* 0.05));
		
		if(quantVendas >= 10) {
			System.out.println("O preco das plantas com desconto de 5% foi de: "+ precoDesconto);
			System.out.println("Venda realizada no sistema");
			listaVendas.add(precoDesconto);
		}else {
			System.out.println("O preco das plantas vendidas foi de R$"+ precoFinal);
			System.out.println("Venda realizada no sistema");
			listaVendas.add(precoFinal);
			
		}	
	}
	
	
	public static void troco() {
		System.out.println("Valor pago pelo cliente");
		float valorCliente = scan.nextFloat();
		System.out.println("valor da compra");
		float valorDaCompra = scan.nextFloat();
		
		System.out.println("O troco do cliente sera de R$" + (valorDaCompra - valorCliente));
		
	}
	
	
	public static void armazenamento() {
		System.out.println(listaVendas);
		
	}
	
	
	
	public static void main(String[] args) {
		int escolha;
		
		do {
			System.out.println("\n===== MENU =====");
	        System.out.println("[1] - Calcular Preço Total");
	        System.out.println("[2] - Calcular Troco");
	        System.out.println("[3] - Mostrar Registro de Vendas");
	        System.out.println("[4] - Sair");
	        System.out.print("Escolha uma opção: ");
	        
	        escolha = scan.nextInt();
			
			switch(escolha) {
				case 1:
					soma();
					break;
				case 2:
					troco();
					break;
				case 3:
					armazenamento();
					break;
				case 4:
					System.out.println("saindo...");
					break;
				
				default:
					
					System.out.println("comando invalido");
					break;
				
			}
		}while(escolha != 4);
	}
	}


					


