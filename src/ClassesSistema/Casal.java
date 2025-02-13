package ClassesSistema;

import java.util.ArrayList;
import java.util.List;

public class Casal {
    private static List<Casal> casais = new ArrayList<>(); 
    private Casamento casamento;
    private Festa festa;
    private NovoLar lar;
    private Pessoa pessoa1, pessoa2;

    public Casal(Pessoa pessoa1, Pessoa pessoa2){
        this.pessoa1 = pessoa1;
        this.pessoa2 = pessoa2;
        casamento = null;
        festa = null;
        lar = null;
    }

    public void setFesta(Festa festa){
        this.festa = festa;
    }

    public void setCasamento(Casamento casamento){
        this.casamento = casamento;
    }

    public void setNovoLar(NovoLar lar){
        this.lar = lar;
    }

    public void addCasal(){
        casais.add(this);
    }

    public static List<Casal> getCasaisList(){
        return casais;
    }
}
