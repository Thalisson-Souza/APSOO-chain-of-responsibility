package chain.moeda;

/** ConcreteHandler que processa moedas de 10 centavos. */
public class Moeda10CentavosHandler extends MoedaHandler {
    @Override
    public int processar(int centavos) {
        if (centavos == 10) {
            return centavos;
        }
        return encaminhar(centavos);
    }
}
