import java.time.LocalDate;
import java.util.*;

public class ShowInfo {
    private final int id;
    private final String name;
    private final String language;
    private final List<String> genres;
    private final Double ratingAverage; // pode ser null
    private final String status;        // Running, Ended, etc (API)
    private final LocalDate premiered;  // pode ser null
    private final LocalDate ended;      // pode ser null
    private final String networkName;   // pode ser null

    public ShowInfo(int id, String name, String language, List<String> genres, Double ratingAverage,
                    String status, LocalDate premiered, LocalDate ended, String networkName) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.genres = genres == null ? List.of() : List.copyOf(genres);
        this.ratingAverage = ratingAverage;
        this.status = status;
        this.premiered = premiered;
        this.ended = ended;
        this.networkName = networkName;
    }

    public int id() { return id; }
    public String name() { return name; }
    public String language() { return language; }
    public List<String> genres() { return genres; }
    public Double ratingAverage() { return ratingAverage; }
    public String status() { return status; }
    public LocalDate premiered() { return premiered; }
    public LocalDate ended() { return ended; }
    public String networkName() { return networkName; }

    public String basicLine() {
        String nota = ratingAverage == null ? "-" : String.format(Locale.ROOT, "%.1f", ratingAverage);
        return "%s (id=%d) | Nota: %s | Estado: %s | Estreia: %s".formatted(
                name, id, nota, statusPt(status), premiered == null ? "-" : premiered);
    }

    public String fullDetails() {
        return """
               Nome: %s
               Idioma: %s
               Gêneros: %s
               Nota geral: %s
               Estado: %s
               Estreia: %s   Término: %s
               Emissora: %s
               """.formatted(
                name,
                nvl(language, "-"),
                genres.isEmpty() ? "-" : String.join(", ", genres),
                ratingAverage == null ? "-" : String.format(Locale.ROOT, "%.1f", ratingAverage),
                statusPt(status),
                premiered == null ? "-" : premiered,
                ended == null ? "-" : ended,
                nvl(networkName, "-")
        );
    }

    private static String nvl(String s, String alt) { return (s == null || s.isBlank()) ? alt : s; }

    // Mapa simples para exibir/ordenar por "estado" em PT
    public static String statusPt(String apiStatus) {
        if (apiStatus == null) return "-";
        return switch (apiStatus) {
            case "Running" -> "Ainda transmitindo";
            case "Ended" -> "Já concluída";
            case "To Be Determined" -> "A definir";
            case "In Development" -> "Em desenvolvimento";
            case "Hiatus" -> "Em hiato";
            case "Canceled" -> "Cancelada";
            default -> apiStatus;
        };
    }

    // Comparadores
    public static final Comparator<ShowInfo> BY_NAME_ASC =
            Comparator.comparing(ShowInfo::name, String.CASE_INSENSITIVE_ORDER);

    public static final Comparator<ShowInfo> BY_RATING_DESC =
            Comparator.comparing((ShowInfo s) -> s.ratingAverage == null ? -1.0 : s.ratingAverage).reversed();

    public static final Comparator<ShowInfo> BY_PREMIERE_ASC =
            Comparator.comparing((ShowInfo s) -> s.premiered == null ? LocalDate.of(3000,1,1) : s.premiered);

    public static final Comparator<ShowInfo> BY_STATUS_PT =
            Comparator.comparing((ShowInfo s) -> statusRank(statusPt(s.status)));

    private static int statusRank(String st) {
        // Ordem: Ainda transmitindo, Já concluída, Cancelada, Hiato, A definir, outros
        return switch (st) {
            case "Ainda transmitindo" -> 1;
            case "Já concluída" -> 2;
            case "Cancelada" -> 3;
            case "Em hiato" -> 4;
            case "A definir" -> 5;
            default -> 9;
        };
    }
}
