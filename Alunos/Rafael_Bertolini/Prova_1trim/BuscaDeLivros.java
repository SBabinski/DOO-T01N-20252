package codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaDeLivros {

	static Scanner scan = new Scanner(System.in);

	public void buscaPorLivro(Livro livro) {

		List<Livro> listaLivros = livro.listaDeLivros();

		if (listaLivros.isEmpty()) {
			System.out.println("Não existe livros registrados.");
			return;
		}

		System.out.println("Digite o nome do livro.");
		System.out.println("OBS: O nome do livro não pode conter erros, se não a busca não será realizada.");
		String nomeDoLivro = scan.nextLine();

		for (Livro buscaPeloLivro : listaLivros) {

			if (buscaPeloLivro.getTitulo().equalsIgnoreCase(nomeDoLivro)) {

				System.out.println("O livro " + nomeDoLivro + " foi encontrado.");
				break;

			} else {

				System.out.println("O livro " + nomeDoLivro + " não existe na biblioteca.");

			}

		}

	}

	public void buscaPeloAutor(Livro livro) {

		List<Livro> listaLivros = livro.listaDeLivros();
		List<Livro> autoresEncontrados = new ArrayList<>();

		if (listaLivros.isEmpty()) {
			System.out.println("Não existe livros registrados.");
			return;
		}

		System.out.println("Digite o nome do autor do livro.");
		System.out.println("OBS: O nome do autor do livro não pode conter erros, se não a busca não será realizada.");
		String nomeDoAutor = scan.nextLine();

		for (Livro buscaPeloAutor : listaLivros) {

			if (buscaPeloAutor.getAutor().equalsIgnoreCase(nomeDoAutor)) {

				autoresEncontrados.add(buscaPeloAutor);

			}

			if (autoresEncontrados.isEmpty()) {
				System.out.println("Não existe livros no nome deste autor.");
			}

			for (Livro livrosAutor : autoresEncontrados) {

				System.out.println("O livro " + livrosAutor.getTitulo() + " é do autor informado.");

			}

		}
	}

}
