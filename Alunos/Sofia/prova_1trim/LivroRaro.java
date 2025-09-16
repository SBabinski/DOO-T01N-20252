package Alunos.Sofia.prova_1trim;

public class LivroRaro extends Livro {
    private String motivoRaridade;

    public LivroRaro(String titulo, String autor, String motivo) {
        super(titulo, autor);
        this.motivoRaridade = motivo;
    }

    @Override
    public boolean podeSerEmprestado() {
        return false;
    }

    @Override
    public String detalhes() {
        return "[Raro] " + titulo + " - " + autor + " | Motivo: " + motivoRaridade;
    }
}
