import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Serie> favoritas;
    private List<Serie> assistidas;
    private List<Serie> desejoAssistir;

    public Usuario(String nome) {
        this.nome = nome;
        favoritas = new ArrayList<>();
        assistidas = new ArrayList<>();
        desejoAssistir = new ArrayList<>();
    }

    public String getNome() { return nome; }

    public List<Serie> getFavoritas() { return favoritas; }
    public List<Serie> getAssistidas() { return assistidas; }
    public List<Serie> getDesejoAssistir() { return desejoAssistir; }

    public void adicionarSerie(List<Serie> lista, Serie s) {
        if (!lista.contains(s)) lista.add(s);
    }

    public void removerSerie(List<Serie> lista, Serie s) {
        lista.remove(s);
    }
}
