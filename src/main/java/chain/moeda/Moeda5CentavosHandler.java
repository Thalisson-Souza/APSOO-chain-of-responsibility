package chain.moeda;

public class Moeda5CentavosHandler extends MoedaHandler {
    @Override
    public int processar(int centavos) {
        if (centavos == 5) {
            return centavos;
        }
        return encaminhar(centavos);
    }
}
