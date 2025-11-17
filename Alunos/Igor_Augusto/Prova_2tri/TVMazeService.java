import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TVMazeService {
    private static final String BASE_URL = "https://api.tvmaze.com";
    private HttpClient httpClient;
    
    public TVMazeService() {
        this.httpClient = HttpClient.newHttpClient();
    }
    
    public List<TVSeries> searchSeries(String query) throws IOException, InterruptedException {
        String url = BASE_URL + "/search/shows?q=" + 
                    java.net.URLEncoder.encode(query, "UTF-8");
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        
        HttpResponse<String> response = httpClient.send(request, 
                HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na API: " + response.statusCode());
        }
        
        return parseSearchResults(response.body());
    }
    
    private List<TVSeries> parseSearchResults(String jsonResponse) {
        List<TVSeries> seriesList = new ArrayList<>();
        JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();
        
        for (JsonElement element : jsonArray) {
            JsonObject showObject = element.getAsJsonObject().get("show").getAsJsonObject();
            TVSeries series = parseSeriesFromJson(showObject);
            if (series != null) {
                seriesList.add(series);
            }
        }
        
        return seriesList;
    }
    
    private TVSeries parseSeriesFromJson(JsonObject showObject) {
        try {
            int id = showObject.get("id").getAsInt();
            String name = showObject.get("name").getAsString();
            String language = showObject.has("language") && !showObject.get("language").isJsonNull() 
                    ? showObject.get("language").getAsString() : "N/A";
            
            List<String> genres = new ArrayList<>();
            if (showObject.has("genres")) {
                JsonArray genresArray = showObject.get("genres").getAsJsonArray();
                for (JsonElement genre : genresArray) {
                    genres.add(genre.getAsString());
                }
            }
            
            double rating = showObject.has("rating") && 
                    showObject.get("rating").getAsJsonObject().has("average") &&
                    !showObject.get("rating").getAsJsonObject().get("average").isJsonNull()
                    ? showObject.get("rating").getAsJsonObject().get("average").getAsDouble()
                    : 0.0;
            
            String status = showObject.has("status") && !showObject.get("status").isJsonNull()
                    ? showObject.get("status").getAsString() : "Unknown";
            
            LocalDate premiered = parseDate(showObject, "premiered");
            LocalDate ended = parseDate(showObject, "ended");
            
            String network = "N/A";
            if (showObject.has("network") && !showObject.get("network").isJsonNull()) {
                JsonObject networkObject = showObject.get("network").getAsJsonObject();
                network = networkObject.has("name") ? networkObject.get("name").getAsString() : "N/A";
            }
            
            return new TVSeries(id, name, language, genres, rating, status, premiered, ended, network);
            
        } catch (Exception e) {
            System.err.println("Erro ao parsear série: " + e.getMessage());
            return null;
        }
    }
    
    private LocalDate parseDate(JsonObject jsonObject, String fieldName) {
        if (jsonObject.has(fieldName) && !jsonObject.get(fieldName).isJsonNull()) {
            try {
                String dateString = jsonObject.get(fieldName).getAsString();
                return LocalDate.parse(dateString);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
