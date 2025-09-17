package Alunos.Sofia.prova_1trim;

import java.util.Date;

public class Emprestimo {
    private Cliente cliente;
    private Livro livro;
    private Date dataEmprestimo;

    public Emprestimo(Cliente cliente, Livro livro) {
        this.cliente = cliente;
        this.livro = livro;
        this.dataEmprestimo = new Date();
        livro.setEmprestado(true);
    }

    public double devolver() {
        livro.setEmprestado(false);

        Date hoje = new Date();
        long diff = hoje.getTime() - dataEmprestimo.getTime();
        long dias = diff / (1000 * 60 * 60 * 24);

        if (dias > 7) {
            long atraso = dias - 7;
            return atraso * 3.50;
        }
        return 0.0;
    }

    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
