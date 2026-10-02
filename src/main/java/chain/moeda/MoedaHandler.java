package chain.moeda;

public abstract class MoedaHandler {
    private MoedaHandler proximo;

    public MoedaHandler setProximo(MoedaHandler proximo) {
        this.proximo = proximo;
        return proximo;
    }

    protected abstract int valor();

    public int processar(int centavos) {
        if (centavos == valor()) {
            return centavos;
        }
        return encaminhar(centavos);
    }

    protected int encaminhar(int centavos) {
        if (proximo == null) {
            return 0;
        }
        return proximo.processar(centavos);
    }
}
