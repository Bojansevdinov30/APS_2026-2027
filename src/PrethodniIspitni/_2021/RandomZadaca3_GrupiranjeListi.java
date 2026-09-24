package PrethodniIspitni._2021;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

// od edna lista pravi 10 listi so slicna golemina
// pr: lista 1 ima 14 elementi
// result : 2 elems -> 2 elems -> 2 elems -> 2 elems -> 1 - > 1 -> 1 -> 1 -> 1-> 1 ->
// neshto taka
/*
test input:
14
2 8 13 5 3 11 55 66 23 99 34 71 43 69

expected output:
2->8, 13->5, 3->11, 55->66, 23, 99, 34, 71, 43, 69
 */
public class RandomZadaca3_GrupiranjeListi {
    public static void createNewList(SLL<Integer> list) {
        int n = list.size(); // 14
        SLL<SLL<Integer>> newList = new SLL<SLL<Integer>>();
        double count = (double) n / 10; // 1.4
        int cel = (int) Math.floor(count); // 1
        int ostatok = (int) Math.round((count - cel) * 10); // 4
        SLLNode<Integer> tmp = list.getHead();
        for (int i = 0; i < ostatok; i++) { // 4 pati
            SLL<Integer> tempList = new SLL<Integer>();
            for (int j = 1; j <= cel + 1; j++) { // 2 pati
                tempList.insertLast(tmp.element);
                tmp = tmp.succ;
            }
            newList.insertLast(tempList);
        }
        for (int i = 0; i < 10 - ostatok; i++) { // 6 pati
            SLL<Integer> tempList = new SLL<Integer>();
            for (int j = 1; j <= cel; j++) { // 1 pat
                tempList.insertLast(tmp.element);
                tmp = tmp.succ;
            }
            newList.insertLast(tempList);
        }
        SLLNode<SLL<Integer>> tmpnode = newList.getHead();
        while (tmpnode != null) {
            tmpnode.element.toString();
            tmpnode = tmpnode.succ;
        }

    }

    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<Integer>();
        Scanner input = new Scanner(System.in);
        var n = input.nextInt();
        for (int i = 0; i < n; i++) {
            SLLNode<Integer> tmp = new SLLNode<>(input.nextInt(), null);
            lista.insertLast(tmp.element);
        }
        createNewList(lista);

    }
}
