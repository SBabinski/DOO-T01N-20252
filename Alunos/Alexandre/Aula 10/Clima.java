import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Clima {
    private static final String API_KEY = "WN5FEVSCREZDAKPEPEQDZNLL8";

    public static void main(String[] args) {
        String cidade = "Cascavel";
        buscarClima(cidade);
    }

    public static void buscarClima(String cidade) {
        try {
            String urlString = String.format(
                "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s?unitGroup=metric&key=%s&contentType=json",
                cidade, API_KEY
            );

            URL url = new URL(urlString);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = in.readLine()) != null) {
                resposta.append(linha);
            }
            in.close();

            JSONObject json = new JSONObject(resposta.toString());
            JSONObject hoje = json.getJSONArray("days").getJSONObject(0);
            JSONObject atual = json.getJSONObject("currentConditions");

            double tempAtual = atual.getDouble("temp");
            double tempMax = hoje.getDouble("tempmax");
            double tempMin = hoje.getDouble("tempmin");
            double umidade = atual.getDouble("humidity");
            String condicao = atual.getString("conditions");
            double precipitacao = hoje.getDouble("precip");
            double ventoVel = atual.getDouble("windspeed");
            double ventoDir = atual.getDouble("winddir");

            System.out.println("===== CLIMA EM " + cidade.toUpperCase() + " =====");
            System.out.println("Temperatura atual: " + tempAtual + " °C");
            System.out.println("Temperatura máxima: " + tempMax + " °C");
            System.out.println("Temperatura mínima: " + tempMin + " °C");
            System.out.println("Umidade: " + umidade + " %");
            System.out.println("Condição: " + condicao);
            System.out.println("Precipitação: " + precipitacao + " mm");
            System.out.println("Vento: " + ventoVel + " km/h, direção " + ventoDir + "°");
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados do clima: " + e.getMessage());
        }
    }
}
