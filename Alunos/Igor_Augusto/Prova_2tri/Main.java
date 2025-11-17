import java.util.Scanner;

public class Main {
    private static UserManager userManager;
    private static TVMazeService tvMazeService;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        try {
            initializeSystem();
            showMainMenu();
        } catch (Exception e) {
            System.out.println("Erro crítico: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    
    private static void initializeSystem() {
        userManager = new UserManager();
        tvMazeService = new TVMazeService();
        scanner = new Scanner(System.in);
        
        System.out.println("=== Sistema de Acompanhamento de Séries ===");
        setupUser();
    }
    
    private static void setupUser() {
        System.out.print("Digite seu nome ou apelido: ");
        String userName = scanner.nextLine().trim();
        userManager.setCurrentUser(userName);
        System.out.println("Olá, " + userName + "!");
    }
    
    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Procurar séries");
            System.out.println("2. Ver lista de favoritos");
            System.out.println("3. Ver séries já assistidas");
            System.out.println("4. Ver séries para assistir");
            System.out.println("5. Ordenar listas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1 -> searchSeries();
                    case 2 -> showFavorites();
                    case 3 -> showWatched();
                    case 4 -> showWatchlist();
                    case 5 -> showSortMenu();
                    case 6 -> {
                        userManager.saveData();
                        System.out.println("Até mais!");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    private static void searchSeries() {
        System.out.print("\nDigite o nome da série: ");
        String searchTerm = scanner.nextLine();
        
        try {
            var series = tvMazeService.searchSeries(searchTerm);
            if (series.isEmpty()) {
                System.out.println("Nenhuma série encontrada.");
                return;
            }
            
            System.out.println("\n=== RESULTADOS DA BUSCA ===");
            for (int i = 0; i < series.size(); i++) {
                System.out.println((i + 1) + ". " + series.get(i).getName());
            }
            
            System.out.print("\nDigite o número da série para ver detalhes (0 para voltar): ");
            int choice = Integer.parseInt(scanner.nextLine());
            
            if (choice > 0 && choice <= series.size()) {
                showSeriesDetails(series.get(choice - 1));
            }
            
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
    }
    
    private static void showSeriesDetails(TVSeries series) {
        System.out.println("\n=== DETALHES DA SÉRIE ===");
        series.displayDetails();
        
        System.out.println("\n=== AÇÕES ===");
        System.out.println("1. Adicionar aos favoritos");
        System.out.println("2. Adicionar às já assistidas");
        System.out.println("3. Adicionar à lista para assistir");
        System.out.println("4. Remover dos favoritos");
        System.out.println("5. Remover das já assistidas");
        System.out.println("6. Remover da lista para assistir");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1 -> userManager.addToFavorites(series);
                case 2 -> userManager.addToWatched(series);
                case 3 -> userManager.addToWatchlist(series);
                case 4 -> userManager.removeFromFavorites(series.getId());
                case 5 -> userManager.removeFromWatched(series.getId());
                case 6 -> userManager.removeFromWatchlist(series.getId());
            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void showFavorites() {
        System.out.println("\n=== FAVORITOS ===");
        userManager.displayFavorites();
    }
    
    private static void showWatched() {
        System.out.println("\n=== JÁ ASSISTIDAS ===");
        userManager.displayWatched();
    }
    
    private static void showWatchlist() {
        System.out.println("\n=== PARA ASSISTIR ===");
        userManager.displayWatchlist();
    }
    
    private static void showSortMenu() {
        System.out.println("\n=== ORDENAR LISTAS ===");
        System.out.println("1. Ordenar favoritos");
        System.out.println("2. Ordenar já assistidas");
        System.out.println("3. Ordenar para assistir");
        System.out.print("Escolha uma lista: ");
        
        try {
            int listChoice = Integer.parseInt(scanner.nextLine());
            
            System.out.println("\n=== CRITÉRIOS DE ORDENAÇÃO ===");
            System.out.println("1. Ordem alfabética");
            System.out.println("2. Nota geral");
            System.out.println("3. Estado da série");
            System.out.println("4. Data de estreia");
            System.out.print("Escolha um critério: ");
            
            int sortChoice = Integer.parseInt(scanner.nextLine());
            
            SortCriteria criteria = switch (sortChoice) {
                case 1 -> SortCriteria.NAME;
                case 2 -> SortCriteria.RATING;
                case 3 -> SortCriteria.STATUS;
                case 4 -> SortCriteria.PREMIERED;
                default -> throw new IllegalArgumentException("Critério inválido");
            };
            
            switch (listChoice) {
                case 1 -> userManager.sortFavorites(criteria);
                case 2 -> userManager.sortWatched(criteria);
                case 3 -> userManager.sortWatchlist(criteria);
                default -> System.out.println("Lista inválida!");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um número válido.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
