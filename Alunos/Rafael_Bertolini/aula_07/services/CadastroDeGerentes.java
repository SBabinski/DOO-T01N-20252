package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Gerentes;
import model.Vendedores;

public class CadastroDeGerentes {

	static Scanner scan = new Scanner(System.in);
	List<Vendedores> listaGerentes = new ArrayList<>();

	public void cadastrandoGerentes() {

		System.out.println("Qual o nome do gerente?");
		String nome = scan.nextLine();
		System.out.println("Qual idade do gerente?");
		int idade = scan.nextInt();
		scan.nextLine();
		System.out.println("Qual loja esse gerente vai trabalhar?");
		String loja = scan.nextLine();
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
		System.out.println("Qual sera o salario base desse gerente?");
		BigDecimal salarioBase = scan.nextBigDecimal();
		scan.nextLine();

		Gerentes novoGerente = new Gerentes(nome, idade, loja, estado, cidade, bairro, numero, complemento,
				salarioBase);
		listaGerentes.add(novoGerente);

		System.out.println("Gerente cadastrado!");

	}

	public List<Vendedores> printaVendedoresNaTela() {
		return listaGerentes;
	}

}
