package dadeniVezbi.courses;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.util.Objects;
import java.util.Scanner;

public class Heshiranje_2 {
    public static class Vraboten implements Comparable<Vraboten> {
        String ime;
        int vozrast;

        public Vraboten(String ime, int vozrast) {
            this.ime = ime;
            this.vozrast = vozrast;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vraboten vraboten = (Vraboten) o;
            return vozrast == vraboten.vozrast && Objects.equals(ime, vraboten.ime);
        }

        @Override
        public int hashCode() {
            return vozrast * (int) ime.charAt(0);
        }

        @Override
        public String toString() {
            return "<" + ime + ", " + vozrast + ">";
        }

        @Override
        public int compareTo(Vraboten o) {
            if(this.vozrast < o.vozrast) return -1;
            else if(this.vozrast > o.vozrast) return 1;
            else return 0;
        }
    }

    public static class Proekt {
        int rabotnoVreme;
        int plataPoCas;

        public Proekt(int rabotnoVreme, int plataPoCas) {
            this.rabotnoVreme = rabotnoVreme;
            this.plataPoCas = plataPoCas;
        }

        public int getPlata() {
            return rabotnoVreme * plataPoCas;
        }

        @Override
        public String toString() {
            return "<" + rabotnoVreme + ", " + plataPoCas + ">";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        CBHT<Vraboten, Proekt> hashtabela = new CBHT<>(10);

        for (int i = 0; i < n; i++) {
            String[] linija = sc.nextLine().split(" ");
            String ime = linija[0];
            int vozrast = Integer.parseInt(linija[1]);
            int vreme = Integer.parseInt(linija[2]);
            int plataPoCas = Integer.parseInt(linija[3]);

            Vraboten v = new Vraboten(ime, vozrast);
            Proekt p = new Proekt(vreme, plataPoCas);

            SLLNode<MapEntry<Vraboten, Proekt>> node = hashtabela.search(v);

            if (node == null) {
                hashtabela.insert(v, p);
            } else if (node.getElement().getValue().getPlata() < p.getPlata()) {
                hashtabela.insert(v, p);
            }
        }

        System.out.println(hashtabela);
    }

}
