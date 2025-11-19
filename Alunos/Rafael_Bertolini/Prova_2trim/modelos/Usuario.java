package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Usuario {

    private String apelido;
    private List<Serie> listaFavoritos;
    private List<Serie> listaJaAssistidos;
    private List<Serie> listaDesejoAssistir;
    private static String chamaArquivoJSON = "arquivo.json";

    public Usuario(String apelido) {
        this.apelido = apelido;
    }

    public String getApelido() {
        return apelido;
    }

    public List<Serie> getListaFavoritos() {
        return listaFavoritos;
    }

    public void setListaFavoritos(List<Serie> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }

    public List<Serie> getListaJaAssistidos() {
        return listaJaAssistidos;
    }

    public void setListaJaAssistidos(List<Serie> listaJaAssistidos) {
        this.listaJaAssistidos = listaJaAssistidos;
    }

    public List<Serie> getListaDesejoAssistir() {
        return listaDesejoAssistir;
    }

    public void setListaDesejoAssistir(List<Serie> listaDesejoAssistir) {
        this.listaDesejoAssistir = listaDesejoAssistir;
    }

    public void salvar() {

        Gson converteDados = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter chamaJavaParaJSON = new FileWriter(chamaArquivoJSON)) {

            converteDados.toJson(this, chamaJavaParaJSON);

        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }

    public static Usuario ler() {

        Gson lendoApelido = new Gson();

        try (FileReader lendoArquivoJSON = new FileReader(chamaArquivoJSON)) {

            return lendoApelido.fromJson(lendoArquivoJSON, Usuario.class);

        } catch (IOException erro) {
            erro.printStackTrace();
        }

        return null;
    }
}
