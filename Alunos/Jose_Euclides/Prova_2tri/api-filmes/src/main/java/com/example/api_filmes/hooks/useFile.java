package com.example.api_filmes.hooks;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class useFile {
    public static String getContent(String filePath) {
        try {
            if (!Files.exists(Paths.get(filePath))) {
                System.out.println("Arquivo não encontrado: " + filePath);
                return "";
            }
            
            String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
            return content;
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo " + filePath + ": " + e.getMessage());
            return "";
        }
    }

    /**
     * Salva conteúdo em um arquivo
     */
    public static boolean saveContent(String filePath, String content) {
        try {
            // Cria diretórios se não existirem
            java.nio.file.Path path = Paths.get(filePath);
            java.nio.file.Path parent = path.getParent();
            if (parent != null && !Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            
            // Escreve o conteúdo no arquivo
            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
            return true;
            
        } catch (Exception e) {
            System.err.println("Erro ao salvar arquivo " + filePath + ": " + e.getMessage());
            return false;
        }
    }
}