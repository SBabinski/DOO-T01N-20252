import java.util.List;
import java.util.Objects;

public class Serie {
    private int id;
    private String name;
    private String language;
    private List<String> genres;
    private String status;
    private String premiered;
    private String ended;
    private Rating rating;
    private Network network;
    private Network webChannel;

    public static class Rating {
        Double average;

        public Double getAverage() {
            return average;
        }
    }

    public static class Network {
        String name;

        public String getName() {
            return name;
        }
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language != null ? language : "Desconhecido";
    }

    public String getGenres() {
        return (genres != null && !genres.isEmpty()) ? String.join(", ", genres) : "Sem gênero";
    }

    public Double getNota() {
        return (rating != null && rating.getAverage() != null) ? rating.getAverage() : 0.0;
    }

    public String getStatus() {
        return status != null ? status : "Desconhecido";
    }

    public String getDataEstreia() {
        return premiered != null ? premiered : "N/A";
    }

    public String getDataTermino() {
        return ended != null ? ended : "Em andamento/N/A";
    }

    public String getEmissora() {
        if (network != null)
            return network.getName();
        if (webChannel != null)
            return webChannel.getName();
        return "N/A";
    }

    @Override
    public String toString() {
        return String.format(
                "------------------------------------------------\n" +
                        "Título: %s\n" +
                        "Nota: %.1f | Status: %s\n" +
                        "Gêneros: %s | Idioma: %s\n" +
                        "Estreia: %s | Fim: %s\n" +
                        "Emissora: %s\n" +
                        "------------------------------------------------",
                getName(), getNota(), getStatus(), getGenres(), getLanguage(),
                getDataEstreia(), getDataTermino(), getEmissora());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Serie serie = (Serie) o;
        return id == serie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}