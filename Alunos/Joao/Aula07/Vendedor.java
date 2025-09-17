import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salbase;
    ArrayList<Double> salrecebido = new ArrayList<>();

    public Vendedor(){}

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro,
                    String rua, double salbase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salbase = salbase;
        salrecebido.add(1900.00);
        salrecebido.add(2000.00);
        salrecebido.add(2100.00);
    }

    public void cadastrarVendedor(){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite o nome do vendedor: ");
        String nomeV = scanner.nextLine();

        System.out.println("Digite a idade do vendedor: ");
        int idadeV = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite a loja do vendedor: ");
        String lojaV = scanner.nextLine();

        System.out.println("Digite a cidade do vendedor: ");
        String cidadeV = scanner.nextLine();

        System.out.println("Digite o bairro do vendedor: ");
        String bairroV = scanner.nextLine();

        System.out.println("Digite a rua do vendedor: ");
        String ruaV = scanner.nextLine();

        System.out.println("Digite o salário base do vendedor: ");
        double salbaseV = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Vendedores cadastrados com sucesso!");
    }

    public void apresentarse() {
        System.out.println("Loja: " + nome + " | Idade: " + idade + " | Loja: " + loja);
    }


    public double calcmedia() {
        double soma = 0;
        for (int i = 0; i < salrecebido.size(); i++) {
            soma += salrecebido.get(i);
        }
        return soma / salrecebido.size();
    }

    public double calcbonus() {
        return salbase * 0.2;
    }

}
