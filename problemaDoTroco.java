
import java.util.ArrayList;
import java.util.Collections;



/*Suponha que tenhamos disponíveis moedas com certos valores (por exemplo, de 100, 25, 10, 5 e 1). O problema do troco consiste criar um algoritmo que para conseguir obter um determinado valor com o menor número de moedas ´ possível. Por exemplo, para “dar um troco” de R$2,89, a melhor solução, isto é, o menor número de moedas possível para obter o valor consiste em 10 moedas: 2 de valor 100, 3 de valor 25, 1 de valor 10 e 4 de valor 1.

Objetivo: contrua um algorítmo que recebe a lista das moedas disponíveis e um valor, e retorna uma lista com a menor quantidade de moedas para este troco;
Defina uma assinatura adequada para este método;
Utiliza uma abordagem gulosa (se puder);
Contabilize e exiba o número de iterações para cada caso de teste*/

public class problemaDoTroco{

    public static int count;

    public static void main(String[] args) {
        System.out.println("hello world");
        count = 0;
        ArrayList<Integer> moedas = new ArrayList<>();
        moedas.add(100);
        moedas.add(100);
        moedas.add(10);
        moedas.add(25);
        moedas.add(25);
        moedas.add(25);
        moedas.add(1);
        moedas.add(1);
        moedas.add(1);
        moedas.add(1);

        ArrayList<Integer> troco = troco(moedas, 100);

        System.out.println("Moedas usadas para o troco:");
        for (int x : troco) {
            System.out.println(x);
        }
        System.out.println("Número de iterações: " + count);
    }

    public static ArrayList<Integer> troco(ArrayList<Integer> lista, int valor) {
        ArrayList<Integer> troco = new ArrayList<>();
        Collections.sort(lista, Collections.reverseOrder()); // Ordena as moedas em ordem decrescente
        
        while (valor > 0) {
            boolean encontrouMoeda = false;
            for (int i = 0; i < lista.size(); i++) {
                int moeda = lista.get(i);
                if (valor >= moeda) {
                    troco.add(moeda);
                    valor -= moeda;
                    count++;
                    lista.remove(i); // Remove a moeda da lista
                    encontrouMoeda = true;
                    break;
                }
            }
            if (!encontrouMoeda) {
                // Caso o valor não possa ser trocado com as moedas restantes
                System.out.println("Não é possível dar o troco exato com as moedas disponíveis.");
                break;
            }
        }

        return troco;
    }
}