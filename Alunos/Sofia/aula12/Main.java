package Alunos.Sofia.aula12;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Main {
	public static void main(String[] args) {

		//ATV1 - Filtrar números pares
		System.out.println("//ATV1");
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10, 12);
		List<Integer> pares = numeros.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());
		System.out.println("Números pares: " + pares);

		//ATV2 - Converter nomes para maiúsculas
		System.out.println("\n//ATV2");
		List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
		List<String> nomesMaiusculos = nomes.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println("Nomes maiúsculos: " + nomesMaiusculos);

		//ATV3 - Contar quantas vezes cada palavra aparece em uma lista
		System.out.println("\n//ATV3");
		List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
		Map<String, Long> contagem = palavras.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Contagem de palavras:");
		contagem.forEach((palavra, qte) -> System.out.println(palavra + " -> " + qte));

		//ATV4 - Classe Produto e filtro de produtos com preço > 100
		System.out.println("\n//ATV4");
		List<Produto> produtos = Arrays.asList(
				new Produto("Caneta", 5.00),
				new Produto("Fone Bluetooth", 199.90),
				new Produto("Teclado Mecânico", 350.00),
				new Produto("Caderno", 12.50)
		);
		List<Produto> produtosCaros = produtos.stream()
				.filter(p -> p.getPreco() > 100.00)
				.collect(Collectors.toList());
		System.out.println("Produtos com preço > R$100,00:");
		produtosCaros.forEach(p -> System.out.println(p.getNome() + " - R$ " + p.getPreco()));

		//ATV5 - Soma do valor total dos produtos
		System.out.println("\n//ATV5");
		double somaTotal = produtos.stream()
				.mapToDouble(Produto::getPreco)
				.sum();
		System.out.printf("Soma total dos produtos: R$ %.2f%n", somaTotal);

		//ATV6 - Ordenar lista por tamanho da palavra (menor -> maior)
		System.out.println("\n//ATV6");
		List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
		List<String> ordenadoPorTamanho = linguagens.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		System.out.println("Ordenado por tamanho: " + ordenadoPorTamanho);
	}
}

// Classe Produto definida no mesmo arquivo
class Produto {
	private String nome;
	private double preco;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return nome + " - R$ " + preco;
	}
}
