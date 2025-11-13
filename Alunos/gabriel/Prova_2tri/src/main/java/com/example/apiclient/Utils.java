package com.example.apiclient;

import java.util.List;

public class Utils {
    /**
     * Metodo que ordena LISTA de series pelo nome
     */
    public static List<Serie> ordenaPorNome(List<Serie> lista, String title) {
        if (lista.size() == 0) {
            System.out.println("NENHUMA " + title);
            return lista;
        }

        List<Serie> listaOrdenada = lista.stream()
                .sorted((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()))
                .toList();

        System.out.println("\n📺 Séries " + title + " (ordenadas por nome):\n");

        // Exibe cada série formatada
        listaOrdenada.forEach(serie -> System.out.printf(
                "• Nome: %s\n Idioma: %s\n Genero: %s\n  Nota: %s\n  Estado: %s\n  Estreia: %s\n  Emissora: %s\n  \n\n",
                serie.getName(),
                serie.getLanguage(),
                serie.getGenres(),
                (serie.getRating() != null && serie.getRating().getAverage() != null
                        ? serie.getRating().getAverage()
                        : "Sem nota"),
                serie.getStatus(),
                serie.getPremiered(),
                (serie.getNetwork() != null ? serie.getNetwork().getName() : "Desconhecida")));

        System.out.println(listaOrdenada.size());

        return listaOrdenada;

    }



         /**
     * Metodo que ordena LISTA de series pela nota
     */
    public static List<Serie> ordenaPorNota(List<Serie> lista, String title) {
        if (lista.size() == 0) {
            System.out.println("NENHUMA " + title);
            return lista;
        }

        List<Serie> listaOrdenada = lista.stream()
                .sorted((s1, s2) -> {
                    Double r1 = (s1.getRating() != null && s1.getRating().getAverage() != null)
                            ? s1.getRating().getAverage()
                            : Double.MIN_VALUE;
                    Double r2 = (s2.getRating() != null && s2.getRating().getAverage() != null)
                            ? s2.getRating().getAverage()
                            : Double.MIN_VALUE;
                    // Ordena da maior para menor nota
                    return r2.compareTo(r1);
                })
                .toList();

        System.out.println("\n📺 Séries " + title + " (ordenadas por nota):\n");

        // Exibe cada série formatada
        listaOrdenada.forEach(serie -> System.out.printf(
                "• Nome: %s\n Idioma: %s\n Genero: %s\n  Nota: %s\n  Estado: %s\n  Estreia: %s\n  Emissora: %s\n  \n\n",
                serie.getName(),
                serie.getLanguage(),
                serie.getGenres(),
                (serie.getRating() != null && serie.getRating().getAverage() != null
                        ? serie.getRating().getAverage()
                        : "Sem nota"),
                serie.getStatus(),
                serie.getPremiered(),
                (serie.getNetwork() != null ? serie.getNetwork().getName() : "Desconhecida")));

        System.out.println(listaOrdenada.size());

        return listaOrdenada;

    }


    public static List<Serie> ordenaPorEstado(List<Serie> lista, String title) {
        if (lista.size() == 0) {
            System.out.println("NENHUMA " + title);
            return lista;
        }

        List<Serie> listaOrdenada = lista.stream()
        .sorted((s1, s2) -> s1.getStatus().compareToIgnoreCase(s2.getStatus()))
        .toList();

        System.out.println("\n📺 Séries " + title + " (ordenadas por estado):\n");

        // Exibe cada série formatada
        listaOrdenada.forEach(serie -> System.out.printf(
                "• Nome: %s\n Idioma: %s\n Genero: %s\n  Nota: %s\n  Estado: %s\n  Estreia: %s\n  Emissora: %s\n  \n\n",
                serie.getName(),
                serie.getLanguage(),
                serie.getGenres(),
                (serie.getRating() != null && serie.getRating().getAverage() != null
                        ? serie.getRating().getAverage()
                        : "Sem nota"),
                serie.getStatus(),
                serie.getPremiered(),
                (serie.getNetwork() != null ? serie.getNetwork().getName() : "Desconhecida")));

        System.out.println(listaOrdenada.size());

        return listaOrdenada;

    }


    public static List<Serie> ordenaPorEstreia(List<Serie> lista, String title) {
        if (lista.size() == 0) {
            System.out.println("NENHUMA " + title);
            return lista;
        }

        List<Serie> listaOrdenada = lista.stream()
        .sorted((s1, s2) -> s1.getPremiered().compareToIgnoreCase(s2.getPremiered()))
        .toList();

        System.out.println("\n📺 Séries " + title + " (ordenadas por estreia):\n");

        // Exibe cada série formatada
        listaOrdenada.forEach(serie -> System.out.printf(
                "• Nome: %s\n Idioma: %s\n Genero: %s\n  Nota: %s\n  Estado: %s\n  Estreia: %s\n  Emissora: %s\n  \n\n",
                serie.getName(),
                serie.getLanguage(),
                serie.getGenres(),
                (serie.getRating() != null && serie.getRating().getAverage() != null
                        ? serie.getRating().getAverage()
                        : "Sem nota"),
                serie.getStatus(),
                serie.getPremiered(),
                (serie.getNetwork() != null ? serie.getNetwork().getName() : "Desconhecida")));

        System.out.println(listaOrdenada.size());

        return listaOrdenada;

    }












}
