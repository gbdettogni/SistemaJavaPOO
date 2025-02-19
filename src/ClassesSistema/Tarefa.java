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
        System.out.printf("Tarefa prestada por %s desde %s prazo de %d dias/meses\n", prestador.getNome(), data, prazo);
        compra.imprimeCompras();
    }

    public String getId() {
        return id;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}
