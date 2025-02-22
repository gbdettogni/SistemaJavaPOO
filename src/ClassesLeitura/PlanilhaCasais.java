package ClassesLeitura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;
import java.util.Hashtable;
import java.util.Scanner;

import ClassesSistema.Casal;
import ClassesSistema.Casamento;
import ClassesSistema.NovoLar;
import ClassesSistema.PessoaFisica;

public class PlanilhaCasais {
    static void lePlanilhaLares(String pasta) throws Exception{
        try {
            Hashtable<String, String> idsLar = new Hashtable<>();
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
                    throw new NumberFormatException("Erro de formatação");
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
                    if(p1 == null) {
                        if(p2 == null){
                            throw new NullPointerException("ID(s) de Pessoa " + idPessoa1 + " " + idPessoa2 + " não cadastrado no Lar de ID " + idLar + ".");
                        }
                        throw new NullPointerException("ID(s) de Pessoa " + idPessoa1 + " não cadastrado no Lar de ID " + idLar + ".");
                    }
                    throw new NullPointerException("ID(s) de Pessoa " + idPessoa2 + " não cadastrado no Lar de ID " + idLar + ".");
                }
            }
            leitor.close();

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Erro de I/O");
        }
    }

    static void lePlanilhaCasamentos(String pasta) throws Exception {
        try {
            Scanner leitor = new Scanner(new File(pasta + "casamentos.csv")); //depois pela planilha de casamentos
            leitor.useDelimiter("\n");
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");
//              <id_casamento>;<id1>;<id2>;<data>;<hora>;<local>

                String idCasamento = dados[0], idPessoa1 = dados[1], idPessoa2 = dados[2], local = dados[5];
                LocalDate data = null;
                LocalTime hora = null;
                try{
                    data = LocalDate.parse(dados[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    hora = LocalTime.parse(dados[4], DateTimeFormatter.ofPattern("HH:mm"));
                }
                catch (DateTimeParseException e){
                    throw new DateTimeParseException("Erro de formatação", dados[3]+dados[4], 0);
                }


                PessoaFisica p1 = PessoaFisica.getById(idPessoa1), p2 = PessoaFisica.getById(idPessoa2);
                if (p1 != null && p2 != null) {
                    Casal c = Casal.getByPessoas(p1, p2);
                    if (c == null) {
                        c = new Casal(p1, p2);
                        c.addToList();
                    }
                    c.setCasamento(new Casamento(idCasamento, data, hora, local));
                } else {
                    if(p1 == null) {
                        if(p2 == null){
                            throw new NullPointerException("ID(s) de Pessoa " + idPessoa1 + " " + idPessoa2 + " não cadastrado no Casamento de ID " + idCasamento + ".");
                        }
                        throw new NullPointerException("ID(s) de Pessoa " + idPessoa1 + " não cadastrado no Casamento de ID " + idCasamento + ".");
                    }
                    throw new NullPointerException("ID(s) de Pessoa " + idPessoa2 + " não cadastrado no Casamento de ID " + idCasamento + ".");
                }
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Erro de I/O");
        }
    }
}
