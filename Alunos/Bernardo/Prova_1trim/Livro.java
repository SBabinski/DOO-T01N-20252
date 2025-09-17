package Alunos.Bernardo.Prova_1trim;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Livro {
    static DecimalFormat df = new DecimalFormat("0.00");

    protected String titulo;
    protected String autor;
    protected boolean emprestado;
    protected LocalDate dataEmprestimo; 
    protected String cpfEmprestimo;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
        this.dataEmprestimo = null;
        this.cpfEmprestimo = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public String getCpfEmprestimo() {
        return cpfEmprestimo;
    }

    public boolean emprestar(String cpf, LocalDate data) {
        if (!emprestado) {
            this.emprestado = true;
            this.cpfEmprestimo = cpf;
            this.dataEmprestimo = data;
            System.out.println("Livro emprestado com sucesso!\nData do empréstimo: " 
                               + data + "\nCPF do cliente: " + cpfEmprestimo);
            return true;
        } else {
            System.out.println("Livro já emprestado!");
            return false;
        }
    }
    public float devolver(LocalDate dataDevolucao) {
        if (!emprestado) {
            System.out.println("Esse livro não estava emprestado.");
            return 0.0f;
        }

        long dias = ChronoUnit.DAYS.between(this.dataEmprestimo, dataDevolucao);
        this.emprestado = false;
        String cpf = this.cpfEmprestimo;

        this.dataEmprestimo = null;
        this.cpfEmprestimo = null;

        if (dias > 7) {
            float multa = (dias - 7) * 3.50f;
            System.out.println("Livro devolvido com atraso de " + dias + " dias. Valor da multa: R$ " + df.format(multa));
            return multa;
        } else {
            System.out.println("Devolvido dentro do prazo. Sem multa.");
            return 0.0f;
        }
    }

    public String info() {
        return titulo + " - " + autor + (emprestado ? " (EMPRESTADO por CPF: " + cpfEmprestimo + ")" : " (DISPONÍVEL)");
    }
}
