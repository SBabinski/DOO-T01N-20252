package com.tvtracker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tvtracker.model.UserData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Persistence {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_NAME = "user_profile.json"; // <-- ARQUIVO ÚNICO

    public void save(UserData userData) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(userData, writer);
        }
    }

    // Tenta carregar um usuário. Retorna null se o arquivo não existe.
    public UserData load() {
        File file = new File(FILE_NAME);

        if (file.exists()) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
                UserData data = gson.fromJson(content, UserData.class);
                System.out.println("Bem-vindo de volta, " + data.username + "!");
                return data;
            } catch (IOException e) {
                System.err.println("Erro ao ler arquivo do usuário. Criando novo perfil.");
            }
        }
        
        // Retorna null se o arquivo não existe ou se houve erro na leitura
        return null;
    }
}