package com.example.api_filmes.dto;

import java.util.HashMap;
import java.util.Map;

import com.example.api_filmes.hooks.useFile;
import com.example.api_filmes.model.Show;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Gerenciador de persistência de dados em JSON
 */
public class ShowDTO {
    private static final String SHOWS_FILE_PATH = "db\\shows.json";
    private final ObjectMapper objectMapper;
    private Map<Long, Show> showsCache;

    public ShowDTO() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        this.showsCache = new HashMap<>();
        loadShows();
    }

    /**
     * Carrega as séries do arquivo JSON
     */
    private void loadShows() {
        try {
            String content = useFile.getContent(SHOWS_FILE_PATH);
            
            if (content != null && !content.trim().isEmpty() && !content.trim().equals("{}")) {
                showsCache = objectMapper.readValue(content, 
                        new TypeReference<Map<Long, Show>>() {});
                System.out.println("Séries salvas carregadas: " + showsCache.size());
            } else {
                showsCache = new HashMap<>();
                System.out.println("Cache de séries iniciado vazio");
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar séries do cache: " + e.getMessage());
            showsCache = new HashMap<>();
        }
    }

    /**
     * Salva todas as séries no arquivo JSON
     */
    private void saveShows() {
        try {
            String jsonContent = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(showsCache);
            useFile.saveContent(SHOWS_FILE_PATH, jsonContent);
        } catch (Exception e) {
            System.err.println("Erro ao salvar séries: " + e.getMessage());
        }
    }

    /**
     * Salva uma série no cache
     */
    public void saveShow(Show show) {
        if (show != null && show.getId() != null) {
            showsCache.put(show.getId(), show);
            saveShows();
        }
    }

    /**
     * Obtém uma série do cache
     */
    public Show getShow(Long showId) {
        return showsCache.get(showId);
    }

    /**
     * Obtém todas as séries do cache
     */
    public Map<Long, Show> getAllShows() {
        return new HashMap<>(showsCache);
    }

    /**
     * Limpa o cache de séries
     */
    public void clearShows() {
        showsCache.clear();
        saveShows();
    }
}
