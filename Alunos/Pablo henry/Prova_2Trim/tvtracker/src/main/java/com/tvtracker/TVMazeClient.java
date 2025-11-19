package com.tvtracker;

import com.google.gson.*;
import com.tvtracker.model.Series;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TVMazeClient {
    private static final String API_SEARCH = "https://api.tvmaze.com/search/shows?q=";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public List<Series> searchShows(String query) throws IOException {
        String url = API_SEARCH + java.net.URLEncoder.encode(query, java.nio.charset.StandardCharsets.UTF_8);
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String body = response.body().string();
            JsonArray arr = JsonParser.parseString(body).getAsJsonArray();

            List<Series> results = new ArrayList<>();
            for (JsonElement el : arr) {
                JsonObject obj = el.getAsJsonObject().getAsJsonObject("show");
                Series s = parseShow(obj);
                results.add(s);
            }
            return results;
        }
    }

    private Series parseShow(JsonObject obj) {
        int id = obj.has("id") && !obj.get("id").isJsonNull() ? obj.get("id").getAsInt() : -1;

        String name = safeGet(obj, "name");
        String language = safeGet(obj, "language");

        List<String> genres = new ArrayList<>();
        if (obj.has("genres") && obj.get("genres").isJsonArray()) {
            for (JsonElement g : obj.getAsJsonArray("genres")) genres.add(g.getAsString());
        }

        Double rating = null;
        if (obj.has("rating") && obj.getAsJsonObject("rating").has("average") && !obj.getAsJsonObject("rating").get("average").isJsonNull())
            rating = obj.getAsJsonObject("rating").get("average").getAsDouble();

        String status = safeGet(obj, "status");
        String premiered = safeGet(obj, "premiered");
        String ended = safeGet(obj, "ended");

        String network = null;
        if (obj.has("network") && obj.get("network").isJsonObject()) {
            JsonObject net = obj.getAsJsonObject("network");
            network = safeGet(net, "name");
        } else if (obj.has("webChannel") && obj.get("webChannel").isJsonObject()) {
            JsonObject net = obj.getAsJsonObject("webChannel");
            network = safeGet(net, "name");
        }

        return new Series(id, name, language, genres, rating, status, premiered, ended, network);
    }

    private String safeGet(JsonObject o, String member) {
        return (o.has(member) && !o.get(member).isJsonNull()) ? o.get(member).getAsString() : null;
    }
}
