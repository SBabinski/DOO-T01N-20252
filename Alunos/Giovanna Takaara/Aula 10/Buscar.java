import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Buscar {
    private static final String API_KEY = "BPJ2K5S6RP73NN99K2T8JY582";

    public static Clima buscar(String cidade) throws IOException {
        String urlStr = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                + cidade + "?unitGroup=metric&key=" + API_KEY + "&contentType=json";

        URL url = new URL(urlStr);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");

        int cod = conexao.getResponseCode();
        if (cod != 200) {
            throw new IOException("Erro! Código: " + cod);
        }
        Scanner scanner = new Scanner(conexao.getInputStream(), "UTF-8");
        StringBuilder resp = new StringBuilder();
        while (scanner.hasNext()) {
            resp.append(scanner.nextLine());
        } scanner.close();

        JSONObject json = new JSONObject (resp.toString());
        JSONObject climaAtual = json.getJSONObject("currentConditions");
        JSONArray dias = json.getJSONArray("days");
        JSONObject dia = dias.getJSONObject(0);

        return new Clima (
                json.optString("resolvedAddress"),
                climaAtual.optDouble("temp", Double.NaN),
                dia.optDouble("tempmax", Double.NaN),
                dia.optDouble("tempmin", Double.NaN),
                climaAtual.optInt("humidity", 0),
                climaAtual.optString("conditions", "Desconhecida"),
                climaAtual.optDouble("windspeed", 0.0),
                climaAtual.optDouble("winddir", 0.0)
        );
    }
}