package ClassesSistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tarefa {
    private String id;
    private double preco;
    private LocalDate data;
    private int prazo;
    private Pessoa prestador;
    private List<Compra> compras;
    private Parcela parcela;

    public Tarefa(String id, LocalDate data, double preco, int prazo, Pessoa prestador, Parcela parcela) {
        this.id = id;
        this.data = data;
        this.preco = preco;
        this.prazo = prazo;
        this.prestador = prestador;
        this.parcela = parcela;
        compras = new ArrayList<>();

    }

    public void imprimeDados(){
        System.out.printf("Tarefa: %f\n", preco);
        if(compras != null) {
            for (Compra compra : compras){
                compra.imprimeCompras();
            }
        }
    }

    public double getPrecoTarefa(){
        double precoTarefa = preco;
        if (compras != null){
            for (Compra compra : compras){
                precoTarefa += compra.getPreco();
            }
        }
        return precoTarefa;
    }

    public String getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void addCompra(Compra compra) {
        compras.add(compra);
    }

    public List<Parcela> getTotalParcelas() {
        List<Parcela> parcelas = new ArrayList<>();
        parcelas.add(parcela);
        if(compras != null) {
            for (Compra compra : compras){
                parcelas.add(compra.getParcela());
            }
        }
        return parcelas;
    }


}
