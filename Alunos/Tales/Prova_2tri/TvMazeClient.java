import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.*;

public class TvMazeClient {
    private final HttpClient http = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static final String BASE = "https://api.tvmaze.com";

    public List<ShowInfo> searchShows(String query) {
        try {
            String url = BASE + "/search/shows?q=" + URI.create("http://x/?" + "q=" + query).getQuery().substring(2);
            // truque simples para escapear query com segurança
            HttpRequest req = HttpRequest.newBuilder(URI.create(url))
                    .timeout(Duration.ofSeconds(15))
                    .header("User-Agent", "Prova2Tri/1.0")
                    .GET().build();
            HttpResponse<String> resp = sendWithRetry(req);
            if (resp.statusCode() != 200) return List.of();

            String json = resp.body();
            // A resposta é um array de objetos com campo "show": {...}
            List<String> showObjects = JsonUtils.extractObjects(json, "\"show\":\\s*\\{", '}');
            List<ShowInfo> list = new ArrayList<>();
            for (String showJson : showObjects) {
                ShowInfo s = parseShow(showJson);
                if (s != null) list.add(s);
            }
            return list;
        } catch (Exception e) {
            return List.of();
        }
    }

    public ShowInfo getShowById(int id) {
        try {
            String url = BASE + "/shows/" + id;
            HttpRequest req = HttpRequest.newBuilder(URI.create(url))
                    .timeout(Duration.ofSeconds(15))
                    .header("User-Agent", "Prova2Tri/1.0")
                    .GET().build();
            HttpResponse<String> resp = sendWithRetry(req);
            if (resp.statusCode() != 200) return null;
            return parseShow(resp.body());
        } catch (Exception e) {
            return null;
        }
    }

    public List<ShowInfo> fetchManyByIds(Collection<Integer> ids) {
        if (ids == null || ids.isEmpty()) return List.of();
        List<ShowInfo> out = new ArrayList<>();
        for (int id : ids) {
            var s = getShowById(id);
            if (s != null) out.add(s);
        }
        return out;
    }

    private HttpResponse<String> sendWithRetry(HttpRequest req) throws Exception {
        // Respeita rate limit (TVmaze: pelo menos 20 req/10s por IP). Se 429, espera e tenta de novo.
        for (int i = 0; i < 3; i++) {
            HttpResponse<String> resp = http.send(req, HttpResponse.BodyHandlers.ofString());
            if (resp.statusCode() != 429) return resp;
            Thread.sleep(1500L * (i + 1));
        }
        return http.send(req, HttpResponse.BodyHandlers.ofString());
    }

    // --------- Parse JSON (campos usados) ----------
    private ShowInfo parseShow(String showJson) {
        try {
            Integer id = JsonUtils.getInt(showJson, "\"id\"");
            String name = JsonUtils.getString(showJson, "\"name\"");
            String language = JsonUtils.getString(showJson, "\"language\"");
            List<String> genres = JsonUtils.getStringArray(showJson, "\"genres\"");
            Double rating = JsonUtils.getNestedDouble(showJson, "\"rating\"", "\"average\"");
            String status = JsonUtils.getString(showJson, "\"status\"");
            String premiered = JsonUtils.getString(showJson, "\"premiered\"");
            String ended = JsonUtils.getString(showJson, "\"ended\"");
            String networkName = JsonUtils.getNestedString(showJson, "\"network\"", "\"name\"");
            return new ShowInfo(
                    id == null ? -1 : id,
                    name,
                    language,
                    genres,
                    rating,
                    status,
                    JsonUtils.toLocalDate(premiered),
                    JsonUtils.toLocalDate(ended),
                    networkName
            );
        } catch (Exception e) {
            return null;
        }
    }
}
