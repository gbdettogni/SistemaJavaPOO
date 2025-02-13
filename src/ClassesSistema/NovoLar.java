package ClassesSistema;

import java.util.ArrayList;
import java.util.List;

public class NovoLar {
    private String id;
    private String rua;
    private int numero;
    private String complemento;
    private List<Tarefa> tarefas = new ArrayList<>();

    public NovoLar(String id, String rua, int numero, String complemento){
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
}
