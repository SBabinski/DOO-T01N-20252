import java.util.Scanner;
import java.util.ArrayList;

public class Emprestimo {
    Scanner scanner = new Scanner(System.in);

    String buscatitulo;
    boolean encontrado;

    public void emprestarL(ArrayList<Livro> livros) {
        System.out.println("Digite o título do livro para emprestar: ");
        buscatitulo = scanner.nextLine();
        encontrado = false;

        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).titulo.equals(buscatitulo)) {
                encontrado = true;

                if (!livros.get(i).isEmprestado()) {
                    livros.get(i).emprestar();
                } else {
                    System.out.println(" Livro já está emprestado!");
                }
                break;
            }
        }
        if (! encontrado){
            System.out.println("Livro não encontrado ");
        }
    }
   }