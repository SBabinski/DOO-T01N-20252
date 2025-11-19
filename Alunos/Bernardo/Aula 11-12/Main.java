import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Map;

public class Main {
    
    public static void ex1() { //exercício 1
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(pares);
    }


    public static void ex2() { //exercício 2
        List<String> nomes = Arrays.asList("roberto", "jose", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(nomesMaiusculos);
    }

    
    public static void ex3() { //exercício 3
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println(contagem);
    }


    public static void ex4() { //exercício 4
        class Produto {
            private String nome;
            private double preco;

            public Produto(String nome, double preco) {
                this.nome = nome;
                this.preco = preco;
            }

            public String getNome() {
                return nome;
            }

            public double getPreco() {
                return preco;
            }

            @Override
            public String toString() {
                return nome + " - R$ " + preco;
            }
        }
        List<Produto> produtos = Arrays.asList(
            new Produto("camiseta", 110.00),
            new Produto("bermuda", 49.90),
            new Produto("cueca", 15.00),
            new Produto("casaco", 300.00)
        );

        List<Produto> filtrados = produtos.stream()
                .filter(p -> p.getPreco() > 100.0)
                .collect(Collectors.toList());

        System.out.println("Produtos acima de R$ 100:");
        System.out.println(filtrados);
    }


    public static void ex5() { //exercício 5
        class Produto {
            private String nome;
            private double preco;

            public Produto(String nome, double preco) {
                this.nome = nome;
                this.preco = preco;
            }
            public double getPreco() {
                return preco;
            }
        }
        List<Produto> produtos = Arrays.asList(
            new Produto("camiseta", 110.00),
            new Produto("bermuda", 49.90),
            new Produto("cueca", 15.00),
            new Produto("casaco", 300.00)
        );

        double soma = produtos.stream().mapToDouble(Produto::getPreco).sum();
        System.out.println(soma);
    }


    public static void ex6() { //exercício 6
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadas = linguagens.stream().sorted((a, b) -> Integer.compare(a.length(), b.length())).collect(Collectors.toList());
        System.out.println(ordenadas);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\nEscolha um exercício (1 a 6):");
            int opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    ex1();
                    break;
                case 2:
                    ex2();
                    break;
                case 3:
                    ex3();
                    break;
                case 4:
                    ex4();
                    break;
                case 5:
                    ex5();
                    break;
                case 6:
                    ex6();
                    break;
                default:
                    System.out.println("Este exercício não existe!");
                    break;
            }
        }
    }
}