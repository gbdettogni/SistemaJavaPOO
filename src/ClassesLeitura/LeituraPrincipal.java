package ClassesLeitura;

import ClassesSistema.Pessoa;
import ClassesSistema.Casal;

import java.util.List;

public class LeituraPrincipal {
    public static void lePessoas(String pasta){
        PlanilhaPessoas.lePlanilhaPessoas(pasta);
    }

    public static void leCasais(String pasta){
        PlanilhaCasais.lePlanilhaLares(pasta);
        PlanilhaCasais.lePlanilhaCasamentos(pasta);
    }
}
