package chain.moeda;

public class Moeda50CentavosHandler extends MoedaHandler {
    @Override
    public int processar(int centavos) {
        if (centavos == 50) {
            return centavos;
        }
        return encaminhar(centavos);
    }
}
