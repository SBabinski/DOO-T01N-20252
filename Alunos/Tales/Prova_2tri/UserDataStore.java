import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class UserDataStore {
    private final String path;

    public UserDataStore(String path) { this.path = path; }

    public UserData loadOrCreate(ConsoleUI ui) {
        File f = new File(path);
        if (!f.exists()) {
            String nome = ui.askLine("Olá! Informe seu nome/apelido: ");
            UserData u = new UserData(nome);
            save(u);
            return u;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            String json = br.lines().collect(Collectors.joining("\n"));
            String username = JsonUtils.getString(json, "\"username\"");
            Set<Integer> fav = JsonUtils.getIntSet(json, "\"favorites\"");
            Set<Integer> wat = JsonUtils.getIntSet(json, "\"watched\"");
            Set<Integer> wlt = JsonUtils.getIntSet(json, "\"watchlist\"");
            UserData u = new UserData(username);
            u.getFavorites().addAll(fav);
            u.getWatched().addAll(wat);
            u.getWatchlist().addAll(wlt);
            return u;
        } catch (Exception e) {
            // arquivo corrompido? cria novo com backup
            new File(path + ".bak").delete();
            new File(path).renameTo(new File(path + ".bak"));
            ui.error("Não foi possível ler 'userdata.json'. Um novo arquivo será criado (backup em userdata.json.bak).");
            UserData u = new UserData("Usuário");
            save(u);
            return u;
        }
    }

    public void save(UserData u) {
        String json = """
                {
                  "username": %s,
                  "favorites": %s,
                  "watched": %s,
                  "watchlist": %s
                }
                """.formatted(
                JsonUtils.quote(u.getUsername()),
                JsonUtils.intSetToJson(u.getFavorites()),
                JsonUtils.intSetToJson(u.getWatched()),
                JsonUtils.intSetToJson(u.getWatchlist())
        );
        try (Writer w = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8)) {
            w.write(json);
        } catch (IOException e) {
            System.err.println("Falha ao salvar dados: " + e.getMessage());
        }
    }
}
