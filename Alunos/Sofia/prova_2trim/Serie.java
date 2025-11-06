import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Serie {
    private int id;
    private String name;
    private String premiered;
    private String summary;
    private String language;
    private double rating = -1.0;
    private String status;
    private String ended;
    private String networkName;
    private List<String> genres = new ArrayList<>();

    public Serie() {}

    public Serie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPremiered() { return premiered; }
    public String getSummary() { return summary; }
    public List<String> getGenres() { return genres; }

    public JSONObject toJSON() {
        JSONObject o = new JSONObject();
        o.put("id", id);
        o.put("name", name == null ? JSONObject.NULL : name);
        o.put("premiered", premiered == null ? JSONObject.NULL : premiered);
        o.put("summary", summary == null ? JSONObject.NULL : summary);
        
        o.put("language", language == null ? JSONObject.NULL : language);
        o.put("rating", rating);
        o.put("status", status == null ? JSONObject.NULL : status);
        o.put("ended", ended == null ? JSONObject.NULL : ended);
        o.put("networkName", networkName == null ? JSONObject.NULL : networkName);
        JSONArray arr = new JSONArray();
        for (String g : genres) arr.put(g);
        o.put("genres", arr);
        return o;
    }

    public static Serie fromJSON(JSONObject o) {
        if (o == null) return null;
        Serie s = new Serie();
        s.id = o.optInt("id", -1);
        s.name = o.optString("name", "");
        s.premiered = o.optString("premiered", "");
        s.summary = o.optString("summary", "");

    // carregar gêneros
        JSONArray arrGeneros = o.optJSONArray("genres");
        if (arrGeneros != null) {
            for (int i = 0; i < arrGeneros.length(); i++) s.genres.add(arrGeneros.optString(i));
        }

    

    // idioma
        s.language = o.optString("language", "");

    // nota
        if (o.has("rating") && !o.isNull("rating")) {
            JSONObject notaObj = o.optJSONObject("rating");
            if (notaObj != null) s.rating = notaObj.optDouble("average", -1.0);
            else s.rating = o.optDouble("rating", -1.0);
        }

    // estado e término
        s.status = o.optString("status", "");
        s.ended = o.optString("ended", "");

    // emissora
        if (o.has("network") && !o.isNull("network")) {
            JSONObject rede = o.optJSONObject("network");
            if (rede != null) s.networkName = rede.optString("name", "");
        } else if (o.has("webChannel") && !o.isNull("webChannel")) {
            JSONObject canalWeb = o.optJSONObject("webChannel");
            if (canalWeb != null) s.networkName = canalWeb.optString("name", "");
        }

    // preencher campos alternativos, se disponíveis
    if ((s.language == null || s.language.isEmpty()) && o.has("language")) s.language = o.optString("language", "");
    if ((s.networkName == null || s.networkName.isEmpty()) && o.has("networkName")) s.networkName = o.optString("networkName", "");

        return s;
    }

    // getters
    public String getLanguage() { return language; }
    public double getRating() { return rating; }
    public String getStatus() { return status; }
    public String getEnded() { return ended; }
    public String getNetworkName() { return networkName; }
}
