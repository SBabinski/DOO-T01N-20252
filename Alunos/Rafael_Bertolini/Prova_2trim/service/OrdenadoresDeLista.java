package service;

import modelos.Serie;

import java.util.Comparator;
import java.util.List;

public class OrdenadoresDeLista {

    // Ordena a lista in-place pelo nome da série.
// Usa referência de método (Serie::getName) para obter a chave de comparação
// e String.CASE_INSENSITIVE_ORDER para comparar ignorando maiúsculas/minúsculas.
    public static void ordenarListaPorNome(List<Serie> lista) {
        lista.sort(Comparator.comparing(Serie::getName, String.CASE_INSENSITIVE_ORDER));
    }

    // Ordena a lista in-place pela nota média (rating.average).
// Para cada série, o lambda pega rating.getAverage() quando não for null; caso contrário retorna 0.0.
// Comparator.comparing cria o comparador com essa chave; .reversed() inverte a ordem para maiores notas primeiro.
    public static void ordenarListaPorNota(List<Serie> lista) {
        lista.sort(Comparator.comparing((Serie serie) -> serie.getRating() != null
                && serie.getRating().getAverage() != null ? serie.getRating().getAverage() : 0.0)
                .reversed());
    }

    // Ordena a lista in-place pela data de estreia (campo premiered).
// Usa Comparator.nullsLast(String::compareTo) para que valores null fiquem no final.
// Observação: comparar como String funciona corretamente se premiered estiver em formato ISO (yyyy-MM-dd).
    public static void ordenarListaPorEstreia(List<Serie> lista) {
        lista.sort(Comparator.comparing(Serie::getPremiered, Comparator.nullsLast(String::compareTo)));
    }

    // Ordena a lista in-place pelo status da série (campo status).
// Usa Serie::getStatus como chave e String.CASE_INSENSITIVE_ORDER para comparar ignorando maiúsc/minúsc.
    public static void ordenarListaPorEstadoDaSerie(List<Serie> lista) {
        lista.sort(Comparator.comparing(Serie::getStatus, String.CASE_INSENSITIVE_ORDER));
    }
}
