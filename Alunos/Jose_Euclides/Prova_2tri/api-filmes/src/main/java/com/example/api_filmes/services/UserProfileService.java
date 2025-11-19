package com.example.api_filmes.services;

import java.util.List;

import com.example.api_filmes.dto.UserDTO;
import com.example.api_filmes.model.Show;
import com.example.api_filmes.model.User;

/**
 * Serviço para gerenciar o perfil do usuário e suas listas de séries
 */
public class UserProfileService {
    private final ShowService showService;
    private User currentUser;

    public UserProfileService(ShowService showService) {
        this.showService = showService;
        loadUser();
    }

    /**
     * Carrega o usuário do arquivo ou cria um novo
     */
    private void loadUser() {
        try {
            List<User> users = UserDTO.getUsers();
            if (users != null && !users.isEmpty()) {
                currentUser = users.get(0); // Pega o primeiro usuário
            } else {
                currentUser = new User("Usuário");
                UserDTO.saveUser(currentUser);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar usuário: " + e.getMessage());
            currentUser = new User("Usuário");
        }
    }

    /**
     * Salva os dados do usuário
     */
    public void saveUser() {
        try {
            UserDTO.saveUser(currentUser);
        } catch (Exception e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    /**
     * Obtém o usuário atual
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Define o nome do usuário
     */
    public void setUserName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            currentUser.setName(name.trim());
            saveUser();
        }
    }

    // ==================== GERENCIAMENTO DE FAVORITOS ====================

    /**
     * Adiciona uma série aos favoritos
     */
    public boolean addToFavorites(Long showId) {
        if (showId == null) return false;
        
        boolean added = currentUser.addToFavorites(showId);
        if (added) {
            saveUser();
            System.out.println("Série adicionada aos favoritos!");
        } else {
            System.out.println("Série já está nos favoritos.");
        }
        return added;
    }

    /**
     * Remove uma série dos favoritos
     */
    public boolean removeFromFavorites(Long showId) {
        boolean removed = currentUser.removeFromFavorites(showId);
        if (removed) {
            saveUser();
            System.out.println("Série removida dos favoritos.");
        } else {
            System.out.println("Série não estava nos favoritos.");
        }
        return removed;
    }

    /**
     * Obtém a lista de séries favoritas
     */
    public List<Show> getFavoriteShows() {
        return showService.getShowsByIds(currentUser.getFavoriteShows());
    }

    // ==================== GERENCIAMENTO DE ASSISTIDAS ====================

    /**
     * Adiciona uma série à lista de assistidas
     */
    public boolean addToWatched(Long showId) {
        if (showId == null) return false;
        
        boolean added = currentUser.addToWatched(showId);
        if (added) {
            saveUser();
            System.out.println("Série adicionada às assistidas!");
        } else {
            System.out.println("Série já está nas assistidas.");
        }
        return added;
    }

    /**
     * Remove uma série da lista de assistidas
     */
    public boolean removeFromWatched(Long showId) {
        boolean removed = currentUser.removeFromWatched(showId);
        if (removed) {
            saveUser();
            System.out.println("Série removida das assistidas.");
        } else {
            System.out.println("Série não estava nas assistidas.");
        }
        return removed;
    }

    /**
     * Obtém a lista de séries assistidas
     */
    public List<Show> getWatchedShows() {
        return showService.getShowsByIds(currentUser.getWatchedShows());
    }

    /**
     * Adiciona uma série à watchlist (para assistir)
     */
    public boolean addToWatchlist(Long showId) {
        if (showId == null) return false;
        
        boolean added = currentUser.addToWatchlist(showId);
        if (added) {
            saveUser();
            System.out.println("Série adicionada à lista para assistir!");
        } else {
            System.out.println("Série já está na lista para assistir.");
        }
        return added;
    }

    /**
     * Remove uma série da watchlist
     */
    public boolean removeFromWatchlist(Long showId) {
        boolean removed = currentUser.removeFromWatchlist(showId);
        if (removed) {
            saveUser();
            System.out.println("Série removida da lista para assistir.");
        } else {
            System.out.println("Série não estava na lista para assistir.");
        }
        return removed;
    }

    /**
     * Obtém a lista de séries para assistir
     */
    public List<Show> getWatchlistShows() {
        return showService.getShowsByIds(currentUser.getWatchlistShows());
    }

    /**
     * Obtém favoritos ordenados por critério
     */
    public List<Show> getFavoritesSorted(SortCriteria criteria) {
        List<Show> favorites = getFavoriteShows();
        return sortShows(favorites, criteria);
    }

    /**
     * Obtém assistidas ordenadas por critério
     */
    public List<Show> getWatchedSorted(SortCriteria criteria) {
        List<Show> watched = getWatchedShows();
        return sortShows(watched, criteria);
    }

    /**
     * Obtém watchlist ordenada por critério
     */
    public List<Show> getWatchlistSorted(SortCriteria criteria) {
        List<Show> watchlist = getWatchlistShows();
        return sortShows(watchlist, criteria);
    }

    /**
     * Ordena uma lista de séries pelo critério especificado
     */
    private List<Show> sortShows(List<Show> shows, SortCriteria criteria) {
        switch (criteria) {
            case NAME:
                return showService.sortByName(shows);
            case RATING:
                return showService.sortByRating(shows);
            case STATUS:
                return showService.sortByStatus(shows);
            case PREMIERE_DATE:
                return showService.sortByPremiereDate(shows);
            default:
                return shows;
        }
    }

    // ==================== MÉTODOS DE VERIFICAÇÃO ====================

    /**
     * Verifica se uma série está nos favoritos
     */
    public boolean isFavorite(Long showId) {
        return currentUser.isFavorite(showId);
    }

    /**
     * Verifica se uma série foi assistida
     */
    public boolean isWatched(Long showId) {
        return currentUser.isWatched(showId);
    }

    /**
     * Verifica se uma série está na watchlist
     */
    public boolean isInWatchlist(Long showId) {
        return currentUser.isInWatchlist(showId);
    }

    /**
     * Obtém o status de uma série para o usuário
     */
    public String getShowStatus(Long showId) {
        StringBuilder status = new StringBuilder();
        
        if (isFavorite(showId)) {
            status.append("Favorito;");
        }
        if (isWatched(showId)) {
            status.append("Assistida;");
        }
        if (isInWatchlist(showId)) {
            status.append("Para assistir");
        }
        
        return status.length() > 0 ? status.toString().trim() : "";
    }

    /**
     * Obtém estatísticas do usuário
     */
    public String getUserStats() {
        return String.format(
            "Estatísticas de %s:\n" +
            "Favoritas: %d séries\n" +
            "Assistidas: %d séries\n" +
            "Para assistir: %d séries",
            currentUser.getName(),
            currentUser.getFavoriteShows().size(),
            currentUser.getWatchedShows().size(),
            currentUser.getWatchlistShows().size()
        );
    }

    /**
     * Enum para critérios de ordenação
     */
    public enum SortCriteria {
        NAME("Nome (A-Z)"),
        RATING("Nota (maior primeiro)"),
        STATUS("Status"),
        PREMIERE_DATE("Data de estreia (mais recente)");

        private final String description;

        SortCriteria(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
