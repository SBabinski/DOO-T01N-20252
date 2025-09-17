import java.util.Scanner;
import java.util.ArrayList;

public class Devolucao {
    Scanner scanner = new Scanner(System.in);

    String buscatitulo;
    boolean encontrado;

    public void devolverL(ArrayList<Livro> livros) {
        System.out.println("Digite o titulo do livro para devolver: ");
        buscatitulo = scanner.nextLine();

        encontrado = false;

        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).titulo.equals(buscatitulo)) {
                encontrado = true;

                if (livros.get(i).isEmprestado()) {
                    livros.get(i).setEmprestado(false);
                    System.out.println(" Livro devolvido: " + livros.get(i).titulo);
                } else {
                    System.out.println(" Livro não estava emprestado!");
                }
                break;
             }
        }
        if (!encontrado){
            System.out.println(" Livro não encontrado! ");
        }
    }
}

