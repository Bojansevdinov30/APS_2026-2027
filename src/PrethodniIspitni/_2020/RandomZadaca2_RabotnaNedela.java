package PrethodniIspitni._2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RandomZadaca2_RabotnaNedela {
    static class RabotnaNedela {

        private int[] casovi;
        private int brNedela;

        public int getCasovi() {
            int sum = 0;
            for (int cas : casovi) {
                sum += cas;
            }
            return sum;
        }

        public void setCasovi(int[] casovi) {
            this.casovi = casovi;
        }

        public int getBrNedela() {
            return brNedela;
        }

        public void setBrNedela(int brNedela) {
            this.brNedela = brNedela;
        }

        public RabotnaNedela(int[] casovi, int brNedela) {
            super();
            this.casovi = casovi;
            this.brNedela = brNedela;
        }

        @Override
        public String toString() {
            String out = "";
            int sum = 0;
            for (int cas : casovi) {
                sum += cas;
            }
            out += sum;
            return out;
        }

    }

    static class Rabotnik {

        private String ime;
        private RabotnaNedela[] nedeli;

        public String getIme() {
            return ime;
        }

        public void setIme(String ime) {
            this.ime = ime;
        }

        public RabotnaNedela[] getNedeli() {
            return nedeli;
        }

        public void setNedeli(RabotnaNedela[] nedeli) {
            this.nedeli = nedeli;
        }

        public Rabotnik(String ime, RabotnaNedela[] nedeli) {
            super();
            this.ime = ime;
            this.nedeli = nedeli;
        }

        @Override
        public String toString() {
            String out = ime + "   ";
            int vk = 0;
            for (RabotnaNedela ned : nedeli) {
                vk += ned.getCasovi();
                out += ned.toString() + "   ";
            }
            out += vk + "\n";
            return out;
        }

        public int sumNedeli() {
            int vk = 0;
            for (RabotnaNedela ned : nedeli) {
                vk += ned.getCasovi();
            }
            return vk;
        }

    }

    public static Rabotnik najvreden_rabotnik(Rabotnik[] niza) {
        Rabotnik najvreden = niza[0];
        for (Rabotnik r : niza) {
            if (r.sumNedeli() > najvreden.sumNedeli()) {
                najvreden = r;
            }
        }
        return najvreden;
    }

    public static void table(Rabotnik[] niza) {
        String out = "Rab   1   2   3   4   Vkupno\n";
        for (Rabotnik r : niza) {
            out += r;
        }
        System.out.println(out);

    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Rabotnik[] niza = new Rabotnik[n];
        for (int i = 0; i < n; i++) {
            String name = input.next();
            List<RabotnaNedela> nedeli = new ArrayList<RabotnaNedela>();

            for (int z = 0; z < 4; z++) {
                int[] casovi = new int[5];
                casovi[0] = input.nextInt();
                casovi[1] = input.nextInt();
                casovi[2] = input.nextInt();
                casovi[3] = input.nextInt();
                casovi[4] = input.nextInt();
                RabotnaNedela ned = new RabotnaNedela(casovi, z + 1);
                nedeli.add(ned);
            }
            niza[i] = new Rabotnik(name, nedeli.toArray(new RabotnaNedela[nedeli.size()]));
        }

        table(niza);
        System.out.println("NAJVREDEN RABOTNIK: " + najvreden_rabotnik(niza).getIme());

    }
}
