package chain.moeda;

public abstract class MoedaHandler {
    private MoedaHandler proximo;

    public MoedaHandler setProximo(MoedaHandler proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract int processar(int centavos);

    protected int encaminhar(int centavos) {
        if (proximo == null) {
            return 0;
        }
        return proximo.processar(centavos);
    }
}
