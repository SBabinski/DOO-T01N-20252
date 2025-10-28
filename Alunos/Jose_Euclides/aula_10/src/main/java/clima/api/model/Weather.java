package clima.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("days")
    private List<Day> days;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("address")
    private String address;

    public Weather() {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Day {
        @JsonProperty("datetime")
        private String datetime;

        @JsonProperty("tempmax")
        private Double tempMax;

        @JsonProperty("tempmin")
        private Double tempMin;

        @JsonProperty("temp")
        private Double temp;

        @JsonProperty("humidity")
        private Double humidity;

        @JsonProperty("conditions")
        private String conditions;

        @JsonProperty("precip")
        private Double precip;

        @JsonProperty("windspeed")
        private Double windSpeed;

        @JsonProperty("winddir")
        private Double windDir;

        public Day() {
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public Double getTempMax() {
            return tempMax;
        }

        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }

        public Double getTempMin() {
            return tempMin;
        }

        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        public String getConditions() {
            return conditions;
        }

        public void setConditions(String conditions) {
            this.conditions = conditions;
        }

        public Double getPrecip() {
            return precip;
        }

        public void setPrecip(Double precip) {
            this.precip = precip;
        }

        public Double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(Double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public Double getWindDir() {
            return windDir;
        }

        public void setWindDir(Double windDir) {
            this.windDir = windDir;
        }
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
