package com.example.api_filmes.Services;
import java.net.URI;
import java.net.http.HttpClient;


public abstract class SeasonService {
    public static void SearchSeason(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        URI url = new URI("https://api.tvmaze.com/search/shows?q=".concat(query))

    }


    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        URI url = new URI("https://api.tvmaze.com/search/shows?q=".concat(query))

    }
}
