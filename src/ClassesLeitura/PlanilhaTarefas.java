package ClassesLeitura;

import ClassesSistema.Pessoa;
import ClassesSistema.Parcela;
import ClassesSistema.NovoLar;
import ClassesSistema.Casal;
import ClassesSistema.Tarefa;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class PlanilhaTarefas {
    static void lePlanilhaTarefas(String pasta) throws Exception{
        try {
            Hashtable<String,String> idsTarefa = new Hashtable<>();
            Scanner leitor = new Scanner(new File(pasta + "/tarefas.csv"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
//                <id_tarefa>;<id_lar>;<id_prestador>;<data_inicio>;<prazo_entrega>;
//                <valor_prestador>;<num_parcelas>
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String  idTarefa = dados[0];
                if (idsTarefa.containsKey(idTarefa)){
                    throw new IllegalArgumentException("ID repetido "+idTarefa+" na classe Tarefa.");
                }else idsTarefa.put(idTarefa,idTarefa);

                String  idLar = dados[1],
                        idPrestador = dados[2];

                DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataInicio;
                try {
                    dataInicio = LocalDate.parse(dados[3], parser);
                }catch (DateTimeParseException e){
                    throw new DateTimeParseException("Erro de formatação", dados[3], 0);
                }

                int prazo;
                int numParcelas;

                try {
                    prazo = Integer.parseInt(dados[4]);
                    numParcelas = Integer.parseInt(dados[6]);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Erro de formatação");
                }

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                double valorPrestador;
                try {
                    valorPrestador = format.parse(dados[5]).doubleValue();
                } catch (ParseException e) {
                    throw new ParseException("Erro de formatação",0);  //caso doubles não estejam no formato certo
                }


                Pessoa prestador = Pessoa.getById(idPrestador);
                if(prestador == null){
                    throw new NullPointerException("ID(s) de Prestador de Serviço "+idPrestador+" não cadastrado na Tarefa de ID "+idTarefa+".");
                }else{
                    if(!prestador.isPrestador()){
                        prestador.setPrestador(true);
                    }
                    prestador.setValorRecebido(prestador.getValorRecebido() + valorPrestador);
                }
                Parcela p = new Parcela(numParcelas, valorPrestador, dataInicio);

                NovoLar l = Casal.getLarById(idLar);
                if(l != null)
                    l.addTarefa(new Tarefa(idTarefa, dataInicio, valorPrestador, prazo, prestador, p));
                else{
                    throw new NullPointerException("ID(s) de Lar " + idLar+ " não cadastrado na tarefa de ID " + idTarefa + ".");
                }
            }
            leitor.close();

        }catch (IOException e) {
            System.out.println(7);

            throw new IOException("Erro de I/O tarefas");

        }
    }
}
