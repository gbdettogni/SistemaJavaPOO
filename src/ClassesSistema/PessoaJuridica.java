package ClassesSistema;

import java.util.Locale;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public  PessoaJuridica(String id, String nome, String telefone, String endereco, String cnpj){
        super(id,nome,telefone,endereco);
        this.cnpj = cnpj;
    }

    public void imprimeSujeito(){
        Locale l = Locale.FRANCE;
        System.out.printf(l,"Loja: %s\nEndereço: %s\nTelefone: %s\nCNPJ: %s\n",nome,endereco,telefone,cnpj);
    }
}
