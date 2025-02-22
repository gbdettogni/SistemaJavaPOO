package ClassesLeitura;

import ClassesSistema.Parcela;
import ClassesSistema.Casamento;
import ClassesSistema.Casal;
import ClassesSistema.Festa;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PlanilhaFestas {
    static void lePlanilhaFestas(String pasta) throws Exception{
        try {
            Hashtable<String,String> idsFesta = new Hashtable<>();
            Scanner leitor = new Scanner(new File(pasta + "/festas.csv"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

//              <id_festa>;<id_casamento>;<local>;<data>;<hora>;<valor_pago>;<num_parcelas>;
//              <numero_convidados>;<nome_convidado1>;<nome_convidado2>;

                String  idFesta = dados[0];
                if (idsFesta.containsKey(idFesta)){
                    throw new IllegalArgumentException("ID repetido "+idFesta+" na classe Festa.");
                }else idsFesta.put(idFesta,idFesta);

                String  idCasamento = dados[1],
                        local = dados[2];

                LocalDate dataFesta;
                LocalTime horario;
                try {
                    dataFesta = LocalDate.parse(dados[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    horario = LocalTime.parse(dados[4], DateTimeFormatter.ofPattern("HH:mm"));
                }catch (DateTimeParseException e){
                    throw new DateTimeParseException("Erro de formatação", dados[3]+dados[4], 0);
                }

                int numParcelas;
                int numConvidados;
                try {
                    numParcelas = Integer.parseInt(dados[6]);
                    numConvidados = Integer.parseInt(dados[7]);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Erro de formatação");
                }

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                double preco;
                try {
                    preco = format.parse(dados[5]).doubleValue();
                } catch (ParseException e) {
                    throw new ParseException("Erro de formatação", 0);
                }
                Parcela parcela = new Parcela(numParcelas, preco, dataFesta);

                List<String> convidados = null;
                if(numConvidados > 0)
                    convidados = new ArrayList<>(Arrays.asList(dados).subList(8, dados.length));

                Casamento c = Casal.getCasamentoById(idCasamento);
                if(c!=null){
                    c.setFesta(new Festa(local, preco, dataFesta, horario, convidados, parcela));
                }
                else {
                    throw new NullPointerException("ID(s) de Casamento " + idCasamento + " não cadastrado na Festa de ID " + idFesta + ".");
                }
            }
            leitor.close();

        }catch (IOException e) {
            System.out.println(5);

            throw new IOException("Erro de I/O");
        }
    }
}
