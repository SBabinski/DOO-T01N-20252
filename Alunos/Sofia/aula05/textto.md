# Paradigmas de Programação: Imperativo e Declarativo

Na aula teórica do dia **26/08/2025**, estudamos os paradigmas de programação **imperativo** e **declarativo**, que representam formas distintas de pensar e estruturar soluções computacionais.

O **paradigma imperativo** é caracterizado pela ênfase em **como** a tarefa deve ser realizada. O programador define passo a passo as instruções, controlando o fluxo do programa por meio de variáveis, laços e condicionais. Linguagens como **Java**, **C** e **Python** (em grande parte) seguem este modelo.

Por outro lado, o **paradigma declarativo** concentra-se em **o que** precisa ser alcançado, sem detalhar a sequência de operações. O programador declara propriedades, regras ou relações, e o sistema encarrega-se de resolver o problema. Linguagens como **Prolog** e **SQL** são bons exemplos dessa abordagem.

---

## Exemplos em Java e Prolog

```java
// Exemplo em Java (Imperativo)

public class Paridade {
    public static void main(String[] args) {
        int numero = 6;
        if (numero % 2 == 0) {
            System.out.println(numero + " é par.");
        } else {
            System.out.println(numero + " é ímpar.");
        }
    }
}

// Exemplo em Prolog (Declarativo)

% Regra para verificar se um número é par
par(X) :- 0 is X mod 2.

% Consulta
?- par(6).
