import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherApp {
    private static final String API_KEY = "UEM6EWCDK8VXJ69LH6NSZKSLY"; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite a data (YYYY-MM-DD): ");
        String data = scanner.nextLine();

        try {
            exibirClima(cidade, data);
        } catch (IOException e) {
            System.out.println("Erro ao obter os dados do clima: " + e.getMessage());
        }
    }

    private static void exibirClima(String cidade, String data) throws IOException {
        String urlString = String.format(
            "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s/%s?unitGroup=metric&key=%s&contentType=json",
            cidade, data, API_KEY
        );

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new IOException("Erro na resposta da API: " + conn.getResponseCode());
        }

        Scanner scanner = new Scanner(conn.getInputStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.toString());
        JsonNode dia = root.get("days").get(0);

        double tempAtual = root.has("currentConditions")
                ? root.get("currentConditions").get("temp").asDouble()
                : dia.get("temp").asDouble();

        System.out.println("\n=== Clima em " + root.get("resolvedAddress").asText() + " ===");
        System.out.println("Data: " + dia.get("datetime").asText());
        System.out.println("Temperatura atual: " + tempAtual + " °C");
        System.out.println("Máxima: " + dia.get("tempmax").asDouble() + " °C");
        System.out.println("Mínima: " + dia.get("tempmin").asDouble() + " °C");
        System.out.println("Umidade: " + dia.get("humidity").asDouble() + " %");
        System.out.println("Condição: " + dia.get("conditions").asText());
        System.out.println("Precipitação: " + dia.get("precip").asDouble() + " mm");
        System.out.println("Vento: " + dia.get("windspeed").asDouble() + " km/h");
        System.out.println("Direção do vento: " + dia.get("winddir").asDouble() + "°");
    }
}
