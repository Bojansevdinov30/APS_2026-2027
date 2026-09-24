package dadeniVezbi.courses;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class ZadacaZaPrvKol_1 {
    private static void duplicateNumbers(SLL<Integer> list, int m) {
        SLLNode<Integer> curr = list.getHead();
        int counter = 0;
        while (curr != null) {
            if(curr.getElement() == m) {
                counter++;
            }
            curr = curr.getSucc();
        }

        if(counter % 2 != 0) {
            curr = list.find(m);
            list.insertBefore(curr.getElement(), curr);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();

        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int m = sc.nextInt();

        duplicateNumbers(list, m);

        System.out.println(list);
    }

}
