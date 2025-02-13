package ClassesLeitura;

import ClassesSistema.Pessoa;
import ClassesSistema.Casal;

import java.util.List;

public class LeituraPrincipal {
    public static void lePessoa(String pasta){
        PlanilhaPessoas._lePlanilhaPessoa(pasta);
    }

    public static List<Casal> leCasais(String pasta, List<Pessoa> pessoas){
        return PlanilhaCasais._lePlanilhaCasais(pasta);
    }
}
