package Alunos.Sofia.prova_1trim;

public class LivroComum extends Livro {
    public LivroComum(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public boolean podeSerEmprestado() {
        return true;
    }

    @Override
    public String detalhes() {
        return "[Comum] " + titulo + " - " + autor;
    }
}
