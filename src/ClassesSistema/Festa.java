package ClassesSistema;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Festa {
    private String local;
    private double precoPago;
    private LocalDate data;
    private LocalTime horario;
    private List<String> listaConvidados = new ArrayList<>();
    private Parcela parcela;

    public Festa(String local, double precoPago, LocalDate data, LocalTime horario, List<String> listaConvidados, Parcela parcela) {
        this.local = local;
        this.precoPago = precoPago;
        this.data = data;
        this.horario = horario;
        this.listaConvidados = listaConvidados;
        this.parcela = parcela;
    }

    public double getPrecoPago() {
        return precoPago;
    }

    public void imprimeDados(){
        System.out.printf("Festa: %s (gasto de R$%f), vai ser dia %d/%d, parcela em %d vezes ai meu patrão\n", local, precoPago, data.getMonthValue(), data.getYear(), parcela.getNumAtual());
        System.out.println(data + " | " + horario);
        System.out.println("Convidados:");
        System.out.println(listaConvidados);
    }

    //public void pagaFesta(LocalDate dataAtual) {

    //}

    public Parcela getParcelaFesta() {
        return parcela;
    }
}
