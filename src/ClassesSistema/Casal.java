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

    public static Casal getByPessoas(Pessoa p1, Pessoa p2){
        for (Casal c : casais){
            if((c.pessoa1 == p1 && c.pessoa2 == p2)||(c.pessoa1 == p2 && c.pessoa2 == p1))
                return c;
        }
        return null;
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

    public void addToList(){
        casais.add(this);
    }

    public static List<Casal> getCasais(){
        return casais;
    }

    public void imprimeCasal(){
        System.out.println("Casal:");
        pessoa1.imprimeSujeito();
        pessoa2.imprimeSujeito();
        if(lar != null){
            lar.imprimeDados();
        }
        System.out.println("----------------");
    }
}
