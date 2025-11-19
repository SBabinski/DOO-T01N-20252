package main;

import modelos.Serie;
import modelos.Usuario;
import service.*;

import java.util.List;
import java.util.Scanner;

public class MapaMenus {

    static Scanner scan = new Scanner(System.in);


    static void menuPesquisaSerie(Usuario usuario) throws Exception {

        Requisicao req = new Requisicao();
        System.out.println("\n🧐 Qual o nome da serie que você deseja pesquisar?");
        String nomeSerie = scan.nextLine();

        try {
            req.requisicaoAPI(nomeSerie);
            System.out.println("\n 1️⃣ Salvar série. || 2️⃣ Pesquisar outra série. || 0️⃣ Voltar ao menu principal.");

            if (!scan.hasNextInt()) {
                System.out.println("❌ Não existe opções com o caractere informado.");
                scan.nextLine();
                menuPesquisaSerie(usuario);
            }

            int escolhaOpcao = scan.nextInt();
            scan.nextLine();
            switch (escolhaOpcao) {
                case 0:
                    System.out.println("↩️ Retornando ao menu principal.");
                            return;
                case 1:
                    menuSelecaoSeries(usuario);
                    break;
                case 2:
                    menuPesquisaSerie(usuario);
                default:
                    System.out.println("❌ Erro na seleção! Redirecionando para ao menu principal. . .");
            }
        } catch (Exception ex) {
            System.out.println("❌ Erro ao pesquisar a serie.");
        }
    }//fim menu de pesquisa de serie

    public static void menuSelecaoSeries(Usuario usuario) {
        //Instancio uma nova lista que recebe a lista que guardou todas as series da pesquisa no menu de requesicao;
        List<Serie> listaResults = Requisicao.getResultados();

        if (listaResults.isEmpty()) {
            System.out.println("❌ Nenhuma série encontrada.");
            return;
        }

        int id = 1;
        System.out.println("🔍 Selecione a serie desejada: ");
        for (Serie series : listaResults) {
            System.out.println(
                    "\n—————————————————————————————————————————————————————————————————————————————————————————————————————————————" +
                    "\n\n[ 🆔 " + id +" ]" +
                    " 🎬 Nome da serie: " + series.getName() +
                    "\n          📺 Emissora: " + (series.getNetwork() != null ? series.getNetwork().getName() : "N/A") +
                    "\n          🎭 Genêros: " + String.join(" ,", series.getGenres()));

            id++;
        }

        while (true) {
            try {
                System.out.println("\n❓ Qual serie deseja selecionar?");
                if (!scan.hasNextInt()) {
                    System.out.println("\n❌ Entrada invalida, informe algum dos números do menu.");
                    scan.nextLine();
                    continue;
                }
                int escolha = scan.nextInt();
                scan.nextLine();

                if (escolha < 0 || escolha > listaResults.size()) {
                    System.out.println("\n🤔 Informe alguma opção que foi dada no menu, a opção que você passou não existe.");
                    continue;
                }

                System.out.println("\n🌟 A série " + listaResults.get(escolha - 1).getName() + " foi selecionada\n" +
                        "\n❓ Qual lista deseja salvar? \n" +
                        "\n 1️⃣ Favoritos || 2️⃣ Já assistidos || 3️⃣ Quero assistir ||" +
                        " 4️⃣ Voltar para seleção de série || 5️⃣ Voltar a seleção de séries || 0️⃣ Voltar ao menu principal\n");
                int escolhaLista = scan.nextInt();
                scan.nextLine();

                switch (escolhaLista) {
                    case 0 -> {
                        return;
                    }
                    case 1 -> ListaFavoritos.adicionandoSerieParaLista(escolha - 1, usuario);
                    case 2 -> ListaJaAssistidos.adicionandoSerieParaListaJaAssistidos(escolha - 1, usuario);
                    case 3 -> ListaDesejoAssistir.adicionandoSerieParaListaDesejoAssistir(escolha - 1, usuario);
                    case 4 -> menuSelecaoSeries(usuario);
                    case 5 -> {continue;}
                    default -> {
                        System.out.println("🤔 Opção inexistente.");
                        continue;
                    }
                }

                break;
            } catch (Exception e) {
                System.out.println("❌ Erro");
                scan.nextLine();
            }
        }
    }//fim do menu Seleção Series

