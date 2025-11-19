import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //ATV1:
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> pares = num.stream().filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("\nNúmeros pares: " + pares + "\n");

        //ATV2:
        List<String> pessoas = Arrays.asList("Roberto", "José", "Caio", "Vinicius");
        List<String> maiusculo = pessoas.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Nomes maiúsculo: " + maiusculo+ "\n");

        //ATV3:
        List<String> palavra = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> conta = palavra.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println("Contagem de palavras: " + conta + "\n");

        //ATV4:
        List<Produto> produtos = Arrays.asList(new Produto("Carregador", 50.0),
        new Produto ("Celular", 900.0), new Produto ("Garrafa", 101.0),
                new Produto ("Esmalte", 5.0));

        List<Produto> cem = produtos.stream().filter(i -> i.getPreco() > 100)
                .collect(Collectors.toList());

        System.out.println("Mais que cem: ");
        cem.forEach(i -> System.out.println(i.getNome() + " R$: " + i.getPreco()));
        System.out.println("\n");

        //ATV5:
        double soma = produtos.stream().mapToDouble(Produto:: getPreco).sum();
        System.out.println("A soma é: " + soma + "\n");

        //ATV6:
        List<String> linguagem = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> tam = linguagem.stream().sorted(Comparator.comparingInt(String:: length))
                .collect(Collectors.toList());
        System.out.println("Palavras por tamanho: " + tam + "\n");
    }
}