package ClassesSistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

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

    public LocalDate getData() {
        return data;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public List<Parcela> getTotalParcelas() {
        List<Parcela> parcelas = new ArrayList<>();
        parcelas.add(parcela);
        if(compra != null) {
            parcelas.add(compra.getParcela());
        }
        return parcelas;
    }


}
