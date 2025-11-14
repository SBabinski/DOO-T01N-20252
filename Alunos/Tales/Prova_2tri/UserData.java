import java.util.*;

public class UserData {
    private String username;
    private final Set<Integer> favorites = new LinkedHashSet<>();
    private final Set<Integer> watched = new LinkedHashSet<>();
    private final Set<Integer> watchlist = new LinkedHashSet<>();

    public UserData(String username) {
        this.username = (username == null || username.isBlank()) ? "Usuário" : username.trim();
    }

    public String getUsername() { return username; }
    public void setUsername(String u) { this.username = (u == null || u.isBlank()) ? "Usuário" : u.trim(); }

    public Set<Integer> getFavorites() { return favorites; }
    public Set<Integer> getWatched() { return watched; }
    public Set<Integer> getWatchlist() { return watchlist; }
}
