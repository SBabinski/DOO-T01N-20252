import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TvMazeApi {
    private static final String URL_BUSCA = "https://api.tvmaze.com/search/shows?q=";

    public static List<Serie> buscarSerie(String termo) throws IOException {
        try {
            String consulta = URLEncoder.encode(termo, StandardCharsets.UTF_8);
            String urlCompleta = URL_BUSCA + consulta;

        HttpClient cliente = HttpClient.newBuilder()
            .connectTimeout(java.time.Duration.ofSeconds(10))
            .build();
        HttpRequest requisicao = HttpRequest.newBuilder()
            .uri(URI.create(urlCompleta))
            .GET()
            .timeout(java.time.Duration.ofSeconds(20))
            .header("Accept", "application/json")
            .build();

        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        int status = resposta.statusCode();
        if (status < 200 || status >= 300) {
            return new ArrayList<>();
        }
        String body = resposta.body();

            JSONArray results = new JSONArray(body);
            List<Serie> lista = new ArrayList<>();
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
                JSONObject show = item.getJSONObject("show");
                lista.add(Serie.fromJSON(show));
            }
            return lista;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Requisição interrompida", e);
        }
    }
}
