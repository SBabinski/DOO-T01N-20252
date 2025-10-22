package Sistema;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Requisicao {

    private static final String apiLink = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    private static final String apiKey = "4JA2C8NEYR9LLYSF3Y4HUTLV4";

    public MoldeClima.Dia getRequisicao(String cidade) throws IOException, InterruptedException {
        String cidadeInformada = URLEncoder.encode(cidade, StandardCharsets.UTF_8);

        String url = apiLink + cidadeInformada
                + "/?key=" + apiKey +
                "&unitGroup=metric&lang=pt";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        MoldeClima resposta = mapper.readValue(response.body(), MoldeClima.class);

        return resposta.days.get(0);
    }
}
