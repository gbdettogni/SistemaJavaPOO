package ClassesSistema;

import java.math.BigInteger;

public abstract class Pessoa {
    protected BigInteger id;
    protected String nome;
    protected String telefone;
    protected String endereco;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
