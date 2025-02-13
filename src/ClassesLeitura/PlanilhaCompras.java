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

import static ClassesSistema.Pessoa.getPessoas;

public class PlanilhaCompras {
    static void _lePlanilhaCompras(String pasta){
        try {
            Scanner leitor = new Scanner(new File(pasta + "pessoas.csv"));
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
                Parcela parcela = new Parcela(numParcelas);

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

                double preco = 0;
                try {
                    preco = format.parse(dados[5]).doubleValue();
                } catch (ParseException e) {
                    System.out.println("Erro de formatação");   //caso doubles não estejam no formato certo
                }

                List<Pessoa> pessoas = getPessoas();
                //as tarefas devem ser buscadas por cada lar, mas como a estrutura dele
                //ainda nao foi feita, vou simular como seria, sem necessariamente endereçar uma tarefa

                for(Pessoa pre:pessoas){
                    if(pre.getClass() == Loja.class & pre.getId().equals(idLoja)){
                        Compra cp = new Compra(nome, qtd, preco, (Loja)pre, parcela);
                        //tarefa.addCompra(cp);
                        //reiterando, precisa buscar essa bomba por id
                        break;
                    }
                }
            }
            leitor.close();

        }catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }
    }
}
