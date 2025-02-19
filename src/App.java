import ClassesLeitura.LeituraPrincipal;
import ClassesSistema.Casal;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        LeituraPrincipal.leituraCompleta(args[0]);

        System.out.println("CASAIS:");
        List<Casal> casais = Casal.getCasais();
        for(Casal c : casais) c.imprimeCasal();


    }
}