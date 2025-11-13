package com.example.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static final String FILE_NAME = "user.json";

    private String username;
    private List<Serie> favoritos;
    private List<Serie> assistidos;
    private List<Serie> desejos;

    public UserData() {
    }

    public UserData(String username) {
        this.username = username;
        this.favoritos = new ArrayList<>();
        this.assistidos = new ArrayList<>();
        this.desejos = new ArrayList<>();
    }

    // 🔹 Carrega o arquivo user.json (login + favoritos)
    public static UserData load() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_NAME);

        if (!file.exists())
            return null;

        try {
            return mapper.readValue(file, UserData.class);
        } catch (IOException e) {
            System.err.println("Erro ao carregar usuário: " + e.getMessage());
            return null;
        }
    }

    // 🔹 Salva tudo (login + favoritos)
    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_NAME), this);
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    // 🔹 Métodos de favoritos integrados
    public void addFavorito(Serie serie) {
        if (favoritos == null)
            favoritos = new ArrayList<>();
        favoritos.add(serie);
        save();
        System.out.println("✅ Série adicionada aos favoritos!");
    }

    public void removeFavoritoPorIndice(int indice) {
        if (favoritos == null || favoritos.isEmpty()) {
            System.out.println("⚠ Nenhum favorito salvo.");
            return;
        }
    
        if (indice < 0 || indice >= favoritos.size()) {
            System.out.println("⚠ Índice inválido. Digite um número de id mostrado na lista.");
            return;
        }
    
        Serie removida = favoritos.remove(indice);
        save();
        System.out.println("❌ Série '" + removida.getName() + "' removida dos favoritos.");
    }

    public void listarFavoritos() {
        if (favoritos == null || favoritos.isEmpty()) {
            System.out.println("⭐ Nenhum favorito ainda.");
            setFavoritos(favoritos);
            return;
        }
        int numero = 0;
        System.out.println("\n--- Seus Favoritos ---");
        for (Serie s : favoritos) {
            System.out.println("📺 " + s.getName() + " (ID " + numero + ")");
            System.out.println("   Idioma: " + s.getLanguage());
            System.out.println("   Gêneros: " + s.getGenres());
            System.out.println(
                    "   Nota: " + (s.getRating() != null && s.getRating().getAverage() != null
                            ? s.getRating().getAverage()
                            : "Sem nota"));
            System.out.println("   Estado: " + s.getStatus());
            System.out.println("   Estreia: " + s.getPremiered() + " | Fim: " + s.getEnded());
            System.out.println("   Emissora: "
                    + (s.getNetwork() != null ? s.getNetwork().getName() : "Desconhecida"));
            numero++;
        }
    }

    public void addAssitido(int indice) {
        if (assistidos == null)
            assistidos = new ArrayList<>();
        if (indice < 0 || indice >= favoritos.size()) {
            System.out.println("⚠ Índice inválido. Digite um número de id mostrado na lista.");
            return;
        }
        Serie serieParaAdicionar = favoritos.get(indice);
        if (assistidos.contains(serieParaAdicionar)) {
            System.out.println("⚠ Série já está na lista de assistidos.");
            return;
        }
        assistidos.add(serieParaAdicionar);
        save();
        System.out.println("✅ Série adicionada aos assistidos!");
    }

    public void removeAssistidos(int indice) {
        if (assistidos == null || assistidos.isEmpty()) {
            System.out.println("⚠ Nenhum assistido salvo.");
            return;
        }
    
        if (indice < 0 || indice >= assistidos.size()) {
            System.out.println("⚠ Índice inválido. Digite um número de id mostrado na lista.");
            return;
        }
    
        Serie removida = assistidos.remove(indice);
        save();
        System.out.println("❌ Série '" + removida.getName() + "' removida dos assistidos.");
    }
    

    public void listarAssistidos() {
        if (assistidos == null || assistidos.isEmpty()) {
            System.out.println(" Nenhum assistido ainda.");
            return;
        }
        int numero = 0;
        System.out.println("\n--- Seus Assistidos ---");
        for (Serie s : assistidos) {
            System.out.println("📺 " + s.getName() + " (ID " + numero + ")");
            System.out.println("   Idioma: " + s.getLanguage());
            System.out.println("   Gêneros: " + s.getGenres());
            System.out.println(
                    "   Nota: " + (s.getRating() != null && s.getRating().getAverage() != null
                            ? s.getRating().getAverage()
                            : "Sem nota"));
            System.out.println("   Estado: " + s.getStatus());
            System.out.println("   Estreia: " + s.getPremiered() + " | Fim: " + s.getEnded());
            System.out.println("   Emissora: "
                    + (s.getNetwork() != null ? s.getNetwork().getName() : "Desconhecida"));
            numero++;
        }
    }

    public void addDesejoAssistir(int indice) {
        if (desejos == null)
            desejos = new ArrayList<>();
        if (indice < 0 || indice >= favoritos.size()) {
            System.out.println("⚠ Índice inválido. Digite um número de id mostrado na lista.");
            return;
        }
        Serie serieParaAdicionar = favoritos.get(indice);
        if (desejos.contains(serieParaAdicionar)) {
            System.out.println("⚠ Série já está na lista de desejos a assistir.");
            return;
        }
        desejos.add(serieParaAdicionar);
        save();
        System.out.println("✅ Série adicionada aos desejos de assistir!");
    }
    public void removeDesejos(int  indice) {
        if (desejos == null || desejos.isEmpty()) {
            System.out.println("⚠ Nenhuma serie ou filme desejados a assistir  salvo.");
            return;
        }
    
        if (indice < 0 || indice >= desejos.size()) {
            System.out.println("⚠ Índice inválido. Digite um número de id mostrado na lista.");
            return;
        }
    
        Serie removida = desejos.remove(indice);
        save();
        System.out.println("❌ Série '" + removida.getName() + "' removida dos desejos.");
    }
    

    public void listarDesejos() {
        if (desejos == null || desejos.isEmpty()) {
            System.out.println(" Nenhum filme ou serie na sua deseja  ainda.");
            return;
        }
        int numero = 0;
        System.out.println("\n--- Seus Desejos de assistir  ---");
        for (Serie s : desejos) {
            System.out.println("📺 " + s.getName() + " (ID " + numero + ")");
            System.out.println("   Idioma: " + s.getLanguage());
            System.out.println("   Gêneros: " + s.getGenres());
            System.out.println(
                    "   Nota: " + (s.getRating() != null && s.getRating().getAverage() != null
                            ? s.getRating().getAverage()
                            : "Sem nota"));
            System.out.println("   Estado: " + s.getStatus());
            System.out.println("   Estreia: " + s.getPremiered() + " | Fim: " + s.getEnded());
            System.out.println("   Emissora: "
                    + (s.getNetwork() != null ? s.getNetwork().getName() : "Desconhecida"));
            numero++;
        }
    }

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Serie> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Serie> favoritos) {
        this.favoritos = favoritos;
    }

    public List<Serie> getAssistidos() {
        return assistidos;
    }

    public void setAssistido(List<Serie> assistidos) {
        this.assistidos = assistidos;
    }

    public List<Serie> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<Serie> desejos) {
        this.desejos = desejos;
    }

}
