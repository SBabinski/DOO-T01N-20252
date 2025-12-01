package DOO-T01N-20252. Alunos.Alexandre.Prova_2tri;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class TvMazeService {
    private static final String BASE_URL = "https://api.tvmaze.com/search/shows?q=";
    private final HttpClient client;
    private final Gson gson;

    public TvMazeService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public List<Serie> buscarSeries(String query) throws Exception {
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + encodedQuery))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Erro na API: " + response.statusCode());
        }

        TypeToken<List<SerieSearchItem>> token = new TypeToken<>() {
        };
        List<SerieSearchItem> resultados = gson.fromJson(response.body(), token.getType());

        return resultados.stream()
                .map(item -> item.show)
                .collect(Collectors.toList());
    }
}