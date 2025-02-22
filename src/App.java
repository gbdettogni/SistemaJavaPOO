import ClassesLeitura.LeituraPrincipal;
import ClassesRelatorio.RelatorioCasais;
import ClassesRelatorio.RelatorioPrestadores;
import ClassesRelatorio.RelatorioFinanceiro;
import ClassesSistema.Casal;
import ClassesRelatorio.RelatorioGeral;
import ClassesFinanceiro.Iterador;
import ClassesSistema.Par;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            RelatorioGeral.criaRelatorios(args[0]+"/");
            LeituraPrincipal.leituraCompleta(args[0]+"/");

            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");

            while(true){
                String linha = sc.nextLine();
                if (linha.isEmpty()){
                    break;
                }
                String[] cpfs = linha.split(", ");
                Par p = new Par(cpfs[0], cpfs[1]);
                Par.getCasaisPar().add(p);
            }

            sc.close();

            List<Casal> casais = Casal.getCasais();
            for(Casal c : casais) {
                c.processaGastoTotal();
                c.processaCasamentosConjuntos();
                //c.imprimeCasal();
            }
            Iterador.iteraParcelas();

            RelatorioCasais.ordenaListaCasais();
            RelatorioCasais.geraRelatorioCasais(args[0]+"/");
            RelatorioFinanceiro.geraRelatorioFinanceiro(args[0]+"/");
            RelatorioPrestadores.geraRelatorioPrestadores(args[0]+"/");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}