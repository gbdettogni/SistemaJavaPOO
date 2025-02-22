package ClassesLeitura;

import ClassesSistema.PessoaFisica;
import ClassesSistema.PessoaJuridica;
import ClassesSistema.Loja;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


class PlanilhaPessoas {
    static void lePlanilhaPessoas(String pasta) throws Exception{
        try {
            Scanner leitor = new Scanner(new File(pasta + "pessoas.csv"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String  id = dados[0],      //dados comuns a Pessoa
                        tipo = dados[1],
                        nome = dados[2],
                        telefone = dados[3],
                        endereco = dados[4];

                if(tipo.equals("F")){       //dados adicionais PessoaFísica
                    String cpf = dados[5];

                    DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataNascimento = LocalDate.parse(dados[6], parser);

                    NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                    double poupanca=0, salario=0, gastos=0;
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
                else if (tipo.equals("J")) {  //dados adicionais PessoaJuridica
                    String cnpj = dados[5];

                    PessoaJuridica pj = new PessoaJuridica(id,nome,telefone,endereco,cnpj);
                    pj.addToList();
                }
                else if (tipo.equals("L")) {  //dados adicionais Loja
                    String cnpj = dados[5];

                    Loja l = new Loja(id,nome,telefone,endereco,cnpj);
                    l.addToList();
                }
            }
            leitor.close();

        }catch (FileNotFoundException e) {
            throw new FileNotFoundException("Erro de I/O");
        }
    }
}
