package book._03_LinkedLists.DLLLists;
/*
Дадени се две двоjно поврзани листи чии што jазли содржат по една природен
броj. Од првата листа треба да се избришат сите поjавувања на втората листа
(поjавување на една листа во друга значи првата листа да е подлиста на втората).
Jазлите што ´ке останат во првата листа треба да се прикажат на излез. Ако не
остане ниту еден jазел се печати Prazna lista.
Влез: Во првиот ред од влезот е даден броjот на jазли на првата листа, потоа
во вториот ред се дадени броевите од кои се составени jазлите по редослед во
првата листа разделени со празно место. Во третиот ред е даден броjот на jазли
на втората листа, а во четвртиот ред броевите од кои се составени jазлите по
редослед во втората листа.
Излез: На излез треба да се испечатат jазлите по редослед во резултантната
(првата) листа. Ако не остане ниту еден jазел се печати Prazna lista.
Пример.
Влез:
22
1 2 3 4 5 6 1 2 3 4 5 6 1 2 6 5 1 3 4 1 5 2
3
4 5 6 Излез:
1 2 3 1 2 3 1 2 6 5 1 3 4 1 5 2
*/
import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

public class Zadaca7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        DLL<Integer> list1 = new DLL<>();

        for (int i = 0; i < n; i++) {
            list1.insertLast(sc.nextInt());
        }

        int m = sc.nextInt();

        DLL<Integer> list2 = new DLL<>();

        for (int i = 0; i < m; i++) {
            list2.insertLast(sc.nextInt());
        }

        DLLNode<Integer> current = list1.getFirst();

        while (current != null) {

            DLLNode<Integer> p1 = current;
            DLLNode<Integer> p2 = list2.getFirst();

            // Проверуваме дали list2 започнува од current
            while (p1 != null && p2 != null && p1.getElement().equals(p2.getElement())) {
                p1 = p1.getSucc();
                p2 = p2.getSucc();
            }

            // Ако p2 == null, сме ја поминале целата втора листа
            // => најдено е појавување
            if (p2 == null) {

                DLLNode<Integer> toDelete = current;

                for (int i = 0; i < m; i++) {
                    DLLNode<Integer> next = toDelete.getSucc();

                    list1.delete(toDelete);

                    toDelete = next;
                }

                // Продолжуваме од првиот јазол после избришаната подлиста
                current = p1;

            } else {
                current = current.getSucc();
            }
        }

        if (list1.getFirst() == null) {
            System.out.println("Prazna lista");
        } else {
            System.out.println(list1);
        }
    }
}