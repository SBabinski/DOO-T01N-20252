package Alunos.Jose_Euclides.Prova_1trim;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Book> dataBooks = new ArrayList<>();
    private static ArrayList<LoanBooks> dataLoanBooks = new ArrayList<>();
    private static ArrayList<Customer> dataCustomers = new ArrayList<>();

    public static String getNameFromUser(String message) {
        System.out.println(message);
        return scan.next();
    }

    public static String getStringFromUser(String message) {
        System.out.println(message);
        String text = scan.nextLine();
        return text;
    }

    public static int getIntFromUser(String message) {
        System.out.println(message);
        return scan.nextInt();
    }

    public static void flowCreateNewCustomer() {
        Customer customer = new Customer();
        customer.setName(getStringFromUser("\nDigite o nome do cliente: "));
        customer.setCpf(getStringFromUser("\nDigite o CPF do cliente (Ex: 707.090.174-18): "));
        customer.setEmail(getStringFromUser("\nDigite o email do cliente (Ex: jose18@gmail.com): "));
        customer.setPhone(getStringFromUser("\nDigite o telefone do cliente (Ex: (45)99838-5841 - *Sem espaços): "));

        dataCustomers.add(customer);
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println(customer.toString());
    }

    public static void flowCreateBookCommon() {
        Book book = new Book();

        book.setTitle(getStringFromUser("Digite o título do livro: "));
        book.setAuthor(getStringFromUser("Digite o autor do livro: "));
        book.setSpecial(false);

        dataBooks.add(book);
        System.out.println("Livro comum cadastrado com sucesso!");
        System.out.println(book.toString());
    }

    public static void flowCreateBookSpecial() {
        Book book = new Book();

        book.setTitle(getStringFromUser("Digite o título do livro: "));
        book.setAuthor(getStringFromUser("Digite o autor do livro: "));
        book.setSpecial(true);
        book.setTextWhyIsSpecial(getStringFromUser("Digite o motivo pelo qual este livro é especial/raro: "));

        dataBooks.add(book);
        System.out.println("Livro especial cadastrado com sucesso!");
        System.out.println(book.toString());
    }

    public static String replaceLettesWithAcentos(String text) {
        text = text.toLowerCase();

        text = text.replace("á", "a");
        text = text.replace("ã", "a");
        text = text.replace("é", "e");
        text = text.replace("í", "i");
        text = text.replace("ó", "o");
        text = text.replace("õ", "o");
        text = text.replace("ú", "u");
        text = text.replace("ç", "c");

        return text;
    }

    public static void flowSearchByTitle() {
        String titleSearched = getStringFromUser("Digite o título do livro que deseja buscar: ");
        titleSearched = replaceLettesWithAcentos(titleSearched);

        System.out.println("\n\n=== RESULTADOS DA BUSCA POR TÍTULO ===");
        boolean found = false;

        for (int i = 0; i < dataBooks.size(); i++) {
            Book book = dataBooks.get(i);
            String titleInBook = replaceLettesWithAcentos(book.getTitle());

            if (titleInBook.contains(titleSearched)) {
                found = true;
                System.out.println("[" + (i + 1) + "] " + book.toString());
                return;
            }
        }

        if (!found) {
            System.out.println("Nenhum livro encontrado com o título: " + titleSearched);
        }
    }

    public static void flowSearchByAuthor() {
        String authorSearched = getStringFromUser("Digite o autor do livro que deseja buscar: ");
        authorSearched = replaceLettesWithAcentos(authorSearched);

        System.out.println("\n\n=== RESULTADOS DA BUSCA POR AUTOR ===");
        boolean found = false;

        for (int i = 0; i < dataBooks.size(); i++) {
            Book book = dataBooks.get(i);
            String authorInBook = replaceLettesWithAcentos(book.getAuthor());

            if (authorInBook.contains(authorSearched)) {
                found = true;
                System.out.println("[" + (i + 1) + "] " + book.toString());
                return;
            }
        }

        if (!found) {
            System.out.println("Nenhum livro encontrado com o autor: " + authorSearched);
        }
    }

    /*
     * public validaIndex(int index, ArrayList array) {
     * 
     * }
     */

    public static void flowMakeLoan() {
        if (dataBooks.size() == 0) {
            System.out.println("Nenhum livro cadastrado! Cadastre um livro primeiro.");
            return;
        }

        if (dataCustomers.size() == 0) {
            System.out.println("Nenhum cliente cadastrado! Cadastre um cliente primeiro.");
            return;
        }

        System.out.println("\n=== REALIZAR EMPRÉSTIMO ===");

        System.out.println("Escolha o cliente:");
        for (int i = 0; i < dataCustomers.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + dataCustomers.get(i).getName());
        }

        int customerIndex = getIntFromUser("Digite o número do cliente: ") - 1;
        if (customerIndex < 0 || customerIndex >= dataCustomers.size()) {
            System.out.println("Índice de cliente inválido!");
            return;
        }

        Customer selectedCustomer = dataCustomers.get(customerIndex);

        System.out.println("\nEscolha o livro:");
        for (int i = 0; i < dataBooks.size(); i++) {
            Book book = dataBooks.get(i);
            System.out.println("[" + (i + 1) + "] - " + book.getTitle() + " - " + book.getAuthor());
        }

        int livroIndex = getIntFromUser("Digite o número do livro: ") - 1;
        if (livroIndex < 0 || livroIndex >= dataBooks.size()) {
            System.out.println("Índice de livro inválido!");
            return;
        }

        Book selectedBook = dataBooks.get(livroIndex);

        if (selectedBook.isSpecial()) {
            System.out.println("Este livro é especial e não pode ser emprestado!");
            System.out.println("Motivo: " + selectedBook.getTextWhyIsSpecial());
            return;
        }

        if (!checkBookAvailability(selectedBook)) {
            System.out.println("Este livro já está emprestado!");
            return;
        }

        LoanBooks loan = new LoanBooks();
        loan.setIdBook(selectedBook.getTitle() + "_" + selectedBook.getAuthor());
        loan.setCpfCustomer(selectedCustomer.getCpf());
        loan.setDateDoneLoan(LocalDate.now());

        scan.nextLine();
        String dateString = getStringFromUser("Digite a data que é para devolver o livro: (padrao: dia/mes/ano)");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        loan.setDateToBack(date);
        loan.setDateBackBook(null);

        dataLoanBooks.add(loan);

        System.out.println("Empréstimo realizado com sucesso!");
        System.out.println("Cliente: " + dataCustomers.get(customerIndex).getName());
        System.out.println("Livro: " + selectedBook.getTitle());
        System.out.println("Data do empréstimo: " + loan.getDateDoneLoan());
        System.out.println("Data limite para devolução: " + loan.getDateToBack());
    }

    public static void flowMakeBookBack() {
        if (dataLoanBooks.size() == 0) {
            System.out.println("Nenhum empréstimo ativo encontrado!");
            return;
        }

        System.out.println("\n=== REALIZAR DEVOLUÇÃO ===");

        System.out.println("Livros sem devoluçao:");
        for (int i = 0; i < dataLoanBooks.size(); i++) {
            LoanBooks loan = dataLoanBooks.get(i);
            if (loan.getDateBackBook() == null) {
                String customerName = getCustomerNameByCpf(loan.getCpfCustomer());
                System.out.println(
                        "[" + (i + 1) + "] - " + loan.getIdBook() +
                                " (Cliente: " + customerName + " - CPF: " + loan.getCpfCustomer() +
                                " - Emprestado em: " + loan.getDateDoneLoan() +
                                " - Devolver até: " + loan.getDateToBack() + ")");
            }
        }

        int loanIndex = getIntFromUser("Digite o número do empréstimo para devolver: ") - 1;
        if (loanIndex < 0 || loanIndex >= dataLoanBooks.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        LoanBooks selectedLoan = dataLoanBooks.get(loanIndex);

        if (selectedLoan.getDateBackBook() != null) {
            System.out.println("Este empréstimo já foi devolvido!");
            return;
        }

        LocalDate today = LocalDate.now();
        LocalDate dateToBack = selectedLoan.getDateToBack();

        double priceFine = 0.0;
        if (today.isAfter(dateToBack)) {
            long overdueDays = ChronoUnit.DAYS.between(dateToBack, today);
            priceFine = overdueDays * 3.50;
        }

        selectedLoan.setDateBackBook(today);

        System.out.println("Devolução realizada com sucesso!");
        System.out.println("Livro: " + selectedLoan.getIdBook());
        System.out.println("Data da devolução: " + today);
        System.out.println("Data limite era: " + dateToBack);

        if (priceFine > 0) {
            long overdueDays = ChronoUnit.DAYS.between(dateToBack, today);
            System.out.println("Multa por atraso: R$ " + String.format("%.2f", priceFine));
            System.out.println("Dias de atraso: " + overdueDays);
        } else {
            System.out.println("Devolução dentro do prazo - sem multa!");
        }
    }

    public static void checkLoanAvailabilityOfBook() {
        if (dataBooks.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        System.out.println("\n=== VERIFICAR DISPONIBILIDADE ===");

        System.out.println("Escolha o livro:");
        for (int i = 0; i < dataBooks.size(); i++) {
            Book book = dataBooks.get(i);
            System.out.println("[" + (i + 1) + "] - " + book.getTitle() + " - " + book.getAuthor());
        }

        int livroIndex = getIntFromUser("Digite o número do livro: ") - 1;
        if (livroIndex < 0 || livroIndex >= dataBooks.size()) {
            System.out.println("Índice de livro inválido!");
            return;
        }

        Book selectedBook = dataBooks.get(livroIndex);

        if (selectedBook.isSpecial()) {
            System.out.println("Este livro é especial e não pode ser emprestado!");
            System.out.println("Motivo: " + selectedBook.getTextWhyIsSpecial());
            return;
        }

        boolean available = checkBookAvailability(selectedBook);

        if (available) {
            System.out.println("Livro disponível para empréstimo!");
        } else {
            LoanBooks activeLoan = getActiveLoanByBook(selectedBook);
            if (activeLoan != null) {
                String customerName = getCustomerNameByCpf(activeLoan.getCpfCustomer());
                System.out.println("Livro indisponível, já está emprestado!");
                System.out.println("   Cliente: " + customerName + " (CPF: " + activeLoan.getCpfCustomer() + ")");
                System.out.println("   Data do empréstimo: " + activeLoan.getDateDoneLoan());
            }
        }
    }

    private static boolean checkBookAvailability(Book book) {
        String bookId = book.getTitle() + "_" + book.getAuthor();

        for (LoanBooks loan : dataLoanBooks) {
            if (loan.getIdBook().equals(bookId) && loan.getDateBackBook() == null) {
                return false;
            }
        }
        return true;
    }

    private static String getCustomerNameByCpf(String cpf) {
        for (Customer customer : dataCustomers) {
            if (customer.getCpf().equals(cpf)) {
                return customer.getName();
            }
        }
        return "Cliente não encontrado";
    }

    private static LoanBooks getActiveLoanByBook(Book book) {
        String bookId = book.getTitle() + "_" + book.getAuthor();

        for (LoanBooks loan : dataLoanBooks) {
            if (loan.getIdBook().equals(bookId) && loan.getDateBackBook() == null) {
                return loan;
            }
        }
        return null;
    }

    public static void listActiveLoans() {
        if (dataLoanBooks.size() == 0) {
            System.out.println("Nenhum livro foi emprestado ainda!");
            return;
        }

        System.out.println("\n=== LIVROS EMPRESTADOS SEM DEVOLUÇÃO ===");
        boolean hasActiveLoans = false;

        for (int i = 0; i < dataLoanBooks.size(); i++) {
            LoanBooks loan = dataLoanBooks.get(i);
            if (loan.getDateBackBook() == null) {
                String customerName = getCustomerNameByCpf(loan.getCpfCustomer());
                System.out.println("\n--- Empréstimo " + (i + 1) + " ---");
                System.out.println("Livro: " + loan.getIdBook());
                System.out.println("Cliente: " + customerName);
                System.out.println("CPF: " + loan.getCpfCustomer());
                System.out.println("Data do empréstimo: " + loan.getDateDoneLoan());
                System.out.println("Data limite para devolução: " + loan.getDateToBack());

                LocalDate today = LocalDate.now();
                LocalDate dateToBack = loan.getDateToBack();

                if (today.isAfter(dateToBack)) {
                    long overdueDays = ChronoUnit.DAYS.between(dateToBack, today);
                    double priceFine = overdueDays * 3.50;
                    System.out.println("ATRASADO! Multa acumulada: R$ " + String.format("%.2f", priceFine));
                    System.out.println("Dias de atraso: " + overdueDays);
                } else {
                    long daysLeft = ChronoUnit.DAYS.between(today, dateToBack);
                    System.out.println("Em dia! Restam " + daysLeft + " dias para devolução");
                }

                hasActiveLoans = true;
            }
        }

        if (!hasActiveLoans) {
            System.out.println("Nenhum empréstimo ativo encontrado!");
        }
    }

    public static void openMenuNavigation() {
        System.out.println("Bem-vindo ao sistema da BibliotecaPub!");

        boolean next = true;

        while (next) {
            System.out.println("\n\n=== Sistema - BibliotecaPub ===");
            System.out.println("Digite o número da categoria que deseja: (Ex: 2 para Cadastrar um Livro Comum)");
            System.out.println("\n-> Clientes");
            System.out.println("  [1] - Cadastrar Clientes");
            System.out.println("\n-> Livros");
            System.out.println("  [2] - Cadastrar Livro Comum");
            System.out.println("  [3] - Cadastrar Livro Especial/Raro");
            System.out.println("  [4] - Buscar Livro por Título");
            System.out.println("  [5] - Buscar Livro por Autor");
            System.out.println("  [6] - Realizar um Empréstimo");
            System.out.println("  [7] - Realizar uma Devolução");
            System.out.println("  [8] - Verificar a disponibilidade de empréstimo de um título");
            System.out.println("  [9] - Listar todos os livros SEM DEVOLUÇAÕ");
            System.out.println("\n[0] - Sair");

            System.out.print("\nDigite sua opção: ");
            String option = scan.next();

            if (option.equals("1")) {
                scan.nextLine();
                flowCreateNewCustomer();
            } else if (option.equals("2")) {
                scan.nextLine();
                flowCreateBookCommon();
            } else if (option.equals("3")) {
                scan.nextLine();
                flowCreateBookSpecial();
            } else if (option.equals("4")) {
                scan.nextLine();
                flowSearchByTitle();
            } else if (option.equals("5")) {
                scan.nextLine();
                flowSearchByAuthor();
            } else if (option.equals("6")) {
                flowMakeLoan();
            } else if (option.equals("7")) {
                flowMakeBookBack();
            } else if (option.equals("8")) {
                checkLoanAvailabilityOfBook();
            } else if (option.equals("9")) {
                listActiveLoans();
            } else if (option.equals("0")) {
                System.out.println("Obrigado por usar o sistema!");
                next = false;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scan.close();
    }

    public static void main(String[] args) {
        openMenuNavigation();
    }
}