package ClassesLeitura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entrada {
    public static List<Par> casais = new ArrayList<>();

    public static List<Par> getCasaisPar() {
        return casais;
    }

    static void leEntradaTxt(String pasta){
        try {
            Scanner leitor = new Scanner(new File(pasta + "entrada.txt"));
            leitor.useDelimiter("\n");
            while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(", ");

                String  cpf1 = dados[0],
                        cpf2 = dados[1];

                Par p = new Par(cpf1, cpf2);

                casais.add(p);
            }
            leitor.close();

        }catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
            System.exit(0);
        }
    }
    public static class Par {
        String cpf1;
        String cpf2;
        private Par(String a, String b){
            this.cpf1 = a;
            this.cpf2 = b;
        }

        public String getCpf1() {
            return cpf1;
        }

        public String getCpf2() {
            return cpf2;
        }
    }
}
