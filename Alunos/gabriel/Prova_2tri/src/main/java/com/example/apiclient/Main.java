package com.example.apiclient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.apiclient.Utils.*;

public class Main {

    

    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Scanner scanner = new Scanner(System.in);

        // 🔹 Carregar ou criar o usuário
        UserData user = UserData.load();
        if (user == null) {
            System.out.println("Bem-vindo pela primeira vez!");
            System.out.print("Digite seu nome de usuário: ");
            user = new UserData(scanner.nextLine());
            user.save();
        } else {
            System.out.println("Bem-vindo de volta, " + user.getUsername() + "!");
        }

        List<Serie> ultimaBusca = null; // 👉 Guarda a última lista de séries buscadas

        // 🔁 Menu principal
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Buscar série");
            System.out.println("2 - Adicionar aos favoritos (da última busca)");
            System.out.println("3 - Remover dos favoritos");
            System.out.println("4 - Listar favoritos");
            System.out.println("5 - adicionar serie assitidos  ");
            System.out.println("6 - remover serie assitidos  ");
            System.out.println("7 - listar serie assistidas");
            System.out.println("8 - adiciona a lista de desejos de assisir ");
            System.out.println("9 - remover series ou filmes desejados a assitir ");
            System.out.println("10 - listar series desejadas a assistir ");
            System.out.println("11 - ordenar a lista");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> {
                    System.out.print("Digite o nome da série: ");
                    String termo = scanner.nextLine();
                    try {
                        List<Serie> series = apiClient.buscarSeries(termo);
                        ultimaBusca = series; // ✅ Armazena a última busca

                        if (series.isEmpty()) {
                            System.out.println("Nenhuma série encontrada.");
                        } else {
                            System.out.println("\n📺 Resultados encontrados:");
                            for (int i = 0; i < series.size(); i++) {
                                Serie s = series.get(i);
                                System.out.println("\n[" + i + "] " + s.getName());
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

                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Erro: " + e.getMessage());
                    }
                }

                case "2" -> {
                    if (ultimaBusca == null || ultimaBusca.isEmpty()) {
                        System.out.println(" Nenhuma série buscada recentemente. Use a opção 1 primeiro.");
                        break;
                    }

                    System.out.print(
                            "Digite o número da série que deseja favoritar (aparece no canto superior esquerdo): ");
                    try {
                        int indice = Integer.parseInt(scanner.nextLine());
                        if (indice >= 0 && indice < ultimaBusca.size()) {
                            Serie escolhida = ultimaBusca.get(indice);
                            user.addFavorito(escolhida);
                            System.out.println(" Série '" + escolhida.getName() + "' adicionada aos favoritos!");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Digite apenas o número.");
                    }
                }

                case "3" -> {

                    user.listarFavoritos();

                    System.out.print("Digite o id (índice) da série para remover: ");
                    try {
                        int numero = Integer.parseInt(scanner.nextLine());
                        user.removeFavoritoPorIndice(numero);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Digite apenas um número de id.");
                    }
                }

                case "4" -> user.listarFavoritos();

                case "5" -> {
                    user.listarFavoritos();

                    // Verifica se há séries nos favoritos antes de continuar
                    if (user.getFavoritos() == null || user.getFavoritos().isEmpty()) {
                        System.out.println("⚠ Nenhuma série disponível para marcar como assistida.");

                        break; // Volta ao menu
                    }

                    System.out.print("Digite o número da série que deseja marcar como assistida: ");
                    try {
                        int indice = Integer.parseInt(scanner.nextLine());
                        user.addAssitido(indice); // ✅ Chama seu método corretamente
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida. Digite apenas o número.");
                    }

                    break;
                }

                case "6" -> {

                    user.listarAssistidos();

                    System.out.print("Digite o id da série para remover: ");
                    try {
                        int indice = Integer.parseInt(scanner.nextLine());
                        user.removeAssistidos(indice);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Digite apenas um número de id.");
                    }
                }

                case "7" -> user.listarAssistidos();

                case "8" -> {

                    user.listarFavoritos();
                    System.out.println();

                    System.out.print("Digite o número da série que deseja marcar na lista de desejos de assistir: ");
                    try {
                        int indice = Integer.parseInt(scanner.nextLine());
                        user.addDesejoAssistir(indice);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Digite apenas o número.");
                    }
                }

                case "9" -> {

                    user.listarDesejos();

                    System.out.print("Digite o id da série para remover da lista de desejos de series: ");
                    try {
                        int indice = Integer.parseInt(scanner.nextLine());
                        user.removeDesejos(indice);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Digite apenas um número de id.");
                    }
                }

                case "10" -> user.listarDesejos();

                case "11" -> {
                    

                    menuOrdenacao: while (true) {
                        System.out.println("1 - ordenar por ordem alfabetica ");
                        System.out.println("2 - ordenar por nota avaliada");
                        System.out.println("3 - ordenar por estado da serie");
                        System.out.println("4 - ordenar por data de estreia");
                        System.out.println("5 - para voltar ao menu");

                        System.out.print("Escolha uma opção: ");
                        String op = scanner.nextLine();


                        switch (op) {
                          
                        case "1" : {
                                // Ordena lista de assistidos por nome (A → Z)
                                Utils.ordenaPorNome(user.getAssistidos(), "assistidas");
                                Utils.ordenaPorNome(user.getFavoritos(), "favoritas");
                                Utils.ordenaPorNome(user.getDesejos(), "series adicionada a desejos assistir");

                            }

                            case "2" : {
                                Utils.ordenaPorNota(user.getAssistidos(), "assistidas");
                                Utils.ordenaPorNota(user.getFavoritos(), "favoritas");
                                Utils.ordenaPorNota(user.getDesejos(), "series adicionada a desejos assistir");



                            }

                        case "3" : {

                            Utils.ordenaPorEstado(user.getAssistidos(), "Assistidas");
                            Utils.ordenaPorEstado(user.getFavoritos(), "favoritas");
                            Utils.ordenaPorEstado(user.getDesejos(), "series adicionada a desejos assistir");
                            

                        }

                        case "4": {
                            Utils.ordenaPorEstreia(user.getAssistidos(), "Assistidas" );
                            Utils.ordenaPorEstreia(user.getFavoritos(), "favoritas");
                            Utils.ordenaPorEstreia(user.getDesejos(), "series adicionada a desejos assistir");
                        }

                        case "5": {
                            break menuOrdenacao; // Volta para o menu principal
                        }

                        }
                        
                    }

                }

                case "0" -> {
                    System.out.println("Saindo... até logo, " + user.getUsername() + "!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
}}
