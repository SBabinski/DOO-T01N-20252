package DOO-T01N-20252. Alunos.Alexandre.Prova_2tri;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersistenciaService {
    private static final String FILE_NAME = "dados_usuario.json";
    private final Gson gson;

    public PersistenciaService() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void salvarUsuario(Usuario usuario) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(usuario, writer);
            System.out.println(">> Dados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public Usuario carregarUsuario() {
        if (!Files.exists(Paths.get(FILE_NAME))) {
            return null;
        }
        try (Reader reader = new FileReader(FILE_NAME)) {
            return gson.fromJson(reader, Usuario.class);
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
            return null;
        }
    }
}