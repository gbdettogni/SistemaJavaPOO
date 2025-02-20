package ClassesSistema;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    protected String id;
    protected String nome;
    protected String telefone;
    protected String endereco;

    public Pessoa(String id, String nome, String telefone, String endereco){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Pessoa getById(String id){
        PessoaFisica pf = PessoaFisica.getById(id);
        if(pf != null) return pf;
        return PessoaJuridica.getById(id);
    }

    public abstract void imprimeSujeito();
}
