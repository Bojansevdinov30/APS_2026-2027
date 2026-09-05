package auds.auds1;

import dataStructures.SLL;

// Zadaca 2 - prevrtuvanje na SLL.
// Implementacijata na mirror() se naogja vo samata klasa SLL.
public class Auds1_ex2 {

    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<Integer>();
        lista.insertLast(1);
        lista.insertLast(2);
        lista.insertLast(3);

        System.out.println("Pred prevrtuvanje: " + lista);
        lista.mirror();
        System.out.println("Po prevrtuvanje: " + lista);
    }
}
