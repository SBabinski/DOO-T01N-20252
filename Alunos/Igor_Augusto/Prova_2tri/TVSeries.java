import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TVSeries {
    private int id;
    private String name;
    private String language;
    private List<String> genres;
    private double rating;
    private String status;
    private LocalDate premiered;
    private LocalDate ended;
    private String network;
    
    public TVSeries(int id, String name, String language, List<String> genres, 
                   double rating, String status, LocalDate premiered, 
                   LocalDate ended, String network) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.genres = genres;
        this.rating = rating;
        this.status = status;
        this.premiered = premiered;
        this.ended = ended;
        this.network = network;
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLanguage() { return language; }
    public List<String> getGenres() { return genres; }
    public double getRating() { return rating; }
    public String getStatus() { return status; }
    public LocalDate getPremiered() { return premiered; }
    public LocalDate getEnded() { return ended; }
    public String getNetwork() { return network; }
    
    public void displayDetails() {
        System.out.println("Nome: " + name);
        System.out.println("Idioma: " + language);
        System.out.println("Gêneros: " + String.join(", ", genres));
        System.out.println("Nota: " + (rating > 0 ? rating : "N/A"));
        System.out.println("Estado: " + status);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Estreia: " + 
            (premiered != null ? premiered.format(formatter) : "N/A"));
        System.out.println("Término: " + 
            (ended != null ? ended.format(formatter) : "N/A"));
        System.out.println("Emissora: " + (network != null ? network : "N/A"));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TVSeries series = (TVSeries) obj;
        return id == series.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
