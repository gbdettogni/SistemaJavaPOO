package ClassesSistema;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa {
    private LocalDate dataNascimento;
    private String cpf;
    private double poupanca;
    private double salario;
    private double gastos;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setPoupanca(double poupanca) {
        this.poupanca = poupanca;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public static void imprimeSujeito(PessoaFisica pf){
        System.out.println(pf.cpf);
        System.out.println(pf.gastos);
        System.out.println(pf.nome);
        System.out.println(pf.endereco);
        System.out.println(pf.salario);
        System.out.println(pf.telefone);
        System.out.println(pf.dataNascimento);
    }
}
