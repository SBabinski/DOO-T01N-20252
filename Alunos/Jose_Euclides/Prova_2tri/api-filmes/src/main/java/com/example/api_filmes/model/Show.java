package com.example.api_filmes.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {
    private Long id;
    private String name;
    private String language;
    private List<String> genres;
    
    @JsonProperty("rating")
    private Rating rating;
    
    private String status;
    
    @JsonProperty("premiered")
    private LocalDate premiered;
    
    @JsonProperty("ended")
    private LocalDate ended;
    
    @JsonProperty("network")
    private Network network;
    
    @JsonProperty("webChannel")
    private Network webChannel;
    
    private String summary;

    // Construtores
    public Show() {}

    public Show(Long id, String name, String language, List<String> genres, 
                Rating rating, String status, LocalDate premiered, LocalDate ended, 
                Network network, Network webChannel, String summary) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.genres = genres;
        this.rating = rating;
        this.status = status;
        this.premiered = premiered;
        this.ended = ended;
        this.network = network;
        this.webChannel = webChannel;
        this.summary = summary;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public List<String> getGenres() { return genres; }
    public void setGenres(List<String> genres) { this.genres = genres; }

    public Rating getRating() { return rating; }
    public void setRating(Rating rating) { this.rating = rating; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getPremiered() { return premiered; }
    public void setPremiered(LocalDate premiered) { this.premiered = premiered; }

    public LocalDate getEnded() { return ended; }
    public void setEnded(LocalDate ended) { this.ended = ended; }

    public Network getNetwork() { return network; }
    public void setNetwork(Network network) { this.network = network; }

    public Network getWebChannel() { return webChannel; }
    public void setWebChannel(Network webChannel) { this.webChannel = webChannel; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    // Método auxiliar para obter o nome da emissora
    public String getNetworkName() {
        if (network != null && network.getName() != null) {
            return network.getName();
        }
        if (webChannel != null && webChannel.getName() != null) {
            return webChannel.getName();
        }
        return "Desconhecida";
    }

    // Método auxiliar para obter a nota
    public Double getRatingScore() {
        return rating != null ? rating.getAverage() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return Objects.equals(id, show.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Show{id=%d, name='%s', status='%s', rating=%.1f}", 
                           id, name, status, getRatingScore());
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rating {
        private Double average;

        public Rating() {}
        
        public Rating(Double average) {
            this.average = average;
        }

        public Double getAverage() { return average; }
        public void setAverage(Double average) { this.average = average; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Network {
        private String name;
        private Country country;

        public Network() {}
        
        public Network(String name, Country country) {
            this.name = name;
            this.country = country;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public Country getCountry() { return country; }
        public void setCountry(Country country) { this.country = country; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Country {
        private String name;
        private String code;

        public Country() {}
        
        public Country(String name, String code) {
            this.name = name;
            this.code = code;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }
    }
}