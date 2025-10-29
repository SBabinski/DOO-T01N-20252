package clima.api.service;

import clima.api.model.City;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service class for managing city operations
 * Responsible for fetching cities from IBGE API
 */
@Service
public class CityService {

    private static final String IBGE_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public CityService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Fetches all cities from IBGE API
     * 
     * @return List of all cities sorted by name
     */
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(IBGE_API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                cities = objectMapper.readValue(jsonResponse, new TypeReference<List<City>>() {
                });
                System.out.println("Total de cidades carregadas: " + cities.size());
            } else {
                System.err.println("[CityService] Erro HTTP: " + response.statusCode());
            }

            Collections.sort(cities, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        } catch (Exception e) {
            System.err.println("[CityService] Erro ao buscar cidades: " + e.getMessage());
        }

        return cities;
    }

    public City findCityByName(String cityName) {
        List<City> allCities = getAllCities();

        return allCities.stream()
                .filter(city -> city.getName().equalsIgnoreCase(cityName))
                .findFirst()
                .orElse(null);
    }
}
