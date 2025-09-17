import java.util.Scanner;

public class Livro {

    String titulo;
    String autor;
    String data;
    private boolean emprestado;

    public Livro(String titulo, String autor, String data){
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.emprestado = false;
    }

    public Livro(){
    }

    Scanner scanner = new Scanner(System.in);
    public void cadastrarL (){
        System.out.println("Digite o nome do livro: ");
        titulo = scanner.nextLine();

        System.out.println("Digite o autor do livro: ");
        autor = scanner.nextLine();

        System.out.println("Digite a data: (dd/mm/aaaa) ");
        data = scanner.nextLine();

        System.out.println(" Livro cadastrado com sucesso! \n");
    }
    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }

    public void emprestar() {
        if (!emprestado) {
            setEmprestado(true);
            emprestado = true;
            System.out.println("Livro emprestado: " + titulo);
        } else {
            System.out.println("Livro já está emprestado!");
        }
    }
}
