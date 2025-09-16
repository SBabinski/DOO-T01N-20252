import java.util.Date;

public class Livro {
    private String titulo;
    private String autor;
    private boolean raro;
    private String descricao;
    private boolean emprestado;
    private Date dataEmprestimo;

    public Livro(String titulo, String autor, boolean raro, String descricao) {
        this.titulo = titulo;
        this.autor = autor;
        this.raro = raro;
        this.descricao = descricao;
        this.emprestado = false;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isRaro() { return raro; }
    public String getDescricao() { return descricao; }
    public boolean isEmprestado() { return emprestado; }
    public Date getDataEmprestimo() { return dataEmprestimo; }

    public void emprestar() { emprestado = true; }
    public void devolver() { emprestado = false; dataEmprestimo = null; }
    public void setDataEmprestimo(Date data) { dataEmprestimo = data; }
}
