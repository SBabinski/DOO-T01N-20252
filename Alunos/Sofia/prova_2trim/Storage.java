import java.io.*;
import java.nio.file.*;
import org.json.*;

public class Storage {
    private final Path path;

    public Storage(String fileName) {
        this.path = Paths.get(fileName);
    }

    public void salvarUsuario(Usuario usuario) throws IOException {
        JSONObject obj = usuario.toJSON();
        Files.write(path, obj.toString(2).getBytes());
    }

    public Usuario carregarUsuario() throws IOException {
        if (!Files.exists(path)) return null;
        String conteudo = new String(Files.readAllBytes(path)).trim();
        if (conteudo.isEmpty()) return null;
        try {
            JSONObject obj = new JSONObject(conteudo);
            return Usuario.fromJSON(obj);
        } catch (org.json.JSONException e) {
            return null;
        }
    }
}
