package main;

import java.math.BigDecimal;
import java.util.Scanner;

import model.Valores;
import services.Calculo;
import services.Troco;
import model.ValoresTroco;

public class Main {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
	
		Valores valores = new Valores();
		ValoresTroco valoresTroco = new ValoresTroco();
		
		while(true) {
		System.out.println("Bem-vindo ao MENU!");
		System.out.println("[1] Calcular preço total.");
		System.out.println("[2] Calcular troco.");
		System.out.println("[3] Sair");
		int escolha = scan.nextInt();
		
		
			switch (escolha) {
			
			case 1:
				
				System.out.println("Qual a quantidade?");
				int quantidade = scan.nextInt();
				System.out.println("Qual valor?");
				BigDecimal valor = scan.nextBigDecimal();
				valores.setQuantidade(quantidade);
				valores.setValor(valor);
				
				Calculo calculo = new Calculo();
				BigDecimal total = calculo.ValorTotal(valores);
				System.out.println("O preço total foi de: "+ total + "R$");
			break;
			
			case 2: 
				
				System.out.println("Qual o valor total do produto?");
				BigDecimal valorTotalProduto = scan.nextBigDecimal();
				System.out.println("Qual valor pago pelo cliente?");
				BigDecimal valorPagoPeloCliente = scan.nextBigDecimal();
				valoresTroco.setValorPago(valorPagoPeloCliente);
				valoresTroco.setValorTotal(valorTotalProduto);
				
				Troco troco = new Troco();
				BigDecimal resultadoFinalDoTroco = troco.ResultadoDoTroco(valoresTroco);
				System.out.println("O troco deve ser: "+ resultadoFinalDoTroco + "R$");
				break;
			
			case 3:
				return;
				
			default:
				System.out.println("Opcao invalida");
			break;	
			
			}	
		}
	}
}
