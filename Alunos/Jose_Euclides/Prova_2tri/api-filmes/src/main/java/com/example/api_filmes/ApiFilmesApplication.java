package com.example.api_filmes;

import com.example.api_filmes.dto.ShowDTO;
import com.example.api_filmes.services.ShowService;
import com.example.api_filmes.services.TvMazeClient;
import com.example.api_filmes.services.UserProfileService;
import com.example.api_filmes.view.View;

/**
 * Aplicação principal
 */
public class ApiFilmesApplication {

    public static void main(String[] args) {
        System.out.println("====  Iniciando Minhas Séries de TV... ====\n");
        
        try {
            TvMazeClient tvMazeClient = new TvMazeClient();
            ShowDTO dataStore = new ShowDTO();
            ShowService showService = new ShowService(tvMazeClient, dataStore);
            UserProfileService userService = new UserProfileService(showService);
            
            View view = new View(showService, userService);
            view.start();
            
        } catch (Exception e) {
            System.err.println("Erro fatal na aplicação: " + e.getMessage());
            e.printStackTrace();
            System.err.println("\nDica: Verifique se você tem conexão com a internet.");
            System.exit(1);
        }
        
        System.out.println("\nSistema encerrado com sucesso!");
    }
}
