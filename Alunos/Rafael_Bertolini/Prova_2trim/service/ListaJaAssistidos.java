package service;

import main.MapaMenus;
import modelos.Serie;
import modelos.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaJaAssistidos {

    static MapaMenus mapaMenus = new MapaMenus();

    public static void adicionandoSerieParaListaJaAssistidos(int valor, Usuario usuario) {

        try {
            if (usuario.getListaJaAssistidos() == null) {
                usuario.setListaJaAssistidos(new ArrayList<>());
            }

            List<Serie> lista = usuario.getListaJaAssistidos();
            Serie serieSelecionada = Requisicao.getResultados().get(valor);
            lista.add(serieSelecionada);

            usuario.salvar();
            System.out.println("\n✅ Série adicionada a lista de já assistidos.");
        }catch (Exception e){
            System.out.println("\n❌ Erro ao adicionar a lista de já assistidos.");
        }
    }//fim do metodo para adicionar na lista de ja assistidos

    public static void lendoListaJaAssistidos(Usuario usuario) {
        try {
            List<Serie> lista = usuario.getListaJaAssistidos();

            if (lista.isEmpty() || lista == null) {
                System.out.println("\n📪 Sua lista está vazia.");
                return;
            }

            System.out.println("\n🌟 Sua lista de séries já assistidas: ");
            for (Serie serie : lista) {
                System.out.println(serie);
            }
            mapaMenus.menuOrdenarListas(lista, usuario);
        }catch (Exception e){
            System.out.println("❌ Erro ao ler a lista de Já Assistidos.");
        }
    }//fim do metodo para ler a lista de ja assistidos

    public static void deleteListaJaAssistidos(Usuario usuario){

        var listaDeSeries = usuario.getListaJaAssistidos();
        mapaMenus.menuDeletaSerie(usuario, listaDeSeries);
        usuario.salvar();

    }

}
