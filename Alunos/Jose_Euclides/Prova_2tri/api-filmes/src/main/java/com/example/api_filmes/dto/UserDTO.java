package com.example.api_filmes.dto;

import java.util.List;

import com.example.api_filmes.hooks.useFile;
import com.example.api_filmes.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDTO {
    public static String pathDbUser = "db\\users.json";

    public UserDTO() {}

    public static List<User> getUsers() {
        ObjectMapper objectMapper = new ObjectMapper();
        String usersJSON = useFile.getContent(pathDbUser);

        if (usersJSON == null || usersJSON.trim().isEmpty()) {
            System.out.println("Arquivo users.json vazio ou não encontrado. Criando lista vazia.");
            return new java.util.ArrayList<>();
        }

        try {
            List<User> usersList = objectMapper.readValue(usersJSON, new TypeReference<List<User>>() {});
            return usersList;
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao processar JSON: " + e.getMessage());
            System.err.println("Conteúdo do arquivo: " + usersJSON.substring(0, Math.min(100, usersJSON.length())));
            System.out.println("Retornando lista vazia de usuários.");
            return new java.util.ArrayList<>();
        }
    }

    public static User saveUser(User user) {
        if (user == null) {
            System.err.println("Usuário não pode ser nulo.");
            return null;
        }

        try {
            List<User> users = getUsers();
            
            boolean userExists = false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId().equals(user.getId())) {
                    users.set(i, user);
                    userExists = true;
                    break;
                }
            }
            
            if (!userExists) {
                users.add(user);
                System.out.println("Novo usuário adicionado: " + user.getName());
            }
            
            saveAllUsers(users);
            return user;
            
        } catch (Exception e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
            return null;
        }
    }

    /**
     * Salva toda a lista de usuários no arquivo JSON
     */
    public static boolean saveAllUsers(List<User> users) {
        if (users == null) {
            System.err.println("Lista de usuários não pode ser nula.");
            return false;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            
            String jsonContent = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(users);

            useFile.saveContent(pathDbUser, jsonContent);
            return true;
            
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao converter usuários para JSON: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Erro inesperado ao salvar usuários: " + e.getMessage());
            return false;
        }
    }
}
