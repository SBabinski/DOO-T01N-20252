
# COMPARANDO PARADIGMAS: IMPERATIVO VS DECLARATIVO

NA PROGRAMACAO, OS PARADIGMAS DETERMINAM O "JEITO" DE PENSAR E ESCREVER CODIGO. DOIS DOS MAIS CLASSICOS SAO O **IMPERATIVO** E O **DECLARATIVO**.

- **PARADIGMA IMPERATIVO**: FOCA NO *COMO* FAZER. O CODIGO E UMA SEQUENCIA DE INSTRUCOES QUE MODIFICAM O ESTADO DO PROGRAMA. LINGUAGENS COMO JAVA SAO EXEMPLOS TIPICOS.
- **PARADIGMA DECLARATIVO**: FOCA NO *O QUE* DEVE SER FEITO. O PROGRAMADOR DESCREVE O RESULTADO DESEJADO E A LINGUAGEM SE VIRA PARA ENCONTRAR UMA SOLUCAO. PROLOG E UM OTIMO EXEMPLO.

vamos comparar os dois com um exemplo simples: descobrir se uma pessoa e mae de outra.

## java (paradigma imperativo)

```java
public class Mae {
    public static void main(String[] args) {
        String[][] relacoes = {{"Ana", "Pedro"}, {"Beatriz", "Joao"}};

        String mae = "Ana";
        String filho = "Pedro";

        boolean resultado = false;
        for (int i = 0; i < relacoes.length; i++) {
            if (relacoes[i][0].equals(mae) && relacoes[i][1].equals(filho)) {
                resultado = true;
                break;
            }
        }

        if (resultado) {
            System.out.println(mae + " e mae de " + filho);
        } else {
            System.out.println(mae + " nao e mae de " + filho);
        }
    }
}
```

nesse exemplo, o programa percorre manualmente as relacoes, compara strings e controla o fluxo com estruturas de repeticao e condicao.

## prolog (paradigma declarativo)

```prolog
mae(ana, pedro).
mae(beatriz, joao).

eh_mae(Mae, Filho) :- mae(Mae, Filho).
```

em prolog, a gente so declara os fatos (`mae(ana, pedro)`) e uma regra. depois basta perguntar:
```prolog
?- eh_mae(ana, pedro).
true.
```

## conclusao

a diferenca e clara: no java, temos que dizer *passo a passo* o que fazer. ja no prolog, basta descrever a relacao e deixar o sistema resolver.

os dois funcionam, mas tem jeitos bem diferentes de pensar e escrever. cada paradigma tem suas vantagens dependendo do problema. para logica e regras, prolog e mais direto. para controle e estrutura mais rigida, o estilo imperativo de java pode ser melhor.
