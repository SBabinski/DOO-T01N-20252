package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Item;

public class CadastroItens {

	static Scanner scan = new Scanner(System.in);
	List<Item> listaDeItens = new ArrayList<>();
	int contadorId = 0;

	public void cadastrandoItem() {

		System.out.println("Qual o nome do item?");
		String nome = scan.nextLine();
		System.out.println("Qual o tipo do item?");
		String tipo = scan.nextLine();
		System.out.println("Qual o valor do item?");
		BigDecimal valor = scan.nextBigDecimal();
		scan.nextLine();

		contadorId++;

		Item item = new Item(contadorId, nome, tipo, valor);
		listaDeItens.add(item);

		System.out.println("Item cadastrado!");

	}

	public List<Item> chamaListaDeItens() {
		return listaDeItens;
	}

}
