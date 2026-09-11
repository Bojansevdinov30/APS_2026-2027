package book._03_LinkedLists.DLLLists;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

/* !!!!
Пред командантот на воjската наредени се сите воjници и во двоjно поврзана
листа дадени се нивните ID-a. На командантот не му се допа´га како се наредени
воjниците и решава да одбере два под-интервали од воjници и да им ги замени
местата, односно воjниците што се нао´гаат во едниот под-интервал ´ке ги смести
во другиот, и обратно.

Влез: Во првиот ред даден е броjот на воjници.
Во вториот ред дадени се ID-то на секоj од воjниците.
Во третиот ред дадени се два броеви, ID на првиот воjник и ID на последниот
воjник од првиот интервал.
Во четвртиот ред дадени се два броеви, ID на првиот воjник и ID на последниот
воjник од вториот интервал.

Излез: Да се испечати новиот редослед на воjниците (т.е. на нивните ID-a)
Забелешка 1: Интервалите никогаш нема да се преклопуваат и ´ке содржат барем
еден воjник. Целата низа ´ке содржи наjмалку два воjника.
Забелешка 2: Обратете посебно внимание кога интервалите се еден до друг и
кога некоj од интервалите почнува од првиот воjник или завршува со последниот
воjник.

Пример.
Влез:
10
1 2 3 4 5 6 7 8 9 10
1 5
6 10
Излез:
6 7 8 9 10 1 2 3 4 5
*/

public class Zadaca8 {

    public static void swapIntervals(
            DLL<Integer> list,
            int first1, int last1,
            int first2, int last2) {

        DLLNode<Integer> start1 = null;
        DLLNode<Integer> end1 = null;
        DLLNode<Integer> start2 = null;
        DLLNode<Integer> end2 = null;

        DLLNode<Integer> temp = list.getFirst();

        while (temp != null) {
            if (temp.getElement() == first1) {
                start1 = temp;
            }
            if (temp.getElement() == last1) {
                end1 = temp;
            }
            if (temp.getElement() == first2) {
                start2 = temp;
            }
            if (temp.getElement() == last2) {
                end2 = temp;
            }

            temp = temp.getSucc();
        }

        // If the second interval actually comes before the first,
        // swap the interval references so interval 1 is always left.
        temp = list.getFirst();
        boolean firstIntervalSeenFirst = false;

        while (temp != null) {
            if (temp == start1) {
                firstIntervalSeenFirst = true;
                break;
            }
            if (temp == start2) {
                break;
            }
            temp = temp.getSucc();
        }

        if (!firstIntervalSeenFirst) {
            DLLNode<Integer> x;

            x = start1;
            start1 = start2;
            start2 = x;

            x = end1;
            end1 = end2;
            end2 = x;
        }

        DLLNode<Integer> before1 = start1.getPred();
        DLLNode<Integer> after1 = end1.getSucc();

        DLLNode<Integer> before2 = start2.getPred();
        DLLNode<Integer> after2 = end2.getSucc();

        // Special case: intervals are directly succ to each other
        if (after1 == start2) {

            if (before1 != null) {
                before1.setSucc(start2);
            }

            start2.setPred(before1);

            end2.setSucc(start1);
            start1.setPred(end2);

            end1.setSucc(after2);

            if (after2 != null) {
                after2.setPred(end1);
            }

        } else {

            // Connect what was before interval 1 to interval 2
            if (before1 != null) {
                before1.setSucc(start2);
            }

            start2.setPred(before1);

            // Connect end of interval 2 to what was after interval 1
            end2.setSucc(after1);

            if (after1 != null) {
                after1.setPred(end2);
            }

            // Connect what was before interval 2 to interval 1
            if (before2 != null) {
                before2.setSucc(start1);
            }

            start1.setPred(before2);

            // Connect end of interval 1 to what was after interval 2
            end1.setSucc(after2);

            if (after2 != null) {
                after2.setPred(end1);
            }
        }

        // Fix first
        if (before1 == null) {
            list.setFirst(start2);
        }

        // Fix last
        if (after2 == null) {
            list.setLast(end1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        DLL<Integer> list = new DLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int first1 = sc.nextInt();
        int last1 = sc.nextInt();

        int first2 = sc.nextInt();
        int last2 = sc.nextInt();

        swapIntervals(list, first1, last1, first2, last2);

        System.out.println(list);
    }
}