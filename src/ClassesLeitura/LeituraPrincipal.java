package ClassesLeitura;

public class LeituraPrincipal {
    public static void lePessoas(String pasta){
        PlanilhaPessoas.lePlanilhaPessoas(pasta);
    }

    public static void leCasais(String pasta){
        PlanilhaCasais.lePlanilhaLares(pasta);
        PlanilhaCasais.lePlanilhaCasamentos(pasta);
    }

    public static void leFestas(String pasta){
        PlanilhaFestas.lePlanilhaFestas(pasta);
    }

    public static void leTarefas(String pasta){
        PlanilhaTarefas.lePlanilhaTarefas(pasta);
    }

    public static void leCompras(String pasta){
        PlanilhaCompras.lePlanilhaCompras(pasta);
    }

    public static void leituraCompleta(String pasta){
       lePessoas(pasta);
       leCasais(pasta);
       leFestas(pasta);
       leTarefas(pasta);
       leCompras(pasta);
    }
}
