package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Loja;
import model.Vendedores;

public class CadastroVendedores {

	static Scanner scan = new Scanner(System.in);
	List<Vendedores> listaVendedores = new ArrayList<>();
	Loja lojaa = new Loja();

	public void cadastrandoVendedores() {

		String loja = lojaa.getNomeFantasia();
		System.out.println("Qual o nome do vendedor?");
		String nome = scan.nextLine();
		System.out.println("Qual idade do vendedor?");
		int idade = scan.nextInt();
		scan.nextLine();
		System.out.println("Qual estado do vendedor?");
		String estado = scan.nextLine();
		System.out.println("Informe a cidade do vendedor:");
		String cidade = scan.nextLine();
		System.out.println("Qual bairro?");
		String bairro = scan.nextLine();
		System.out.println("Qual numero?");
		int numero = scan.nextInt();
		scan.nextLine();
		System.out.println("Qual complemento?");
		String complemento = scan.nextLine();
		System.out.println("Qual sera o salario base desse vendedor?");
		BigDecimal salarioBase = scan.nextBigDecimal();
		scan.nextLine();

		Vendedores novoVendedor = new Vendedores(nome, idade, loja, estado, cidade, bairro, numero, complemento,
				salarioBase);
		listaVendedores.add(novoVendedor);

		System.out.println("Vendedor cadastrado!");

	}

	public List<Vendedores> printaVendedoresNaTela() {
		return listaVendedores;
	}

}
