import java.util.*;

public class UserData {
    private String userName;
    private List<TVSeries> favorites;
    private List<TVSeries> watched;
    private List<TVSeries> watchlist;
    
    public UserData(String userName) {
        this.userName = userName;
        this.favorites = new ArrayList<>();
        this.watched = new ArrayList<>();
        this.watchlist = new ArrayList<>();
    }
    
    // Getters para serialização
    public String getUserName() { return userName; }
    public List<TVSeries> getFavorites() { return favorites; }
    public List<TVSeries> getWatched() { return watched; }
    public List<TVSeries> getWatchlist() { return watchlist; }
    
    // Setters para desserialização
    public void setUserName(String userName) { this.userName = userName; }
    public void setFavorites(List<TVSeries> favorites) { this.favorites = favorites; }
    public void setWatched(List<TVSeries> watched) { this.watched = watched; }
    public void setWatchlist(List<TVSeries> watchlist) { this.watchlist = watchlist; }
    
    public void addToFavorites(TVSeries series) {
        if (!favorites.contains(series)) {
            favorites.add(series);
        }
    }
    
    public void addToWatched(TVSeries series) {
        if (!watched.contains(series)) {
            watched.add(series);
        }
    }
    
    public void addToWatchlist(TVSeries series) {
        if (!watchlist.contains(series)) {
            watchlist.add(series);
        }
    }
    
    public void removeFromFavorites(int seriesId) {
        favorites.removeIf(series -> series.getId() == seriesId);
    }
    
    public void removeFromWatched(int seriesId) {
        watched.removeIf(series -> series.getId() == seriesId);
    }
    
    public void removeFromWatchlist(int seriesId) {
        watchlist.removeIf(series -> series.getId() == seriesId);
    }
    
    public void displayFavorites() {
        if (favorites.isEmpty()) {
            System.out.println("Nenhuma série nos favoritos.");
            return;
        }
        for (int i = 0; i < favorites.size(); i++) {
            System.out.println((i + 1) + ". " + favorites.get(i).getName());
        }
    }
    
    public void displayWatched() {
        if (watched.isEmpty()) {
            System.out.println("Nenhuma série assistida.");
            return;
        }
        for (int i = 0; i < watched.size(); i++) {
            System.out.println((i + 1) + ". " + watched.get(i).getName());
        }
    }
    
    public void displayWatchlist() {
        if (watchlist.isEmpty()) {
            System.out.println("Nenhuma série na lista para assistir.");
            return;
        }
        for (int i = 0; i < watchlist.size(); i++) {
            System.out.println((i + 1) + ". " + watchlist.get(i).getName());
        }
    }
    
    public void sortFavorites(SortCriteria criteria) {
        sortList(favorites, criteria);
    }
    
    public void sortWatched(SortCriteria criteria) {
        sortList(watched, criteria);
    }
    
    public void sortWatchlist(SortCriteria criteria) {
        sortList(watchlist, criteria);
    }
    
    private void sortList(List<TVSeries> list, SortCriteria criteria) {
        list.sort((s1, s2) -> {
            switch (criteria) {
                case NAME:
                    return s1.getName().compareToIgnoreCase(s2.getName());
                case RATING:
                    return Double.compare(s2.getRating(), s1.getRating()); // Descendente
                case STATUS:
                    return s1.getStatus().compareTo(s2.getStatus());
                case PREMIERED:
                    if (s1.getPremiered() == null && s2.getPremiered() == null) return 0;
                    if (s1.getPremiered() == null) return 1;
                    if (s2.getPremiered() == null) return -1;
                    return s1.getPremiered().compareTo(s2.getPremiered());
                default:
                    return 0;
            }
        });
    }
}