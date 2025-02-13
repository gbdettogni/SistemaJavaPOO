package ClassesSistema;

import ClassesLeitura.LeituraPrincipal;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        LeituraPrincipal.lePessoa(args[0]);
        //for(Pessoa p : pessoas) p.imprimeSujeito();
        //List<Casal> casais = LeituraPrincipal.leCasais(args[0], pessoas);
    }
}