package chain.maquina;

import chain.moeda.MoedaHandler;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaquinaDeVendas {
    private final MoedaHandler cadeia;
    private final Map<String, Integer> produtos = new LinkedHashMap<>();
    private String selecionado;
    private int inserido;

    public MaquinaDeVendas(MoedaHandler cadeia) {
        if (cadeia == null) {
            throw new IllegalArgumentException("A cadeia de moedas é obrigatória.");
        }
        this.cadeia = cadeia;
    }

    public void cadastrarProduto(String nome, int precoEmCentavos) {
        produtos.put(nome, precoEmCentavos);
    }

    public Map<String, Integer> getProdutos() {
        return produtos;
    }

    public boolean selecionarProduto(String nome) {
        if (!produtos.containsKey(nome)) {
            return false;
        }
        selecionado = nome;
        inserido = 0;
        return true;
    }

    public boolean inserirMoeda(int centavos) {
        int aceito = cadeia.processar(centavos);
        inserido += aceito;
        return aceito > 0;
    }

    public int getInserido() {
        return inserido;
    }

    public int getPreco() {
        return produtos.get(selecionado);
    }

    public boolean pago() {
        return inserido >= getPreco();
    }

    public int liberar() {
        int troco = inserido - getPreco();
        selecionado = null;
        inserido = 0;
        return troco;
    }
}
