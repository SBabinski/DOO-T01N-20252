package Sistema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoldeClima {

        public List<Dia> days;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Dia {
        public double temp;
        public double tempmax;
        public double tempmin;
        public double humidity;
        public String conditions;
        public double precip;
        public double windspeed;
        public double winddir;

        @Override
        public String toString() {
            return "🌡️ Temperatura atual: " + temp + "°C" +
                    "\n📈 Temperatura Máxima: " + tempmax + "°C" +
                    "\n📉 Temperatura Minima: " + tempmin + "°C" +
                    "\n💧 Humidade atual: " + humidity + "%" +
                    "\n☔ Condição atual: " + conditions +
                    "\n🌦️ Precipitação: " + precip + "mm" +
                    "\n🍃 Velocidade do vento : " + windspeed + "Km/h, direção: " + winddir + "°" +
                    "\n================================================================================================";
        }
    }
}
