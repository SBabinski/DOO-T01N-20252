import java.util.ArrayList;
import java.util.Scanner;

    public class Vendedor {
        String nome;
        int idade;
        String loja;
        String cidade;
        String bairro;
        String rua;
        double salarioBase;
        ArrayList<Double> salarioRecebido = new ArrayList<>();

        public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
            this.nome = nome;
            this.idade = idade;
            this.loja = loja;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.salarioBase = salarioBase;
            this.salarioRecebido.add((double)2000.0);
            this.salarioRecebido.add((double)2100.0);
            this.salarioRecebido.add((double)2200.0);
        }
        public Vendedor() {
        }

        public void cadastrarVend(){
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nome: ");
            nome = scanner.nextLine();
            System.out.print("Idade: ");
            idade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Cidade: ");
            cidade = scanner.nextLine();
            System.out.print("Bairro: ");
            bairro = scanner.nextLine();
            System.out.print("Rua: ");
            rua = scanner.nextLine();
            System.out.print("Salário Base: ");
            salarioBase = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Vendedor cadastrado com sucesso!");
        }


        public void apresentarVendedor() {
            System.out.println("Vendedor: " + this.nome + "\nIdade: " + this.idade + "\nLoja: " + this.loja);
        }

        public double calcularmedia() {
            double soma = (double)0.0F;

            for (int i = 0; i < this.salarioRecebido.size(); ++i) {
                soma += (Double)this.salarioRecebido.get(i);
            }

            return soma / (double)this.salarioRecebido.size();
        }

        public double calcularBonus() {
            return this.salarioBase * 0.2;
        }
    }
