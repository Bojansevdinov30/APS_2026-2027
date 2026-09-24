package labs.Lab7;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

public class Zadaca4 {
    static class Lek {
        String ime;
        int pozitiven;
        int cena;
        int zaliha;

        Lek(String ime, int pozitiven, int cena, int zaliha) {
            this.ime = ime;
            this.pozitiven = pozitiven;
            this.cena = cena;
            this.zaliha = zaliha;
        }

        public String getIme() {
            return ime;
        }

        public void setIme(String ime) {
            this.ime = ime;
        }

        public int isPozitiven() {
            return pozitiven;
        }

        public void setPozitiven(int pozitiven) {
            this.pozitiven = pozitiven;
        }

        public int getCena() {
            return cena;
        }

        public void setCena(int cena) {
            this.cena = cena;
        }

        public int getZaliha() {
            return zaliha;
        }

        public void setZaliha(int zaliha) {
            this.zaliha = zaliha;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Lek lek = (Lek) o;
            return pozitiven == lek.pozitiven && cena == lek.cena && zaliha == lek.zaliha && ime.equals(lek.ime);
        }

        @Override
        public String toString() {
            if (pozitiven == 1) {
                return ime + '\n' + "POZ\n" + cena + '\n' + zaliha;

            } else {
                return ime + '\n' + "NEG" + '\n' + cena + '\n' + zaliha;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        CBHT<String, Lek> tabela = new CBHT<>(2 * N);

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] pom = line.split(" ");
            Lek l = new Lek(pom[0], Integer.parseInt(pom[1]), Integer.parseInt(pom[2]), Integer.parseInt(pom[3]));

            tabela.insert(pom[0], l);
        }

        String obid = br.readLine().toUpperCase();

        while (!obid.equals("KRAJ")) {
            SLLNode<MapEntry<String, Lek>> ime = tabela.search(obid);
            int naracani = Integer.parseInt(br.readLine());

            if (ime == null) {
                System.out.println("Nema takov lek");
                obid = br.readLine().toUpperCase();
            } else {
                System.out.println(ime.element.value.toString());
                if (ime.element.value.zaliha - naracani > 0) {
                    ime.element.value.setZaliha(ime.element.value.getZaliha() - naracani);
                    tabela.insert(obid, ime.element.value);
                    System.out.println("Napravena naracka");
                    obid = br.readLine().toUpperCase();
                } else {
                    System.out.println("Nema dovolno lekovi");
                    obid = br.readLine().toUpperCase();

                }
            }

        }
    }

}