    public static void menuDeletaSerie(Usuario usuario, List<Serie> lista){

        if(lista.isEmpty()){
            System.out.println("📪 Sua lista selecionada está vazia por enquanto! Redirecionando ao menu de deletes . . .");
            encaminhaDeletes(usuario);
        }

        int id = 1;
        System.out.println("📄 Escolha a série que deseja deletar da lista: ");

        for (Serie series : lista){
            System.out.println(
                    "—————————————————————————————————————————————————————————————————————————————————————————————————————————————" +
                            "\n\n[ 🆔 " + id +" ]" +
                            " 🎬 Nome da serie: " + series.getName() +
                            "\n          📺 Emissora: " + (series.getNetwork() != null ? series.getNetwork().getName() : "N/A") +
                            "\n          🎭 Genêros: " + String.join(" ,", series.getGenres()));

            id++;
        }
        if(!scan.hasNextInt()){
            scan.nextLine();
            System.out.println("❌ Opção invalida! Sendo redirecionado ao menu anterior . . .");
            encaminhaDeletes(usuario);
        }

        int escolha = scan.nextInt();
        scan.nextLine();
        if( escolha<=0 || escolha>lista.size()){
            System.out.println("❌ Opção invalida! Sendo redirecionado ao menu anterior . . .");
            encaminhaDeletes(usuario);
        }

        lista.remove(escolha - 1);
        System.out.println("🚮 Série removida da lista!");

    }//fim menu deleta serie

    public static void menuOrdenarListas(List<Serie> lista, Usuario usuario){

        while(true) {
            System.out.println("\n1️⃣ Ordenar por ordem alfabetica || 2️⃣ Ordenar por nota. ||" +
                    " 3️⃣ Ordenar por estreia || 4️⃣ Ordenar pelo estado da serie || 0️⃣ Voltar ao menu principal.\n");
            int escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 0 :
                    System.out.println("↩️ Voltando ao menu principal. . .");
                    return;
                case 1 :
                System.out.println("\n🔤 Sua lista ordenada por ordem alfabética: \n");
                OrdenadoresDeLista.ordenarListaPorNome(lista);
                break;
                case 2:
                    System.out.println("\n🔢 Sua lista ordenada por nota: \n");
                    OrdenadoresDeLista.ordenarListaPorNota(lista);
                    break;
                case 3:
                    System.out.println("\n📅 Sua lista ordenada por estreia: \n");
                    OrdenadoresDeLista.ordenarListaPorEstreia(lista);
                    break;
                case 4:
                    System.out.println("\n⏳ Sua lista ordenada pelo estado da serie: \n");
                    OrdenadoresDeLista.ordenarListaPorEstadoDaSerie(lista);
                    break;
                default:
                    System.out.println("\n❌ Opção invalida!");
                    continue;
            }

            for (Serie serie : lista) {
                System.out.println(serie);
            }

        }
    }//fim menu ordenar listas

    public static void encaminhaLeituras(Usuario usuario) {

        System.out.println("\n📄 Qual lista deseja visualizar?" +
                "\n0️⃣ Voltar ao menu inicial." +
                "\n1️⃣ Lista de favoritos." +
                "\n2️⃣ Lista de Já Assistidos." +
                "\n3️⃣ Lista de Desejo Assistir.\n");
        int escolha = scan.nextInt();
        scan.nextLine();

        switch (escolha) {
            case 0 -> {
                break;
            }
            case 1 -> ListaFavoritos.lendoListaFavoritos(usuario);
            case 2 -> ListaJaAssistidos.lendoListaJaAssistidos(usuario);
            case 3 -> ListaDesejoAssistir.lendoListaDesejoAssistir(usuario);
            default -> {
                System.out.println("\n❌ Opção invalida.");
                encaminhaLeituras(usuario);
            }
        }
    }//fim do encaminhador para visualizar listas

    public static void encaminhaDeletes(Usuario usuario){
        System.out.println("\n📄 Qual lista você deseja acessar?" +
                "\n0️⃣ Voltar ao menu inicial." +
                "\n1️⃣ Lista de favoritos." +
                "\n2️⃣ Lista de Já Assistidos." +
                "\n3️⃣ Lista de Desejo Assistir.\n");
        int escolha = scan.nextInt();
        scan.nextLine();
        switch (escolha) {
            case 0 -> {
                return;
            }
            case 1 -> ListaFavoritos.deleteListaFavoritos(usuario);
            case 2 -> ListaJaAssistidos.deleteListaJaAssistidos(usuario);
            case 3 -> ListaDesejoAssistir.deleteListaDesejoAssistir(usuario);
            default -> {
                System.out.println("\n❌ Opção invalida.");
                encaminhaDeletes(usuario);
            }
        }

    }//fim do encaminhador de deletes
}
