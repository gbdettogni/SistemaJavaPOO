package ClassesSistema;

import java.util.Currency;
import java.util.Locale;

public class Compra {
    private String nomeProduto;
    private int quantidade;
    private double precoUnidade;
    private Loja loja;
    private Parcela parcela;

    public Compra(String nomeProduto, int quantidade, double precoUnidade, Loja loja, Parcela parcela) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnidade = precoUnidade;
        this.loja = loja;
        this.parcela = parcela;
    }

    public double getPreco(){
        return precoUnidade * quantidade;
    }

    public void imprimeCompras() {
        System.out.printf("Compra: R$%f\n", getPreco());
    }
}
