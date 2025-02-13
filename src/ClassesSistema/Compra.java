package ClassesSistema;

import java.util.Currency;

public class Compra {
    private String nomeProduto;
    private int quantidade;
    private double preco;
    private Loja loja;
    private Parcela parcela;

    public Compra(String nomeProduto, int quantidade, double preco, Loja loja, Parcela parcela) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.loja = loja;
        this.parcela = parcela;
    }
}
