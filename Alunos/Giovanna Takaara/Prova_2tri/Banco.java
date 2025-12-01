import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

class Banco {
    private static final String ARQ = "dados.json";


    public static void salvar(Usuario u) {
        try {
            Gson g = new GsonBuilder().setPrettyPrinting().create();
            FileWriter fw = new FileWriter(ARQ);
            fw.write(g.toJson(u));
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Usuario carregar() {
        try {
            File f = new File(ARQ);
            if (!f.exists()) return new Usuario();
            Gson g = new Gson();
            return g.fromJson(new FileReader(f), Usuario.class);
        } catch (Exception e) {
            return new Usuario();
        }
    }
}
