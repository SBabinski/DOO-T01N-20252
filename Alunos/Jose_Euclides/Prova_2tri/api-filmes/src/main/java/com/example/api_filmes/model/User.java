package com.example.api_filmes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private List<Long> idsFavoriteShows;
    private List<Long> idsWatchedShows;
    private List<Long> idsWatchlistShows;

    public User() {
        this.idsFavoriteShows = new ArrayList<>();
        this.idsWatchedShows = new ArrayList<>();
        this.idsWatchlistShows = new ArrayList<>();
    }

    public User(String id, String name) {
        this();
        this.id = createId();
        this.name = name;
    }

    public User(String name) {
        this();
        this.id = createId();
        this.name = name;
    }
    
    public static String createId() {
        return UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getFavoriteShows() {
        return idsFavoriteShows;
    }

    public void setIdsFavoriteShows(List<Long> idsFavoriteShows) {
        this.idsFavoriteShows = idsFavoriteShows != null ? idsFavoriteShows : new ArrayList<>();
    }

    public List<Long> getWatchedShows() {
        return idsWatchedShows;
    }

    public void setIdsWatchedShows(List<Long> idsWatchedShows) {
        this.idsWatchedShows = idsWatchedShows != null ? idsWatchedShows : new ArrayList<>();
    }

    public List<Long> getWatchlistShows() {
        return idsWatchlistShows;
    }

    public void setIdsWatchlistShows(List<Long> idsWatchlistShows) {
        this.idsWatchlistShows = idsWatchlistShows != null ? idsWatchlistShows : new ArrayList<>();
    }

    public boolean addToFavorites(Long showId) {
        if (showId != null && !idsFavoriteShows.contains(showId)) {
            return idsFavoriteShows.add(showId);
        }
        return false;
    }

    public boolean removeFromFavorites(Long showId) {
        return idsFavoriteShows.remove(showId);
    }

    public boolean addToWatched(Long showId) {
        if (showId != null && !idsWatchedShows.contains(showId)) {
            return idsWatchedShows.add(showId);
        }
        return false;
    }

    public boolean removeFromWatched(Long showId) {
        return idsWatchedShows.remove(showId);
    }

    public boolean addToWatchlist(Long showId) {
        if (showId != null && !idsWatchlistShows.contains(showId)) {
            return idsWatchlistShows.add(showId);
        }
        return false;
    }

    public boolean removeFromWatchlist(Long showId) {
        return idsWatchlistShows.remove(showId);
    }

    // Métodos de verificação
    public boolean isFavorite(Long showId) {
        return idsFavoriteShows.contains(showId);
    }

    public boolean isWatched(Long showId) {
        return idsWatchedShows.contains(showId);
    }

    public boolean isInWatchlist(Long showId) {
        return idsWatchlistShows.contains(showId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{name= " + this.name + ", favorites=" + this.idsFavoriteShows.size() + ", watched=" + this.idsWatchedShows.size() + ", watchlist=" + this.idsWatchlistShows.size() + "}";
    }
}