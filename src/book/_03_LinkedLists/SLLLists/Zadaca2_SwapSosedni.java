/*Дадена е еднострано поврзана листа чии што jазли содржат по еден природен
броj. Да се трансформира листата така што секоj соседен пар jазли ´ке си ги
заменат местата (првиот со вториот, па третиот со четвртиот итн...).
Влез: Во првата линиjа е даден броjот на елементи n. Во следните n линии
се дадени елементите на листата.
Излез: На излез треба да се испечатат jазлите на резултантната листа.
Пример.
Влез:
4
1
2
3
4
Излез:
2->1->4->3*/
package book._03_LinkedLists.SLLLists;
import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.*;

public class Zadaca2_SwapSosedni {
    // istovo moze mn polesno da se resi samo so vrednostite ako gi zememe, a ne celite nodes
    public static void swapNodes(SLL<Integer> list) {
        SLLNode<Integer> current = list.getHead();

        if (current == null || current.getSucc() == null) {
            return;
        }

        SLLNode<Integer> previous = null;

        while (current != null && current.getSucc() != null) {

            SLLNode<Integer> second = current.getSucc();
            SLLNode<Integer> afterPair = second.getSucc();

            // Swap current and second
            second.setSucc(current);
            current.setSucc(afterPair);

            // Connect previous pair to this pair
            if (previous == null) {
                list.setHead(second);
            } else {
                previous.setSucc(second);
            }

            // current is now the second node of the swapped pair
            previous = current;

            // move to the succ pair
            current = afterPair;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();

        for(int i = 0; i < n; i++){
            list.insertLast(sc.nextInt());
        }

        swapNodes(list);

        System.out.println(list.toString());

    }

}
