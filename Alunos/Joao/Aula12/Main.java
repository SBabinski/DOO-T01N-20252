import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        //ATV1
        List<Integer> num = Arrays.asList(3, 8, 15, 22, 9, 10, 6, 7, 12);

        List<Integer> pares = num.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Os números pares são: " + pares + "\n");

        //ATV2
        List<String> nomes = Arrays.asList("Roberto" , "José", "Caio", "Vinícius");

        List<String> maiuscilo = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Nomes em letras maiúsculas: " + maiuscilo + "\n");

        //ATV3
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");

        Map<String, Long> contagem = palavras.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Contagem de palavras: " + contagem + "\n");

        //ATV4
        List<Produto> produtos = Arrays.asList(
                new Produto("Celular", 1500.0),
                new Produto("Notebook", 2000.0),
                new Produto("TV", 1750.0),
                new Produto("Controle", 40.0)
        );

        List<Produto> pCaros = produtos.stream()
                .filter(produto -> produto.getPreco() > 100.0)
                .collect(Collectors.toList());

        System.out.println("Produtos com preço maior que R$100: ");
        pCaros.forEach(produto -> System.out.println("- " + produto.getNome() +
                " (R$ " + produto.getPreco() + ")" + "\n"));

        //ATV5
        double somaTotal = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();

        System.out.println("Soma total dos produtos: R$ " +somaTotal + "\n");


        //ATV6
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> ordem = linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println("Linguagens ordenadas por tamanho: " + ordem);
        }
    }