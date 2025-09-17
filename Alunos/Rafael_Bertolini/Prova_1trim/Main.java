package codigo;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		Livro livro = new Livro();
		BuscaDeLivros bl = new BuscaDeLivros();
		EmprestimoDevolucao emp = new EmprestimoDevolucao();

		while (true) {

			System.out.println("--- MENU ---");
			System.out.println("[0] Encerrar sistema.");
			System.out.println("[1] Cadastrar cliente.");
			System.out.println("[2] Cadastro de livros.");
			System.out.println("[3] Buscar livro na biblioteca.");
			System.out.println("[4] Cadastrar um empréstimo de um livro.");
			System.out.println("[5] Devolver um livro emprestado.");
			int escolhaMenu = scan.nextInt();
			scan.nextLine();

			switch (escolhaMenu) {

			case 0:
				return;

			case 1:
				cliente.cadastroCliente();
				break;

			case 2:
				livro.cadastroLivro();
				break;

			case 3:
				System.out.println("Selecione uma opção:");
				System.out.println("[1] Buscar livro pelo nome do livro.");
				System.out.println("[2] Buscar livro pelo nome do autor.");
				int opcao = scan.nextInt();
				scan.nextLine();

				if (opcao == 1) {
					bl.buscaPorLivro(livro);
				} else if (opcao == 2) {
					bl.buscaPeloAutor(livro);
				} else {
					System.out.println("Opção invalida");
				}
				break;

			case 4:
				emp.realizarEmprestimo(livro);
				break;

			case 5:
				emp.devoluçãoLivro(livro);
				break;
			}
		}
	}
}
