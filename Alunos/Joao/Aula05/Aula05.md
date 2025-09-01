# Paradigmas de Programação: Imperativo e Declarativo

---
Na computação, um paradigma de programação é um jeito de organizar como
os programas são feitos.
Dois exemplos comuns são o **imperativo** e o **declarativo**.

No **imperativo** você explica **como** fazer algo. 
O código mostra passo a passo o que precisa acontecer. Linguagens como
Java seguem esse estilo, e o programador precisa controlar a ordem das
instruções e os valores das variáveis.

Já o **declarativo** foca em **o que** você quer que aconteça, 
sem precisar explicar cada passo. Linguagens como Prolog usam 
esse estilo: você define regras e fatos, e o próprio sistema
encontra a solução.


## Comparação de Códigos

### Exemplo em Java (Imperativo)

```java
public class Soma {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int resultado = a + b;
        System.out.println("Resultado: " + resultado);
    }
} 
```

### Exemplo em Prolog (Declarativo)

```prolog
soma(A, B, Resultado) :- 
    Resultado is A + B.
```
---
## Comparação dos dois paradigmas

O paradigma **imperativo**, como em Java, faz com que o programador 
explique **como** o computador deve executar cada passo. Você precisa
controlar a ordem das instruções, mexer nas variáveis e acompanhar cada
operação até chegar no resultado.

O paradigma **declarativo**, como em Prolog, se concentra no **o que** 
deve ser feito. O programador define regras e condições, e o sistema 
encontra a solução sozinho, sem detalhar cada passo.

Conclusão, no imperativo você diz **como fazer**, enquanto no 
declarativo você diz **o que quer que seja feito**, deixando que o 
programa cuide dos detalhes.

---