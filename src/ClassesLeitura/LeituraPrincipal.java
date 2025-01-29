package ClassesLeitura;

import ClassesSistema.Pessoa;

import java.util.List;

public class LeituraPrincipal {
    public static List<Pessoa> lePessoa(String pasta){
        return PlanilhaPessoas._lePlanilhaPessoa(pasta);
    }
}
