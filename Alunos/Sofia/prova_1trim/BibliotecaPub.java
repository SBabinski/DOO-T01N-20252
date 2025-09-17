package Alunos.Sofia.prova_1trim;

import java.util.*;

public class BibliotecaPub {
    private static Scanner sc = new Scanner(System.in);
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Livro> livros = new ArrayList<>();
    private static List<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- BibliotecaPub ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Buscar Livro por Título");
            System.out.println("4. Buscar Livro por Autor");
            System.out.println("5. Realizar Empréstimo");
            System.out.println("6. Realizar Devolução");
            System.out.println("7. Verificar Disponibilidade de Livro");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarLivro();
                    break;
                case 3:
                    buscarPorTitulo();
                    break;
                case 4:
                    buscarPorAutor();
                    break;
                case 5:
                    realizarEmprestimo();
                    break;
                case 6:
                    realizarDevolucao();
                    break;
                case 7:
                    verificarDisponibilidade();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }

    private static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        clientes.add(new Cliente(nome));
        System.out.println("Cliente cadastrado!");
    }

    private static void cadastrarLivro() {
        System.out.print("1. Livro Comum | 2. Livro Raro: ");
        int tipo = sc.nextInt();
        sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();

        if (tipo == 1) {
            livros.add(new LivroComum(titulo, autor));
        } else {
            System.out.print("Motivo de raridade: ");
            String motivo = sc.nextLine();
            livros.add(new LivroRaro(titulo, autor, motivo));
        }
        System.out.println("Livro cadastrado!");
    }

    private static void buscarPorTitulo() {
        System.out.print("Digite o título: ");
        String titulo = sc.nextLine();
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Encontrado: " + l.detalhes());
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    private static void buscarPorAutor() {
        System.out.print("Digite o autor: ");
        String autor = sc.nextLine();
        for (Livro l : livros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                System.out.println("Encontrado: " + l.detalhes());
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    private static void realizarEmprestimo() {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.print("Título do livro: ");
        String titulo = sc.nextLine();
        Livro livro = livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }
        if (!livro.podeSerEmprestado()) {
            System.out.println("Este livro é raro e não pode ser emprestado!");
            return;
        }
        if (livro.isEmprestado()) {
            System.out.println("Livro já emprestado!");
            return;
        }

        emprestimos.add(new Emprestimo(cliente, livro));
        System.out.println("Empréstimo realizado!");
    }

    private static void realizarDevolucao() {
        System.out.print("Título do livro a devolver: ");
        String titulo = sc.nextLine();
        Emprestimo emprestimo = emprestimos.stream()
                .filter(e -> e.getLivro().getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado!");
            return;
        }

        double multa = emprestimo.devolver();
        emprestimos.remove(emprestimo);

        if (multa > 0) {
            System.out.printf("Devolução feita com multa de R$ %.2f\n", multa);
        } else {
            System.out.println("Devolução feita sem multa.");
        }
    }

    private static void verificarDisponibilidade() {
        System.out.print("Título do livro: ");
        String titulo = sc.nextLine();
        Livro livro = livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

        if (livro == null) {
            System.out.println("Livro não encontrado!");
        } else if (livro.isEmprestado()) {
            System.out.println("Livro emprestado no momento.");
        } else {
            System.out.println("Livro disponível!");
        }
    }
}
