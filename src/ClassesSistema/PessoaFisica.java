package ClassesSistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PessoaFisica extends Pessoa {
    private static List<PessoaFisica> pessoasFisicas = new ArrayList<>();
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

    public static PessoaFisica getById(String id){
        for (PessoaFisica pf : pessoasFisicas){
            if (pf.id.equals(id)) return pf;
        }
        return null;
    }

    public void imprimeSujeito(){
        Locale l = Locale.FRANCE;
        System.out.printf(l,"Nome: %s\nEndereço: %s\nTelefone: %s\nCPF: %s\nGasto Mensal: %s\n",nome,endereco,telefone,cpf,gastos);
    }

    public void addToList(){
        pessoasFisicas.add(this);
    }

    public static List<PessoaFisica> getPessoas() {
        return pessoasFisicas;
    }

    public double getPoupanca() {
        return poupanca;
    }

    public double getSalario() {
        return salario;
    }

    public double getGastos() {
        return gastos;
    }
}
