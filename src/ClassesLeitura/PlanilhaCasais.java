package ClassesLeitura;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ClassesSistema.Casal;
import ClassesSistema.Casamento;
import ClassesSistema.NovoLar;
import ClassesSistema.PessoaFisica;

public class PlanilhaCasais {
    static void lePlanilhaLares(String pasta){
        try {
            Scanner leitor = new Scanner(new File(pasta + "lares.csv"));    //primeiro pela planilha de lares
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
            }
            leitor.close();

        } catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }
    }

    static void lePlanilhaCasamentos(String pasta){
        try {
            Scanner leitor = new Scanner(new File(pasta + "casamentos.csv")); //depois pela planilha de casamentos
            leitor.useDelimiter("\n");
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");
//              <id_casamento>;<id1>;<id2>;<data>;<hora>;<local>

                String idCasamento = dados[0], idPessoa1 = dados[1], idPessoa2 = dados[2], local = dados[5];
                LocalDate data = LocalDate.parse(dados[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalTime hora = LocalTime.parse(dados[4], DateTimeFormatter.ofPattern("HH:mm"));

                PessoaFisica p1 = PessoaFisica.getById(idPessoa1), p2 = PessoaFisica.getById(idPessoa2);
                if (p1 != null && p2 != null) {
                    Casal c = Casal.getByPessoas(p1, p2);
                    if (c == null) {
                        c = new Casal(p1, p2);
                        c.addToList();
                    }
                    c.setCasamento(new Casamento(idCasamento, data, hora, local));
                } else {
                    //EXCEPTION PESSOA INEXISTENTE
                }
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
        }
    }
}
