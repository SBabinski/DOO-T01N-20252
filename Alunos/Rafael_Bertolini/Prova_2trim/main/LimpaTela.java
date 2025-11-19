package main;

import java.util.Scanner;

public class LimpaTela {

    public static void limpandoTela(){

        Scanner scan = new Scanner(System.in);

        System.out.println("\n🧐 Você deseja realmente limpar a tela? \n   Digite SIM para prosseguir");
        String confirmacao = scan.nextLine();

        if(confirmacao.equalsIgnoreCase("SIM")){
            System.out.println("\n ⏳Limpando tela em: \n");
            for(int i=3; i>0; i--){
                System.out.println(i);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("\n❌ Não foi possível limpar a tela.");
                }
            }

            for(int j=0; j<70; j++ ){
                System.out.println(" ");
            }

        }else{
            System.out.println("\n↩️ Voltando ao menu principal. . .");
        }
    }
}
