package book._03_LinkedLists.DLLLists;
/*
Дадена е двострано поврзана листа чии што jазли содржат по еден природен броj.
Листата треба да се подели на две резултантни листи, т.ш. во првата листа треба
да се сместат сите jазли кои содржат броеви помали или еднакви на просекот
на листата, а во втората сите jазли кои содржат броеви поголеми од просекот на
листата. Jазлите во резултантните листи се додаваат според обратен редослед
од оноj по коj по коj се поjавуваат во дадената листа (т.е. прво се започнува со
разгледување на последниот jазол од влезната листа и се додава во соодветната
резултантна листа, па претпоследниот итн...).

Влез: Во првиот ред од влезот е даден броjот на jазли во листата, а во вториот
ред се дадени броевите од кои се составени jазлите по редослед во листата.

Излез: Во првиот ред од излезот треба да се испечатат jазлите по редослед од
првата резултантна листа (броеви помали или еднакви на просекот на листата),
во вториот ред од втората (броеви поголеми од просекот на листата).

Пример.
Влез:
5
4 2 1 5 3
Излез:
3 1 2
5 4
*/

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

public class Zadaca6_PomaliPogolemiOdProsek {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        DLL<Integer> list = new DLL<>();
        DLL<Integer> smallerOrEqual = new DLL<>();
        DLL<Integer> greater = new DLL<>();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            list.insertLast(x);
            sum += x;
        }

        double average = (double) sum / n;

        DLLNode<Integer> temp = list.getLast();

        while (temp != null) {
            if (temp.getElement() <= average) {
                smallerOrEqual.insertLast(temp.getElement());
            } else {
                greater.insertLast(temp.getElement());
            }

            temp = temp.getPred();
        }

        System.out.println(smallerOrEqual);
        System.out.println(greater);
    }
}