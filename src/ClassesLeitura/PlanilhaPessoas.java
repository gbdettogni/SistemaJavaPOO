package ClassesLeitura;

import ClassesSistema.PessoaFisica;
import ClassesSistema.PessoaJuridica;
import ClassesSistema.Loja;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;


class PlanilhaPessoas {
    static void lePlanilhaPessoas(String pasta) throws Exception{
        try {
            Hashtable<String,String>    idsPessoa = new Hashtable<>(),
                                        cpfs = new Hashtable<>(),
                                        cnpjs = new Hashtable<>();

            Scanner leitor = new Scanner(new File(pasta + "pessoas.csv"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String  id = dados[0];
                if (idsPessoa.containsKey(id)){
                    throw new IllegalArgumentException("ID repetido "+id+" na classe Pessoa.");
                }else idsPessoa.put(id,id);

                String tipo = dados[1],     //dados comuns a Pessoa
                        nome = dados[2],
                        telefone = dados[3],
                        endereco = dados[4];

                if(tipo.equals("F")){       //dados adicionais PessoaFísica
                    String cpf = dados[5];
                    if (cpfs.containsKey(cpf)){
                        throw new IllegalArgumentException("O CPF "+cpf+" da Pessoa " + id + " é repetido.");
                    }else cpfs.put(cpf,cpf);

                    DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataNascimento;
                    try {
                        dataNascimento = LocalDate.parse(dados[6], parser);
                    }catch (DateTimeParseException e){
                        throw new DateTimeParseException("Erro de formatação", dados[6], 0);
                    }

                    NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                    double poupanca, salario, gastos;
                    try {
                        poupanca = format.parse(dados[7]).doubleValue();
                        salario = format.parse(dados[8]).doubleValue();
                        gastos = format.parse(dados[9]).doubleValue();
                    } catch (ParseException e) {
                        throw new ParseException("Erro de formatação", 0);   //caso doubles não estejam no formato certo
                    }

                    PessoaFisica pf = new PessoaFisica(id,nome,telefone,endereco,
                                    dataNascimento,cpf,poupanca,salario,gastos);

                    pf.addToList();
                }
                else{
                    String cnpj = dados[5];
                    if (cnpjs.containsKey(cnpj)){
                        throw new IllegalArgumentException("O CNPJ "+cnpj+" da Pessoa " + id + " é repetido.");
                    }else cnpjs.put(cnpj,cnpj);

                    if (tipo.equals("J")) {
                        PessoaJuridica pj = new PessoaJuridica(id,nome,telefone,endereco,cnpj);
                        pj.addToList();
                    }
                    else if (tipo.equals("L")) {
                        Loja l = new Loja(id,nome,telefone,endereco,cnpj);
                        l.addToList();
                    }
                }
            }
            leitor.close();

        }catch (IOException e) {
            throw new IOException("Erro de I/O");
        }
    }
}
