package main;

import modelos.Usuario;
import service.Requisicao;

import java.util.Scanner;

import static main.MapaMenus.*;

public class Main {

    //Crio um novo objeto de apelido chamando o metodo de ler apelido;
    static Usuario usuario = Usuario.ler();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        //Chamo o objeto criado acima para conferir se o apelido esta null ainda, serve para a primeira ver que
        // rodar o programa, ele reconheça se já foi informado um nome/apelido ou não;
        if (usuario == null) {

            System.out.println("⌨️ Digite seu apelido: ");
            String nomeApelido = scan.nextLine();

            //Chama o objeto de apelido e seta o nome informado;
            usuario = new Usuario(nomeApelido);
            //Chamamos o metodo salver para persistir o apelido em JSON;
            usuario.salvar();

        } else {

            //Caso apelido não seja null, eu dou bem-vindo ao usuario;
            System.out.println("👋 Bem-vindo " + usuario.getApelido());

        }

        while (true) {
            System.out.println(" " +
                    "\n⭐ »Menu Principal« ⭐" +
                    "\n1️⃣ Pesquisar Série." +
                    "\n2️⃣ Visualizar listas." +
                    "\n3️⃣ Deletar série de lista." +
                    "\n4️⃣ Limpar terminal." +
                    "\n0️⃣ Encerrar sistema.");

            if(!scan.hasNextInt()){
                scan.nextLine();
                System.out.println("😡 Informe alguma opção valida no MENU para prosseguir!");
                continue;
            }

            int escolhaMenuPrincipal = scan.nextInt();
            scan.nextLine();

            switch (escolhaMenuPrincipal) {
                case 0 -> System.exit(0);
                case 1 -> menuPesquisaSerie(usuario);
                case 2 -> encaminhaLeituras(usuario);
                case 3 -> encaminhaDeletes(usuario);
                case 4 -> LimpaTela.limpandoTela();
                default -> System.out.println("❌ Opção invalida.");
            }
        }
    }
}
