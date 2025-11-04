package clima.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class representing a city from IBGE API
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    @JsonProperty("nome")
    private String name;

    @JsonProperty("UF")
    private State state;

    public static class State {
        @JsonProperty("sigla")
        private String sigla;

        public String getSigla() {
            return this.sigla;
        }

        public void setSigla(String sigla) {
            this.sigla = sigla;
        }
    }

    public City() {
    }

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public String getNameAndStateString() {
        if (state != null) {
            return this.name + " - " + state.getSigla();
        }
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

