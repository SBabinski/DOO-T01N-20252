import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConsultaClima {
    private static final String API_KEY = "WTTQLK85GDWCKCKLJNEWHCTD9";

            public static Tempo buscarClima(String cidade) throws IOException {
            String urlStr = String.format(
                    "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/" +
                            "timeline/%s?unitGroup=metric&key=%s&contentType=json",
                    cidade, API_KEY
            );

            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            int codigoResp = conexao.getResponseCode();
            if (codigoResp != 200) {
                throw new IOException("Erro na requisição. Código: " + codigoResp);
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder resp = new StringBuilder();

            while (scanner.hasNext()) {
                resp.append(scanner.nextLine());
            }

            scanner.close();

            JSONObject json = new JSONObject(resp.toString());
            JSONObject climaAt = json.getJSONObject("currentConditions");
            JSONArray dias = json.getJSONArray("days");
            JSONObject dia = dias.getJSONObject(0);

            return new Tempo(
                    json.optString("resolvedAdress"),
                    climaAt.optDouble("temp", Double.NaN),
                    dia.optDouble("tempmax", Double.NaN),
                    dia.optDouble("tempmin", Double.NaN),
                    climaAt.optInt("humydity", 0),
                    climaAt.optString("conditions", "Desconhecida"),
                    dia.optDouble("precip", 0.0),
                    climaAt.optDouble("windspeed", 0.0),
                    climaAt.optDouble("winddir", 0.0)
                );
            }
        }
