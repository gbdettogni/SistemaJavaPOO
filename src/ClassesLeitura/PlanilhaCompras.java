package ClassesLeitura;

import ClassesSistema.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;



public class PlanilhaCompras {
    static void lePlanilhaCompras(String pasta){
        try {
            Scanner leitor = new Scanner(new File(pasta + "compras.csv"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String  idCompra = dados[0],      //dados comuns a Pessoa
                        idTarefa = dados[1],
                        idLoja = dados[2],
                        nome = dados[3];

                int qtd = Integer.parseInt(dados[4]);
                int numParcelas = Integer.parseInt(dados[6]);

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

                double preco = 0;
                try {
                    preco = format.parse(dados[5]).doubleValue();
                } catch (ParseException e) {
                    System.out.println("Erro de formatação");   //caso doubles não estejam no formato certo
                }

                Tarefa tarefa = Casal.getTarefaById(idTarefa);//.getTarefaById(idTarefa);
                Loja loja = Loja.getById(idLoja);
                if(loja != null){
                    loja.setValorRecebido(loja.getValorRecebido() + (preco * qtd));
                }


                LocalDate data = null;
                if (tarefa != null) {
                    data = tarefa.getData();
                }
                Parcela parcela = new Parcela(numParcelas, preco* qtd, data);

                if(tarefa!=null)
                    tarefa.setCompra(new Compra(nome, qtd, preco, loja, parcela));
            }
            leitor.close();

        }catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }
    }
}
