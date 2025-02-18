package ClassesSistema;

import ClassesLeitura.LeituraPrincipal;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        LeituraPrincipal.lePessoas(args[0]);
        LeituraPrincipal.leCasais(args[0]);
        LeituraPrincipal.leFestas(args[0]);
        LeituraPrincipal.leTarefas(args[0]);

//        System.out.println("PESSOAS FISICAS:");
//        List<PessoaFisica> pfs = PessoaFisica.getPessoas();
//        for(Pessoa p : pfs) p.imprimeSujeito();
//
//        System.out.println("PESSOAS JURIDICAS:");
//        List<PessoaJuridica> pjs = PessoaJuridica.getPessoas();
//        for(Pessoa p : pjs) p.imprimeSujeito();
//
//        System.out.println("LOJAS:");
//        List<Loja> ls = Loja.getLojas();
//        for(Pessoa p : ls) p.imprimeSujeito();

        System.out.println("CASAIS:");
        List<Casal> casais = Casal.getCasais();
        for(Casal c : casais) c.imprimeCasal();
    }
}