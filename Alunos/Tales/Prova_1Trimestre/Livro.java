import java.time.LocalDate;

public class Livro {
private int id;
private String titulo;
private String autor;
private boolean emprestado = false;
private LocalDate dataEmprestimo; 


public Livro(int id, String titulo, String autor) {
this.id = id;
this.titulo = titulo;
this.autor = autor;
}


public boolean podeEmprestar() { return true; }


public int getId() { return id; }
public String getTitulo() { return titulo; }
public String getAutor() { return autor; }
public boolean isEmprestado() { return emprestado; }
public void setEmprestado(boolean e) { emprestado = e; }
public LocalDate getDataEmprestimo() { return dataEmprestimo; }
public void setDataEmprestimo(LocalDate d) { dataEmprestimo = d; }


@Override
public String toString() {
String status = emprestado ? "(EMPRESTADO)" : "(DISPONÍVEL)";
return "[" + id + "] '" + titulo + "' de " + autor + " " + status;
}
}