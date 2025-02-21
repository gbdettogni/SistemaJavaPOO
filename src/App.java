import ClassesLeitura.LeituraPrincipal;
import ClassesRelatorio.RelatorioCasais;
import ClassesRelatorio.RelatorioPrestadores;
import ClassesSistema.Casal;
import ClassesRelatorio.RelatorioGeral;
import ClassesFinanceiro.Iterador;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        RelatorioGeral.criaRelatorios(args[0]);
        LeituraPrincipal.leituraCompleta(args[0]);

        System.out.println("CASAIS:");
        List<Casal> casais = Casal.getCasais();
        for(Casal c : casais) {
            c.processaGastoTotal();
            c.processaCasamentosConjuntos();
            c.imprimeCasal();
        }
        Iterador.iteraParcelas();

        RelatorioCasais.ordenaListaCasais();
        RelatorioCasais.geraRelatorioCasais(args[0]);
        RelatorioPrestadores.geraRelatorioPrestadores(args[0]);
    }
}