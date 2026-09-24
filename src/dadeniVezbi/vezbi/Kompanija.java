package dadeniVezbi.vezbi;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

/*Податоците за плати на вработените во една компанија привремено се чуваат во еднострано поврзана листа. Во секој јазол од
листата се чува единствен ID на вработениот и неговата плата. Потребно е да се отстранат сите вработени со помали плати од даден
износ, а остатокот да се прикажат во опаѓачки редослед во однос на ID-то. Во првиот ред од влезот е даден бројот на вработени,
потоа наизменично се дадени ID и плата за секој од вработените и во последниот ред е износот во однос на кој ќе се отстрануваат
вработените. На излез се печати листа (ID, плата) во опаѓачки редослед според ID на секој од вработените.
Доколку нема вработени со плата поголема од дадената да се испечати: nema
*/
public class Kompanija {
    public static class Vraboten {
        public int ID;
        public int plata;

        public Vraboten(int ID, int plata) {
            this.ID = ID;
            this.plata = plata;
        }

        @Override
        public String toString() {
            return "ID = " + ID + ", plata = " + plata;
        }
    }

    public static SLL<Vraboten> sort(SLL<Vraboten> list) {
        SLL<Vraboten> newList = new SLL<Vraboten>();
        int n = list.size();
        for (int i = 0; i < n; i++) {
            SLLNode<Vraboten> min = null;
            SLLNode<Vraboten> curr = list.getHead();
            while (curr != null) {
                if (min == null) {
                    min = curr;
                }
                if (min.getElement().ID < curr.getElement().ID) {
                    min = curr;
                }
                curr = curr.getSucc();
            }
            newList.insertLast(min.getElement());
            list.delete(min);
        }
        return newList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Vraboten> lista = new SLL<>();

        for (int i = 0; i < n; i++) {
            int ID = sc.nextInt();
            int plata = sc.nextInt();

            lista.insertLast(new Vraboten(ID, plata));
        }

        int granica = sc.nextInt();

        SLLNode<Vraboten> curr = lista.getHead();

        System.out.println(lista);

        while (curr != null) {
            if (curr.getElement().plata < granica) {
                lista.delete(curr);
            }

            curr = curr.getSucc();

        }

        System.out.println();

        System.out.println(sort(lista));
    }

}
