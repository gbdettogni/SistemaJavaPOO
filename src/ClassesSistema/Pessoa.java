package ClassesSistema;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    static List<Pessoa> pessoas = new ArrayList<>();

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

    public static void addPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public static List<Pessoa> getPessoas() {
        return pessoas;
    }

    public String getId() {
        return id;
    }

    public abstract void imprimeSujeito();

}
