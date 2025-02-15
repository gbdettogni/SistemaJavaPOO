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
    static void _lePlanilhaFestas(String pasta){
        try {
            Scanner leitor = new Scanner(new File(pasta + "pessoas.csv"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String  idCompra = dados[0],      //dados comuns a Pessoa
                        idCasamento = dados[1],
                        local = dados[2];

                DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataFesta = LocalDate.parse(dados[3], parser);
                LocalTime horario = LocalTime.parse(dados[4]);

                int numParcelas = Integer.parseInt(dados[6]);
                Parcela parcela = new Parcela(numParcelas);

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

                double preco = 0;
                try {
                    preco = format.parse(dados[5]).doubleValue();
                } catch (ParseException e) {
                    System.out.println("Erro de formatação");   //caso doubles não estejam no formato certo
                }

                List<String> convidados = new ArrayList<>(Arrays.asList(dados).subList(7, dados.length));

                //Que nem nas compras, preciso dos casamentos
                //Ai tem que achar a porra do casamento certo, depois anexar ele aqui certinho
                //Se der tempo faço a leitura dos casamentos e lares
                //vc só debuga essa desgraça

                Festa ft = new Festa(local, preco, dataFesta, horario, convidados, parcela);
            }
            leitor.close();

        }catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }
    }
}
