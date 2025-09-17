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
		System.out.println("Qual a cidade do cliente?");
		String cidade = scan.nextLine();
		System.out.println("Qual o bairro que o cliente reside?");
		String bairro = scan.nextLine();
		System.out.println("Qual a rua que o cliente reside?");
		String rua = scan.nextLine();

		Clientes novoCliente = new Clientes(nome, idade, cidade, bairro, rua);
		listaDeClientes.add(novoCliente);

		System.out.println("Cliente registrado!");
		
	}

	public List<Clientes> chamaListaDeClientes() {
		return listaDeClientes;
	}

}
