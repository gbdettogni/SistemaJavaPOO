package ClassesLeitura;

import ClassesSistema.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InvalidClassException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;



public class PlanilhaCompras {
    static void lePlanilhaCompras(String pasta) throws Exception{
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

                int qtd = 0;
                int numParcelas = 0;
                try {
                    qtd = Integer.parseInt(dados[4]);
                    numParcelas = Integer.parseInt(dados[6]);
                }catch (NumberFormatException e){
                    throw new NumberFormatException("Erro de formatação");
                }

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                double preco = 0;
                try {
                    preco = format.parse(dados[5]).doubleValue();
                } catch (ParseException e) {
                    throw new ParseException("Erro de formatação",0);   //caso doubles não estejam no formato certo
                }

                Tarefa tarefa = Casal.getTarefaById(idTarefa);//.getTarefaById(idTarefa);



                Loja loja = Loja.getById(idLoja);
                if(loja != null){
                    loja.setValorRecebido(loja.getValorRecebido() + (preco * qtd));
                }else{                                                                      //nao tem loja com ID
                    PessoaJuridica naoLoja = PessoaJuridica.getById(idLoja);
                    if(naoLoja != null) throw new InvalidClassException("ID " + idLoja + "da compra de ID " + idCompra + "não se refere a uma loja, mas a uma PJ.");    //tem PJ que nao é loja

                    else throw new NullPointerException("ID(s) de Loja " + idLoja + " não cadastrado na Compra de ID " + idCompra +".");    //nao tem ninguem com o ID
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
            throw new FileNotFoundException("Erro de I/O");

        }
    }
}
