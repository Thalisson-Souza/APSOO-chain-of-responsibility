package chain.moeda;

/** ConcreteHandler que processa moedas de 1 real. */
public class Moeda1RealHandler extends MoedaHandler {
    @Override
    public int processar(int centavos) {
        if (centavos == 100) {
            return centavos;
        }
        return encaminhar(centavos);
    }
}
