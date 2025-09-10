# Aula 05 - Texto sobre Paradigmas

## Introdução
Nesse texto será retratado um pequeno resumo do que são os paradigmas **imperativo** e **declarativo**. Antes de falar de cada de forma isolada, vamos entender o que são esses paradigmas.

### Para que servem?
Os paradigmas servem para distinguir formas de pensar e estruturar resoluções de problemas dentro da programação. São como fossem **modelos mentais**, e dividem o mesmo propósito, o de resolucionar problemas, porém **abordam de forma diferente** o caminho para a resolução de um problema dentro da programação.

---

## Paradigma Imperativo
No Paradigma **Imperativo** precisamos passar para o sistema passo a passo do que deve ser feito. **Quem está programando precisa pensar como controlar diretamente o estado do programa**, tudo precisa estar dentro de seu gerenciamento. 

### Contexto Histórico
**Surgiu na década de 40 e 50**, junto com os **primeiros computadores**. Na época, o Paradigma Imperativo estava ligado diretamente com como as máquinas (*computadores*) funcionavam na época. Por conta disso, esse paradigma foi base de praticamente todas linguagens dominantes do mercado, como **C e Java**.

### Na prática
Na prática, no **Paradigma Imperativo**, não basta dizer para o computador o que tem que ser feito, **você precisa dizer para ele como será passo a passo do que ele precisa fazer para chegar no estado final que você deseja.** Se pegarmos um exemplo simples, seria como ensinar alguém a cozinhar. 

>Você precisa instruir a pessoa detalhe por detalhe, passando pela instrução de pegar a panela e ligar o fogo por exemplo, até adicionar temperos.

---

## Paradigma Declarativo
**No Paradigma Declarativo passamos o que desejamos obter**, e o controle de como vai ser feito fica por conta da máquina, **diferente do Paradigma Imperativo, que precisamos passar o passo a passo**.

### Contexto Histórico
Não existe uma data específica sobre a criação do **Paradigma Declarativo**, mas sabemos que **as primeiras ideias começam a aparecer no fim da década de 50** com o **LISP**. Porém, o Paradigma Declarativo **começa a ganhar força nos anos 70**, com o **Prolog e SQL**.

### Na Prática
Dentro desse paradigma apenas **passamos especificações, relações ou propriedades** do problema que desejamos resolucionar. **O passo a passo da resolução quem decide é o compilador**. Se usarmos o  mesmo exemplo de ensinar alguém a cozinhar ficaria assim:

> Você passa que quer um macarrão cozido, com molho de tomate, sal e alho, e diz que o resultado final deve ser pronto para consumo.

---

## Comparação Java x Prolog
Vamos usar para a comparação um exemplo que pedimos o sistema printar um **Hello World** na tela.

### Exemplo em JAVA

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```
Dentro desse código vemos que foi necessário **criar uma classe** com nome de *HelloWorld*. Precisamos **definir um método como main**, que se caracteriza como **ponto de entrada** da aplicação. E por fim, para pedir pro sistema printar, **é preciso usar o System.out.println** para imprimir o texto.

### Exemplo no PROLOG

```Prolog
:- initialization(main).

main :- write('Hello, World!'), nl.
```

No Prolog vemos primeiro o comando **:- initialization(main).**, que **indica ao sistema onde se deve iniciar o programa**. E depois **passamos apenas a ação que queremos**, que seria escrever a frase *"Hello, World!"*, e depois **usar nl para pular uma linha**.

---