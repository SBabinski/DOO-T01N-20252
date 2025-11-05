import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class Usuario {
    String nome;
    List<Serie> favoritos = new ArrayList<>();
    List<Serie> assistidas = new ArrayList<>();
    List<Serie> desejos = new ArrayList<>();

    public Usuario(String nome) { this.nome = nome; }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("nome", nome);
        obj.put("favoritos", listToJSONArray(favoritos));
        obj.put("assistidas", listToJSONArray(assistidas));
        obj.put("desejos", listToJSONArray(desejos));
        return obj;
    }

    private JSONArray listToJSONArray(List<Serie> lista) {
        JSONArray arr = new JSONArray();
        for (Serie s : lista) arr.put(s.toJSON());
        return arr;
    }

    public static Usuario fromJSON(JSONObject obj) {
        Usuario u = new Usuario(obj.optString("nome"));
        u.favoritos = jsonArrayToList(obj.optJSONArray("favoritos"));
        u.assistidas = jsonArrayToList(obj.optJSONArray("assistidas"));
        u.desejos = jsonArrayToList(obj.optJSONArray("desejos"));
        return u;
    }

    private static List<Serie> jsonArrayToList(JSONArray arr) {
        List<Serie> lista = new ArrayList<>();
        if (arr != null) {
            for (int i = 0; i < arr.length(); i++) lista.add(Serie.fromJSON(arr.getJSONObject(i)));
        }
        return lista;
    }
}
