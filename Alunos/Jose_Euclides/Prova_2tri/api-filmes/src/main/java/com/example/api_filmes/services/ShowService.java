package com.example.api_filmes.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.api_filmes.dto.ShowDTO;
import com.example.api_filmes.model.SearchResult;
import com.example.api_filmes.model.Show;
import com.example.api_filmes.services.TvMazeClient.TvMazeApiException;

/**
 * Serviço para gerenciar operações relacionadas às séries
 */
public class ShowService {
    private final TvMazeClient tvMazeClient;
    private final ShowDTO dataStore;

    public ShowService(TvMazeClient tvMazeClient, ShowDTO dataStore) {
        this.tvMazeClient = tvMazeClient;
        this.dataStore = dataStore;
    }

    /**
     * Busca séries pelo nome usando a API TVMaze
     */
    public List<Show> searchShows(String query) throws TvMazeApiException {
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptyList();
        }

        List<SearchResult> results = tvMazeClient.searchShows(query);
        List<Show> shows = new ArrayList<>();

        for (SearchResult result : results) {
            if (result.getShow() != null) {
                Show show = result.getShow();
                // Salva a série em JSON para uso futuro
                try {
                    dataStore.saveShow(show);
                } catch (Exception e) {
                    System.err.println("Erro ao salvar série: " + e.getMessage());
                }
                shows.add(show);
            }
        }

        return shows;
    }

    /**
     * Obtém uma série pelo ID, primeiro tentando o cache
     */
    public Show getShowById(Long showId) throws TvMazeApiException {
        if (showId == null) {
            return null;
        }

        // Primeiro tenta carregar do arquivo JSON
        Show savedShow = dataStore.getShow(showId);
        if (savedShow != null) {
            return savedShow;
        }

        // Se não estiver salva, busca na API e salva
        Show show = tvMazeClient.getShowById(showId);
        if (show != null) {
            try {
                dataStore.saveShow(show);
            } catch (Exception e) {
                System.err.println("Erro ao salvar série: " + e.getMessage());
            }
        }

        return show;
    }

    /**
     * Obtém múltiplas séries pelos IDs
     */
    public List<Show> getShowsByIds(List<Long> showIds) {
        if (showIds == null || showIds.isEmpty()) {
            return Collections.emptyList();
        }

        List<Show> shows = new ArrayList<>();
        for (Long showId : showIds) {
            try {
                Show show = getShowById(showId);
                if (show != null) {
                    shows.add(show);
                }
            } catch (TvMazeApiException e) {
                System.err.println("Erro ao buscar série ID " + showId + ": " + e.getMessage());
                // Continua com as outras séries
            }
        }

        return shows;
    }

    /**
     * Ordena uma lista de séries por nome (ordem alfabética)
     */
    public List<Show> sortByName(List<Show> shows) {
        if (shows == null) return Collections.emptyList();
        
        return shows.stream()
            .sorted((s1, s2) -> {
                String name1 = s1.getName() != null ? s1.getName() : "";
                String name2 = s2.getName() != null ? s2.getName() : "";
                return name1.compareToIgnoreCase(name2);
            })
            .collect(Collectors.toList());
    }

    /**
     * Ordena uma lista de séries por nota geral (decrescente)
     */
    public List<Show> sortByRating(List<Show> shows) {
        if (shows == null) return Collections.emptyList();
        
        return shows.stream()
            .sorted((s1, s2) -> {
                Double rating1 = s1.getRatingScore();
                Double rating2 = s2.getRatingScore();
                
                // Séries sem nota vão para o final
                if (rating1 == null && rating2 == null) return 0;
                if (rating1 == null) return 1;
                if (rating2 == null) return -1;
                
                return Double.compare(rating2, rating1); // Decrescente
            })
            .collect(Collectors.toList());
    }

    /**
     * Ordena uma lista de séries por status
     * Ordem: Running -> Ended -> To Be Determined -> outros
     */
    public List<Show> sortByStatus(List<Show> shows) {
        if (shows == null) return Collections.emptyList();
        
        Map<String, Integer> statusPriority = new HashMap<>();
        statusPriority.put("Running", 1);
        statusPriority.put("Ended", 2);
        statusPriority.put("To Be Determined", 3);
        
        return shows.stream()
            .sorted((s1, s2) -> {
                String status1 = s1.getStatus() != null ? s1.getStatus() : "";
                String status2 = s2.getStatus() != null ? s2.getStatus() : "";
                
                int priority1 = statusPriority.getOrDefault(status1, 999);
                int priority2 = statusPriority.getOrDefault(status2, 999);
                
                if (priority1 != priority2) {
                    return Integer.compare(priority1, priority2);
                }
                
                // Se mesma prioridade, ordena alfabeticamente pelo status
                return status1.compareToIgnoreCase(status2);
            })
            .collect(Collectors.toList());
    }

    /**
     * Ordena uma lista de séries por data de estreia (mais recente primeiro)
     */
    public List<Show> sortByPremiereDate(List<Show> shows) {
        if (shows == null) return Collections.emptyList();
        
        return shows.stream()
            .sorted((s1, s2) -> {
                LocalDate date1 = s1.getPremiered();
                LocalDate date2 = s2.getPremiered();
                
                // Séries sem data vão para o final
                if (date1 == null && date2 == null) return 0;
                if (date1 == null) return 1;
                if (date2 == null) return -1;
                
                return date2.compareTo(date1); // Mais recente primeiro
            })
            .collect(Collectors.toList());
    }

    /**
     * Formata as informações de uma série para exibição
     */
    public String formatShowInfo(Show show) {
        if (show == null) {
            return "Série não encontrada";
        }

        StringBuilder info = new StringBuilder();
        info.append("Nome:").append(show.getName() != null ? show.getName() : "N/A").append("\n");
        
        info.append("Idioma: ").append(show.getLanguage() != null ? show.getLanguage() : "N/A").append("\n");
        
        if (show.getGenres() != null && !show.getGenres().isEmpty()) {
            info.append("Gêneros: ").append(String.join(", ", show.getGenres())).append("\n");
        }
        
        Double rating = show.getRatingScore();
        if (rating != null) {
            info.append("Nota: ").append(String.format("%.1f/10", rating)).append("\n");
        }
        
        info.append("Status: ").append(show.getStatus() != null ? show.getStatus() : "N/A").append("\n");
        
        if (show.getPremiered() != null) {
            info.append("Estreia: ").append(show.getPremiered()).append("\n");
        }
        
        if (show.getEnded() != null) {
            info.append("Término: ").append(show.getEnded()).append("\n");
        }
        
        info.append("Emissora: ").append(show.getNetworkName()).append("\n");
        
        return info.toString();
    }

    /**
     * Obtém estatísticas da base de dados
     */
    public String getDataStats() {
        Map<Long, Show> allShows = dataStore.getAllShows();
        return String.format("Cache: %d séries armazenadas", allShows.size());
    }
}
