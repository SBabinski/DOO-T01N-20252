import java.util.Scanner;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Clima {
    public static void main(String[] args) {
        final String API_KEY = "BXF4FSXJXPNK3TM8B3DV6DNFH";
        final String URL_BASE = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o nome da cidade: ");
        String cidadeInput = scan.nextLine().trim();
        scan.close();

        try {
            // codifica o nome da cidade para evitar erro com acentos e espaços
            String cidade = URLEncoder.encode(cidadeInput, "UTF-8");

            // monta a URL completa
            String urlString = URL_BASE + cidade + "?unitGroup=metric&key=" + API_KEY + "&contentType=json";
            System.out.println("URL requisitada: " + urlString);

            // faz a conexão HTTP
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // lê a resposta
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // converte o texto em JSON
            JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();

            // verifica se tem dados atuais
            if (!json.has("currentConditions")) {
                System.out.println("Não foi possível obter os dados atuais de " + cidadeInput);
                return;
            }

            JsonObject current = json.getAsJsonObject("currentConditions");
            JsonObject today = json.getAsJsonArray("days").get(0).getAsJsonObject();

            double temp = current.has("temp") ? current.get("temp").getAsDouble() : Double.NaN;
            double humidity = current.has("humidity") ? current.get("humidity").getAsDouble() : Double.NaN;
            String conditions = current.has("conditions") ? current.get("conditions").getAsString() : "Desconhecida";
            double windspeed = current.has("windspeed") ? current.get("windspeed").getAsDouble() : Double.NaN;
            double winddir = current.has("winddir") ? current.get("winddir").getAsDouble() : Double.NaN;
            double tempMax = today.has("tempmax") ? today.get("tempmax").getAsDouble() : Double.NaN;
            double tempMin = today.has("tempmin") ? today.get("tempmin").getAsDouble() : Double.NaN;
            double precip = today.has("precip") ? today.get("precip").getAsDouble() : 0.0;

            System.out.println("\n=== Clima em " + cidadeInput + " ===");
            System.out.printf("Temperatura atual: %.1f°C%n", temp);
            System.out.printf("Máxima do dia: %.1f°C%n", tempMax);
            System.out.printf("Mínima do dia: %.1f°C%n", tempMin);
            System.out.printf("Umidade: %.0f%%%n", humidity);
            System.out.println("Condição: " + conditions);
            System.out.printf("Precipitação: %.1f mm%n", precip);
            System.out.printf("Vento: %.1f km/h (direção %.0f°)%n", windspeed, winddir);

        } catch (Exception e) {
            System.out.println("Erro ao buscar dados do clima:");
            e.printStackTrace();
        }
    }
}