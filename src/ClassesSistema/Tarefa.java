package ClassesSistema;

import java.time.LocalDate;
import java.util.Currency;

public class Tarefa {
    private double preco;
    private LocalDate data;
    private int prazo;
    private Pessoa prestador;
    private Compra compra;
    private Parcela parcela;

    public Tarefa(LocalDate data, double preco, int prazo, Pessoa prestador, Parcela parcela) {
        this.data = data;
        this.preco = preco;
        this.prazo = prazo;
        this.prestador = prestador;
        this.parcela = parcela;
    }
}
