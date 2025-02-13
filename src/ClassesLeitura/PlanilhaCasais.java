package ClassesLeitura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ClassesSistema.Casal;
import ClassesSistema.Pessoa;
import ClassesSistema.PessoaFisica;

public class PlanilhaCasais {
    static List<Casal> _lePlanilhaCasais(String pasta){
        List<Casal> casais = new ArrayList<>();

        try {   //primeiro pela planilha de lares
            
            Scanner leitor = new Scanner(new File(pasta + "lares.csv"));
            leitor.useDelimiter("\n");
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String idLar = dados[0];
                //
                //
                //  TO DO: leitura dos lares
                //
                //
            }

            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }

        return casais;
    }
}
