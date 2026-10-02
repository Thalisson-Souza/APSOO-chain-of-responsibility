package chain.app;

import chain.maquina.MaquinaDeVendas;
import chain.moeda.Moeda10CentavosHandler;
import chain.moeda.Moeda1RealHandler;
import chain.moeda.Moeda25CentavosHandler;
import chain.moeda.Moeda2ReaisHandler;
import chain.moeda.Moeda50CentavosHandler;
import chain.moeda.Moeda5CentavosHandler;
import chain.moeda.MoedaHandler;

public class MainEtapa3 {
    public static void main(String[] args) {
        MoedaHandler cadeia = new Moeda5CentavosHandler();
        cadeia.setProximo(new Moeda10CentavosHandler())
              .setProximo(new Moeda25CentavosHandler())
              .setProximo(new Moeda50CentavosHandler())
              .setProximo(new Moeda1RealHandler())
              .setProximo(new Moeda2ReaisHandler());

        Main.executar(new MaquinaDeVendas(cadeia));
    }
}
