package ClassesSistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NovoLar {
    private String id;
    private String rua;
    private int numero;
    private String complemento;
    private List<Tarefa> tarefas = new ArrayList<>();

    public NovoLar(String id, String rua, int numero, String complemento) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Tarefa getTarefaById(String idTarefa) {
        for (Tarefa tf : tarefas){
            if (tf.getId().equals(idTarefa)) return tf;
        }
        return null;
    }

    public double getPrecoTotalTarefas(){
        double precoTarefas = 0;
        for(Tarefa f : tarefas){
            precoTarefas += f.getPrecoTarefa();
        }
        return precoTarefas;
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

    public List<Parcela> getTotalParcelas() {
        List<Parcela> parcelas = new ArrayList<>();
        for (Tarefa tf : tarefas){
            parcelas.addAll(tf.getTotalParcelas());
        }
        return parcelas;
    }
}
