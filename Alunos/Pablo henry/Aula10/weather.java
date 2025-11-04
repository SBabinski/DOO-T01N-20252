import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class weather {

    public static void main(String[] args) throws Exception {
        
        String api = "X97JYNGUKFMU4C5HDZYFVA86Q"; // Sua chave API
        String city = "Cascavel,BR";
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" 
                       + city 
                       + "?unitGroup=metric&include=days&key=" 
                       + api; 
        // ate o timeline e a url padrao, dps do / escolhe a cidade e chama a api key

        HttpClient client = HttpClient.newHttpClient();
        // Httpclient faz todas as requisicoes pela internet, usar ele no projeto principal.

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // transforma string url para que o java entenda e possa ler
                .GET()
                .build(); // finaliza requisicao 

        // enviar o pedido e receber a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // --- Adicionado Bloco try-catch para segurança ---
        // Isso previne o programa de quebrar se a API responder com um erro (não-JSON)
        try {
            // converter o retorno em JSON
            JSONObject json = new JSONObject(response.body());

            // --- Lógica Correta ---
            // Esta API coloca a previsão de "hoje" como o primeiro item (índice 0) do array "days"
            JSONArray days = json.getJSONArray("days"); // pega o array de dias (previsoes)
            JSONObject hoje = days.getJSONObject(0); // usa o primeiro dia como clima atual

            // extrair informacoes principais
            String resolvedAddress = json.getString("resolvedAddress");
            double tempAtual = hoje.getDouble("temp");
            double tempMax = hoje.getDouble("tempmax");
            double tempMin = hoje.getDouble("tempmin");
            double umidade = hoje.getDouble("humidity");
            double vento = hoje.getDouble("windspeed");
            double direcaoVento = hoje.optDouble("winddir", 0); // optDouble é ótimo, não falha se o campo não existir
            double chuva = hoje.optDouble("precip", 0); // optDouble é ótimo
            String condicoes = hoje.getString("conditions");

            // exibir dados no console
            System.out.println("Local: " + resolvedAddress);
            System.out.println("Temperatura atual: " + tempAtual + "°C");
            System.out.println("Máxima: " + tempMax + "°C");
            System.out.println("Mínima: " + tempMin + "°C");
            System.out.println("Umidade: " + umidade + "%");
            System.out.println("Precipitação: " + chuva + "mm");
            System.out.println("Vento: " + vento + " km/h");
            System.out.println("Direção do vento: " + direcaoVento + "°");
            System.out.println("Condições: " + condicoes);

            // link principal: https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/[location]/[date1]/[date2]?key=YOUR_API_KEY
            // &lang=pt deixa o idioma em portugues, mas mudar o idioma so funciona na versao paga, pode se testar e ver se funciona na gratuita
            // exemplo: https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/London?key=SUA_CHAVE&lang=es

        } catch (org.json.JSONException e) {
            // Isso só acontece se a API retornar algo que NÃO é um JSON (ex: erro de chave, 404)
            System.out.println("ERRO: Não foi possível processar a resposta da API.");
            System.out.println("Verifique sua chave de API ou o status do serviço.");
            System.out.println("Resposta recebida: " + response.body());



            // OBS: QUE BOMBA PQP
        }
    }
}