package ClassesSistema;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Festa {
    private String local;
    private Currency precoPago;
    private LocalDate data;
    private LocalTime horario;
    private List<String> listaConvidados = new ArrayList<>();
    private Parcela parcela;
}
