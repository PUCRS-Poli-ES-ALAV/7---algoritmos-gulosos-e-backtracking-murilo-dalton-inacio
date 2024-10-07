import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class escalonamentoDeIntervalos{

    public static void main(String[] args) {
        /*
        int[] s = {4, 6, 13, 4, 2, 6, 7, 9, 1, 3, 9};
        int[] f = {8, 7, 14, 5, 4, 9, 10, 11, 6, 13, 12};
        */

        int[] s = {5, 3, 8, 2, 7, 10, 1, 9, 6, 4, 11};
        int[] f = {9, 4, 12, 5, 8, 13, 3, 11, 7, 6, 14};
        int n = s.length;

        // Criando um array de objetos Interval que contém os inícios e fins
        Intervalo[] intervalos = new Intervalo[n];
        for (int i = 0; i < n; i++) {
            intervalos[i] = new Intervalo(s[i], f[i]);
        }

        // Ordenando os intervalos com base no tempo de fim (f)
        Arrays.sort(intervalos, Comparator.comparingInt(intervalo -> intervalo.f));

        // Exibindo os intervalos ordenados
        //System.out.println("Intervalos ordenados por tempo de fim (f):");
        //for (Intervalo intervalo : intervalos) {
         //   System.out.println("Start: " + intervalo.s + ", End: " + intervalo.f);
        //}

        ArrayList<Intervalo> fIntervalos = new ArrayList(n);

        fIntervalos.add(intervalos[0]);
        for (int i = 1; i < n; i++) {
    
            if (intervalos[i].s > fIntervalos.getLast().f ) fIntervalos.add(intervalos[i]);
        }
        for (Intervalo intervalo : fIntervalos) {
            System.out.println("Start: " + intervalo.s + ", End: " + intervalo.f);
        }

        



    }

    // Classe para representar um intervalo
    static class Intervalo {
        int s, f;

        Intervalo(int s, int f) {
            this.s = s;
            this.f = f;
        }
    }
}