package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Clientes;

public class CadastroDeClientes {

	static Scanner scan = new Scanner(System.in);
	List<Clientes> listaDeClientes = new ArrayList<>();

	public void cadastrandoCliente() {

		System.out.println("Qual o nome do cliente?");
		String nome = scan.nextLine();
		System.out.println("Qual a idade do cliente?");
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

		Clientes novoCliente = new Clientes(nome, idade, estado, cidade, bairro, numero, complemento);
		listaDeClientes.add(novoCliente);

		System.out.println("Cliente registrado!");

	}

	public List<Clientes> chamaListaDeClientes() {
		return listaDeClientes;
	}

}
