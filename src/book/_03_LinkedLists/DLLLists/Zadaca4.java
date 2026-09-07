package book._03_LinkedLists.DLLLists;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

/*
Дадена е двоjно поврзана листа од двоjно поврзани листи. Да се наjде сума на
секоjа од подлистите, а потоа производ на овие суми.

Влез: Броj N коj кажува колку листи има.
Броj М коj кажува колку елементи има во секоjа листа.
Во следните М линии се податоците 1<=A<=1000 за секоjа од листите

Излез: Еден броj што е производот на сумите од низите. Со седум децимали.
Пример.
Влез:
3
4
1 2 3 4
2 3 4 5
6 7 8 9
Излез:
4200
*/
public class Zadaca4 {

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        DLLNode<DLL<Integer>> current = list.getFirst();
        long prod = 1;
        while (true) {
            int sum = 0;
            DLLNode<Integer> current1 = current.getElement().getFirst();
            while (true) {
                sum += current1.getElement();
                if (current1 == current.getElement().getLast()) {
                    break;
                }
                current1 = current1.getSucc();
            }
            prod *= sum;
            if (current == list.getLast()) {
                break;
            }
            current = current.getSucc();
        }
        return prod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        DLL<DLL<Integer>> lists = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> temp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                temp.insertLast(sc.nextInt());
            }
            lists.insertLast(temp);
        }

        System.out.println(findMagicNumber(lists));
    }
}
