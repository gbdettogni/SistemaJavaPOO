package ClassesSistema;

import java.util.ArrayList;
import java.util.List;

public class Par {
    private String cpf1;
    private String cpf2;
    public static List<Par> casais = new ArrayList<>();

    public Par(String a, String b){
        this.cpf1 = a;
        this.cpf2 = b;
    }

    public static List<Par> getCasaisPar() {
        return casais;
    }

    public String getCpf1() {
        return cpf1;
    }

    public String getCpf2() {
        return cpf2;
    }
}