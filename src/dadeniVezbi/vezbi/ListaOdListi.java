package dadeniVezbi.vezbi;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

/*Дадена е двојно поврзана листа од двојно поврзани листи. Да се најде сума на секоја од подлистите, а потоа производ на овие суми

Влез: Број N кој кажува колку листи има Број М кој кажува колку елементи има во секоја листа Во следните М линии се податоците 1<=A<=1000за секоја од листите

Излез: Еден број што е производот на сумите од низите. Со седум децимали.

Пример влез: 3 4 1 2 3 4 2 3 4 5 6 7 8 9

Излез: 4200*/
public class ListaOdListi {
    public static void findListsProduct(DLL<DLL<Integer>> listOfLists) {
        DLLNode<DLL<Integer>> lolCurr = listOfLists.getFirst();
        int product = 1;

        while (lolCurr != null) {
            int listSum = 0;
            DLLNode<Integer> curr = lolCurr.getElement().getFirst();

            while (curr != null) {
                listSum += curr.getElement();
                curr = curr.getSucc();
            }

            product *= listSum;

            lolCurr = lolCurr.getSucc();
        }

        System.out.println(product);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        DLL<DLL<Integer>> listOfLists = new DLL<DLL<Integer>>();

        for (int i = 0; i < n; i++) {
            DLL<Integer> list = new DLL<Integer>();

            for (int j = 0; j < m; j++) {
                list.insertLast(sc.nextInt());
            }

            listOfLists.insertLast(list);
        }

        findListsProduct(listOfLists);
    }
}
