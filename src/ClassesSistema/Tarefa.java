package ClassesSistema;

import java.time.LocalDate;
import java.util.Currency;

public class Tarefa {
    private String id;
    private double preco;
    private LocalDate data;
    private int prazo;
    private Pessoa prestador;
    private Compra compra;
    private Parcela parcela;

    public Tarefa(String id, LocalDate data, double preco, int prazo, Pessoa prestador, Parcela parcela) {
        this.id = id;
        this.data = data;
        this.preco = preco;
        this.prazo = prazo;
        this.prestador = prestador;
        this.parcela = parcela;
        compra = null;
    }

    public void imprimeDados(){
        System.out.printf("Tarefa: %f\n", preco);
        if(compra != null)compra.imprimeCompras();
    }

    public double getPrecoTarefa(){
        double precoTarefa = preco;
        if (compra != null) precoTarefa += compra.getPreco();
        return precoTarefa;
    }

    public String getId() {
        return id;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}
