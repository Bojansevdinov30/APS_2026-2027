package labs.Lab2;

import dataStructures.SLL;

import java.util.Scanner;

public class Lab2_ex7 {
   /* public SLL<E> specialJoin(SLL<E> list1, SLL<E> list2) {
        SLLNode<E> node1 = list1.getFirst();
        SLLNode<E> node2 = list2.getFirst();
        SLL<E> merged = new SLL<>();

        while (node1.succ != null && node2.succ != null) {
            merged.insertLast(node1.element);
            merged.insertLast(node1.succ.element);
            merged.insertLast(node2.element);
            merged.insertLast(node2.succ.element);
            node1 = node1.succ.succ;
            node2 = node2.succ.succ;

            if (node1 == null || node2 == null) {
                break;
            }
        }


        if (node1 != null) {
            while (node1 != null) {
                merged.insertLast(node1.element);
                node1 = node1.succ;
            }
        }
        if (node2 != null) {
            while (node2 != null) {
                merged.insertLast(node2.element);
                node2 = node2.succ;
            }
        }

        return merged;
    }*/

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list1 = new SLL<>();
        for (int i = 0; i < n; i++) {
            list1.insertLast(input.nextInt());
        }

        n = input.nextInt();

        SLL<Integer> list2 = new SLL<>();
        for (int i = 0; i < n; i++) {
            list2.insertLast(input.nextInt());
        }

       // SpecialSLLJoin<Integer> tmp = new SpecialSLLJoin<>();

        // System.out.println(tmp.specialJoin(list1, list2));
    }
}
