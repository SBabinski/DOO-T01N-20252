import java.util.ArrayList;
import java.util.Scanner;

public class BuscaTitulo {
        Scanner scanner = new Scanner(System.in);

        String buscatitulo;
        boolean encontrado;

        public void buscarTitulo(ArrayList<Livro> livros) {
            System.out.println("Digite o título do livro para buscar: ");
            buscatitulo = scanner.nextLine();

            encontrado = false;

            for (int i = 0; i < livros.size(); i++) {
                if (livros.get(i).titulo.equals(buscatitulo)) {
                    encontrado = true;
                    System.out.println("Livro encontrado: " + livros.get(i).titulo +
                            " - " + livros.get(i).autor);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Livro não encontrado!");
            }
        }
    }

