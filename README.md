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
- `Moeda5CentavosHandler`, `Moeda10CentavosHandler`, `Moeda25CentavosHandler`, `Moeda50CentavosHandler`, `Moeda1RealHandler` e `Moeda2ReaisHandler`: ConcreteHandlers
- `MaquinaDeVendas`: guarda os produtos, soma o valor inserido e calcula o troco. Só conhece o primeiro da cadeia
- `Main`: Client. Monta a cadeia e inicia o processamento

## Organização das entregas

As etapas foram organizadas nas seguintes branches:

- [v1 — diagrama UML](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/tree/v1)
- [v2-p1 — implementação e revisão crítica](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/tree/v2-p1)
- [v2-p2 — implementação melhorada](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/tree/v2-p2)
- [v3 — extensão com a moeda de R$ 2,00](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/tree/v3)
- [v4 — análise de uma solução alternativa](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/tree/v4)
