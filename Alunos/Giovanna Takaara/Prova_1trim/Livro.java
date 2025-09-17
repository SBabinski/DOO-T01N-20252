import java.util.ArrayList;
import java.util.Scanner;

public class Livro {
    Scanner scanner = new Scanner(System.in);

    String titulo;
    String autor;
    int quant;

    static ArrayList<Livro> livro = new ArrayList<>();


    public void cadastrarLivro() {
        Livro l = new Livro();

        System.out.println("Digite o titulo do livro: ");
        l.titulo = scanner.nextLine();

        System.out.println("Digite o Autor(a) do livro: ");
        l.autor = scanner.nextLine();

        System.out.println("Digite a quantidade de disponível: ");
        l.quant = scanner.nextInt();

        livro.add(l);

    }

    public void exibirLivros() {
        for (int i = 0; i < livro.size(); i++) {
            System.out.println("Livro " + (i + 1) + ": ");
            System.out.println(livro.get(i));
        }
    }

    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nQuantidade: " + quant;
    }

    public void buscatitulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < livro.size(); i++) {
            Livro l = livro.get(i);
            if (l.titulo.equals(titulo)) {
                System.out.println("Livro encontrado. ");
                System.out.println(l);
                encontrado = true;
            }
        }
        if (encontrado == false) {
            System.out.println("Nenhum livro encontrado.");
        }
    }
    public void buscaautor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < livro.size(); i++) {
            Livro l = livro.get(i);
            if (l.autor.equals(autor)) {
                System.out.println("Livro encontrado. ");
                System.out.println(l);
                encontrado = true;
            }
        }
        if (encontrado == false) {
            System.out.println("Nenhum livro encontrado.");
        }
    }

}

