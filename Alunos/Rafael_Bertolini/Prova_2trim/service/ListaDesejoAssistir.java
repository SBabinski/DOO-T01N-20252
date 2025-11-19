package service;

import main.MapaMenus;
import modelos.Serie;
import modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaDesejoAssistir {

    static MapaMenus mapaMenus = new MapaMenus();

    public static void adicionandoSerieParaListaDesejoAssistir(int valor, Usuario usuario) {

        try {
            if (usuario.getListaDesejoAssistir() == null) {
                usuario.setListaDesejoAssistir(new ArrayList<>());
            }

            List<Serie> lista = usuario.getListaDesejoAssistir();
            Serie serieSelecionada = Requisicao.getResultados().get(valor);
            lista.add(serieSelecionada);

            usuario.salvar();
            System.out.println("\n✅ Série adicionada a lista de Desejo Assistir.");
        }catch (Exception e){
            System.out.println("\n❌ Erro ao adicionar a lista de Desejo Assistir.");
        }
    }//fim do metodo para adicionar na lista de desejo assistir

    public static void lendoListaDesejoAssistir(Usuario usuario) {

        try {
            List<Serie> lista = usuario.getListaDesejoAssistir();

            System.out.println("\n🌟 Sua lista de Desejo Assistir: ");
            for (Serie serie : lista) {
                System.out.println(serie);
            }
            mapaMenus.menuOrdenarListas(lista, usuario);
        }catch (Exception e){
            System.out.println("\n❌ Erro ao ordenar a lista de Desejo Assistir.");
        }
    }//fim do metodo para ler a lista de desejo assistir

    public static void deleteListaDesejoAssistir(Usuario usuario){

        var listaDeSeries = usuario.getListaDesejoAssistir();
        mapaMenus.menuDeletaSerie(usuario, listaDeSeries);
        usuario.salvar();

    }

}
