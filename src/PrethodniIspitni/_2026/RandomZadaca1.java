package PrethodniIspitni._2026;

import java.util.HashMap;
import java.util.Scanner;
/*na daden datum koja e cena na odmor tamu, pomalata cena pobeduva pri sporedba
mislam od kniga beshe zadachava
ne sum sig*/
public class RandomZadaca1 {


    static class Ponuda {
        String grad;
        int pari;

        Ponuda(String grad, int pari) {
            this.grad = grad;
            this.pari = pari;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        HashMap<String, Ponuda> hashmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String vlez = input.nextLine();
            String[] vlezna = vlez.split(" ");
            String datum = vlezna[0];
            Ponuda gip = new Ponuda(vlezna[1], Integer.parseInt(vlezna[2]));
            if (!hashmap.containsKey(datum)) {
                hashmap.put(datum, gip);
            } else {
                Ponuda postoechkaPonuda = hashmap.get(datum);
                int postoechkaCena = postoechkaPonuda.pari;
                int novaCena = gip.pari;
                if (novaCena > postoechkaCena) {
                    hashmap.put(datum, gip);
                }
            }
        }
        String barandatum = input.nextLine();
        if (hashmap.containsKey(barandatum)) {
            Ponuda rezultat = hashmap.get(barandatum);
            System.out.println("City: " + rezultat.grad + ", Price: " + rezultat.pari);
        } else {
            System.out.println("No offers found for this date");
        }
    }
}
