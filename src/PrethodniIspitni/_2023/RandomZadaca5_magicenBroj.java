package PrethodniIspitni._2023;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

public class RandomZadaca5_magicenBroj {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        long sum = 0;
        long product = 1;
        DLL<Integer> tmp= list.getFirst().getElement();
        while (tmp != null){
            DLLNode<Integer> trav = tmp.getFirst();
            while (trav!= null){
                sum+= trav.getElement();
                trav = trav.getSucc();
            }
            product *= sum;
            sum = 0;
            list.deleteFirst();
            if (list.length() == 0) break;
            tmp = list.getFirst().getElement();
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }
}
