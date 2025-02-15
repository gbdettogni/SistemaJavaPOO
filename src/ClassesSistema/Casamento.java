package ClassesSistema;

import java.time.LocalDate;
import java.time.LocalTime;

public class Casamento {
    private String id;
    private LocalDate data;
    private LocalTime horario;
    private String local;
    private Festa festa;

    public Casamento(String id, LocalDate data, LocalTime horario, String local) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.local = local;
        this.festa = null;
    }

    public void imprimeDados(){
        System.out.printf("Casamento: %s %s\n", id, local);
        System.out.println(data + " | " + horario);
    }
}
