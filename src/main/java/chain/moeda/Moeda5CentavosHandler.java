package chain.moeda;

/** ConcreteHandler que processa moedas de 5 centavos. */
public class Moeda5CentavosHandler extends MoedaHandler {
    @Override
    public int processar(int centavos) {
        if (centavos == 5) {
            return centavos;
        }
        return encaminhar(centavos);
    }
}
