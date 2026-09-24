package PrethodniIspitni._2021;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Juni_2021_Vlezna_ModificiranjeLista {
    public static void funkcija(SLL<Integer> lista, int key) {
        SLLNode<Integer> node = lista.getHead();
        int brojac = 0;
        while (node != null) {
            if (node.element.equals(key)) {
                brojac++;
            }
            node = node.succ;
        }
        node = lista.getHead();

        int brojac2 = 0;
        while (node != null) {
            if (node.element.equals(key)) {
                brojac2++;
            }
            if (brojac2 == brojac) lista.delete(node);
            node = node.succ;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        SLL<Integer> lista = new SLL<>();
        for (int i = 0; i < N; i++) {
            int broj = input.nextInt();
            lista.insertLast(broj);
        }
        int key = input.nextInt();
        funkcija(lista, key);
        System.out.println(lista);
    }
}
