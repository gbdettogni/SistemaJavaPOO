package ClassesLeitura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ClassesSistema.Casal;
import ClassesSistema.NovoLar;
import ClassesSistema.PessoaFisica;

public class PlanilhaCasais {
    static void _lePlanilhaCasais(String pasta){
        try {   //primeiro pela planilha de lares
            
            Scanner leitor = new Scanner(new File(pasta + "lares.csv"));
            leitor.useDelimiter("\n");
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String idLar = dados[0], idPessoa1 = dados[1], idPessoa2 = dados[2];
                String rua = dados[3], complemento = dados[5];
                int numero = 0;
                try {
                    numero = Integer.parseInt(dados[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Erro de formatação");
                }

                PessoaFisica p1 = PessoaFisica.getById(idPessoa1), p2 = PessoaFisica.getById(idPessoa2);
                if (p1 != null && p2 != null){
                    Casal c = Casal.getByPessoas(p1,p2);
                    if(c == null){
                        c = new Casal(p1,p2);
                        c.addToList();
                    }
                    c.setNovoLar(new NovoLar(idLar, rua, numero, complemento));
                }
                else{
                    //EXCEPTION PESSOA INEXISTENTE
                }
                //
                //
                //  TO DO: leitura dos lares
                //
                //
            }

            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }
    }
}
