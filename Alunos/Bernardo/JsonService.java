import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;

public class JsonService {

    private static final String FILE_PATH = "usuario.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvarUsuario(Usuario usuario) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(usuario, writer);
        } catch (Exception e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    public static Usuario carregarUsuario() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, Usuario.class);
        } catch (Exception e) {
            return null;
        }
    }
}