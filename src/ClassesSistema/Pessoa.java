package ClassesSistema;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    private String id;
    private String nome;
    private String telefone;
    private String endereco;

    private boolean prestador;
    private double valorRecebido;

    public Pessoa(String id, String nome, String telefone, String endereco, boolean prestador){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.prestador = prestador;
        valorRecebido = 0;
    }

    public boolean isPrestador() {
        return prestador;
    }

    public void setPrestador(boolean prestador) {
        this.prestador = prestador;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public static Pessoa getById(String id){
        PessoaFisica pf = PessoaFisica.getById(id);
        if(pf != null) return pf;
        return PessoaJuridica.getById(id);
    }

    public abstract void imprimeSujeito();
}
