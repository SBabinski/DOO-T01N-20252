import java.util.List;

public class Serie {
    private String nome;
    private String idioma;
    private List<String> generos;
    private double nota;
    private String estado;
    private String estreia;
    private String termino;
    private String emissora;

    public Serie(String nome, String idioma, List<String> generos, double nota,
                 String estado, String estreia, String termino, String emissora) {
        this.nome = nome;
        this.idioma = idioma;
        this.generos = generos;
        this.nota = nota;
        this.estado = estado;
        this.estreia = estreia;
        this.termino = termino;
        this.emissora = emissora;
    }

    public String getNome() { return nome; }
    public double getNota() { return nota; }
    public String getEstado() { return estado; }
    public String getEstreia() { return estreia; }

    public String toString() {
        return "\nNome: " + nome +
               "\nIdioma: " + idioma +
               "\nGêneros: " + generos +
               "\nNota: " + nota +
               "\nEstado: " + estado +
               "\nEstreia: " + estreia +
               "\nTérmino: " + termino +
               "\nEmissora: " + emissora + "\n";
    }
}
