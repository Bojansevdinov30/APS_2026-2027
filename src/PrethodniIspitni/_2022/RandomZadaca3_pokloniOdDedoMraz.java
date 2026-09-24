package PrethodniIspitni._2022;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
3
loki
ulica 231 skopje usa
mila
ulica2 232 skopje aerodrom
david
ulica3 234 skopje centar
2
ulica novaUlica
ulica3 novaUlicaGolemaNaDavid
 */

public class RandomZadaca3_pokloniOdDedoMraz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, String> decinja = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String ime = br.readLine();
            String line = br.readLine();
            // String[] parts=line.split(" ");
            decinja.put(ime, line);
        }
        // System.out.println(decinja);


        int M = Integer.parseInt(br.readLine());

        Map<String, String> adresi = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String staraAdresa = line.split(" ")[0];
            String novaAdresa = line.split(" ")[1];
            adresi.put(staraAdresa, novaAdresa);
        }
        // System.out.println(adresi);

        String detence = br.readLine();

        if (!decinja.containsKey(detence)) {
            System.out.println("Nema poklon");
            return;

        } else {
            String adresa = decinja.get(detence).split(" ")[0];

            if (!adresi.containsKey(adresa)) {
                System.out.println(decinja.get(detence));
            } else {
                System.out.println(adresi.get(adresa) + " " + decinja.get(detence).split(" ")[1] + " " + decinja.get(detence).split(" ")[2] + " " + decinja.get(detence).split(" ")[3]);
            }
        }


    }
}
