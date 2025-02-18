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

    public void imprimeDados(){
        System.out.println("Lar: " + rua + ", Num. " + numero + " (" + complemento + ")");
        if(!tarefas.isEmpty()) System.out.println("Tarefas:");
        for(Tarefa f : tarefas) f.imprimeDados();
    }

    public void addTarefa(Tarefa f){
        tarefas.add(f);
    }

    public String getId() {
        return id;
    }
}
