package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Vendedores;

public class CadastroVendedores {

	static Scanner scan = new Scanner(System.in);
	List<Vendedores> listaVendedores = new ArrayList<>();

	public void cadastrandoVendedores() {

		System.out.println("Qual o nome do vendedor?");
		String nome = scan.nextLine();
		System.out.println("Qual idade do vendedor?");
		int idade = scan.nextInt();
		scan.nextLine();
		System.out.println("Qual loja esse vendedor vai trabalhar?");
		String loja = scan.nextLine();
		System.out.println("Informe a cidade do vendedor:");
		String cidade = scan.nextLine();
		System.out.println("Qual bairro?");
		String bairro = scan.nextLine();
		System.out.println("Qual rua?");
		String rua = scan.nextLine();
		System.out.println("Qual sera o salario base desse vendedor?");
		BigDecimal salarioBase = scan.nextBigDecimal();
		scan.nextLine();

		Vendedores novoVendedor = new Vendedores(nome, idade, loja, cidade, bairro, rua, salarioBase);
		listaVendedores.add(novoVendedor);

		System.out.println("Vendedor cadastrado!");
		
	}

	public List<Vendedores> printaVendedoresNaTela() {
		return listaVendedores;
	}

}
