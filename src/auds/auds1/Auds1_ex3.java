package auds.auds1;

import dataStructures.SLL;
import dataStructures.SLLNode;

// Zadaca 3 - spojuvanje na dve sortirani listi.
// tipovi na zadaci se ili vaka posebno ili kako gore vnatre funkcionalnost + main moze daden moze ne
public class Auds1_ex3 {

    public static <E extends Comparable<E>> SLL<E> joinSortedLists(
            SLL<E> firstList,
            SLL<E> secondList
    ) {
        SLL<E> result = new SLL<E>();
        SLLNode<E> temp1 = firstList.getHead();
        SLLNode<E> temp2 = secondList.getHead();

        while (temp1 != null && temp2 != null) {
            if (temp1.getData().compareTo(temp2.getData()) < 0) {
                result.insertLast(temp1.getData());
                temp1 = temp1.getNext();
            } else {
                result.insertLast(temp2.getData());
                temp2 = temp2.getNext();
            }
        }

        while (temp1 != null) {
            result.insertLast(temp1.getData());
            temp1 = temp1.getNext();
        }

        while (temp2 != null) {
            result.insertLast(temp2.getData());
            temp2 = temp2.getNext();
        }

        return result;
    }

    public static void main(String[] args) {
        SLL<Integer> firstList = new SLL<Integer>();
        firstList.insertLast(1);
        firstList.insertLast(3);
        firstList.insertLast(5);

        SLL<Integer> secondList = new SLL<Integer>();
        secondList.insertLast(2);
        secondList.insertLast(4);
        secondList.insertLast(6);

        System.out.println(joinSortedLists(firstList, secondList));
    }
}
