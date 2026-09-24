package dadeniVezbi.vezbi;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class BrisiJazliPrekuN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        deleteJazli(list, n);
    }

    public static void deleteJazli(SLL<Integer> list, int n) {
        SLLNode<Integer> curr = list.getHead();
        int counter = 1;

        for (int i = 0; i < n && curr != null; i++, curr = curr.getSucc()) {
            if (i == counter) {
                list.delete(curr);
                counter = i + 1;
                i = -1;
            }
        }

        System.out.println(list);
    }

}
