package ClassesSistema;

import ClassesLeitura.LeituraPrincipal;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Pessoa> pessoas = LeituraPrincipal.lePessoa(args[0]);
        for(Pessoa p : pessoas) p.imprimeSujeito();
    }
}