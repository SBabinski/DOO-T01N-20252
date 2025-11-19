package com.example.api_filmes.services;

import com.example.api_filmes.model.SearchResult;
import com.example.api_filmes.model.Show;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Cliente para interagir com a API do TVMaze
 */
public class TvMazeClient {
    private static final String BASE_URL = "https://api.tvmaze.com";
    private static final String SEARCH_ENDPOINT = "/search/shows";
    private static final String SHOW_ENDPOINT = "/shows";
    
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public TvMazeClient() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * Busca séries pelo nome
     * @param query Nome da série para buscar
     * @return Lista de resultados de busca
     * @throws TvMazeApiException Se houver erro na comunicação com a API
     */
    public List<SearchResult> searchShows(String query) throws TvMazeApiException {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query não pode ser vazia");
        }

        try {
            String encodedQuery = URLEncoder.encode(query.trim(), StandardCharsets.UTF_8);
            String url = BASE_URL + SEARCH_ENDPOINT + "?q=" + encodedQuery;
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofSeconds(30))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, 
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                if (responseBody.trim().equals("[]")) {
                    return new ArrayList<>();
                }
                
                return objectMapper.readValue(responseBody, 
                        new TypeReference<List<SearchResult>>() {});
            } else {
                throw new TvMazeApiException(
                    String.format("Erro na API: %d - %s", response.statusCode(), response.body())
                );
            }
            
        } catch (IOException e) {
            throw new TvMazeApiException("Erro de conexão com a API TVMaze: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TvMazeApiException("Requisição interrompida: " + e.getMessage(), e);
        }
    }

    /**
     * Busca uma série específica pelo ID
     * @param showId ID da série
     * @return Dados da série ou null se não encontrada
     * @throws TvMazeApiException Se houver erro na comunicação com a API
     */
    public Show getShowById(Long showId) throws TvMazeApiException {
        if (showId == null) {
            throw new IllegalArgumentException("ID da série não pode ser nulo");
        }

        try {
            String url = BASE_URL + SHOW_ENDPOINT + "/" + showId;
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofSeconds(30))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, 
                    HttpResponse.BodyHandlers.ofString());

            switch (response.statusCode()) {
                case 200:
                    return objectMapper.readValue(response.body(), Show.class);
                case 404:
                    return null; // Série não encontrada
                default:
                    throw new TvMazeApiException(
                        String.format("Erro na API: %d - %s", response.statusCode(), response.body())
                    );
            }
            
        } catch (IOException e) {
            throw new TvMazeApiException("Erro de conexão com a API TVMaze: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TvMazeApiException("Requisição interrompida: " + e.getMessage(), e);
        }
    }

    /**
     * Exceção personalizada para erros da API TVMaze
     */
    public static class TvMazeApiException extends Exception {
        public TvMazeApiException(String message) {
            super(message);
        }

        public TvMazeApiException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
