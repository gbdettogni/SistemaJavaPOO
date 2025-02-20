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

public class PlanilhaTarefas {
    static void lePlanilhaTarefas(String pasta){
        try {
            Scanner leitor = new Scanner(new File(pasta + "tarefas.csv"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
//                <id_tarefa>;<id_lar>;<id_prestador>;<data_inicio>;<prazo_entrega>;
//                <valor_prestador>;<num_parcelas>
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String  idTarefa = dados[0],
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

                Pessoa prestador = Pessoa.getById(idPrestador);
                if(prestador == null){
                    System.out.println("Erro: pessoa não existe");
                }else{
                    if(!prestador.isPrestador()){
                        prestador.setPrestador(true);
                    }
                    prestador.setValorRecebido(prestador.getValorRecebido() + valorPrestador);
                }

                NovoLar l = Casal.getLarById(idLar);
                if(l != null)
                    l.addTarefa(new Tarefa(idTarefa, dataInicio, valorPrestador, prazo, prestador, p));
                else{
                    //EXCEPTION LAR NAO EXISTE
                }
            }
            leitor.close();

        }catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }
    }
}
