package ClassesSistema;

import java.time.LocalDate;
import java.util.Locale;

public class PessoaFisica extends Pessoa {
    private LocalDate dataNascimento;
    private String cpf;
    private double poupanca;
    private double salario;
    private double gastos;

    public PessoaFisica(String id, String nome, String telefone, String endereco,
                        LocalDate dataNascimento, String cpf, double poupanca, double salario, double gastos){
        super(id,nome,telefone,endereco);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.poupanca = poupanca;
        this.salario = salario;
        this.gastos = gastos;
    }

    public void imprimeSujeito(){
        Locale l = Locale.FRANCE;
        System.out.printf(l,"Nome: %s\nEndereço: %s\nTelefone: %s\nCPF: %s\n",nome,endereco,telefone,cpf);
    }
}
