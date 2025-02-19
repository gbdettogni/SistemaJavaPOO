package ClassesSistema;

import java.util.ArrayList;
import java.util.List;

public class Casal {
    private static List<Casal> casais = new ArrayList<>();
    private Casamento casamento;

    private NovoLar lar;
    private PessoaFisica pessoa1, pessoa2;

    private double poupancaConjunta;
    private double salarioConjunto;
    private double gastoConjunto;

    private double gastoTotal;

    public Casal(PessoaFisica pessoa1, PessoaFisica pessoa2){
        if (pessoa1.getNome().compareTo(pessoa2.getNome()) < 0) {   //deixando as pessoas do casal em ordem alfabética
            this.pessoa1 = pessoa1;
            this.pessoa2 = pessoa2;
        } else{
            this.pessoa1 = pessoa2;
            this.pessoa2 = pessoa1;
        }

        poupancaConjunta = pessoa1.getPoupanca() + pessoa2.getPoupanca();
        salarioConjunto = pessoa1.getSalario() + pessoa2.getSalario();
        gastoConjunto = gastoTotal = pessoa1.getGastos() + pessoa2.getGastos();

        casamento = null;
        lar = null;
    }

    public static Casal getByPessoas(Pessoa p1, Pessoa p2){
        for (Casal c : casais){
            if((c.pessoa1 == p1 && c.pessoa2 == p2)||(c.pessoa1 == p2 && c.pessoa2 == p1))
                return c;
        }
        return null;
    }
    public static Tarefa getTarefaById(String idTarefa) {
        for(Casal c : casais){
            if (c.lar != null) return c.lar.getTarefaById(idTarefa);
        }
        return null;
    }
    public static Casamento getCasamentoById(String idCasamento){
        for(Casal c : casais){
            if (c.casamento != null && c.casamento.getId().equals(idCasamento)) return c.casamento;
        }
        return null;
    }

    public static NovoLar getLarById(String idLar){
        for(Casal c : casais){
            if (c.lar != null && c.lar.getId().equals(idLar)) return c.lar;
        }
        return null;
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
        if (casamento != null){
            casamento.imprimeDados();
        }
        System.out.println("----------------");
    }
}