package book._03_LinkedLists.SLLLists;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Zadaca7 {

    public static SLL<Integer> mergeLists(
            SLL<Integer> firstList,
            SLL<Integer> secondList) {

        SLLNode<Integer> first = firstList.getHead();
        SLLNode<Integer> second = secondList.getHead();

        // Dummy node to make building the result easier
        SLLNode<Integer> dummy = new SLLNode<>(null, null);
        SLLNode<Integer> last = dummy;

        while (first != null && second != null) {

            // Take up to 2 nodes from the first list
            for (int i = 0; i < 2 && first != null; i++) {
                SLLNode<Integer> next = first.getSucc();

                last.setSucc(first);
                last = first;

                first = next;
            }

            // Take up to 2 nodes from the second list
            for (int i = 0; i < 2 && second != null; i++) {
                SLLNode<Integer> next = second.getSucc();

                last.setSucc(second);
                last = second;

                second = next;
            }
        }

        // Remaining nodes from the FIRST list
        if (first != null) {
            last.setSucc(first);

            while (last.getSucc() != null) {
                last = last.getSucc();
            }
        }

        // Remaining nodes from the SECOND list
        if (second != null) {
            last.setSucc(second);
        }

        SLL<Integer> result = new SLL<>();
        result.setHead(dummy.getSucc());

        return result;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        SLL<Integer> firstList = new SLL<>();

        for (int i = 0; i < n1; i++) {
            firstList.insertLast(sc.nextInt());
        }

        int n2 = sc.nextInt();
        SLL<Integer> secondList = new SLL<>();

        for (int i = 0; i < n2; i++) {
            secondList.insertLast(sc.nextInt());
        }

        SLL<Integer> result = mergeLists(firstList, secondList);

        System.out.println(result);
    }
}
