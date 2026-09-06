package book._03_LinkedLists.SLLLists;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

/*
Дадена е еднострана поврзана листа со цели броеви. Ваша задача е да бришете
jазли т.ш. прво ´ке оставите еден jазол, еден ´ке бришете, па ´ке оставите 2 jазли
еден ´ке бришете, па ´ке оставите 3 jазли па еден ´ке бришете итн... Односно од вас
се бара да бришете преку 1, па преку 2, па преку 3 jазли итн... додека е возможно
да се брише.
Влез: Во првата линиjа е даден броjот на елементи n. Во втората линиjа се
даваат броевите во листата одделени со празно место.
Излез: Резултатната листа. Доколку листата е празна испечатете: Prazna
lista
Пример.
Влез:
9
4 6 8 3 1 3 5 7 2
Излез:
4->8->3->3->5->7
*/
public class Zadaca6 {
    public static void deletePattern(SLL<Integer> list) {
        if (list.getHead() == null) {
            return;
        }

        SLLNode<Integer> curr = list.getHead();
        int nodesToSkip = 1;

        while (curr != null) {

            // Leave nodesToSkip nodes
            for (int i = 1; i < nodesToSkip && curr != null; i++) {
                curr = curr.getNext();
            }

            // If there is no node after curr, there is nothing left to delete
            if (curr == null || curr.getNext() == null) {
                break;
            }

            // Delete the node after curr
            curr.setNext(curr.getNext().getNext());

            // Continue from the first node after the deleted one
            curr = curr.getNext();

            nodesToSkip++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        deletePattern(list);

        if (list.getHead() == null) {
            System.out.println("Prazna lista");
        } else {
            System.out.println(list);
        }
    }
}
