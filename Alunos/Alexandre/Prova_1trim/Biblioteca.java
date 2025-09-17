import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Biblioteca {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Livro> livros = new ArrayList<>();

    public void cadastrarCliente(Scanner sc) {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());
        clientes.add(new Cliente(nome, idade));
    }

    public void cadastrarLivroComum(Scanner sc) {
        System.out.print("Titulo do livro comum: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        livros.add(new Livro(titulo, autor, false, ""));
    }

    public void cadastrarLivroRaro(Scanner sc) {
        System.out.print("Titulo do livro raro: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Explique porque este livro e raro: ");
        String descricao = sc.nextLine();
        livros.add(new Livro(titulo, autor, true, descricao));
    }

    public void cadastrarLivro(Scanner sc) {
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("E raro? (s/n): ");
        boolean raro = sc.nextLine().equalsIgnoreCase("s");
        String descricao = "";
        if (raro) {
            System.out.print("Explique porque este livro e raro: ");
            descricao = sc.nextLine();
        }
        livros.add(new Livro(titulo, autor, raro, descricao));
    }

    public void buscarLivroTitulo(Scanner sc) {
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Encontrado: " + l.getTitulo() + " - " + l.getAutor() + (l.isRaro() ? " (Raro: " + l.getDescricao() + ")" : ""));
                break;
            }
        }
    }

    public void buscarLivroAutor(Scanner sc) {
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        for (Livro l : livros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                System.out.println("Encontrado: " + l.getTitulo() + " - " + l.getAutor() + (l.isRaro() ? " (Raro: " + l.getDescricao() + ")" : ""));
                break;
            }
        }
    }

    public void emprestarLivro(Scanner sc) {
        System.out.print("Titulo do livro para emprestimo: ");
        String titulo = sc.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                if (l.isRaro()) System.out.println("Livro raro, nao pode ser emprestado.");
                else if (l.isEmprestado()) System.out.println("Livro ja emprestado.");
                else {
                    l.emprestar();
                    l.setDataEmprestimo(new Date());
                    System.out.println("Emprestimo realizado em " + formato.format(l.getDataEmprestimo()));
                }
                break;
            }
        }
    }

    public void devolverLivro(Scanner sc) {
        System.out.print("Titulo do livro para devolucao: ");
        String titulo = sc.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) && l.isEmprestado()) {
                Date hoje = new Date();
                long dias = (hoje.getTime() - l.getDataEmprestimo().getTime()) / (1000L * 60 * 60 * 24);

                System.out.println("Data do emprestimo: " + formato.format(l.getDataEmprestimo()));
                System.out.println("Data da devolucao: " + formato.format(hoje));

                if (dias > 7) {
                    long atraso = dias - 7;
                    double multa = atraso * 3.5;
                    System.out.println("Livro devolvido com atraso de " + atraso + " dias.");
                    System.out.println("Multa a pagar: R$ " + multa);
                } else {
                    System.out.println("Devolucao realizada dentro do prazo. Sem multa.");
                }

                l.devolver();
                return;
            }
        }
        System.out.println("Livro nao encontrado ou nao esta emprestado.");
    }

    public void verificarDisponibilidade(Scanner sc) {
        System.out.print("Titulo do livro: ");
        String titulo = sc.nextLine();
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                if (l.isRaro()) System.out.println("Livro raro, apenas para exposicao.");
                else if (l.isEmprestado()) System.out.println("Livro emprestado.");
                else System.out.println("Disponivel para emprestimo.");
                break;
            }
        }
    }

    public void consultarAcervo() {
        if (livros.isEmpty()) System.out.println("Nenhum livro cadastrado.");
        else {
            System.out.println("Acervo da biblioteca:");
            for (Livro l : livros) {
                System.out.println("- " + l.getTitulo() + " | Autor: " + l.getAutor() + (l.isRaro() ? " (Raro: " + l.getDescricao() + ")" : ""));
            }
        }
    }
}
