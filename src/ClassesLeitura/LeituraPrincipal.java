package ClassesLeitura;

public class LeituraPrincipal {
    public static void lePessoas(String pasta) throws Exception{
        PlanilhaPessoas.lePlanilhaPessoas(pasta);
    }

    public static void leCasais(String pasta) throws Exception{
        PlanilhaCasais.lePlanilhaLares(pasta);
        PlanilhaCasais.lePlanilhaCasamentos(pasta);
    }

    public static void leFestas(String pasta) throws Exception{
        PlanilhaFestas.lePlanilhaFestas(pasta);
    }

    public static void leTarefas(String pasta) throws Exception{
        PlanilhaTarefas.lePlanilhaTarefas(pasta);
    }

    public static void leCompras(String pasta) throws Exception{
        PlanilhaCompras.lePlanilhaCompras(pasta);
    }

    public static void leituraCompleta(String pasta) throws Exception{
       lePessoas(pasta);
       leCasais(pasta);
       leFestas(pasta);
       leTarefas(pasta);
       leCompras(pasta);
    }
}
