package PrethodniIspitni._2023;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class _2023_Vlezna {
    public static void makeZigZag(SLL<Integer> list) {
        SLLNode<Integer> tmp = list.getHead();
        if (tmp == null || tmp.getSucc() == null) {
            return;
        }
        while (tmp != null) {
            if (tmp.getElement() == 0) list.delete(tmp);
            tmp = tmp.getSucc();
        }
        tmp = list.getHead();
        while (tmp != null && tmp.getSucc() != null) {
            while (tmp.getSucc() != null && tmp.getElement() > 0 && tmp.getSucc().getElement() > 0) {
                list.delete(tmp.getSucc());
            }
            if (tmp.getSucc() != null && tmp.getElement() < 0 && tmp.getSucc().getElement() < 0)
                list.insertAfter(tmp.getElement() * -1, tmp);
            tmp = tmp.getSucc();
        }
    }

    public static void putWordsTogether(SLL<String> list) {
        SLLNode<String> tmp = list.getHead();
        while (tmp != null && tmp.getSucc() != null) {
            if (!tmp.getSucc().getElement().equals(",")) {
                tmp.setElement(tmp.getElement() + tmp.getSucc().getElement());
                list.delete(tmp.getSucc());
            } else {
                list.delete(tmp.getSucc());
                tmp = tmp.getSucc();
            }
        }
    }

    public static void main(String[] args) {
//            Scanner input = new Scanner(System.in);
//            int n = input.nextInt();
//            SLL<Integer> list = new SLL<>();
//            for(int i=0;i<n;i++) {
//                list.insertLast(input.nextInt());
//            }
//            System.out.println(list);
//            makeZigZag(list);
//            System.out.println(list);

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();

        String[] parts = line.split(" ");

        SLL<String> list = new SLL<>();

        for (String part : parts) {
            list.insertLast(part);
        }

        System.out.println(list);

        putWordsTogether(list);

        System.out.println(list);
    }
}
