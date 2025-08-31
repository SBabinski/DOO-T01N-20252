# Paradigmas de programação
## Por: Igor Augusto

---

## O quê é um paradigma?

Paradigmas são maneiras de abordar algo, como um modelo, com certas regras e padrões de design, na programação se é tratado de dois paradigmas, o paradigma imperativo e o paradigma declarativo, ambos tem seus usos e especialidades em diferentes tipos de aplicações, usando seu próprio tipo de escrita e organização de código.

Algumas linguagens de programação permitem o uso de diferentes tipos de pogramação ao mesmo tempo, como veremos logo.

---

## Paradigma Imperativo

Se trata de comando, direcionando porgramas com instruções exatas e específicas de como algo deve ser feito. Nela nós temos a programação Estruturada, Procedural e Orientada a Objetos.

### Estruturada

É modular, utilizando estruturas de controle por meio de blocos de decisão (If, Then, Else), construtores de iteração (For e While loops) e funções, esse tipo de programação melhora a legibilidade do código e facilita a reutilização de blocos de código.

### Procedural

É baseado em chamadas de procedimento (sendo também chamadas de sub rotinas ou funções), isso é, listas de instruções que dizem ao computador o que fazer passo a passo.

### Orientada a Objetos

Se baseia na criação de objetos com seus próprios métodos e propriedades, permitindo encapsulamento de dados específicos e reutilização de código. 

---

## Paradigma Declarativo

Foca na lógica de programa e o resultado em si, permitindo que o computador utilize a abordagem que ele decidir contanto que consiga o resultado, dando menos foco no fluxo de controle. Essa abordagem é dividida em Funcional e Lógica

### Funcional

Trata de tudo como funções não utiliza listas de procedimentos ou objetos mas sim funções matemáticas que em conjunto irão obter o resultado. Evita a mudança de estado e dados que são mutáveis.

### Lógica

Foca na declaração de fatos e regras que são utilizados para inferir novas informações e soluções para problemas, só sendo necessário declarar o que se quer resolver, e o computador decide a melhor abordagem para resolver o problema.

---

## Java VS Prolog

Para vermos a diferença das abordagens, vamos ver esses dois trechos de código, tendo a mesma função, verificar números pares e ímpares, um é em Java e o outro é em Prolog

***Java***

```java
public class ParOuImpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        if (numero % 2 == 0) {
            System.out.println("O número é par.");
        } else {
            System.out.println("O número é ímpar.");
        }

        scanner.close();
    }
}
```
Nesse código é utilizado uma lista de instruções por meio de estruturas de controle (if e else), O Java é uma linguagem da abordagem Imperativa que é predominantemente Orientada a objetos, porém tem certos elementos Estruturados e Procedurais, como é visto com o uso de estruturas de controle, por isso o Java é uma linguagem muitas vezes usada para a criação de programas como aplicativos e jogos, que requerem controles de fluxo.

***Prolog***

```prolog
% Arquivo: par_ou_impar.pl

% Regras
par(N) :- 0 is N mod 2.
impar(N) :- 1 is N mod 2.
```

Nesse código se é estabelecido a regra de que N é par se 0 é a sobra da divisão de N por 2, e N é ímpar se 1 é resto de divisão de N por 2. Isso não se trata de uma lista de instruções, mas regras que o computador vai levar em consideração e fazer seus próprios cálculos, já que o motor lógico do Prolog sabe como fazer isso quando se faz a sua consulta, fazendo do Prolog uma linguagem Lógica, sendo predominantemente utilizado por matemáticos, físicos e cientistas.

---

## Conclusão

Cada paradigma tem suas especialidades e funções que permitem que mais um seja utilizado, mas ficam a critério dos desenvolvedores com base em para quê o programa vai ser utilizado, com diferentes linguagems usando diferentes paradigmas.

---