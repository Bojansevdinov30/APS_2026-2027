package PrethodniIspitni._2021;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RandomZadaca1_Pasosi {
    static class Gragjanin {
        private String imePrezime;
        private int lKarta;
        private int pasos;
        private int vozacka;

        public String getImePrezime() {
            return imePrezime;
        }

        public int getlKarta() {
            return lKarta;
        }

        public int getPasos() {
            return pasos;
        }

        public int getVozacka() {
            return vozacka;
        }

        public Gragjanin(String imePrezime, int lKarta, int pasos, int vozacka) {
            this.imePrezime = imePrezime;
            this.lKarta = lKarta;
            this.pasos = pasos;
            this.vozacka = vozacka;
        }
    }

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        int N = Integer.parseInt(br.nextLine());

        Queue<Gragjanin> lkarti = new LinkedList<Gragjanin>();
        Queue<Gragjanin> pasosi = new LinkedList<Gragjanin>();
        Queue<Gragjanin> vozacki = new LinkedList<Gragjanin>();
        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);
            if (covek.getlKarta() == 1) lkarti.add(covek);
            else if (covek.getPasos() == 1) pasosi.add(covek);
            else vozacki.add(covek);
        }
        while (lkarti.peek() != null) {
            Gragjanin covek = lkarti.poll();
            if (covek.getPasos() == 1) pasosi.add(covek);
            else if (covek.getVozacka() == 1) vozacki.add(covek);
            else System.out.println(covek.getImePrezime());
        }
        while (pasosi.peek() != null) {
            Gragjanin covek = pasosi.poll();
            if (covek.getVozacka() == 1) vozacki.add(covek);
            else System.out.println(covek.getImePrezime());
        }
        while (vozacki.peek() != null) {
            Gragjanin covek = vozacki.poll();
            System.out.println(covek.getImePrezime());
        }
    }
}
