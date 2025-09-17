package Alunos.Bernardo.Prova_1trim;

import java.time.LocalDate;

public class LivroRaro extends Livro {
    private String motivo;

    public LivroRaro(String titulo, String autor, String motivo) {
        super(titulo, autor);
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    @Override
    public boolean emprestar(String cpf, LocalDate data) {
        System.out.println("Este livro é raro e não pode ser emprestado! Motivo: " + motivo);
        return false;
    }

    @Override
    public String info() {
        return titulo + " - " + autor + " (RARO: " + motivo + ")";
    }
}
