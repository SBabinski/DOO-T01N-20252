package com.example.api_filmes.view;

import java.util.List;
import java.util.Scanner;

import com.example.api_filmes.model.Show;
import com.example.api_filmes.services.ShowService;
import com.example.api_filmes.services.TvMazeClient.TvMazeApiException;
import com.example.api_filmes.services.UserProfileService;
import com.example.api_filmes.services.UserProfileService.SortCriteria;

/**
 * Interface do sistema
 */
public class View {

    private final Scanner scanner;
    private final ShowService showService;
    private final UserProfileService userService;
    private boolean running;

    public View(ShowService showService, UserProfileService userService) {
        this.scanner = new Scanner(System.in);
        this.showService = showService;
        this.userService = userService;
        this.running = true;
    }

    /**
     * Inicia a interface do usuário
     */
    public void start() {
        showWelcomeMessage();
        setupUser();

        while (running) {
            try {
                showMainMenu();
                handleMainMenuChoice();
            } catch (Exception e) {
                System.err.println("Erro inesperado: " + e.getMessage());
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        }

        showGoodbyeMessage();
    }

    /**
     * Exibe mensagem de boas-vindas
     */
    private void showWelcomeMessage() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("====  SISTEMA DE ACOMPANHAMENTO DE SÉRIES ====");
        System.out.println("=".repeat(60));
        System.out.println("Bem-vindo ao seu sistema pessoal de séries!");
        System.out.println("Conectado à API do TVMaze para buscar informações.");
        System.out.println("=".repeat(60));
    }

    /**
     * Configura informações do usuário
     */
    private void setupUser() {
        String currentName = userService.getCurrentUser().getName();
        System.out.println("\n=== Configuração do Usuário ===");
        System.out.println("Nome atual: " + currentName);

        System.out.print("Deseja alterar o nome? (s/n): ");
        String response = scanner.nextLine().trim();

        if (response.equalsIgnoreCase("s") || response.equalsIgnoreCase("sim")) {
            System.out.print("Digite seu nome ou apelido: ");
            String newName = scanner.nextLine().trim();

            if (!newName.isEmpty()) {
                userService.setUserName(newName);
                System.out.println("Nome atualizado para: " + newName);
            }
        }
    }

