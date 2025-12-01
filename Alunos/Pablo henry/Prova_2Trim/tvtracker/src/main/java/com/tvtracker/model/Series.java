package com.tvtracker.model;

import java.util.List;

public class Series {
    public int id;
    public String name;
    public String language;
    public List<String> genres;
    public Double rating; 
    public String status;
    public String premiered;
    public String ended;
    public String network;

    public Series() {}

    public Series(int id, String name, String language, List<String> genres, Double rating, String status, String premiered, String ended, String network) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.genres = genres;
        this.rating = rating;
        this.status = status;
        this.premiered = premiered;
        this.ended = ended;
        this.network = network;
    }

    @Override
    public String toString() {
        return String.format("%s (id:%d) - %s - %s - rating:%s - premiered:%s - ended:%s - network:%s",
                name, id, language, genres,
                rating == null ? "N/A" : rating.toString(),
                premiered == null ? "N/A" : premiered,
                ended == null ? "N/A" : ended,
                network == null ? "N/A" : network);
    }
}
