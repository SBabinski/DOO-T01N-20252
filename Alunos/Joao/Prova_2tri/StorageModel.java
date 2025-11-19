import java.util.ArrayList;
import java.util.List;

public class StorageModel {
    private User usuario;

    private List<Show> favoritos = new ArrayList<>();
    private List<Show> assistidos = new ArrayList<>();
    private List<Show> queroAssistir = new ArrayList<>();

    public StorageModel() {}

    public User getUsuario() { return usuario; }

    public void setUsuario(User usuario) { this.usuario = usuario; }

    public List<Show> getFavoritos() { return favoritos; }
    public List<Show> getAssistidos() { return assistidos; }
    public List<Show> getQueroAssistir() { return queroAssistir; }
}
