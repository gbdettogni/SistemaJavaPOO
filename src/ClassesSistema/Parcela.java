package ClassesSistema;

import java.time.LocalDate;

public class Parcela {
    private int numInicial;
    private int numAtual;
    private double valor;
    private LocalDate dataInicio;

    public Parcela(int numInicial, double preco, LocalDate data) {
        this.numInicial = numInicial;
        numAtual = numInicial;
        valor = preco/numInicial;
        dataInicio = data;
    }

    public int getNumAtual() {
        return numAtual;
    }

    public void minus(){
        numAtual --;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
}
