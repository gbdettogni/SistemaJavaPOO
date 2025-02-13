package ClassesSistema;

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

    public abstract void imprimeSujeito();

}
