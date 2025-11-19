package modelos;

import java.util.List;

public class Serie {

    private String name;
    private String language;
    private List<String> genres;
    private Rating rating;
    private Network network;
    private String status;
    private String premiered;
    private String ended;

    public static class Network {
        private String name;

        public String getName() {
            return name;
        }
    }

    public static class Rating {
        private Double average;

        public Double getAverage() {
            return average;
        }
    }


    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public Rating getRating() {
        return rating;
    }

    public Network getNetwork() {
        return network;
    }

    public String getStatus() {
        return status;
    }

    public String getPremiered() {
        return premiered;
    }

    public String getEnded() {
        return ended;
    }

    public List<String> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return
            ("\n🎬 Nome: " + name +
                        "\n🗣️ Idioma: " + language +
                        "\n⭐ Nota: " + (rating != null ? rating.getAverage() : "N/A") +
                        "\n📺 Status: " + status +
                        "\n📆 Estreia: " + premiered +
                        "\n📅 Término: " + (ended != null ? ended : "N/A") +
                        "\n🏢 Emissora: " + (network != null ? network.getName() : "N/A") +
                        "\n🎭 Genêros: " + String.join(" ,", genres)+
                    "\n\n—————————————————————————————————————————————————————————————————————————————————————————————————————————————");
    }


}
