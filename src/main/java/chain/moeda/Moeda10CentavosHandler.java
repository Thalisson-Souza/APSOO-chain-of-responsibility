package chain.moeda;

public class Moeda10CentavosHandler extends MoedaHandler {
    @Override
    public int processar(int centavos) {
        if (centavos == 10) {
            return centavos;
        }
        return encaminhar(centavos);
    }
}
