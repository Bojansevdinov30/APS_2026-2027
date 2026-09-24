package dadeniVezbi.courses;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

public class ZadacaZaIspit_3 {
    public static void main(String[] args) throws IOException {
        CBHT<String, Integer> tabela = new CBHT<String, Integer>(300);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().trim();

        /*
         *
         * Vashiot kod tuka....
         *
         */

        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < word.length(); j++) {
                sb.append(word.charAt(j));
                SLLNode<MapEntry<String, Integer>> node = tabela.search(sb.toString());
                if (node == null) {
                    tabela.insert(sb.toString(), 1);
                } else {
                    tabela.insert(sb.toString(), node.getElement().getValue() + 1);
                }
            }
        }

        int maxFrequency = 0;
        String mostFrequent = "";

        for (int i = 0; i < 300; i++) {
            SLLNode<MapEntry<String, Integer>> node = tabela.getBuckets()[i];

            while (node != null) {
                String substring = node.getElement().getKey();
                int frequency = node.getElement().getValue();

                if (frequency > maxFrequency) {
                    mostFrequent = substring;
                    maxFrequency = frequency;
                } else if (frequency == maxFrequency && substring.length() > mostFrequent.length()) {
                    mostFrequent = substring;
                    maxFrequency = frequency;
                } else if (frequency == maxFrequency && substring.length() == mostFrequent.length() && substring.compareTo(mostFrequent) < 0) {
                    mostFrequent = substring;
                    maxFrequency = frequency;
                }
                node = node.getSucc();
            }
        }

        System.out.println(mostFrequent);
    }

}
