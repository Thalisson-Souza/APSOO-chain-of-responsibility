package chain.moeda;

/** ConcreteHandler que processa moedas de 50 centavos. */
public class Moeda50CentavosHandler extends MoedaHandler {
    @Override
    public int processar(int centavos) {
        if (centavos == 50) {
            return centavos;
        }
        return encaminhar(centavos);
    }
}
