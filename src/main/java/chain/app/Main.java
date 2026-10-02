package chain.app;

import chain.maquina.MaquinaDeVendas;
import chain.moeda.Moeda10CentavosHandler;
import chain.moeda.Moeda1RealHandler;
import chain.moeda.Moeda25CentavosHandler;
import chain.moeda.Moeda50CentavosHandler;
import chain.moeda.Moeda5CentavosHandler;
import chain.moeda.MoedaHandler;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MoedaHandler cadeia = new Moeda5CentavosHandler();
        cadeia.setProximo(new Moeda10CentavosHandler())
              .setProximo(new Moeda25CentavosHandler())
              .setProximo(new Moeda50CentavosHandler())
              .setProximo(new Moeda1RealHandler());

        executar(new MaquinaDeVendas(cadeia));
    }

    static void executar(MaquinaDeVendas maquina) {
        maquina.cadastrarProduto("Refrigerante", 150);
        maquina.cadastrarProduto("Salgadinho", 200);
        maquina.cadastrarProduto("Chocolate", 300);

        Scanner entrada = new Scanner(System.in);

        System.out.println("Produtos:");
        for (Map.Entry<String, Integer> p : maquina.getProdutos().entrySet()) {
            System.out.println("- " + p.getKey() + ": " + dinheiro(p.getValue()));
        }
        System.out.print("Escolha o produto: ");
        if (!entrada.hasNextLine() || !maquina.selecionarProduto(entrada.nextLine().trim())) {
            System.out.println("Produto inválido.");
            return;
        }

        while (!maquina.pago()) {
            System.out.println();
            System.out.println("Inserido: " + dinheiro(maquina.getInserido())
                    + " de " + dinheiro(maquina.getPreco()));
            System.out.print("Moeda em centavos: ");
            if (!entrada.hasNextLine()) {
                return;
            }
            try {
                int moeda = Integer.parseInt(entrada.nextLine().trim());
                if (!maquina.inserirMoeda(moeda)) {
                    System.out.println("Moeda de " + dinheiro(moeda) + " não aceita.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite só números.");
            }
        }

        int troco = maquina.liberar();
        System.out.println("Produto liberado.");
        if (troco > 0) {
            System.out.println("Troco: " + dinheiro(troco));
        }
    }

    static String dinheiro(int centavos) {
        return String.format("R$ %d,%02d", centavos / 100, centavos % 100);
    }
}
