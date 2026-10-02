# Chain of Responsibility

## Cenário

Imagine que você está desenvolvendo o software de uma máquina de vendas
automática que comercializa produtos como refrigerantes, salgadinhos e
chocolates.

A máquina aceita moedas de 5, 10, 25 e 50 centavos e de 1 real. Para processar
cada moeda ela possui uma cadeia de responsáveis. Cada responsável conhece um
valor de moeda e se não consegue processar passa para o próximo.

Quando o valor inserido atinge ou passa o preço do produto o produto é liberado
e o troco é calculado se tiver.

## Estrutura

- `MoedaHandler`: Handler. Guarda o próximo e tem o `encaminhar`
- `Moeda5CentavosHandler`, `Moeda10CentavosHandler`, `Moeda25CentavosHandler`, `Moeda50CentavosHandler` e `Moeda1RealHandler`: ConcreteHandlers
- `MaquinaDeVendas`: guarda os produtos, soma o valor inserido e calcula o troco. Só conhece o primeiro da cadeia
- `Main`: Client. Monta a cadeia e inicia o processamento

## Como rodar

```
mvn compile
java -cp target/classes chain.app.Main
```
