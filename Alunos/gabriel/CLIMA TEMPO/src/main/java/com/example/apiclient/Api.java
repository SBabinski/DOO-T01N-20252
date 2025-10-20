package com.example.apiclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Api {

    private final String apiKey = "M37WVYKL4E3RGBUVR24LMY9HF";

    public RepoInfo getRepoInfo(String cidade) throws IOException, InterruptedException, Exception {
        HttpClient client = HttpClient.newHttpClient();
        
        String encodedCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
        String link = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" +
                encodedCidade +
                "/?key=" + apiKey +
                "&unitGroup=metric&lang=pt";
        URI url = URI.create(link);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(url)
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return RepoInfo.fromJson(response.body());
        } else {
            throw new IOException("Erro HTTP: " + response.statusCode());
        }
    }
}