package ClassesLeitura;

import ClassesSistema.Pessoa;
import ClassesSistema.PessoaFisica;
import ClassesSistema.PessoaJuridica;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Scanner;

class PlanilhaPessoas {
    static List<Pessoa> _lePlanilhaPessoa(String pasta){
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            Scanner leitor = new Scanner(new File(pasta + "pessoas.csv"));
            leitor.useDelimiter(";");
            while (leitor.hasNextLine()) {
                BigInteger id = new BigInteger(leitor.next());
                char tipo = leitor.next().charAt(0);

                if('F' == tipo){
                    PessoaFisica pf = new PessoaFisica();
                    pf.setNome(leitor.next());
                    pf.setTelefone(leitor.next());
                    pf.setEndereco(leitor.next());
                    pf.setCpf(leitor.next());
                    DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    pf.setDataNascimento(LocalDate.parse(leitor.next(), parser));
                    pf.setPoupanca(Double.parseDouble(leitor.next()));
                    pf.setSalario(Double.parseDouble(leitor.next()));
                    pf.setGastos(Double.parseDouble(leitor.next()));
                    pessoas.add(pf);
                } else if ('J' == tipo) {
                    PessoaJuridica pj = new PessoaJuridica();
                    pj.setNome(leitor.next());
                    pj.setTelefone(leitor.next());
                    pj.setEndereco(leitor.next());
                    pj.setCnpj(leitor.next());
                    pessoas.add(pj);
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }

        return pessoas;
    }
}
