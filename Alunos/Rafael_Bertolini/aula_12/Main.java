import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //atv1
        List<Integer> atividade1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> pares = atividade1.stream().
                filter(n -> n % 2 == 0).
                collect(Collectors.toList());

        System.out.println("Pares: " + pares);

        //atv2
        List<String> nomesAtv2 = Arrays.asList("roberto", "josé", "caio", "vinicius");

        List<String> nomesMaiusculo = nomesAtv2.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());

        System.out.println("Nomes: " + nomesMaiusculo);

        //atv3
        List<String> atv3 = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");

        Map<String, Long> contagem = atv3.stream().
                collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        System.out.println("Contagem: " + contagem);

        //atv4
        List<Produto> atv4 = new ArrayList<>();

        atv4.add(new Produto("Monitor", new BigDecimal("650")));
        atv4.add(new Produto("Mouse USB", new BigDecimal("67.50")));
        atv4.add(new Produto("TV", new BigDecimal("1450")));
        atv4.add(new Produto("Caderno", new BigDecimal("40.99")));

        Map<String, BigDecimal> maioresDe100 = atv4.stream().
                filter(n -> n.getPreco().compareTo(new BigDecimal("100.0")) > 0 ).
                collect(Collectors.toMap(Produto::getNome, Produto::getPreco));

        System.out.println("Maiores de 100: " + maioresDe100);

        //atv5
        BigDecimal somaProdutos = atv4.stream().
                map(Produto::getPreco).
                reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Soma de produtos: " + somaProdutos);

        //atv6
        List<String> atv6 = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> nomesRankeados = atv6.stream().
        sorted(Comparator.comparingInt(p -> p.length())).
                collect(Collectors.toList());

        System.out.println("Nomes ordenados: " + nomesRankeados);

    }
    static class Produto {
        private String nome;
        private BigDecimal preco;

        public Produto(String nome, BigDecimal preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {return nome;}
        public BigDecimal getPreco() {return preco;}
    }
}