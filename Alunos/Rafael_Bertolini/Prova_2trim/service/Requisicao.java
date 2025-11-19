package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelos.Serie;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Requisicao {

    static List<Serie> listaResultadosFinal = new ArrayList<>();

    public void requisicaoAPI(String nome) throws Exception {

        listaResultadosFinal.clear();
        String nomeCodificado = URLEncoder.encode(nome, "UTF-8");

        HttpClient client = HttpClient.newHttpClient();
        URI url = new URI("https://api.tvmaze.com/search/shows?q=" + nomeCodificado);

        HttpRequest requesicao = HttpRequest.newBuilder(url).GET().build();
        HttpResponse<String> resposta = client.send(requesicao, HttpResponse.BodyHandlers.ofString());

        if (resposta.statusCode() == 200) {

            List<ResultadosDaAPI> lista = new Gson().fromJson(resposta.body(),
                    new TypeToken<List<ResultadosDaAPI>>() {
                    }.getType());

            for (ResultadosDaAPI rAPI : lista) {
                Serie s = rAPI.getShow();
                System.out.println(s);
                listaResultadosFinal.add(rAPI.getShow());
            }

        } else {
            System.out.println("Erro na requesição!");
        }
    }

    public static List<Serie> getResultados() {
        return listaResultadosFinal;
    }


    private static class ResultadosDaAPI {
        private Serie show;

        public Serie getShow() {
            return show;
        }
    }
}

