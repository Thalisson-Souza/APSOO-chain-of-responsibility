package chain.moeda;

/** ConcreteHandler que processa moedas de 25 centavos. */
public class Moeda25CentavosHandler extends MoedaHandler {
    @Override
    public int processar(int centavos) {
        if (centavos == 25) {
            return centavos;
        }
        return encaminhar(centavos);
    }
}
