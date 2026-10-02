# Etapa 4 — Análise de uma solução alternativa

## Solução analisada

Outro desenvolvedor fez o processamento direto na `MaquinaDeVendas` com um
`se/senão se` pra cada moeda:

```java
if (moeda == 5) {
    // processa
} else if (moeda == 10) {
    // processa
} else if (moeda == 25) {
    // processa
} else if (moeda == 50) {
    // processa
} else if (moeda == 100) {
    // processa
} else {
    // moeda não aceita
}
```

## Análise

**1. Qual é o principal problema quando novos valores de moeda precisam ser adicionados?**

Toda moeda nova obriga a abrir a `MaquinaDeVendas` e colocar mais um `else if`. Isso viola o Aberto/Fechado, porque não dá pra estender sem modificar

**2. Qual classe fica responsável por conhecer todos os tipos de moeda?**

A própria `MaquinaDeVendas`

**3. Como o crescimento da quantidade de valores aceitos pode afetar essa classe?**

Ela vai virando uma classe gigante. Além dos produtos, do saldo e do troco ainda guarda a lista de moedas, e cada moeda nova deixa ela mais difícil de ler. Um erro numa moeda pode quebrar as outras. Isso também afeta a Responsabilidade Única

**4. Como o Chain of Responsibility distribui essa responsabilidade?**

Cada `else if` vira uma classe. O `moeda == 25` virou o `Moeda25CentavosHandler` e a máquina só entrega a moeda pra cadeia

**5. Qual é o papel do encaminhamento da solicitação no padrão?**

É o que liga os responsáveis e quem não sabe tratar passa pro próximo sem saber quem ele é, e o cliente só entrega a moeda pro primeiro sem saber quem vai tratar

**6. O que significa dizer que cada responsável possui uma responsabilidade específica?**

Cada handler só decide sobre um valor de moeda, então o de 50 centavos não sabe nada do de 1 real por exemplo

**7. A cadeia precisa conter todos os tipos de moeda conhecidos pelo sistema? O que acontece quando nenhum responsável processa a moeda?**

Não precisa, por conta que o cliente monta a cadeia e pode usar só as moedas que quiser. E se ninguém trata a moeda ela chega no fim da cadeia e o `processar` devolve 0, e a máquina avisa que a moeda não foi aceita e não soma nada no saldo
