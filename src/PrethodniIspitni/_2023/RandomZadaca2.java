package PrethodniIspitni._2023;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class RandomZadaca2 {
    public static void change(SLL<Integer> list, int br) {
        SLLNode<Integer> tmp = list.getHead();
        int ctr = 0;
        while (tmp != null){
            if (tmp.getElement() == br) ctr++;
            tmp = tmp.getSucc();
        }
        if (ctr %2 != 0) list.insertBefore(br, list.find(br));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        change(list1,br);
        System.out.println(list1);


    }
}
