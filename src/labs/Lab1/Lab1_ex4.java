package labs.Lab1;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

// vo SLL od stringovi i dadena dolzina L pred sekoj string sto sodrzi string so pogolema dolzina da se vmetne Node "Outlier"
public class Lab1_ex4 {
    //    public static void change(SLL<String> list, int length) {
//        SLLNode<String> head = list.getHead();
//
//        // Special case: first element
//        if (head != null && head.getElement().length() > length) {
//            list.insertFirst("Outlier");
//            head = head.getSucc(); // move to original first element
//        }
//
//        while (head != null && head.getSucc() != null) {
//            if (head.getSucc().getElement().length() > length) {
//                SLLNode<String> temp =
//                        new SLLNode<>("Outlier", head.getSucc());
//
//                head.setSucc(temp);
//
//                // Skip the Outlier AND the original element
//                head = temp.getSucc();
//            } else {
//                head = head.getSucc();
//            }
//        }
//    }
    public static void change(SLL<String> list, int length) {
        SLLNode<String> curr = list.getHead();
        SLLNode<String> prev = null;
        if(prev == null && curr != null && curr.getElement().length() > length) {
            list.insertFirst("Outlier");
            prev = curr;
            curr = curr.getSucc();
        }
        while (curr != null) {
            if (curr.getElement().length() > length) {
                prev.setSucc(new SLLNode<String>("Outlier", curr));
            }
            prev = curr;
            curr = curr.getSucc();
        }


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<String> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(input.next());
        }
        int k = input.nextInt();

        System.out.println(list.toString());

        change(list, k);

        System.out.println(list.toString());

    }

}
