package service;

import main.MapaMenus;
import modelos.Serie;
import modelos.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaFavoritos {

    static MapaMenus mapaMenus = new MapaMenus();

    public static void adicionandoSerieParaLista(int valor, Usuario usuario) {

        try {
            if (usuario.getListaFavoritos() == null) {
                usuario.setListaFavoritos(new ArrayList<>());
            }

            List<Serie> lista = usuario.getListaFavoritos();
            Serie serieSelecionada = Requisicao.getResultados().get(valor);
            lista.add(serieSelecionada);

            usuario.salvar();
            System.out.println("\n✅ Série adicionada a lista de favoritos.");
        }catch (Exception e){
            System.out.println("\n❌ Erro ao adicionar a lista de favoritos.");
        }
    }//fim do metodo para adicionar na lista de favoritos

    public static void lendoListaFavoritos(Usuario usuario) {
        try {
            List<Serie> lista = usuario.getListaFavoritos();

            if (lista.isEmpty() || lista == null) {
                System.out.println("\n📪 Sua lista está vazia.");
                return;
            }

            System.out.println("\n🌟 Sua lista de favoritos: ");
            for (Serie serie : lista) {
                System.out.println(serie);
            }
            mapaMenus.menuOrdenarListas(lista, usuario);
        }catch (Exception e){
            System.out.println("❌ Erro ao ordenar a lista de favoritos.");
        }
    }//fim do metodo para ler a lista de favoritos.

    public static void deleteListaFavoritos(Usuario usuario){

    List<Serie> listaDeSeries = usuario.getListaFavoritos();
    mapaMenus.menuDeletaSerie(usuario, listaDeSeries);
    usuario.salvar();

    }

}
