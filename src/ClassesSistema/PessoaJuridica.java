package ClassesSistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PessoaJuridica extends Pessoa {
    private static List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
    private String cnpj;

    public  PessoaJuridica(String id, String nome, String telefone, String endereco, String cnpj){
        super(id,nome,telefone,endereco);
        this.cnpj = cnpj;
    }

    public static PessoaJuridica getById(String id){
        for(PessoaJuridica pj : pessoasJuridicas) {
            if (pj.id.equals(id)) return pj;
        }
        return null;
    }

    public void imprimeSujeito(){
        Locale l = Locale.FRANCE;
        System.out.printf(l,"Loja: %s\nEndereço: %s\nTelefone: %s\nCNPJ: %s\n",nome,endereco,telefone,cnpj);
    }

    public void addToList(){
        pessoasJuridicas.add(this);
    }

    public static List<PessoaJuridica> getPessoas() {
        return pessoasJuridicas;
    }
}
