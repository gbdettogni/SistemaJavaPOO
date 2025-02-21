package ClassesRelatorio;

import java.io.File;
import java.io.IOException;

public class RelatorioGeral {
    public static void criaRelatorios(String caminho) throws IOException {
        File planejamentoFile = new File(caminho + "saida/1-planejamento.csv");
        planejamentoFile.createNewFile();
        File estPrestadoresFile = new File(caminho + "saida/2-estatisticas-prestadores.csv");
        estPrestadoresFile.createNewFile();
        File estCasaisFile = new File(caminho + "saida/3-estatisticas-casais.csv");
        estCasaisFile.createNewFile();
    }
}
