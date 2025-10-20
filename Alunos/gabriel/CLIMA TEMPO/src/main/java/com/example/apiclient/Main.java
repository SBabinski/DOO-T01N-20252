package com.example.apiclient;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Api api = new Api();

        System.out.println("Bem vindo ao sistema de clima");
        while (true) {

            System.out.println("Digite o nome da cidade: (ou 'sair' para sair)");
            String cidade = scan.nextLine().trim();

            if (cidade.equalsIgnoreCase("sair")) {
                System.out.println("Saindo do sistema...");
                break;
            }

            try {
                RepoInfo repoInfo = api.getRepoInfo(cidade);
                System.out.println(repoInfo);
            } catch (Exception e) {
                System.err.println("Falha ao consumir a API: " + e.getMessage());
            }
        }

    }
}
