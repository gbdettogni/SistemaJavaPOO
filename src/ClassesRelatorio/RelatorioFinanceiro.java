package ClassesRelatorio;


import ClassesSistema.Casal;
import ClassesSistema.Par;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import java.io.IOException;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;

public class RelatorioFinanceiro {
    public static void geraRelatorioFinanceiro(String caminho) throws IOException {
        try {
            File relatorio2 = new File(caminho + "saida/1-planejamento.csv");
            if (relatorio2.exists()){
                OutputStream os = new FileOutputStream(relatorio2);
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
                for (Par p : Par.getCasaisPar()){
                    boolean cadastrado = false;

                    for (Casal c : Casal.getCasais()){
                        if(c.getPessoa1().getCpf().equals(p.getCpf1()) && c.getPessoa2().getCpf().equals(p.getCpf2())){
                            cadastrado = true;
                            LocalDate data = c.getPagamentoMaisNovo();
                            if(data != null){
                                pw.printf("Nome 1;Nome 2");
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
                            else pw.printf("Casal com CPFs %s e %s não possui gastos cadastrados.\n",
                                    p.getCpf1(), p.getCpf2());
                            break;
                        }
                    } if(!cadastrado) pw.printf("Casal com CPFs %s e %s não está cadastrado.\n",
                                    p.getCpf1(), p.getCpf2());
                }
                pw.close();
            }else System.out.println("Sou um viadinho e nao existo");

        }catch (IOException e) {
            throw new IOException();
        }
    }
}