    /**
     * Exibe o menu principal
     */
    private void showMainMenu() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("─".repeat(50));
        System.out.println("1. Buscar séries");
        System.out.println("2. Ver meus favoritos");
        System.out.println("3. Ver séries assistidas");
        System.out.println("4. Ver lista para assistir");
        System.out.println("5. Ver perfil e estatísticas");
        System.out.println("0. Sair");
        System.out.println("─".repeat(50));
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Processa a escolha do menu principal
     */
    private void handleMainMenuChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1:
                    handleSearchShows();
                    break;
                case 2:
                    handleShowFavorites();
                    break;
                case 3:
                    handleShowWatched();
                    break;
                case 4:
                    handleShowWatchlist();
                    break;
                case 5:
                    handleShowProfile();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um número válido.");
        }
    }

    /**
     * Manipula a busca de séries
     */
    private void handleSearchShows() {
        System.out.println("\n=== BUSCAR SÉRIES ===");
        System.out.println("─".repeat(30));
        System.out.print("Digite o nome da série: ");
        String query = scanner.nextLine().trim();

        if (query.isEmpty()) {
            System.out.println("Nome não pode estar vazio.");
            return;
        }

        try {
            System.out.println("Buscando séries...");
            List<Show> results = showService.searchShows(query);
            if (results.isEmpty()) {
                System.out.println("Nenhuma série encontrada com o nome: " + query);
                return;
            }
            System.out.println("\nResultados encontrados: " + results.size());
            displayShowsList(results, true);

        } catch (TvMazeApiException e) {
            System.err.println("Erro ao buscar séries: " + e.getMessage());
            System.out.println("Verifique sua conexão com a internet e tente novamente.");
        }
    }

    /**
     * Manipula exibição dos favoritos
     */
    private void handleShowFavorites() {
        System.out.println("\nMEUS FAVORITOS");
        System.out.println("─".repeat(30));

        List<Show> favorites = userService.getFavoriteShows();

        if (favorites.isEmpty()) {
            System.out.println("Sua lista de favoritos está vazia.");
            System.out.println("Use a busca para encontrar séries e adicioná-las aos favoritos!");
            return;
        }

        SortCriteria criteria = chooseSortCriteria();
        if (criteria != null) {
            favorites = userService.getFavoritesSorted(criteria);
        }

        System.out.println("\nSuas séries favoritas (" + favorites.size() + "):");
        displayShowsList(favorites, true);
    }

    /**
     * Manipula exibição das séries assistidas
     */
    private void handleShowWatched() {
        System.out.println("\nSÉRIES ASSISTIDAS");
        System.out.println("─".repeat(30));

        List<Show> watched = userService.getWatchedShows();

        if (watched.isEmpty()) {
            System.out.println("Sua lista de assistidas está vazia.");
            return;
        }

        SortCriteria criteria = chooseSortCriteria();
        if (criteria != null) {
            watched = userService.getWatchedSorted(criteria);
        }

        System.out.println("\nSéries que você assistiu (" + watched.size() + "):");
        displayShowsList(watched, true);
    }

    /**
     * Manipula exibição da watchlist
     */
    private void handleShowWatchlist() {
        System.out.println("\n=== LISTA PARA ASSISTIR ===");
        System.out.println("─".repeat(30));

        List<Show> watchlist = userService.getWatchlistShows();

        if (watchlist.isEmpty()) {
            System.out.println("Sua lista para assistir está vazia.");
            return;
        }

        SortCriteria criteria = chooseSortCriteria();
        if (criteria != null) {
            watchlist = userService.getWatchlistSorted(criteria);
        }

        System.out.println("\nSéries para assistir (" + watchlist.size() + "):");
        displayShowsList(watchlist, true);
    }

    /**
     * Manipula exibição do perfil
     */
    private void handleShowProfile() {
        System.out.println("\nMEU PERFIL");
        System.out.println("─".repeat(30));
        System.out.println(userService.getUserStats());
        System.out.println("\n" + showService.getDataStats());
        System.out.println("\nPressione Enter para voltar ao menu...");
        scanner.nextLine();
    }

    /**
     * Permite ao usuário escolher critério de ordenação
     */
    private SortCriteria chooseSortCriteria() {
        System.out.println("\nComo deseja ordenar a lista?");
        System.out.println("1. " + SortCriteria.NAME.getDescription());
        System.out.println("2. " + SortCriteria.RATING.getDescription());
        System.out.println("3. " + SortCriteria.STATUS.getDescription());
        System.out.println("4. " + SortCriteria.PREMIERE_DATE.getDescription());
        System.out.println("0. Manter ordem atual");
        System.out.print("Escolha: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1:
                    return SortCriteria.NAME;
                case 2:
                    return SortCriteria.RATING;
                case 3:
                    return SortCriteria.STATUS;
                case 4:
                    return SortCriteria.PREMIERE_DATE;
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Exibe uma lista de séries
     */
    private void displayShowsList(List<Show> shows, boolean allowActions) {
        for (int i = 0; i < shows.size(); i++) {
            Show show = shows.get(i);
            System.out.println("\n" + (i + 1) + ". " + formatShowSummary(show));

            if (allowActions) {
                System.out.println("" + userService.getShowStatus(show.getId()));
            }
        }

        if (allowActions && !shows.isEmpty()) {
            handleShowActions(shows);
        } else {
            System.out.println("\nPressione Enter para voltar ao menu...");
            scanner.nextLine();
        }
    }

    /**
     * Formata resumo de uma série para listagem
     */
    private String formatShowSummary(Show show) {
        StringBuilder summary = new StringBuilder();
        summary.append("Nome: ").append(show.getName()).append('\n');

        if (show.getRatingScore() != null) {
            summary.append("Avaliação: ").append(String.format("%.1f", show.getRatingScore())).append('\n');
        } else {
            summary.append("Avaliação: N/A").append('\n');
        }

        summary.append("Status: ").append(show.getStatus()).append('\n');

        if (show.getPremiered() != null) {
            summary.append("Lançamento: ").append(show.getPremiered().getYear());
        } else {
            summary.append("Lançamento: N/A");
        }

        return summary.toString();
    }

    /**
     * Manipula ações sobre séries (adicionar/remover das listas)
     */
    private void handleShowActions(List<Show> shows) {
        boolean choiceValid = false;

        while (!choiceValid) {
            System.out.println("\n=== AÇÕES ===");
            System.out.println("Digite o número da série para ver detalhes e opções (0 para voltar): ");
            System.out.print("Escolha: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 0) {
                    return;
                }

                if (choice < 1 || choice > shows.size()) {
                    System.out.println("Número inválido!");
                    choiceValid = false;
                } else {
                    Show selectedShow = shows.get(choice - 1);
                    showShowDetails(selectedShow);
                    choiceValid = true;
                }

            } catch (NumberFormatException e) {
                choiceValid = false;
                System.out.println("Por favor, digite um número válido.");
            }
        }

    }

    /**
     * Exibe detalhes de uma série e opções de gerenciamento
     */
    private void showShowDetails(Show show) {
        System.out.println("\n" + showService.formatShowInfo(show));
        System.out.println("Status atual: " + userService.getShowStatus(show.getId()));
        System.out.println("\n=== GERENCIAR SÉRIE ===");
        System.out.println("1. " + (userService.isFavorite(show.getId())
                ? "Remover dos favoritos" : "Adicionar aos favoritos"));
        System.out.println("2. " + (userService.isWatched(show.getId())
                ? "Remover das assistidas" : "Marcar como assistida"));
        System.out.println("3. " + (userService.isInWatchlist(show.getId())
                ? "Remover da lista para assistir" : "Adicionar à lista para assistir"));
        System.out.println("0. Voltar");
        System.out.print("Escolha: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1:
                    if (userService.isFavorite(show.getId())) {
                        userService.removeFromFavorites(show.getId());
                    } else {
                        userService.addToFavorites(show.getId());
                    }
                    break;
                case 2:
                    if (userService.isWatched(show.getId())) {
                        userService.removeFromWatched(show.getId());
                    } else {
                        userService.addToWatched(show.getId());
                    }
                    break;
                case 3:
                    if (userService.isInWatchlist(show.getId())) {
                        userService.removeFromWatchlist(show.getId());
                    } else {
                        userService.addToWatchlist(show.getId());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }

            // Pausa para mostrar resultado da ação
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();

        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um número válido.");
        }
    }

    /**
     * Exibe mensagem de despedida
     */
    private void showGoodbyeMessage() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Obrigado por usar o Sistema de Séries!");
        System.out.println("Seus dados foram salvos automaticamente.");
        System.out.println("Até a próxima!");
        System.out.println("=".repeat(50));
        scanner.close();
    }
}
