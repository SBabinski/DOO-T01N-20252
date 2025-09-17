import java.util.Scanner;

public class Gerente extends Vendedor {
    Scanner scanner = new Scanner (System.in);

    public Gerente (){
        this.salarioRecebido.clear();

        salarioRecebido.add(3.100);
        salarioRecebido.add(3.200);
        salarioRecebido.add(3.300);

    }

    public void calcularMedia() {
        double soma = 0;
        double media = 0;

        int i;
        for (i = 0; i < salarioRecebido.size(); i++) {
            soma += salarioRecebido.get(i);

        } media = soma / salarioRecebido.size();

        System.out.println("A media do salario é: " + media);
    }

    public double calcularBonus(){
        double bonus = 0;

        System.out.println("Digite o salario base: ");
        double salariob = scanner.nextDouble();

        bonus = salariob * 0.35;

        System.out.println("O bonus é: " + bonus);
        return 0;
    }
    public void cadastrarGerente () {
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

    }

    }

