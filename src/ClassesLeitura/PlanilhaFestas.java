package ClassesLeitura;

import ClassesSistema.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PlanilhaFestas {
    static void lePlanilhaFestas(String pasta) throws Exception{
        try {
            Scanner leitor = new Scanner(new File(pasta + "festas.csv"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

//              <id_festa>;<id_casamento>;<local>;<data>;<hora>;<valor_pago>;<num_parcelas>;
//              <numero_convidados>;<nome_convidado1>;<nome_convidado2>;

                String  idFesta = dados[0],
                        idCasamento = dados[1],
                        local = dados[2];

                LocalDate dataFesta = LocalDate.parse(dados[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalTime horario = LocalTime.parse(dados[4], DateTimeFormatter.ofPattern("HH:mm"));

                int numParcelas = Integer.parseInt(dados[6]);

                int numConvidados = Integer.parseInt(dados[7]);

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                double preco = 0;
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

        }catch (FileNotFoundException e) {
            throw new FileNotFoundException("Erro de I/0");
        }
    }
}
