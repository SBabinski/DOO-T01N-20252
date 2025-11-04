package clima.api.service;

import clima.api.model.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

//Service class to fetch weather data from Visual Crossing API
@Service
public class WeatherService {

    private static final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Value("${weather.api.key:}")
    private String apiKey;

    public WeatherService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

  
    public Weather getWeatherByCity(String cityName, String state) throws WeatherServiceException {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new WeatherServiceException(
                    "API key não configurada. Configure 'weather.api.key' no arquivo application.properties");
        }

        try {
            String location = cityName + ", " + state + ", Brazil";
            System.out.println("[GET > Weather] Location: ".concat(location));
            String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);

            String url = BASE_URL + encodedLocation +
                    "?unitGroup=metric" +
                    "&key=" + apiKey +
                    "&contentType=json";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new WeatherServiceException(
                        "Erro na API: Status " + response.statusCode() + " - " + response.body());
            }

            Weather weather = objectMapper.readValue(response.body(), Weather.class);

            return weather;

        } catch (WeatherServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new WeatherServiceException("Erro ao buscar dados do clima: " + e.getMessage(), e);
        }
    }

    public static class WeatherServiceException extends Exception {
        public WeatherServiceException(String message) {
            super(message);
        }

        public WeatherServiceException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
