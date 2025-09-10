# Paradigmas de Programação: Imperativo vs Declarativo

Na área de programação, diferentes paradigmas oferecem formas distintas de resolver problemas. Dois dos mais conhecidos são o **imperativo** e o **declarativo**. Antes de explorarmos exemplos, vale entender também como o próprio formato deste texto, o **Markdown**, funciona.

## O que é Markdown

Markdown é uma linguagem de marcação simples, usada para formatar textos de forma leve e legível. Diferente de linguagens de programação, o Markdown não executa instruções, mas organiza conteúdo. Por exemplo, títulos são criados com o símbolo `#`, listas com `-` ou `*`, e blocos de código com três crases (```). É bastante usado em documentação, relatórios técnicos e arquivos README de projetos de software.

## Paradigma Imperativo

O paradigma imperativo é baseado em comandos que alteram o estado do programa passo a passo. O programador precisa dizer exatamente **como** a tarefa deve ser executada, controlando o fluxo por meio de estruturas como variáveis, laços (`for`, `while`) e condições (`if`).

Um exemplo em **Java**, linguagem fortemente associada ao paradigma imperativo, é verificar se um número está em uma lista:

```java
public class Exemplo {
    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5};
        int numero = 3;
        boolean encontrado = false;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == numero) {
                encontrado = true;
                break;
            }
        }

        System.out.println("Número encontrado? " + encontrado);
    }
}
```

Nesse código, temos uma sequência clara de passos: declarar a lista, definir o número a ser buscado, percorrer os elementos com um laço e, em cada iteração, comparar o valor. Caso seja encontrado, o programa atualiza a variável `encontrado` e interrompe a busca. Por fim, imprime o resultado. O foco está no _como_ fazer a busca.

## Paradigma Declarativo

O paradigma declarativo, por outro lado, descreve **o que** deve ser resolvido, sem detalhar os passos de execução. Cabe ao mecanismo da linguagem descobrir como encontrar a resposta. Em linguagens como **Prolog**, esse paradigma é aplicado por meio de fatos e regras lógicas que descrevem relações.

Exemplo em Prolog para verificar se um elemento pertence a uma lista:

```prolog
membro(X, [X|_]).
membro(X, [_|Cauda]) :- membro(X, Cauda).

?- membro(3, [1,2,3,4,5]).
```

Aqui não existe um laço explícito como em Java. O programador apenas define duas regras:

1. Um elemento é membro de uma lista se ele for a cabeça da lista.
2. Caso contrário, ele é membro se pertencer à cauda (restante) da lista.

Ao consultar `?- membro(3, [1,2,3,4,5]).`, o interpretador Prolog aplica essas regras recursivamente até chegar à conclusão de que o número está presente. O _como_ é abstraído pela linguagem, que faz a busca automaticamente.

## Comparação

- **Markdown**: organiza e apresenta informação, servindo como suporte para documentação clara e estruturada.
- **Java (Imperativo)**: requer especificar o processo detalhado de iteração e comparação, controlando manualmente as variáveis e o fluxo do programa.
- **Prolog (Declarativo)**: expressa apenas a relação desejada, e o motor lógico encontra a resposta por meio da aplicação de regras.

Embora os três casos lidem com contextos distintos (formatação de texto, programação imperativa e programação declarativa), todos mostram como linguagens diferentes podem refletir filosofias distintas: detalhar passos, declarar condições ou simplesmente estruturar a comunicação. No fim, Java e Prolog chegam ao mesmo objetivo — verificar a presença de um elemento em uma lista — mas de formas conceitualmente opostas.
