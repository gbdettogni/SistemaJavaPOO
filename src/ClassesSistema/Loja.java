package ClassesSistema;

import java.util.ArrayList;
import java.util.List;

public class Loja extends PessoaJuridica {
    private static List<Loja> lojas = new ArrayList<>();
    public Loja(String id, String nome, String telefone, String endereco, String cnpj){
        super(id,nome,telefone,endereco,cnpj);
    }

    @Override
    public void addToList(){
        lojas.add(this);
    }

    public static List<Loja> getLojas(){return lojas;}
}
