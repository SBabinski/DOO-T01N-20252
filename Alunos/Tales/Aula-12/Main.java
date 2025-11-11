import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

   
    record Produto(String nome, double preco) {}

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        // ATV1 - Filtrar números pares
        System.out.println("ATV1");
        var numeros = List.of(3, 8, 15, 22, 7, 10, 4, 19, 2, 31);
        var pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Entrada: " + numeros);
        System.out.println("Pares: " + pares);
        System.out.println();

        // ATV2 - Converter nomes para maiúsculas
        System.out.println("ATV2");
        var nomes = List.of("roberto", "josé", "caio", "vinicius");
        var nomesMaiusculos = nomes.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Entrada: " + nomes);
        System.out.println("Maiúsculas: " + nomesMaiusculos);
        System.out.println();

        // ATV3 - Contar ocorrências de palavras
        System.out.println("ATV3");
        var palavras = List.of("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        var contagem = palavras.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        contagem.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        System.out.println();

        // ATV4 - Filtrar produtos > R$100
        System.out.println("ATV4");
        var produtos = List.of(
                new Produto("Fone de Ouvido", 89.90),
                new Produto("Teclado Mecânico", 199.00),
                new Produto("Cadeira Gamer", 799.90),
                new Produto("Cabo USB-C", 25.00)
        );
        var acimaDe100 = produtos.stream()
                .filter(p -> p.preco() > 100.00)
                .toList();
        System.out.println("Produtos: " + produtos);
        System.out.println("Filtrados (> R$100): " + acimaDe100);
        System.out.println();

        // ATV5 - Soma total dos produtos
        System.out.println("ATV5");
        var soma = produtos.stream()
                .mapToDouble(Produto::preco)
                .sum();
        System.out.printf("Valor total dos produtos: R$ %.2f%n", soma);
        System.out.println();

        // ATV6 - Ordenar linguagens por tamanho
        System.out.println("ATV6");
        var linguagens = List.of("Java", "Python", "C", "JavaScript", "Ruby");
        var ordenadas = linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println("Entrada: " + linguagens);
        System.out.println("Ordenadas por tamanho: " + ordenadas);
    }
}
