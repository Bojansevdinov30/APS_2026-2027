package auds.auds0;

import java.util.Scanner;

// Primer 1 - OOP vo Java
public class Auds0_ex1 {

    static class Zadaca {
        private String opis;
        private int casovi;
        private boolean status;

        public Zadaca() {
        }

        public Zadaca(String opis, int casovi) {
            this.opis = opis;
            this.casovi = casovi;
        }

        public String getOpis() {
            return opis;
        }

        public void setOpis(String opis) {
            this.opis = opis;
        }

        public int getCasovi() {
            return casovi;
        }

        public void setCasovi(int casovi) {
            this.casovi = casovi;
        }

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Opis: " + opis + "\ncasovi: " + casovi + "\nstatus: "
                    + (status ? "aktivna" : "zaavrsena");
        }
    }

    static class Vraboten {
        private static double BOD = 50;
        private String ime;
        private String prezime;
        private double plata;
        private int staz;
        private int brBod;
        private Zadaca[] zadaci; // nema pokazuvaci vo Java
        private int brZadaci;

        public Vraboten() {
            zadaci = new Zadaca[10];
            brZadaci = 0;
        }

        public Vraboten(String ime, String prezime, int staz, int brBod) {
            this(); // povikuva konstruktor bez argumenti, ovoj gore
            this.ime = ime;
            this.prezime = prezime;
            this.staz = staz;
            this.brBod = brBod;
        }

        public static double getBOD() {
            return BOD;
        }

        public static void setBOD(double BOD) {
            Vraboten.BOD = BOD;
        }

        public String getIme() {
            return ime;
        }

        public void setIme(String ime) {
            this.ime = ime;
        }

        public String getPrezime() {
            return prezime;
        }

        public void setPrezime(String prezime) {
            this.prezime = prezime;
        }

        public double getPlata() {
            return plata;
        }

        public void setPlata(double plata) {
            this.plata = plata;
        }

        public int getStaz() {
            return staz;
        }

        public void setStaz(int staz) {
            this.staz = staz;
        }

        public int getBrBod() {
            return brBod;
        }

        public void setBrBod(int brBod) {
            this.brBod = brBod;
        }

        public Zadaca[] getZadaci() {
            return zadaci;
        }

        public void setZadaci(Zadaca[] zadaci) {
            this.zadaci = zadaci;
        }

        public int getBrZadaci() {
            return brZadaci;
        }

        public void setBrZadaci(int brZadaci) {
            this.brZadaci = brZadaci;
        }

        public void dodadiZadaca(Zadaca z) {
            if (brZadaci == 10) {
                System.out.println("Ne moze da se dodade zadaca");
            } else {
                zadaci[brZadaci++] = z;
            }
        }

        public double procentZavrseni() {
            int br = 0;
            for (int i = 0; i < brZadaci; i++) {
                if (zadaci[i].getStatus()) {
                    br++;
                }
            }
            return (double) br / brZadaci;
        }

        public int vkupnoCasovi() {
            int suma = 0;
            for (int i = 0; i < brZadaci; i++) {
                suma += zadaci[i].getCasovi();
            }
            return suma;
        }

        @Override
        public String toString() {
            return ime + " " + prezime;
        }
    }

    public static class Kompanija {
        private Vraboten[] vraboteni;

        public Kompanija(Vraboten[] vraboteni) {
            this.vraboteni = vraboteni;
        }

        public Vraboten najangaziran() {
            int max = 0;
            int k = 0;
            for (int i = 0; i < vraboteni.length; i++) {
                if (vraboteni[i].vkupnoCasovi() > max) {
                    max = vraboteni[i].vkupnoCasovi();
                    k = i;
                }
            }
            return vraboteni[k];
        }

        public void pecatiPoUspesnost() {
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int j = 0; j < vraboteni.length - 1; j++) {
                    if (vraboteni[j].procentZavrseni()
                            < vraboteni[j + 1].procentZavrseni()) {
                        Vraboten temp = vraboteni[j];
                        vraboteni[j] = vraboteni[j + 1];
                        vraboteni[j + 1] = temp;
                        flag = true;
                    }
                }
            }
            for (Vraboten vraboten : vraboteni) {
                System.out.printf(
                        "Vraboten: %s %s Uspesnost: %.2f%n",
                        vraboten.getIme(),
                        vraboten.getPrezime(),
                        vraboten.procentZavrseni() * 100
                );
            }
        }

        public void pecati() {
            for (Vraboten v : vraboteni) {
                System.out.println(v.toString());
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Vraboten[] pom = new Vraboten[n];

        for (int i = 0; i < n; i++) {
            Vraboten v = new Vraboten();
            v.setIme(input.next());
            v.setPrezime(input.next());
            v.setStaz(input.nextInt());
            v.setBrBod(input.nextInt());
            pom[i] = v;

            int p = input.nextInt();
            for (int j = 0; j < p; j++) {
                Zadaca z = new Zadaca();
                z.setCasovi(input.nextInt());
                z.setOpis(input.next());
                z.setStatus(input.nextBoolean());
                v.dodadiZadaca(z);
            }
        }

        Kompanija k = new Kompanija(pom);
        k.pecati();
        k.pecatiPoUspesnost();
        System.out.println("Najangaziran vraboten e: " + k.najangaziran());
    }
}
