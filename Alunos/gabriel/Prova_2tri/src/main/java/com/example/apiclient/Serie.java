package com.example.apiclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Serie {
    
    private String name;   //nome da serie
    private String language; //linguagem da serie
    private List<String> genres; //generos da serie
    private Rating rating; //nota da serie
    private Network network; //rede de tv
    private String status; //status da serie
    private String premiered; //data de estreia da serie
    private String ended; //data de fim da serie
    private boolean assistido = false; //se a serie foi assistida
    private boolean desejos = false; //se a serie foi adicionada a desejos assistir

    // Getters e Setters
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    // Subclasses

    @JsonIgnoreProperties(ignoreUnknown = true) //ignora propriedades desconhecidas
    public static class Network { //classe para a rede de tv
        private double id;
        private String name;

        public double getId() {
            return id;
        }

        public void setId(double id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true) //ignora propriedades desconhecidas
    public static class Rating { //classe para a nota da serie
        private Double average;

        public Double getAverage() {
            return average;
        }

        public void setAverage(Double average) {
            this.average = average;
        }

        public Object compareToIgnoreCase(Rating rating) {
            //metodo para comparar a nota da serie
            throw new UnsupportedOperationException("Unimplemented method 'compareToIgnoreCase'"); 
        }
    }

    public boolean isAssistido() { 
        return assistido;
    }

    public void setAssistido(boolean assistido) {
        this.assistido = assistido;
    }

    public boolean isDesejos() {
        return desejos;
    }

    public void setDesejos(boolean desejos) {
        this.desejos = desejos;
    }



}
