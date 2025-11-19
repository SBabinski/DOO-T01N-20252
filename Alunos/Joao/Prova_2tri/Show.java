import java.util.List;
import java.util.Objects;

public class Show {
    private int id;
    private String name;
    private String language;
    private List<String> genres;
    private Double rating;
    private String status;
    private String premiered;
    private String ended;
    private String networkName;

    public Show() {}

    public Show(int id, String name, String language, List<String> genres, Double rating,
                String status, String premiered, String ended, String networkName) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.genres = genres;
        this.rating = rating;
        this.status = status;
        this.premiered = premiered;
        this.ended = ended;
        this.networkName = networkName;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLanguage() { return language; }
    public List<String> getGenres() { return genres; }
    public Double getRating() { return rating; }
    public String getStatus() { return status; }
    public String getPremiered() { return premiered; }
    public String getEnded() { return ended; }
    public String getNetworkName() { return networkName; }

    @Override
    public String toString() {
        String nota = (rating == null) ? "N/A" : String.format("%.1f", rating); //se nn tiver nota

        return name + " (" + nota + ") - " + (status == null ? "N/A" : status); //se tiver
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Show)) return false;

        Show show = (Show) o;
        return id == show.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
