package ClassesRelatorio;

import ClassesSistema.Loja;
import ClassesSistema.Pessoa;
import ClassesSistema.PessoaFisica;
import ClassesSistema.PessoaJuridica;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Comparator;


public class RelatorioPrestadores {
    public static void geraRelatorioPrestadores(String caminho) throws IOException {
        try {
            File relatorio2 = new File("saida/2-estatisticas-prestadores.csv");
            if (relatorio2.exists()){
                OutputStream os = new FileOutputStream(relatorio2);
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
                List<PessoaFisica> prestadoresPF = RelatorioPrestadores.ordenaListaPrestadoresPF();
                for(PessoaFisica pf : prestadoresPF){
                    pw.printf(Locale.FRANCE, "PF;%s;R$ %.2f\n",
                            pf.getNome(),
                            pf.getValorRecebido());
                }
                List<PessoaJuridica> pjs = PessoaJuridica.getPessoas();
                Collections.sort(pjs, new OrdenadorPrestadores());
                for(PessoaJuridica pj : pjs){
                    pw.printf(Locale.FRANCE, "PJ;%s;R$ %.2f\n",
                            pj.getNome(),
                            pj.getValorRecebido());
                }
                List<Loja> lojas = Loja.getLojas();
                Collections.sort(lojas, new OrdenadorPrestadores());
                for (Loja l : lojas){
                    pw.printf(Locale.FRANCE, "Loja;%s;R$ %.2f\n",
                            l.getNome(),
                            l.getValorRecebido());
                }
                pw.close();
            }else System.out.println("Sou um viadinho e nao existo");

        }catch (IOException e){
            throw new IOException();
        }
    }

    public static List<PessoaFisica> ordenaListaPrestadoresPF(){
        List<PessoaFisica> pessoasFisicas = PessoaFisica.getPessoas();
        List<PessoaFisica> prestadoresFisicos = new ArrayList<>();
        for(PessoaFisica pf : pessoasFisicas){
            if (pf.isPrestador()) prestadoresFisicos.add(pf);
        }
        Collections.sort(prestadoresFisicos, new OrdenadorPrestadores());
        return prestadoresFisicos;
    }
}

class OrdenadorPrestadores implements Comparator<Pessoa>{
    @Override
    public int compare(Pessoa a, Pessoa b){
        if(b.getValorRecebido() - a.getValorRecebido() > 0) return 1;
        else if(b.getValorRecebido() - a.getValorRecebido() < 0) return -1;
        else {
            String nomeA = a.getNome(), nomeB = b.getNome();
            return nomeA.compareToIgnoreCase(nomeB);
        }
    }
}
