public class WeatherInfo {
    private double currentTemp;
    private double maxTemp;
    private double minTemp;
    private double humidity;
    private String conditions;
    private double precipitation;
    private double windSpeed;
    private String windDirection;

    // Getters and Setters
    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    @Override
    public String toString() {
        return "Condições do tempo:\n" +
               "Temperatura atual: " + currentTemp + "°C\n" +
               "Temperatura máxima: " + maxTemp + "°C\n" +
               "Temperatura mínima: " + minTemp + "°C\n" +
               "Humidade: " + humidity + "%\n" +
               "Condições: " + conditions + "\n" +
               "Precipitação: " + precipitation + "mm\n" +
               "Velocidade do vento: " + windSpeed + " km/h\n" +
               "Direção do vento: " + windDirection;
    }
}