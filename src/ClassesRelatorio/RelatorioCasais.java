package ClassesRelatorio;

import ClassesSistema.Casal;

import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


public class RelatorioCasais {
    public static void ordenaListaCasais(){
        List<Casal> casais = Casal.getCasais();
        Collections.sort(casais, new ordenadorCasais());
    }

    public static void geraRelatorioCasais(String caminho) throws IOException{
        try{
            File relatorio3 = new File(caminho + "saida/3-estatisticas-casais.csv");
            System.out.println(relatorio3.canWrite());

            OutputStream os = new FileOutputStream(relatorio3);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
            List<Casal> casais = Casal.getCasais();
            for(Casal c : casais){
                pw.printf(Locale.FRANCE,"%s;%s;R$ %.2f;%d\n",
                        c.getPessoa1().getNome(),
                        c.getPessoa2().getNome(),
                        c.getGastoTotal(),
                        0);
            }
            pw.close();
        } catch (IOException e) {
            throw new IOException();
            }
        }
}

class ordenadorCasais implements Comparator<Casal>{
    @Override
    public int compare(Casal a, Casal b){
        if(a.getGastoTotal() - b.getGastoTotal() > 0) return 1;
        else if(a.getGastoTotal() - b.getGastoTotal() < 0) return -1;
        else{
            String nome1A = a.getPessoa1().getNome();
            String nome1B = b.getPessoa1().getNome();
            return nome1A.compareToIgnoreCase(nome1B);
        }
    }
}