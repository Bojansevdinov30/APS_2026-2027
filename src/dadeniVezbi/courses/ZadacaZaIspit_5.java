package dadeniVezbi.courses;

import dataStructures.OBHT;

import java.io.*;
import java.util.Objects;

public class ZadacaZaIspit_5 {
    static class Zbor implements Comparable<Zbor> {
        String zbor;

        public Zbor(String zbor) {
            this.zbor = zbor;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Zbor zbor1 = (Zbor) o;
            return Objects.equals(zbor, zbor1.zbor);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(zbor);
        }

        @Override
        public String toString() {
            return zbor;
        }

        @Override
        public int compareTo(Zbor arg0) {
            return zbor.compareTo(arg0.zbor);
        }
    }


    public static void main(String[] args) throws IOException {
        OBHT<Zbor, String> tabela;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //---Vie odluchete za goleminata na hesh tabelata----
        tabela = new OBHT<Zbor, String>(2 * N + 1);
        /*
         *
         * Vashiot kod tuka....
         *
         */
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            tabela.insert(new Zbor(word), word);
        }

        String text = br.readLine();

        text = text.replaceAll("[.,!?]", "");
        text = text.toLowerCase();
        String[] words = text.split(" ");

        boolean valid = true;

        if (words.length > 1) {
            for (String word : words) {
                Zbor z = new Zbor(word);
                if (tabela.search(z) == OBHT.NONE) {
                    System.out.println(z.toString());
                    valid = false;
                }
            }
        }

        if (valid) {
            System.out.println("Bravo");
        }
    }
}
