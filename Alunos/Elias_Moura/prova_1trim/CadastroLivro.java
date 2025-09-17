public class CadastroLivro {
    
    private String titulo;
    private String autor;
    private boolean emprestado;
    private String motivoRaridade;

    public void Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
        this.motivoRaridade = motivoRaridade;

    }

    public boolean isEmprestado() { 
     return emprestado; }


    public void setEmprestado(boolean status) {
      this.emprestado = emprestado; }

 
    public String getTitulo() { 
        return titulo;
     }

    public String getAutor() { 
       return autor; }

    public boolean getEmprestado(){
        return emprestado;
    }


    public String getMotivoRaridade() {
        return motivoRaridade;
    }
 





}