package codigo;

import java.util.List;

public class VerificaEmprestimoDevolucao {

	public void verificacao(Livro ls, List<Livro> livrosEmprestados) {

		if (ls.getRaro()) {
			System.out.println(
					"O livro selecionado é um livro RARO! Livros raros estão probidos de empréstimo pelo seu alto valor e risco de não devolução.");
			return;
		}
		for (Livro vn : livrosEmprestados) {
			if (vn.getTitulo().equalsIgnoreCase(ls.getTitulo())) {
				System.out.println("O livro " + vn.getTitulo() + " já está emprestado.");
				return;
			}

			if (livrosEmprestados.isEmpty()) {
				livrosEmprestados.add(ls);
				System.out.println("Livro emprestado!");
				return;
			}
		}

		livrosEmprestados.add(ls);
		System.out.println("Livro emprestado!");

	}

	public void devolucao(Livro ls, List<Livro> livrosEmprestados) {

		int cont = 0;
		for (Livro lv : livrosEmprestados) {
			if (lv.getTitulo().equalsIgnoreCase(ls.getTitulo())) {
				livrosEmprestados.remove(cont);
				System.out.println("Livro devolvido!");
				return;
			}
			cont++;
		}

	}
}
