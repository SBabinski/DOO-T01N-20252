package com.tvtracker;

import com.tvtracker.model.Series;
import com.tvtracker.model.UserData;

import java.io.IOException;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Persistence persistence = new Persistence();
    private static final TVMazeClient tvClient = new TVMazeClient();
    private static UserData userData;

    public static void main(String[] args) {
        System.out.println("=== TVTracker - Sistema de Séries ===");
        
        // Tenta carregar o perfil único
        userData = persistence.load(); 

        if (userData == null) {
            // Se não carregou (arquivo não existe ou foi deletado), pede o nome
            System.out.print("Nenhum perfil salvo encontrado. Digite seu nome para criar um novo perfil: ");
            String usernameInput = scanner.nextLine().trim();

            if (usernameInput.isEmpty()) {
                usernameInput = "Convidado"; 
            }
            userData = new UserData(usernameInput);
            System.out.println("-------------------------------------");
            System.out.println("Novo perfil criado: " + userData.username);
        } else {
            // Se carregou, a mensagem de boas-vindas já foi impressa
            System.out.println("-------------------------------------");
        }

        boolean running = true;
        while (running) {
            try {
                showMenu();
                String opt = scanner.nextLine().trim();

                switch (opt) {
                    case "1" -> doSearch();
                    case "2" -> showList(userData.favorites, "Favoritas");
                    case "3" -> showList(userData.watched, "Já assistidas");
                    case "4" -> showList(userData.toWatch, "Deseja assistir");
                    case "5" -> changeUsername();
                    case "6" -> {
                        saveAndExit();
                        running = false;
                    }
                    default -> System.out.println("Opção inválida.");
                }

            } catch (Exception ex) {
                System.err.println("Ocorreu um erro: " + ex.getMessage());
            }
        }
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1) Procurar série por nome (API TVMaze)");
        System.out.println("2) Ver lista de Favoritas");
        System.out.println("3) Ver lista de Já assistidas");
        System.out.println("4) Ver lista Deseja assistir");
        System.out.println("5) Alterar nome de usuário");
        System.out.println("6) Salvar e sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void doSearch() {
        System.out.print("Digite nome para buscar: ");
        String q = scanner.nextLine().trim();

        if (q.isEmpty()) {
            System.out.println("Busca vazia.");
            return;
        }

        try {
            List<Series> results = tvClient.searchShows(q);
            if (results.isEmpty()) {
                System.out.println("Nenhum resultado.");
                return;
            }

            for (int i = 0; i < results.size(); i++)
                System.out.println((i + 1) + ") " + results.get(i));

            System.out.print("Escolha número (ou ENTER p/ voltar): ");
            String s = scanner.nextLine().trim();
            if (s.isEmpty()) return;

            try {
                int idx = Integer.parseInt(s) - 1;
                if (idx < 0 || idx >= results.size()) {
                    System.out.println("Indice invalido");
                    return;
                }
                showSeriesOptions(results.get(idx));
            } catch (NumberFormatException e) {
                System.out.println("Número inválido.");
            }

        } catch (IOException e) {
            System.err.println("Erro ao consultar API: " + e.getMessage());
        }
    }

    private static void showSeriesOptions(Series s) {
        System.out.println("\nDetalhes:");
        printSeriesDetails(s);

        System.out.println("1) Adicionar às Favoritas");
        System.out.println("2) Remover das Favoritas");
        System.out.println("3) Marcar como Já assistida");
        System.out.println("4) Remover de Já assistida");
        System.out.println("5) Adicionar à Deseja assistir");
        System.out.println("6) Remover de Deseja assistir");
        System.out.println("ENTER para voltar");
        System.out.print("Escolha: ");

        String opt = scanner.nextLine().trim();
        switch (opt) {
            case "1" -> addIfNotExists(userData.favorites, s, "Favoritas");
            case "2" -> removeIfExists(userData.favorites, s, "Favoritas");
            case "3" -> {
                addIfNotExists(userData.watched, s, "Já assistidas");
                removeIfExists(userData.toWatch, s, "Deseja assistir");
            }
            case "4" -> removeIfExists(userData.watched, s, "Já assistidas");
            case "5" -> addIfNotExists(userData.toWatch, s, "Deseja assistir");
            case "6" -> removeIfExists(userData.toWatch, s, "Deseja assistir");
        }
    }

    private static void printSeriesDetails(Series s) {
        System.out.println("Nome: " + safe(s.name));
        System.out.println("Idioma: " + safe(s.language));
        System.out.println("Gêneros: " + (s.genres == null ? "N/A" : String.join(", ", s.genres)));
        System.out.println("Nota geral: " + (s.rating == null ? "N/A" : s.rating));
        System.out.println("Estado: " + safe(s.status));
        System.out.println("Estreia: " + safe(s.premiered));
        System.out.println("Término: " + safe(s.ended));
        System.out.println("Emissora: " + safe(s.network));
    }

    private static String safe(String v) {
        return v == null ? "N/A" : v;
    }

    private static void addIfNotExists(List<Series> list, Series s, String listName) {
        if (list.stream().anyMatch(x -> x.id == s.id)) {
            System.out.println("Já existe na lista " + listName);
            return;
        }

        list.add(s);
        System.out.println("Adicionado à lista " + listName);
    }

    private static void removeIfExists(List<Series> list, Series s, String listName) {
        if (list.stream().noneMatch(x -> x.id == s.id)) {
            System.out.println("Não está na lista " + listName);
            return;
        }

        list.removeIf(x -> x.id == s.id);
        System.out.println("Removido da lista " + listName);
    }

    private static void showList(List<Series> list, String title) {
        if (list.isEmpty()) {
            System.out.println(title + " vazia.");
            return;
        }

        System.out.println("\n--- " + title + " ---");
        System.out.println("Ordenar por: 1) Nome 2) Nota 3) Estado 4) Estreia (ENTER = sem ordenação)");
        System.out.print("Escolha: ");

        String opt = scanner.nextLine().trim();
        List<Series> copy = new ArrayList<>(list);

        switch (opt) {
            case "1" -> copy.sort(Comparator.comparing(a -> a.name == null ? "" : a.name.toLowerCase()));
            case "2" -> copy.sort(Comparator.comparing((Series a) -> a.rating == null ? -1.0 : a.rating).reversed());
            case "3" -> copy.sort(Comparator.comparing(a -> a.status == null ? "" : a.status));
            case "4" -> copy.sort(Comparator.comparing(a -> a.premiered == null ? "" : a.premiered));
        }

        for (int i = 0; i < copy.size(); i++)
            System.out.println((i + 1) + ") " + copy.get(i));

        System.out.println("\nDigite número p/ detalhes ou ENTER p/ voltar:");
        String s = scanner.nextLine().trim();
        if (s.isEmpty()) return;

        try {
            int idx = Integer.parseInt(s) - 1;
            if (idx < 0 || idx >= copy.size()) {
                System.out.println("Índice inválido.");
                return;
            }
            showSeriesOptions(copy.get(idx));
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    private static void changeUsername() {
        System.out.print("Novo nome: ");
        String n = scanner.nextLine().trim();

        if (!n.isBlank()) {
            userData.username = n;
            System.out.println("Nome alterado para: " + n);
            // Aviso removido: Agora sempre salva no mesmo arquivo fixo
        }
    }

    private static void saveAndExit() {
        try {
            persistence.save(userData);
            System.out.println("Dados salvos! Até logo!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
}