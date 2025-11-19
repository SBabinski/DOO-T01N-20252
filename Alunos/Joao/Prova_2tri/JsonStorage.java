import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonStorage {

    private static final String arquivodados = "dados.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void salvar(ShowManager manager) {

        try (FileWriter writer = new FileWriter(arquivodados)) {
            gson.toJson(manager, writer);

        } catch (IOException e) {

            System.out.println("Erro ao salvar JSON: " + e.getMessage());
        }
    }

    public static ShowManager carregar() {
        try (FileReader reader = new FileReader(arquivodados)) {
            return gson.fromJson(reader, ShowManager.class);
        } catch (Exception e) {
            return new ShowManager();
        }
    }
}
