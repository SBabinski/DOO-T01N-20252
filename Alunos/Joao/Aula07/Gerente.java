import java.util.Scanner;

public class Gerente extends Vendedor {


    public Gerente() {
        this.salrecebido.clear();

        salrecebido.add(4400.00);
        salrecebido.add(4700.00);
        salrecebido.add(5000.00);
    }

    Scanner scanner = new Scanner(System.in);


    public void cadastrarG(){

        System.out.println(" Digite o nome do gerente: ");
        String nomeG = scanner.nextLine();

        System.out.println(" Digite a loja do gerente: ");
        String lojaG = scanner.nextLine();

        System.out.println(" Digite a cidade do gerente: ");
        String cidadeG = scanner.nextLine();

        System.out.println(" Digite o bairro do gerente: ");
        String bairroG = scanner.nextLine();

        System.out.println(" Digite a rua do gerente: ");
        String ruaG = scanner.nextLine();

        System.out.println(" Digite o salário base do gerente: ");
        Float salbaseG = scanner.nextFloat();

        salrecebido.add(3900.00);
        salrecebido.add(4000.00);
        salrecebido.add(4200.00);

    }
    public double calcmedia () {
        double soma = 0;
        for (int i = 0; i < salrecebido.size(); i++) {
            soma += salrecebido.get(i);
        }
        return soma / salrecebido.size();
    }

    public double calcbonus() {
        return salbase * 0.35;
    }

    @Override
    public void apresentarse(){
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Loja: " + loja);
     }
}
