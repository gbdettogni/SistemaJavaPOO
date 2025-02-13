package ClassesLeitura;

import ClassesSistema.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static ClassesSistema.Pessoa.getPessoas;

public class PlanilhaTarefas {
    static List<Tarefa> _lePlanilhaTarefas(String pasta){
        List<Tarefa> tarefas = new ArrayList<>();

        try {
            Scanner leitor = new Scanner(new File(pasta + "pessoas.csv"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String  idTarefa = dados[0],      //dados comuns a Pessoa
                        idLar = dados[1],
                        idPrestador = dados[2];
                DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataInicio = LocalDate.parse(dados[3], parser);

                int prazo = Integer.parseInt(dados[4]);
                int numParcelas = Integer.parseInt(dados[6]);

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

                double valorPrestador = 0;
                try {
                    valorPrestador = format.parse(dados[5]).doubleValue();
                } catch (ParseException e) {
                    System.out.println("Erro de formatação");   //caso doubles não estejam no formato certo
                }
                Parcela p = new Parcela(numParcelas);

                List<Pessoa> pessoas = getPessoas();

                for(Pessoa pre:pessoas){
                    if(pre.getId().equals(idPrestador)){
                        Tarefa tf = new Tarefa(dataInicio,valorPrestador,
                                prazo, pre, p);
                        tarefas.add(tf);
                        break;
                    }
                }
            }
            leitor.close();

        }catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }

        return tarefas;
    }
}
