import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherService {
    private static final String API_KEY = "7KU5Y4J8MZ7BGBWD3WLQEPYLZ";
    private static final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    
    public WeatherInfo getWeatherData(String city) {
        try {
            String urlString = BASE_URL + city + "?unitGroup=metric&key=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            // Parse the JSON response and create WeatherInfo object
            // We'll implement this later when we create the WeatherInfo class
            
            return parseWeatherData(response.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private WeatherInfo parseWeatherData(String jsonResponse) {
        try {
            JSONObject json = new JSONObject(jsonResponse);
            JSONObject currentConditions = json.getJSONObject("currentConditions");
            JSONObject today = json.getJSONArray("days").getJSONObject(0);

            WeatherInfo weatherInfo = new WeatherInfo();
            
            // Tratando valores que podem ser nulos
            weatherInfo.setCurrentTemp(currentConditions.isNull("temp") ? 0 : currentConditions.getDouble("temp"));
            weatherInfo.setMaxTemp(today.isNull("tempmax") ? 0 : today.getDouble("tempmax"));
            weatherInfo.setMinTemp(today.isNull("tempmin") ? 0 : today.getDouble("tempmin"));
            weatherInfo.setHumidity(currentConditions.isNull("humidity") ? 0 : currentConditions.getDouble("humidity"));
            weatherInfo.setConditions(currentConditions.isNull("conditions") ? "Não disponível" : currentConditions.getString("conditions"));
            weatherInfo.setPrecipitation(currentConditions.isNull("precip") ? 0 : currentConditions.getDouble("precip"));
            weatherInfo.setWindSpeed(currentConditions.isNull("windspeed") ? 0 : currentConditions.getDouble("windspeed"));
            weatherInfo.setWindDirection(currentConditions.isNull("winddir") ? "N/A" : String.valueOf(currentConditions.get("winddir")));

            return weatherInfo;
        } catch (Exception e) {
            System.err.println("Erro ao processar dados do clima: " + e.getMessage());
            return null;
        }
    }
}