# Etapa 3 — Extensão com a moeda de R$ 2,00

Criei o `Moeda2ReaisHandler` e a `MainEtapa3`, que monta a mesma cadeia da
`Main` com mais um responsável no final. Não mexi em nenhuma classe que já existia.

**1. Qual classe foi criada para tratar a nova moeda?**

`Moeda2ReaisHandler`

**2. Como essa classe foi incorporada à cadeia?**

Com mais um `setProximo(new Moeda2ReaisHandler())` no fim da montagem na `MainEtapa3`

**3. Por que foi possível adicionar o novo responsável sem modificar os existentes?**

Cada responsável só conhece o `MoedaHandler` do próximo e não a classe concreta. Quem monta a cadeia é o cliente então os outros nem ficam sabendo que tem um novo

**4. O que aconteceria se fosse necessário adicionar mais cinco valores diferentes de moeda?**

Seriam cinco classes novas, cada uma só com o `valor()`, e cinco linhas na montagem da cadeia. O resto continua igual

**5. Como a solução com Chain of Responsibility se comportaria em comparação com uma única classe com vários if/else?**

No `if/else` cada moeda nova é mais um `else if` na mesma classe e ela só cresce. Na cadeia cada valor fica na sua classe e dá pra ler e testar sozinho

**6. O que aconteceria se o processamento de cada valor estivesse dentro da classe da máquina de vendas?**

A `MaquinaDeVendas` teria que conhecer todas as moedas além de cuidar dos produtos, do saldo e do troco. Moeda nova ia obrigar a mexer nela
