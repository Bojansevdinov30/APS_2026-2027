package book._03_LinkedLists.SLLLists;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

/*
Дадена е еднострано поврзана листа чии што jазли содржат по еден природен
броj. Во дадената листа треба да се пронаjдат елементите со наjмала и наjголе-
ма вредност и потоа листата треба да се подели на две резултантни еднострано
поврзани листи, т.ш. во првата листа треба да се сместат сите jазли кои содржат
броеви поблиски до наjмалиот елемент отколку до наjголемиот елемент, а во вто-
рата сите jазли кои содржат броеви поблиски до наjголемиот елемент отколку
до наjмалиот. Доколку елементот е на исто растоjание од наjмалиот и наjголе-
миот елемент тогаш се сместува во листата на елементи поблиски до наjмалот
елемент. Jазлите во резултантните листи се додаваат според редоследот по коj
се поjавуваат во дадената листа. (Помош: броjот 3 е на растоjание 2 од броjот
1 и на растоjание 4 од броjот 7. Следува дека броjот 3 е поблиску до броjот 1
отколку до броjот 7).

Влез: Во првата линиjа е даден броjот на елементи n. Во втората линиjа се
даваат броевите во листата одделени со празно место.

Излез: На излез во првиот ред треба да се испечатат jазлите по редослед на
првата резултантната листа (коjа содржи елементи кои се поблиску до наjмалиот
елемент). Во вториот ред треба да се испечатат jазлите на по редослед на втора-
та резултантната листа (коjа содржи елементи кои се поблиску до наjголемиот
елемент).
Пример.
Влез:
9
1 5 7 3 2 9 4 8 6
Излез:
1->5->3->2->4
7->9->8->6
*/
public class Zadaca5 {
    public static void minMax(SLL<Integer> list) {

        SLLNode<Integer> min = list.getHead();
        SLLNode<Integer> max = list.getHead();
        SLLNode<Integer> temp = list.getHead();
        while (temp != null) {
            if (temp.getData() < min.getData()) {
                min = temp;
            }
            if (temp.getData() > max.getData()) {
                max = temp;
            }
            temp = temp.getNext();
        }
        temp  = list.getHead();
        SLL<Integer> minList = new SLL<>();
        SLL<Integer> maxList = new SLL<>();
        while (temp != null) {
            if (Math.abs(temp.getData() - min.getData()) <=  Math.abs(temp.getData() - max.getData())) {
                minList.insertLast(temp.getData());
            }else if (Math.abs(temp.getData() - min.getData()) > Math.abs(temp.getData() - max.getData())) {
                maxList.insertLast(temp.getData());
            }
            temp = temp.getNext();
        }

        System.out.println(minList.toString());
        System.out.println(maxList.toString());

    }

    public static void main(String[] args) {
        SLL<Integer> list = new SLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        minMax(list);

    }
}
