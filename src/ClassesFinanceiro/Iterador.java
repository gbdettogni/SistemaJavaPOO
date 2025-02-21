package ClassesFinanceiro;

import ClassesSistema.Casal;
import ClassesSistema.PessoaFisica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Iterador {
    public static void iteraParcelas(){
        List<Casal> casais = Casal.getCasais();
        for(Casal c : casais){
            c.somaParcelas();
        }
        LocalDate dataAtual = LocalDate.parse("01/01/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int flag = 0;
        while (true){
            flag = 1;
            for(Casal c : casais){
                if (!c.deduzParcelas(dataAtual)){
                    flag = 0;
                }
            }
            if(flag == 1){
                break;
            }
            dataAtual = dataAtual.plusMonths(1);
        }
        //Casal.imprimeParcelas();
    }
}
