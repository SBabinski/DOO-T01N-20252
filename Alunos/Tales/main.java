package Alunos.Tales;

import java.util.InputMismatchException; 
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        try ( 
                Scanner scanner = new Scanner(System.in)) {
            int opcao = 0; 
            do {
               
                System.out.println("\n=== Calculadora Dona Gabrielinha ===");
                System.out.println("[1] - Calcular Preço Total");
                System.out.println("[2] - Calcular Troco");
                System.out.println("[3] - Sair");
                System.out.print("Escolha uma opção: ");
               
                try {
                    opcao = scanner.nextInt(); 
                } catch (InputMismatchException e) {
                   
                    System.out.println("Entrada inválida. Por favor, digite um número inteiro para a opção.");
                    scanner.next(); 
                    opcao = 0; 
                    continue; 
                }
                
               
                switch (opcao) {
                    case 1:
                        
                        System.out.println("\n--- Calcular Preço Total ---");
                        System.out.print("Digite a quantidade da planta: ");
                        
                        double quantidade = scanner.nextDouble();
                        
                        System.out.println("Digite o preço unitário da planta: R$ ");
                        
                        double precoUnitario = scanner.nextDouble();
                        
                        double precoTotal = quantidade * precoUnitario; 
                        System.out.println("O preço total da venda é: R$ " + String.format("%.2f", precoTotal));
                        break; 
                        
                    case 2:
                       
                        System.out.println("\n--- Calcular Troco ---");
                        System.out.print("Digite o valor recebido do cliente: R$ ");
                       
                        double valorRecebido = scanner.nextDouble();
                        
                        System.out.print("Digite o valor total da compra: R$ ");
                       
                        double valorTotalCompra = scanner.nextDouble();
                        
                        double troco = valorRecebido - valorTotalCompra; 
                        if (troco < 0) {
                           
                            System.out.println("O valor recebido é insuficiente. Faltam: R$ " + String.format("%.2f", Math.abs(troco)));
                        } else {
                            
                            System.out.println("O troco a ser dado é: R$ " + String.format("%.2f", troco));
                        }
                        break; 
                    case 3:
                      
                        System.out.println("Obrigado por usar a Calculadora da Dona Gabrielinha! Volte sempre!");
                        break; 
                        
                    default:
                       
                        System.out.println("Opção inválida. Por favor, escolha 1, 2 ou 3.");
                }
            } while (opcao != 3); 
        } 
    }
}