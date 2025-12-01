import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ShowService {
    private static final String buscaUrl = "https://api.tvmaze.com/search/shows?q=";
    private final Gson gson = new Gson();

    public List<Show> searchShows(String query) throws Exception {
        List<Show> results = new ArrayList<>();
        if (query == null || query.trim().isEmpty()) return results;

        String q = query.trim().replace(" ", "%20");

            URL url = new URL(buscaUrl + q);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

        conn.setConnectTimeout(8000);
        conn.setReadTimeout(8000);
        int code = conn.getResponseCode();
        if (code != 200) throw new Exception("HTTP " + code);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder(); String line;
        while ((line = in.readLine()) != null) sb.append(line);
        in.close();


        JsonArray arr = JsonParser.parseString(sb.toString()).getAsJsonArray();
        for (JsonElement el : arr) {
            JsonObject wrapper = el.getAsJsonObject();
            JsonObject s = wrapper.getAsJsonObject("show");

            int id = s.has("id") && !s.get("id").isJsonNull() ? s.get("id").getAsInt() : 0;
            String name = s.has("name") &&
                    !s.get("name").isJsonNull() ? s.get("name").getAsString() : "";

            String language = s.has("language") &&
                    !s.get("language").isJsonNull() ? s.get("language").getAsString() : "";

            List<String> genres = new ArrayList<>();
            if (s.has("genres") && s.get("genres").isJsonArray()) {
                Type t = new TypeToken<List<String>>(){}.getType();

                genres = gson.fromJson(s.getAsJsonArray("genres"), t);
            }
            Double rating = null;
            if (s.has("rating") && s.getAsJsonObject("rating").has("average") &&
                    !s.getAsJsonObject("rating").get("average").isJsonNull()) {
                try { rating = s.getAsJsonObject("rating").get("average").getAsDouble();
                        } catch (Exception ignored) {}
            }
            String status = s.has("status") &&
                    !s.get("status").isJsonNull() ? s.get("status").getAsString() : "";

            String premiered = s.has("premiered") &&
                    !s.get("premiered").isJsonNull() ? s.get("premiered").getAsString() : "";

            String ended = s.has("ended") &&
                    !s.get("ended").isJsonNull() ? s.get("ended").getAsString() : "";

            String networkName = "Desconhecida";

            if (s.has("network") && !s.get("network").isJsonNull()) {
                JsonObject net = s.getAsJsonObject("network");
                if (net.has("name") && !net.get("name").isJsonNull()) networkName = net.get("name").getAsString();
            } else if (s.has("webChannel") && !s.get("webChannel").isJsonNull()) {
                JsonObject web = s.getAsJsonObject("webChannel");
                if (web.has("name") && !web.get("name").isJsonNull()) networkName = web.get("name").getAsString();
            }

            Show show = new Show(id, name, language, genres, rating, status, premiered, ended, networkName);
            results.add(show);
        }

        return results;
    }
}
