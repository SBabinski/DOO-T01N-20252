import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class Api {

    public static List<Serie> buscar(String nome) {
        List<Serie> lista = new ArrayList<>();
        try {
            String urlStr = "https://api.tvmaze.com/search/shows?q=" + URLEncoder.encode(nome, "UTF-8");

            URL url = new URL(urlStr);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),
                    StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line);
            br.close();

            JsonArray arr = JsonParser.parseString(sb.toString()).getAsJsonArray();
            for (JsonElement el : arr) {
                JsonObject show = el.getAsJsonObject().get("show").getAsJsonObject();
                Serie s = new Serie();
                s.id = show.get("id").getAsInt();
                s.nome = show.get("name").isJsonNull() ? "-" : show.get("name").getAsString();
                s.idioma = show.get("language").isJsonNull() ? "-" : show.get("language").getAsString();

                s.generos = new ArrayList<>();
                for (JsonElement g : show.get("genres").getAsJsonArray()) s.generos.add(g.getAsString());

                if (show.get("rating").getAsJsonObject().get("average").isJsonNull()) s.nota = 0.0;
                else s.nota = show.get("rating").getAsJsonObject().get("average").getAsDouble();

                s.estado = show.get("status").isJsonNull() ? "-" : show.get("status").getAsString();
                s.estreia = show.get("premiered").isJsonNull() ? "-" : show.get("premiered").getAsString();
                s.fim = show.get("ended").isJsonNull() ? "-" : show.get("ended").getAsString();

                JsonObject net = show.get("network").isJsonNull() ? null : show.get("network").getAsJsonObject();
                s.emissora = net == null ? "-" : net.get("name").getAsString();

                lista.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
