# Paradigmas 
Paradigmas são conjuntos de regras, princípios, ... que definem como o código é escrito, organizado e como ele funciona.

## Paradigma Imperativo: 
Importa-se com a sequência em que o programa é executado, cada declaração orienta o que deve e como deve ser feito. E há 3 tipos:

- Programação Estruturada: usa blocos de fluxo de controle do programa (If, Else, ...) visando otimizar o código. E também usa funcções e controles de iteração. Seu maior foco é melhorar a legibilidade do código, o que facilita a reutilização. Exemplos de Linguagem: Cobol, PHP, Go e etc.

- Programação Procedural: o nome já diz, ela é estruturada em procedimentos, como funções ou sub-rotinas. Exemplos: C, C++, Java e Pascal.

- Programação Orientada a Objeto: Baseia-se na criação de objetos abstraídos do mundo real, os quais possuem propriedades e métodos permitindo o reaporveitamento de código e o encapsulamento dos dados. Ex: PHP, Java, C#, JS, Python e Ruby.

## Paradigma Declarativo: 
Importa-se com a lógica do programa, e no resultado. O fluxo não importa, o que importa é alcançar o resultado.

- Programação Funcional: quase tudo é função, basicamente o pc vai realiar uma sequência de funções matemáticas, como exemplo temos o JS, em que quase tudo é função. Também há a Haskell, Scalla e Clojure.

- Programação Lógica: 

- a lógica basicamente define o que deve ser resolvido, sem se importar com o fluxo. Apenas diz o que deve ser resolvido. Exemplos: Prolog e DataLog.



## Comparação entre os paradigmas: Java x Prolog

Para ilustrar ainda mais as diferenças entre os paradigmas imperativo e declarativo, considere o problema de verificar se um número é múltiplo de outro.

### Exemplo: Verificando se um número é múltiplo de outro

#### Imperativo (Java)
```java
public class Multiplo {
    public static void main(String[] args) {
        int a = 15;
        int b = 5;
        if (a % b == 0) {
            System.out.println(a + " é múltiplo de " + b + ".");
        } else {
            System.out.println(a + " não é múltiplo de " + b + ".");
        }
    }
}
```
Neste exemplo imperativo, o código calcula o resto da divisão de `a` por `b` e, se for zero, indica que `a` é múltiplo de `b`.

#### Declarativo (Prolog)
```prolog
multiplo(A, B) :- 0 is A mod B.
```
No exemplo declarativo, basta declarar a regra para múltiplo. Ao consultar `?- multiplo(15, 5).`, o Prolog verifica se a condição é verdadeira e retorna a resposta.

---

## Considerações Finais

A escolha do paradigma pode afetar não apenas a sintaxe do código, mas também a abordagem do programador para resolver problemas. Enquanto o paradigma imperativo pode oferecer mais controle sobre cada passo do processo, o paradigma declarativo pode proporcionar uma visão mais clara e concisa do que se deseja alcançar.