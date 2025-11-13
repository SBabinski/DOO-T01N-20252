package com.example.apiclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiClient {

    private static final String BASE_URL = "https://api.tvmaze.com/search/shows?q=";

    public List<Serie> buscarSeries(String termo) throws IOException, InterruptedException {
        String encoded = java.net.URLEncoder.encode(termo, java.nio.charset.StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + encoded))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.body());

        List<Serie> series = new ArrayList<>();

        for (JsonNode item : root) {
            JsonNode showNode = item.get("show");
            Serie serie = mapper.treeToValue(showNode, Serie.class);
            series.add(serie);
        }

        return series;
    }
}
