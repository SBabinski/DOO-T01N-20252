import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("atividade 01");
        System.out.println("--------------------------------");
        // atividade 01
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        System.out.println("os numeros pares sao:" + pares);

        System.out.println("--------------------------------");

        System.out.println("atividade 02");
        System.out.println("--------------------------------");
        // atividade 02

        List<String> nomes = Arrays.asList("roberto", "jose", "caio", "vinicius");
       
        List<String> nomesMaiusculos = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("os nomes em maiusculo sao:" + nomesMaiusculos);

        System.out.println("--------------------------------");

        // atividade 03
        System.out.println("atividade 03");
        System.out.println("--------------------------------");

        List<String> repetidos = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");

        Map<String, Long> unicos = repetidos.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        System.out.println("os elementos unicos sao:" + unicos);

        System.out.println("--------------------------------");
        System.out.println("atividade 04");
        System.out.println("--------------------------------");

        // atividade 04

        List<Produto> produtos = new ArrayList<>();

        
        produtos.add(new Produto("mouse", new BigDecimal("50.0")));
        produtos.add(new Produto("teclado", new BigDecimal("100.0")));
        produtos.add(new Produto("monitor", new BigDecimal("300.0")));
        produtos.add(new Produto("impressora", new BigDecimal("200.0")));

        Map<String, BigDecimal> precoMaiorQue100 = produtos.stream()
                .filter(p -> p.getPreco().compareTo(new BigDecimal("100.0")) > 0)
                .collect(Collectors.toMap(Produto::getNome, Produto::getPreco));

        System.out.println("os produtos com preco maior que 100 sao:" + precoMaiorQue100);

        System.out.println("--------------------------------");

        System.out.println("atividade 05");
        System.out.println("--------------------------------");

        BigDecimal somaprodutos = produtos.stream().
        map(Produto::getPreco).
        reduce(BigDecimal.ZERO, BigDecimal::add);
        
        System.out.println("o somatorio dos precos dos produtos é: " + somaprodutos);



        System.out.println("--------------------------------");

        System.out.println("atividade 06");
        System.out.println("--------------------------------");

        //atividade 06

            List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

            List<String> linguasTamanho = linguagens.stream().
            sorted(Comparator.comparingInt(i -> i.length())).
            collect(Collectors.toList());

            System.out.println("nomes ordenados por tamanho de letras:" + linguasTamanho );

            System.out.println("--------------------------------");




    }

static class Produto {
    private String nome;
    private BigDecimal preco;

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public BigDecimal getPreco() {return preco;}
    public void setPreco(BigDecimal preco) {this.preco = preco;}
    

}

}
