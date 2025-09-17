import java.util.Scanner;
import java.util.ArrayList;

public class BuscaAutor {
        Scanner scanner = new Scanner(System.in);

        String buscaautor;
        boolean encontrado;

        public void buscarAutor(ArrayList<Livro> livros) {
            System.out.println("Digite o autor do livro para buscar: ");
            buscaautor = scanner.nextLine();

            encontrado = false;

            for (int i = 0; i < livros.size(); i++) {
                if (livros.get(i).autor.equals(buscaautor)) {
                    encontrado = true;
                    System.out.println("Livro encontrado: " + livros.get(i).titulo + " - "
                            + livros.get(i).autor);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Autor não encontrado!");
            }
        }
    }

