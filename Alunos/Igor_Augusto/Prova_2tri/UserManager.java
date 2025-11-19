import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class UserManager {
    private String currentUser;
    private Map<String, UserData> usersData;
    private static final String DATA_FILE = "tvseries_data.json";
    private Gson gson;
    
    public UserManager() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        this.usersData = new HashMap<>();
        loadData();
    }
    
    public void setCurrentUser(String userName) {
        this.currentUser = userName;
        if (!usersData.containsKey(userName)) {
            usersData.put(userName, new UserData(userName));
        }
    }
    
    public void addToFavorites(TVSeries series) {
        getUserData().addToFavorites(series);
        System.out.println("Série adicionada aos favoritos!");
    }
    
    public void addToWatched(TVSeries series) {
        getUserData().addToWatched(series);
        System.out.println("Série adicionada às já assistidas!");
    }
    
    public void addToWatchlist(TVSeries series) {
        getUserData().addToWatchlist(series);
        System.out.println("Série adicionada à lista para assistir!");
    }
    
    public void removeFromFavorites(int seriesId) {
        getUserData().removeFromFavorites(seriesId);
        System.out.println("Série removida dos favoritos!");
    }
    
    public void removeFromWatched(int seriesId) {
        getUserData().removeFromWatched(seriesId);
        System.out.println("Série removida das já assistidas!");
    }
    
    public void removeFromWatchlist(int seriesId) {
        getUserData().removeFromWatchlist(seriesId);
        System.out.println("Série removida da lista para assistir!");
    }
    
    public void displayFavorites() {
        getUserData().displayFavorites();
    }
    
    public void displayWatched() {
        getUserData().displayWatched();
    }
    
    public void displayWatchlist() {
        getUserData().displayWatchlist();
    }
    
    public void sortFavorites(SortCriteria criteria) {
        getUserData().sortFavorites(criteria);
        System.out.println("Favoritos ordenados por " + criteria);
    }
    
    public void sortWatched(SortCriteria criteria) {
        getUserData().sortWatched(criteria);
        System.out.println("Já assistidas ordenadas por " + criteria);
    }
    
    public void sortWatchlist(SortCriteria criteria) {
        getUserData().sortWatchlist(criteria);
        System.out.println("Para assistir ordenadas por " + criteria);
    }
    
    public void saveData() {
        try {
            String json = gson.toJson(usersData);
            Files.writeString(Paths.get(DATA_FILE), json);
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
    
    private void loadData() {
        try {
            Path path = Paths.get(DATA_FILE);
            if (Files.exists(path)) {
                String json = Files.readString(path);
                Type type = new TypeToken<Map<String, UserData>>(){}.getType();
                usersData = gson.fromJson(json, type);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
    
    private UserData getUserData() {
        return usersData.get(currentUser);
    }
}
