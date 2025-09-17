import java.util.Scanner;
import java.util.ArrayList;

public class App {
    
    static Scanner scan = new Scanner(System.in);
    static float[][] biblioteca = new float[5][5];

    public static void cadastroClientes(){
        Cliente clienteNovo = new Cliente();
        System.out.println("nome do cliente?");
        clienteNovo.nome = scan.nextLine();
        System.out.println("cliente cadastrado com sucesso");
    }

    public static void cadastroLivro(){
        System.out.println("O livro é raro? (sim/nao)");
        String tipoLivro = scan.nextLine();
        
        System.out.println("Digite o nome do autor:");
        String autor = scan.nextLine();

        System.out.println("Digite o nome da obra:");
        String nomeObra = scan.nextLine();

        if (tipoLivro == "sim") {
            Raro novoLivroRaro = new Raro(nomeObra, autor);
            System.out.println("Livro raro cadastrado: " + novoLivroRaro.nome + " por " + novoLivroRaro.autor);
            
        } else {
            Livro novoLivro = new Livro(nomeObra, autor);
            System.out.println("Livro normal cadastrado: " + novoLivro.nome + " por " + novoLivro.autor);
        }
        
    
    }


    public static void buscaAut(){
            
    }


    public static void buscaLiv(){

    }



    public static void emprestimo(){

    }

    public static void devolucao(){
        System.out.println("Deseja devolver um livro?(sim/nao)");
        String resposta = scan.nextLine();
        if(resposta == "nao"){

        }else{
            System.out.println("voce devolveu todos os seus livros");
        }
    }

    public static void main(String[] args) throws Exception {
        int escolha;
		
		do {
			System.out.println("\n===== MENU =====");
	        System.out.println("[1] - Cadastrar clientes");
	        System.out.println("[2] - Cadastro de livros");
	        System.out.println("[3] - Buscar livro por titulo");
            System.out.println("[4] - Buscar livro por autor");
	        System.out.println("[5] - Realizar emprestimo");
            System.out.println("[6] - Devolução");
            System.out.println("[7] - Sair");
	        System.out.print("Escolha uma opção: ");
	        
	        escolha = scan.nextInt();
			
			switch(escolha) {
				case 1:
                    scan.nextLine();
					cadastroClientes();
					break;
				case 2:
                    scan.nextLine();
					cadastroLivro();
					break;
				case 3:
					
					break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
				case 7:
					System.out.println("saindo...");
					break;
				
				default:
					
					System.out.println("comando invalido");
					break;
				
			}
		}while(escolha != 7);
	}

}
