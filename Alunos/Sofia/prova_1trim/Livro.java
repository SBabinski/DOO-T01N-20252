package Alunos.Sofia.prova_1trim;

public abstract class Livro {
    protected String titulo;
    protected String autor;
    protected boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
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

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public abstract boolean podeSerEmprestado();

    public abstract String detalhes();
}
