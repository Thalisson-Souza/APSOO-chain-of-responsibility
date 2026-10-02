# Etapa 2 - Implementação e revisão crítica

## Prompt utilizado

```text
Trabalhando usando o Chain of Responsibility. no seguinte cenário é uma máquina de vendas que vende refrigerante, salgadinho e chocolate e aceita moedas de 5, 10, 25 e 50 centavos e de 1 real e cada moeda tem que passar por uma cadeia de responsáveis, cada um conhece um valor e se não consegue processar passa pro próximo. A máquina soma o valor inserido, libera o produto quando chega no preço e calcula o troco se passar. Se a moeda não for aceita tem que avisar.

Eu já fiz o diagrama UML assim: uma classe abstrata MoedaHandler (Handler) com o próximo e o método processar, e as classes Moeda5CentavosHandler, Moeda10CentavosHandler, Moeda25CentavosHandler, Moeda50CentavosHandler e Moeda1RealHandler (ConcreteHandler) que estendem ela. A MaquinaDeVendas guarda o primeiro da cadeia e a Main que é o cliente monta a cadeia.

Implemente seguindo esse diagrama UML. faz uma Main que deixe escolher o produto e inserir moedas. Usa Java 11 com Maven, sem dependência externa.
```

## O que foi feito na `v2-p1`

Commit da implementação inicial: [ver commit](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/commit/8e5a1fa)

Implementação do Chain of Responsibility com base no diagrama da v1.
`MoedaHandler` é o Handler, as classes `Moeda...Handler` são os ConcreteHandlers
e a `Main` é o Client que monta a cadeia. A `MaquinaDeVendas` só conhece o
primeiro da cadeia.

## Revisão crítica

### O que está correto

- O `MoedaHandler` guarda o próximo e o `encaminhar` passa a moeda pra frente, igual ao diagrama
- Cada ConcreteHandler só decide sobre um valor e não conhece os outros
- A `MaquinaDeVendas` só conhece o `MoedaHandler`, não as classes concretas
- Moeda que ninguém trata chega no fim da cadeia, devolve 0 e a máquina avisa

### O que está incompleto ou inadequado

- Não dá pra desistir da compra. Se o usuário coloca uma moeda e muda de ideia a `Main` fica presa até pagar. O `inserirMoeda` sem produto selecionado dá `NullPointerException`. Isso é do Client e da máquina, a cadeia do diagrama não participa
- Os handlers repetem o mesmo `if (centavos == valor) return centavos; return encaminhar(centavos);` só mudando o número. Cada ConcreteHandler repete o encaminhamento, que no diagrama é do Handler, e o valor fica solto no `if`
- O `cadastrarProduto` aceita nome nulo e preço zero ou negativo. Com preço zero o produto sai sem moeda nenhuma e a cadeia não tem como evitar, porque a validação é da máquina

## Melhorias na v2-p2

Cancelar compra, `processar` no `MoedaHandler` com cada ConcreteHandler só informando o `valor()` e validação no `cadastrarProduto`.

[v2-p2 — implementação melhorada](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/tree/v2-p2)
