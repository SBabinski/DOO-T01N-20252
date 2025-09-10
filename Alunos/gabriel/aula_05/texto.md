# Paradigmas de Programação: Imperativo e Declarativo



O paradigma **imperativo**, utilizado em linguagens como Java, parte da ideia de que o programador precisa detalhar passo a passo o que a máquina deve fazer. Isso envolve manipular variáveis, usar estruturas de repetição e condicionais, controlando diretamente o fluxo do programa. 

Já o paradigma **declarativo**, representado por linguagens como Prolog, funciona de outra forma. Nele, o programador não precisa descrever o caminho exato para chegar à solução, mas sim estabelecer regras e relações que descrevem o problema. O sistema, então, utiliza essas declarações para deduzir a resposta. É como dizer ao programa o que se deseja, e deixar que ele descubra sozinho como chegar lá.

## Comparação entre os códigos

**Java (imperativo):**
```java
public class Paridade {
    public static void main(String[] args) {
        int n = 9;
        if (n % 2 == 1) {
            System.out.println(n + " é impar.");
        } else {
            System.out.println(n + " é par.");
        }
    }
}
```

Neste exemplo, o código em Java define uma variável, faz o cálculo do resto da divisão por 2 e, a partir disso, decide se o número é par ou ímpar. A lógica é explícita e controlada linha por linha pelo programador.

**Prolog (declarativo):**
```prolog
par(N) :- 0 is N mod 2.
impar(N) :- 1 is N mod 2.
```

Em Prolog, basta declarar as regras de paridade. Quando perguntamos `?- par(09).`, o interpretador verifica a condição e responde se ela é verdadeira ou não. Não há um passo a passo definido pelo programador, apenas a descrição da relação que caracteriza um número par ou ímpar.

## Considerações finais

A comparação mostra que, mesmo resolvendo o mesmo problema, Java e Prolog seguem caminhos conceitualmente diferentes. Enquanto o primeiro exige que o programador dite o **como**, o segundo permite que se concentre apenas no **o que** deve ser resolvido. Essa diferença não é apenas técnica, mas também filosófica, pois influencia a maneira como pensamos sobre problemas e sobre a própria construção do software.