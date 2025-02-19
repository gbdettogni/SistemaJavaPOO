package ClassesSistema;

import java.util.Currency;
import java.util.Locale;

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

    public void imprimeCompras() {
        System.out.printf("foi comprado %d unidade de %s, por %f nessa tarefa, da loja %s\n", quantidade, nomeProduto, preco, loja.getNome());
    }
}
