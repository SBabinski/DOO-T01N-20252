import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class TVMazeService {

    public static List<Serie> buscarSerie(String nome) {
        List<Serie> series = new ArrayList<>();
        try {
            String urlStr = "https://api.tvmaze.com/search/shows?q=" + nome.replace(" ", "%20");
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine; StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) content.append(inputLine);
            in.close();

            JSONArray arr = new JSONArray(content.toString());
            for (int i = 0; i < arr.length(); i++) {
                JSONObject show = arr.getJSONObject(i).getJSONObject("show");
                String titulo = show.optString("name", "Sem nome");
                String idioma = show.optString("language", "Desconhecido");
                JSONArray genres = show.optJSONArray("genres");
                List<String> listaGeneros = new ArrayList<>();
                if (genres != null) for (int j = 0; j < genres.length(); j++) listaGeneros.add(genres.getString(j));
                double nota = show.optJSONObject("rating").optDouble("average", 0);
                String estado = show.optString("status", "Desconhecido");
                String estreia = show.optString("premiered", "N/A");
                String termino = show.optString("ended", "N/A");
                String emissora = show.optJSONObject("network") != null ?
                        show.getJSONObject("network").optString("name", "N/A") : "N/A";

                series.add(new Serie(titulo, idioma, listaGeneros, nota, estado, estreia, termino, emissora));
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar séries: " + e.getMessage());
        }
        return series;
    }
}
