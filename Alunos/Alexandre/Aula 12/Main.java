import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15);
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(pares);

        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(nomesMaiusculos);

        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println(contagem);

        List<Produto> produtos = Arrays.asList(
                new Produto("Teclado", 80.00),
                new Produto("Monitor", 950.00),
                new Produto("Mouse", 45.00),
                new Produto("Cadeira", 1200.00));
        List<Produto> produtosFiltrados = produtos.stream()
                .filter(p -> p.getPreco() > 100.00)
                .collect(Collectors.toList());
        System.out.println(produtosFiltrados);

        double somaTotal = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println(somaTotal);

        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadas = linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(ordenadas);
    }

    static class Produto {
        private String nome;
        private double preco;

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public double getPreco() {
            return preco;
        }

        @Override
        public String toString() {
            return "Produto{nome='" + nome + "', preco=" + preco + "}";
        }
    }
}