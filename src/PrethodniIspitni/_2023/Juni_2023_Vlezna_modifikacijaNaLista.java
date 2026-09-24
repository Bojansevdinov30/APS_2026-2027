package PrethodniIspitni._2023;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

/*Дадена е еднострано поврзана листа и 2 цели броеви m и n. Треба неизменично да се задржат m последователни елементи, па да се бришат
n последователни елементи од листата, се додека има уште елементи.
Влез:
Во првиот ред се внесува бројот на елементи во листата, па потоа самите елементи. Потоа на крај се внесуваат целите броеви m и n.
Излез:
Листата трансформирана според горенаведените барања.
Примери:
Влез:
8
1 2 3 4 5 6 7 8
2 2
Излез:
1->2->5->6
Влез:
10
1 2 3 4 5 6 7 8 9 10
3 2
Излез:
1->2->3->6->7->8
Влез:
6
0 2 4 6 8 10
1 1
Излез:
0->4->8*/
public class Juni_2023_Vlezna_modifikacijaNaLista {
    public static void keepDelete(SLL<Integer> list, int m, int n) {
        SLLNode<Integer> node = list.getHead();
        while (node != null) { // Keep m elements
            for (int i = 0; i < m && node != null; i++) {
                node = node.getSucc();
            } // Delete n elements
            for (int i = 0; i < n && node != null; i++) {
                SLLNode<Integer> next = node.getSucc();
                list.delete(node);
                node = next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numElements;
        SLL<Integer> list1 = new SLL<Integer>();
        numElements = scan.nextInt();
        for (int i = 0; i < numElements; i++) {
            list1.insertLast(scan.nextInt());
        }
        int m = scan.nextInt();
        int n = scan.nextInt();
        keepDelete(list1, m, n);
        System.out.println(list1);


    }
}
