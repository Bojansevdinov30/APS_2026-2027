package PrethodniIspitni._2022;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;
/*Дадена е двојно поврзана листа од цели броеви. Да се трансформира листата така што ќе се меша N пати (N > 0 и се чита од стандарден влез) на следниот начин:
 Во секое мешање, последниот елемент се поставува во внатрешноста на листата после јазлите чија кумулативна вредност е максимална и помала или еднаква од вредноста
 на елементот кој се вметнува.

Во првиот ред од влезот е даден бројот на елементи на листата M, во вториот ред бројот N и во третиот ред се дадени елементите на листата.

Влез:

M = 14
N = 3
оригинална листа: 1 <-> 5 <-> 2 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1 <-> 4 <-> 6 <-> 8
Мешање 1: 1 <-> 5 <-> 2 <-> 8 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1 <-> 4 <-> 6
Бројот 8 како последен елемент се вади од крајот на листата и се вметнува после елементот 2,
бидејќи збирот 1+5+2 = 8 е најголем кумулативен збир од почетокот на листата, а помал и еднаков на 8

Мешање 2: 1 <-> 5 <-> 6 <-> 2 <-> 8 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1 <-> 4
Бројот 6 како последен елемент се вади од крајот на листата и се вметнува после елементот 5,

бидејќи збирот 1+5 = 6 е најголем кумулативен збир од почетокот на листата, а помал и еднаков на 6

Мешање 3: 1  <-> 4 <-> 5 <-> 6 <-> 2 <-> 8 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1
Бројот 4 како последен елемент се вади од крајот на листата и се вметнува после елементот 1,
бидејќи збирот 1 = 1 е најголем кумулативен збир од почетокот на листата, а помал и еднаков на 4


Излез:
1  <-> 4 <-> 5 <-> 6 <-> 2 <-> 8 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1*/
public class _2022_Kolokvium1_Vlezna_cumulativeSpot {
    static class Element implements Comparable<Element> {
        private int id;

        public Element(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }

        @Override
        public int compareTo(Element o) {
            if (this.id < o.id) return -1;
            else if (this.id > o.id) return 1;
            else return 0;
        }
    }


    private static DLLNode<Element> cumulativeSpot(DLL<Element> list, int value) {
        DLLNode<Element> node = list.getFirst();
        int zbir = 0;
        while (zbir <= value) {
            zbir += node.element.getId();
            if (zbir > value) node = node.pred;
            else node = node.succ;

        }
        return node;
    }

    private static void listTransform(DLL<Element> original, int N) {
        for (int i = 0; i < N; i++) {

            int value = original.getLast().element.getId();
            DLLNode<Element> vnesi = cumulativeSpot(original, value);
            original.insertAfter(original.getLast().element, vnesi);
            original.deleteLast();

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());

        DLL<Element> list = new DLL<Element>();

        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            list.insertLast(new Element(n));
        }


        listTransform(list, N);
        System.out.println(list);

    }
}
