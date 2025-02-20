package ClassesSistema;

import java.time.LocalDate;
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

    private List<Parcela> parcelasTotais = new ArrayList<>();

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
        gastoConjunto = pessoa1.getGastos() + pessoa2.getGastos();

        gastoTotal = 0;

        casamento = null;
        lar = null;
    }

    public void processaGastoTotal(){
        Festa f = casamento.getFesta();
        if(f != null) gastoTotal += f.getPrecoPago();
        if (lar != null){
            gastoTotal += lar.getPrecoTotalTarefas();
        }
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
            if (c.lar != null) {
                Tarefa f = c.lar.getTarefaById(idTarefa);
                if(f != null) return f;
            }
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

    public void somaParcelas() {
            if(casamento != null) {
                Parcela parcela = casamento.getParcelaFesta();
                if (parcela != null) {
                    parcelasTotais.add(parcela);
                }
            }
            if(lar != null) {
                List<Parcela> parcelasTarefas$Compras = lar.getTotalParcelas();
                parcelasTotais.addAll(parcelasTarefas$Compras);
            }
        }

    public static void imprimeParcelas(){
        for (Casal c : casais){
            System.out.printf("para este casal, dos membros %s e %s, tem-se %d parcelas\n", c.pessoa1.getNome(), c.pessoa2.getNome(), c.parcelasTotais.size());
            for (Parcela p : c.parcelasTotais){
                if(p != null) {
                    System.out.printf("voce tem %d parcelas de %f reias\n", p.getNumAtual(), p.getValor());
                }
            }
        }
    }

    public static void atualizaPoupanca() {
        for (Casal c : casais){
            c.poupancaConjunta = c.poupancaConjunta*1.05 + c.salarioConjunto - c.gastoConjunto;
        }
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
        System.out.println("Gasto total: " + gastoTotal);
        System.out.println("----------------");
    }

    public boolean deduzParcelas(LocalDate dataAtual) {
        if(parcelasTotais.isEmpty()){ return true;}
        boolean taValendo = false;
        double vaiPerder = 0;

        for (Parcela p : parcelasTotais){
            //System.out.printf("Casal %s e %s deveriam pagar %f esse mes, eles ja tem %f, recebem %f, e pagam %f\n", pessoa1.getNome(), pessoa2.getNome(), p.getValor(), poupancaConjunta, salarioConjunto, gastoConjunto);
            if(dataAtual.isAfter(p.getDataInicio()) || (dataAtual.getMonthValue() == p.getDataInicio().getMonthValue() && dataAtual.getYear() == p.getDataInicio().getYear())){
                taValendo = true;
                vaiPerder += p.getValor();
                p.minus();
                //System.out.printf("faltam %d parcelas\n", p.getNumAtual());
            }
        }
        parcelasTotais.removeIf(p -> p.getNumAtual() < 1);
        if(taValendo){
            poupancaConjunta *= 1.005;
            if(dataAtual.getMonthValue() == 12){
                poupancaConjunta += 2*salarioConjunto - gastoConjunto - vaiPerder;
            }else{
                poupancaConjunta += salarioConjunto - gastoConjunto - vaiPerder;
            }
            System.out.printf("Casal %s e %s ta com esse tanto aqui esse mês: %f, está vazio: %b\n", pessoa1.getNome(), pessoa2.getNome(), poupancaConjunta, parcelasTotais.isEmpty());
        }
        return false;
    }
}