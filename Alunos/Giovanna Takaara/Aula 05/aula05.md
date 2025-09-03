# Paradigmas: Imperativo e Declarativo

---

> No dia 26/08/2025, aprendemos sobre Markdown e sobre os
paradigmas da programação e vimos que eles podem ser 
declarativos ou imperativos.

---

Os **paradigmas imperativos** (passo a passo), podem ser uma 
programação:

- Estruturada.
- Procedural.
- Orientada a Objetos. 

Na estruturada, ele usa sequências,decisões e repetições para 
organizar o andamento do programa. Na procedural, ele organiza o
código em funções para evitar repetição e melhorar a clareza. E na
orientada a objetos, ele organiza o código em objetos que combina
atributos e métodos, facilitando o reaproveitamento e a organização.

---

Já os **paradigas declarativos** (foca no que deve ser feito),
possui dois tipos principais: 

- Lógico.
- Funcional.

No tipo Lógico, ele se baseia em regras e fatos, permitindo que o
programa encontre soluções "sozinho". E no tipo funcional, cada
entrada produz uma saída sem alterar o estado do programa.

---

## Exemplo (Aula 05) declarativo X imperativo:

**IMPERATIVO:**

- Ir para a cozinha;
- Obtenha açúcar e chá Mate Leão;
- Misture-os e aqueça no fogo até ferever;
- Coloque isso em um copo e traga para mim;

**DECLARATIVO:**
- Chá, Mate-Leão, quente.

---

## Comparação entre Java e Prolog:

Exemplo de paradigma imperativo em Java:

```java
public class NumeroPar {
    public static void main (String[] Args) {
        int num = 8;

if (num % 2 == 0) {
    System.out.println ("O número " + num + " é par.");
} else {
    System.out.println ("O número " + num + " é impar.");
        }
    }
}
```
Exemplo de paradigma declarativo em Prolog:

``` prolog
par(N) :- 0 is N mod 2.
```

---
## Conclusão:

Enquanto em Java o programador deve escrever cada passo, em prolog
ele só precisa declarar a regra lógica. Logo, o paradigma imperativo
está mais próximo da excução da máquina (porque foca em como resolver)
e o paradigma declarativo é mais próximo da lógica matemática (foca em 
o que resolver).





















