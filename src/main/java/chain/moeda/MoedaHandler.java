package chain.moeda;

/** Handler do padrão Chain of Responsibility. */
public abstract class MoedaHandler {
    private MoedaHandler proximo;

    /** Define o próximo da cadeia e o devolve, para encadear as chamadas. */
    public MoedaHandler setProximo(MoedaHandler proximo) {
        this.proximo = proximo;
        return proximo;
    }

    /** Devolve o valor aceito em centavos, ou 0 se ninguém da cadeia aceitou a moeda. */
    public abstract int processar(int centavos);

    protected int encaminhar(int centavos) {
        if (proximo == null) {
            return 0;
        }
        return proximo.processar(centavos);
    }
}
