package ClassesRelatorio;

import ClassesLeitura.Entrada;
import ClassesSistema.Casal;
import ClassesSistema.Loja;
import ClassesSistema.PessoaFisica;
import ClassesSistema.PessoaJuridica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class RelatorioFinanceiro {
    public static void geraRelatorioFinanceiro(String caminho) throws IOException {
        try {
            File relatorio2 = new File("saida/1-planejamento.csv");
            if (relatorio2.exists()){
                OutputStream os = new FileOutputStream(relatorio2);
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
                for (Entrada.Par p : Entrada.getCasaisPar()){
                    //System.out.printf("%s %s\n", p.getCpf1(), p.getCpf2());
                    for (Casal c : Casal.getCasais()){
                        if(c.getPessoa1().getCpf().equals(p.getCpf1()) && c.getPessoa2().getCpf().equals(p.getCpf2())){
                            pw.printf("Nome 1;Nome 2");
                            LocalDate data = c.getPagamentoMaisNovo();
                            for (int i = 0; i < c.getValores().size(); i++){
                                pw.printf(";%tm/%d", data.getMonth(), data.getYear());
                                data = data.plusMonths(1);
                            }
                            pw.println();
                            pw.printf("%s;%s", c.getPessoa1().getNome(), c.getPessoa2().getNome());
                            for(Double val : c.getValores()){
                                pw.printf(";R$ %.2f", val);
                            }
                            pw.println(";");
                        }
                    }
                }
                pw.close();
            }else System.out.println("Sou um viadinho e nao existo");

        }catch (IOException e) {
            throw new IOException();
        }
    }
}
