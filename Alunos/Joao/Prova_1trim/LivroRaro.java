import java.util.Scanner;

public class LivroRaro extends Livro {

   String explic;

   Scanner scanner = new Scanner(System.in);

   public LivroRaro(){}

   public LivroRaro(String titulo, String autor, String data){
       super(titulo, autor, data);
       this.explic = explic;
    }

    public void cadastrarLR(){
       super.cadastrarL();

       System.out.println(" Explique porque esse livro é raro? ");
       explic = scanner.nextLine();

       System.out.println("Livro raro cadastrado com sucesso! \n");
    }
}
