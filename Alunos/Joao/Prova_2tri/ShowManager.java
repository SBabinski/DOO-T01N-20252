import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShowManager {

    private User user;
    private List<Show> favoritos;
    private List<Show> assistidos;
    private List<Show> queroAssistir;

    public ShowManager() {
        this.user = new User("");
        this.favoritos = new ArrayList<>();
        this.assistidos = new ArrayList<>();
        this.queroAssistir = new ArrayList<>();
    }

    public User getUser() { return user; }
    public List<Show> getFavoritos() { return favoritos; }
    public List<Show> getAssistidos() { return assistidos; }
    public List<Show> getQueroAssistir() { return queroAssistir; }

    public void addFavorito(Show s) {
        if (!favoritos.contains(s)) favoritos.add(s);
    }

    public void addAssistido(Show s) {
        if (!assistidos.contains(s)) assistidos.add(s);
    }

    public void addQueroAssistir(Show s) {
        if (!queroAssistir.contains(s)) queroAssistir.add(s);
    }

    public void removeFavorito(Show s) { favoritos.remove(s); }
    public void removeAssistido(Show s) { assistidos.remove(s); }
    public void removeQueroAssistir(Show s) { queroAssistir.remove(s); }

    public void ordenarPorNome(List<Show> lista) {
        lista.sort(Comparator.comparing(Show::getName, String.CASE_INSENSITIVE_ORDER));
    }

    public void ordenarPorNota(List<Show> lista) {
        lista.sort(Comparator.comparing(
                s -> s.getRating() == null ? 0 : s.getRating(),
                Comparator.reverseOrder()
        ));
    }

    public void ordenarPorStatus(List<Show> lista) {
        lista.sort(Comparator.comparing(
                s -> s.getStatus() == null ? "" : s.getStatus(),
                String.CASE_INSENSITIVE_ORDER
        ));
    }

    public void ordenarPorDataEstreia(List<Show> lista) {
        lista.sort(Comparator.comparing(
                s -> s.getPremiered() == null ? "" : s.getPremiered()
        ));
    }
}

