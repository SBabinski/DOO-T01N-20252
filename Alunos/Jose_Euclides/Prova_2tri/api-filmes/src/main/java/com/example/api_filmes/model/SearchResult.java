package com.example.api_filmes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para representar os resultados de busca da API TVMaze
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {
    private Double score;
    
    @JsonProperty("show")
    private Show show;

    public SearchResult() {}

    public SearchResult(Double score, Show show) {
        this.score = score;
        this.show = show;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return String.format("SearchResult{score=%.2f, show=%s}", 
                           score, show != null ? show.getName() : "null");
    }
}