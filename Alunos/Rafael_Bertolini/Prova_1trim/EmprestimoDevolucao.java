package codigo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDevolucao extends Livro {

	private List<Livro> livrosEmprestados = new ArrayList<>();
	private LocalDate dataEmprestimo;

	public EmprestimoDevolucao(String titulo, String autor, String descrição, boolean raro,
			List<Livro> livrosEmprestados, LocalDate dataEmprestimo) {
		super(titulo, autor, descrição, raro);
		this.livrosEmprestados = livrosEmprestados;
		this.dataEmprestimo = dataEmprestimo;
	}

	public EmprestimoDevolucao() {

	}

	public List<Livro> getLivrosEmprestados() {
		return livrosEmprestados;
	}

	public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
		this.livrosEmprestados = livrosEmprestados;
	}

	VerificaEmprestimoDevolucao ve = new VerificaEmprestimoDevolucao();

	public void realizarEmprestimo(Livro livro) {

		List<Livro> listaDeLivros = livro.listaDeLivros();

		if (listaDeLivros.isEmpty()) {
			System.out.println("Não existe livros cadastrados no sistema.");
			return;
		}

		int cont = 1;
		System.out.println("A seguir, selecione um livro da lista para emprestar:");
		for (Livro livros : listaDeLivros) {

			System.out.println(
					"[" + cont + "] | Nome do livro: " + livros.getTitulo() + " | Autor: " + livros.getAutor());
			cont++;

		}

		System.out.println("Selecione o livro desejado pelo número.");
		int escolha = scan.nextInt();
		scan.nextLine();

		Livro livroSelecionado = listaDeLivros.get(escolha - 1);
		ve.verificacao(livroSelecionado, livrosEmprestados);

	}

	public void devoluçãoLivro(Livro livro) {

		if (livrosEmprestados.isEmpty()) {
			System.out.println("Não existe nenhum livro emprestado no momento.");
			return;
		}

		int cont = 1;
		System.out.println("Lista de livros emprestados:");
		for (Livro livros : livrosEmprestados) {
			System.out.println(
					"[" + cont + "] | Nome do livro: " + livros.getTitulo() + " | Autor: " + livros.getAutor());
		}

		System.out.println("Selecione o numero do livro que deseja devolver: ");
		int escolha = scan.nextInt();
		scan.nextLine();

		Livro livroSelecionado = livrosEmprestados.get(escolha - 1);
		ve.devolucao(livroSelecionado, livrosEmprestados);

	}

}
