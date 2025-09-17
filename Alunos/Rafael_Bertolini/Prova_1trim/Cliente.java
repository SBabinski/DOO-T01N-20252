package codigo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

	private String nome;
	private int idade;
	private String dataDeRegistro;

	public Cliente(String nome, int idade, String dataDeRegistro) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.dataDeRegistro = dataDeRegistro;
	}

	public Cliente() {
	}

	static Scanner scan = new Scanner(System.in);
	List<Cliente> listaDeCliente = new ArrayList<>();
	DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public void cadastroCliente() {

		LocalDate dataRegistroCliente = LocalDate.now();
		String dataFormatada = dataRegistroCliente.format(formataData);

		System.out.println("Digite o nome do cliente.");
		String nome = scan.nextLine();
		System.out.println("Digite a idade do cliente.");
		int idade = scan.nextInt();
		scan.nextLine();

		Cliente novoCliente = new Cliente(nome, idade, dataFormatada);
		listaDeCliente.add(novoCliente);

		System.out.println("Cliente cadastrado!");

	}

}
