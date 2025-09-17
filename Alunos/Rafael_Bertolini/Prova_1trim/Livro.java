package codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livro {

	private String titulo;
	private String autor;
	private String descrição;
	private boolean raro;

	public Livro(String titulo, String autor, String descrição, boolean raro) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.descrição = descrição;
		this.raro = raro;
	}

	public Livro() {

	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Boolean getRaro() {
		return raro;
	}

	static Scanner scan = new Scanner(System.in);
	List<Livro> listaLivros = new ArrayList<>();

	public void cadastroLivro() {

		System.out.println("Qual titulo do livro?");
		String titulo = scan.nextLine();
		System.out.println("Qual autor do livro?");
		String autor = scan.nextLine();
		System.out.println("Passe uma breve descrição sobre o livro.");
		String descricao = scan.nextLine();
		System.out.println("Esse livro se encaixa no quadro de livros RAROS?");
		System.out.println("[1] Sim | [2] Não");
		int raroOuNao = scan.nextInt();
		scan.nextLine();
		boolean raro;

		if (raroOuNao == 1) {
			raro = true;
		} else {
			raro = false;
		}

		Livro livro = new Livro(titulo, autor, descricao, raro);
		listaLivros.add(livro);

		System.out.println("Livro cadastrado!");

	}

	public List<Livro> listaDeLivros() {
		return listaLivros;
	}

}
