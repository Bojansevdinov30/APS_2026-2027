package auds.auds7;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadaca2_Rodendeni {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        CBHT<String, Integer> birthdays = new CBHT<>(23);

        for (int i = 0; i < N; i++) {

            String[] p = bf.readLine().split("\\.");

            //доколку елементот со клуч p[1] не постои во хеш табелата
            if (birthdays.search(p[1]) == null) {
                birthdays.insert(p[1], 1);
            } else {
                //доколку елементот со клуч p[1] постои во хеш табелата
                SLLNode<MapEntry<String, Integer>> br = birthdays.search(p[1]);
                birthdays.insert(p[1], br.getElement().getValue() + 1);
            }

        }

        String month = bf.readLine();
        SLLNode<MapEntry<String, Integer>> result = birthdays.search(month);

        //доколку не постои елемент со клуч mesec
        if (result == null) {
            System.out.println("Empty");
        } else {
            System.out.println(result.getElement().getValue());
        }

    }
}
