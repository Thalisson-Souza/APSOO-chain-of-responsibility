# Etapa 2 - Melhorias na implementação

Melhorias feitas saindo da revisão crítica: [implementação inicial](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/tree/v2-p1) e [commit](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/commit/cdf1f15)

## Alterações feitas

| Alteração | Justificativa |
| --------- | ------------- |
| A `Main` aceita `cancelar`. A `MaquinaDeVendas` ganhou o `cancelar()`, que zera a compra e devolve o valor inserido. O `inserirMoeda` retorna `false` se não tem produto selecionado | Dá pra desistir depois de colocar moedas e não estoura mais exceção. Só o Client e a máquina mudaram. A cadeia continua igual ao diagrama da v1 porque cancelar não é moeda e não passa pelos handlers |
| O `processar` foi pro `MoedaHandler`, que compara com o `valor()` e senão chama o `encaminhar`. Cada ConcreteHandler só implementa o `valor()` | O encaminhamento agora fica na classe do diagrama que guarda o próximo. Antes cada ConcreteHandler repetia essa regra. Agora cada um só diz qual moeda trata, e a cadeia funciona igual: a moeda entra no primeiro, quem não trata passa pro próximo e se chegar no fim sem ninguém aceitar volta 0 |
| O `cadastrarProduto` valida nome e preço e lança `IllegalArgumentException` | A máquina soma o que a cadeia devolve e compara com o preço. Com preço zero ou negativo o `pago()` liberava o produto sem moeda nenhuma, e a cadeia não tem como evitar isso |

## Próxima etapa

[v3 — extensão](https://github.com/Thalisson-Souza/APSOO-chain-of-responsibility/tree/v3)
