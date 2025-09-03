# **Paradigmas**

## O que são paradigmas?
Um paradigma de programação é um conjunto de regras, princípios e estilos que definem a forma como um programa é escrito e organizado. Ele orienta como o desenvolvedor deve estruturar o código e pensar a solução de problemas, servindo como uma espécie de “modelo de raciocínio” para criar programas.

## Principais tipos de paradigma

### _Imperativo_ ###
O paradigma imperativo é baseado em comandos que dizem ao computador exatamente como executar uma tarefa. Nele, o programa é construído como uma sequência de instruções passo a passo, que controlam diretamente o fluxo da execução. Esse estilo foca no processo, ou seja, na forma de resolver o problema.

### _Declarativo_ ###
O paradigma declarativo é voltado para o que se deseja alcançar, sem precisar detalhar o caminho para chegar ao resultado. Nesse modelo, a ênfase está na lógica e no objetivo final do programa, e não no controle das etapas de execução. Em outras palavras, o desenvolvedor descreve o que quer obter, deixando que o sistema cuide de como isso será feito.

## Exemplos
### _Código em java (imperativo)_

```java
import java.util.Arrays;
public class ExemploJava {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int buscar = 3;
        boolean encontrado = false;
        for (int n : numeros) {
            if (n == buscar) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println(buscar + " está na lista.");
        } else {
            System.out.println(buscar + " não está na lista.");
        }
    }
}
```
**Como funciona:**  
1. Cria um array com os números.  
2. Define o número que quer buscar.  
3. Percorre a lista (laço for).  
4. Compara cada elemento (if).  
5. Para se encontrar, marca como verdadeiro.  
6. Exibe a resposta no final.

### _Código em Prolog (declarativo)_
```prolog
% Base de conhecimento
numeros([1, 2, 3, 4, 5]).

% Regra: verifica se um elemento está na lista
membro(X, [X|_]).
membro(X, [_|T]) :- membro(X, T).

% Consulta:
?- numeros(Lista), membro(3, Lista).
```
**Como funciona**
1. Define-se uma base de fatos: a lista [1,2,3,4,5].  
2. Define-se uma regra lógica (membro/2) que diz:
- Um número é membro de uma lista se ele for a cabeça da lista.  
- Ou, se ele for membro da cauda da lista.
5. A consulta (?- ...) pergunta diretamente: "3 é membro da lista?"
6. O Prolog responde true ou false. 

_O o que fazer é descrito em termos lógicos; o mecanismo de inferência do Prolog cuida do “como”._