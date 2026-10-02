package chain.moeda;

public class Moeda1RealHandler extends MoedaHandler {
    @Override
    public int processar(int centavos) {
        if (centavos == 100) {
            return centavos;
        }
        return encaminhar(centavos);
    }
}
