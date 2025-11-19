import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        
        // atv 1
        List<Integer> lista1 = Arrays.asList(10, 15, 22, 33, 40, 55, 60, 71, 80, 99);
        List<Integer> pares = lista1.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(pares);

        // atv 2
        List<String> lista2 = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> maiusculas = lista2.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(maiusculas);

        // atv 3
        List<String> lista3 = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = lista3.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting())); //deus abencoe o criador do java
        System.out.println(contagem);

        // atv 4
        List<Produto> lista4 = Arrays.asList(
            new Produto("mouse", 55.0),
            new Produto("teclado", 250.0),
            new Produto("monitor", 900.0),
            new Produto("cabo", 30.0)
        );
        lista4.stream()
            .filter(p -> p.preco > 100)
            .forEach(p -> System.out.println(p.nome + " - " + p.preco));

        // atv 5
        double total = lista4.stream()
                .mapToDouble(p -> p.preco)
                .sum();
        System.out.println(total);

        // atv 6
        List<String> lista6 = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenada = lista6.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))  //seria legal aprender em aula
                .collect(Collectors.toList());
        System.out.println(ordenada);
    }
}

class Produto {
    String nome;
    double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}