package Alunos.Bernardo.Prova_1trim;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Livro> livros = new ArrayList<>();
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static DecimalFormat df = new DecimalFormat("0.00");

    public static void cadastrarCliente() {
        System.out.println("\nDigite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, (float) 0.00);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void cadastrarLivro() {
        System.out.println("\nDigite o tipo do livro:");
        System.out.println("[1] Comum");
        System.out.println("[2] Raro");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o nome do autor:");
        String autor = scanner.nextLine();

        if (opcao == 1) {
            livros.add(new LivroComum(titulo, autor));
            System.out.println("Livro comum cadastrado!");
        } else {
            System.out.println("Digite o motivo do livro ser raro:");
            String motivo = scanner.nextLine();
            livros.add(new LivroRaro(titulo, autor, motivo));
            System.out.println("Livro raro cadastrado!");
        }
    }

    public static void buscarLivro() {
        if (livros.isEmpty()) {
            System.out.println("\nNão há nenhum livro cadastrado!");
            return;
        }
        System.out.println("\n[1] Buscar livro por título");
        System.out.println("[2] Buscar livro por autor");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 1) {
            System.out.println("Digite o título do livro:");
            String pesquisaTitulo = scanner.nextLine();
            for (Livro l : livros) {
                if (l.getTitulo().equalsIgnoreCase(pesquisaTitulo)) {
                    System.out.println("Livro encontrado!");
                    System.out.println("Nome do livro: " + l.getTitulo());
                    System.out.println("Nome do autor: " + l.getAutor());
                    return;
                }
            }
        }
        if (opcao == 2) {
            System.out.println("Digite o nome do autor:");
            String pesquisaAutor = scanner.nextLine();
            for (Livro l : livros) {
                if (l.getAutor().equalsIgnoreCase(pesquisaAutor)) {
                    System.out.println("Livro encontrado!");
                    System.out.println("Nome do livro: " + l.getTitulo());
                    System.out.println("Nome do autor: " + l.getAutor());
                    return;
                }
            }
        }
        System.out.println("Livro não encontrado!");
    }

    public static void realizarEmprestimo() {
        if (livros.isEmpty()) {
        System.out.println("\nNão há nenhum livro cadastrado!");
        return;
        }
        System.out.println("Digite o título do livro a ser emprestado:");
        String titulo = scanner.nextLine();

        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                if (l.isEmprestado()) {
                    System.out.println("Este livro já está emprestado!");
                    return;
                }

                System.out.println("Digite o CPF do cliente que realizará o empréstimo:");
                String cpf = scanner.nextLine();

                Cliente cliente = null;
                for (Cliente c : clientes) {
                    if (c.getCpf().equalsIgnoreCase(cpf)) {
                        cliente = c;
                        break;
                    }
                }

                if (cliente == null) {
                    System.out.println("Cliente não encontrado!");
                    return;
                }

                System.out.println("Digite a data do empréstimo (no seguinte formato - dd/MM/yyyy):");
                String dataString = scanner.nextLine();
                LocalDate data = LocalDate.parse(dataString, dtf);

                l.emprestar(cpf, data);
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    public static void realizarDevolucao() {
        if (livros.isEmpty()) {
            System.out.println("\nNão há nenhum livro cadastrado!");
            return;
        }
        System.out.println("Digite o título do livro a ser devolvido:");
        String titulo = scanner.nextLine();

        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Digite a data da devolução (dd/MM/yyyy):");
                String dataString = scanner.nextLine();
                LocalDate dataDevolucao = LocalDate.parse(dataString, dtf);

                float multa = l.devolver(dataDevolucao);1
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    public static void verificarDisponibilidade() {
        if (livros.isEmpty()) {
            System.out.println("\nNão há nenhum livro cadastrado!");
            return;
        }
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();

        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                if (l.isEmprestado()) {
                    System.out.println("Livro emprestado. Indisponível no momento.");                     
                } else {
                    System.out.println("Livro disponível para empréstimo");
                }
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }
    public static void main (String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("[1] Cadastrar cliente");
            System.out.println("[2] Cadastrar livro");
            System.out.println("[3] Buscar livro");
            System.out.println("[4] Realizar empréstimo");
            System.out.println("[5] Realizar devolução");
            System.out.println("[6] Verificar disponibilidade de empréstimo");
            System.out.println("[7] Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarLivro();
                    break;
                case 3:
                    buscarLivro();
                    break;
                case 4:
                    realizarEmprestimo();
                    break;
                case 5:
                    realizarDevolucao();
                    break;
                case 6:
                    verificarDisponibilidade();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        }
    }
}
