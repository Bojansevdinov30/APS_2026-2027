package PrethodniIspitni._2023;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Januari_2023_Vlezna_modifikacijaNaLista {
    public static void prvTermin(SLL<Integer> list, int k) {
        SLLNode<Integer> node = list.getHead();

        int br = 0;
        while (node != null) {
            if (node.element.equals(k)) br++;
            node = node.succ;
        }
        node = list.getHead();

        int br2 = 0;
        while (node != null) {
            if (node.element.equals(k)) br2++;

            if (br % 2 == 1) {
                if (br == br2) {
                    list.delete(node);
                    break;
                }

            }
            node = node.succ;
        }
        System.out.println(list);
    }

    public static void vtorTermin(SLL<Integer> list, int k) {
        SLLNode<Integer> node = list.getHead();

        int br = 0;
        while (node != null) {
            if (node.element.equals(k)) br++;
            node = node.succ;
        }
        node = list.getHead();

        if (br % 2 == 1) {
            while (node != null) {
                if (node.element.equals(k)) {
                    list.insertAfter(node.element, node);
                    break;
                }
                node = node.succ;
            }
            System.out.println(list);
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();
        int k = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            list1.insertLast(scanner.nextInt());
        }


        //prvTermin(list1,k);
        vtorTermin(list1, k);
    }
}
