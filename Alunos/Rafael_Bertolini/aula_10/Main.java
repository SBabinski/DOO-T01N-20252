package Sistema;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Requisicao requisicao = new Requisicao();

        System.out.println("Bem vindo ao sistema!");
        while (true) {

            System.out.println("Informe a cidade que deseja receber informações climaticas ou digite 'fechar' para fechar o sistema.");
            String cidade = scan.nextLine().trim();

            if (cidade.equalsIgnoreCase("Fechar")) {
                System.out.println("Programa encerrado!");
                break;
            }

            try {
                MoldeClima.Dia clima = requisicao.getRequisicao(cidade);
                System.out.println(clima);
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao buscar o clima da cidade.");
            }
        }
        scan.close();
    }
}