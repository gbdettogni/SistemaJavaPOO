import ClassesLeitura.LeituraPrincipal;
import ClassesSistema.Casal;
import ClassesRelatorio.RelatorioGeral;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        RelatorioGeral.criaRelatorios(args[0]);
        LeituraPrincipal.leituraCompleta(args[0]);

        System.out.println("CASAIS:");
        List<Casal> casais = Casal.getCasais();
        for(Casal c : casais) {
            c.processaGastoTotal();
            c.imprimeCasal();
        }


    }
}