package ClassesSistema;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Currency;
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
}
