package dadeniVezbi.vezbi;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

/*Листа од цели броеви помеѓу 1 и 999 е цик цак листа доколку паровите од соседни елементи се наизменично во стриктно
опаѓачки и стриктно растечки редослед и првиот пар е во растечки редослед. На пример:

1 <-> 5 <-> 1 <-> 5

1 <-> 12 <-> 2 <-> 15 <-> 10

6 <-> 10 <-> 8 <-> 9 <-> 2 <-> 2 <-> 4 <-> 3

Додека пак следните не се цик цак листи:

5 <-> 1 <-> 5 <-> 1

1 <-> 5 <-> 10 <-> 5 <-> 1

5 <-> 10 <-> 7 <-> 5 <-> 7

1 <-> 10 <-> 10 <-> 1

Секоја листа од цели броеви можеме да ја претвориме во цик цак листа. На пример, во листите

1 <-> 5 <-> 10 <-> 5 <-> 1

првиот пар кој што не прави наизменична промена е парот 5 <-> 10, кој би требало да е во опаќачки редослед бидејќи пред него
има пар во растечки редослед.

5 <-> 10 <-> 7 <-> 5 <-> 7

првиот пар кој што не прави наизменична промена е парот 7 <-> 5, кој би требало да е во растечки редослед бидејќи пред него
има пар во опаѓачки редослед.

Кога има пар што е во растечки редослед, а треба да е во опаѓачки, како на пример 5 <-> 10, или пар што е во опаѓачки редослед, а
треба да е во растечки, како на пример 7 <-> 5, можеме да го отстраниме јазелот кој што е втро во парот, во овој случај јазлите
со вредност 10 во првиот пар и 5 во вториот пар.

Влез: Во првиот ред од влезот е даден цел број N, кој го претставува бројот на јазли во листата, а потоа во следниот ред N
цели броеви одделени со празно место помеѓу 1 и 999.

Излез: На излез треба да се испечати променетата листа после нејзината трансформација во цик цак листа.

Пример:

Влез:

5

1 5 10 5 1

Излез:

1 <-> 5 <-> 10 <-> 5 <-> 1

1 <-> 5 <-> 1

Појаснување: Отстранети се два јазли, тој со вредност 10 бидејќи не е во опаќачки редослед со претходниот елемент, и тој
со вредност 5 после јазелот со вредност 10, повторно бидејќи не е во опаѓачки редослед со претходниот елемент.*/
public class CikCakLista2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        makeZigZag(list);
    }

    private static void makeZigZag(DLL<Integer> list) {
        System.out.println(list);

        DLLNode<Integer> curr = list.getFirst();

        if(curr.getElement() >= curr.getSucc().getElement()) {
            list.delete(curr);
            curr = curr.getSucc();
        }

        boolean smaller = false;
        boolean larger = true;

        while (curr.getSucc() != null) {
            if(larger) {
                if (curr.getSucc().getElement() <= curr.getElement()) {
                    list.delete(curr.getSucc());
                    continue;
                }
                smaller = true;
                larger = false;
                curr = curr.getSucc();
                continue;
            }
            if(smaller) {
                if(curr.getSucc().getElement() >= curr.getElement()) {
                    list.delete(curr.getSucc());
                    continue;
                }
                smaller = false;
                larger = true;
                curr = curr.getSucc();
                continue;
            }
        }

        System.out.println(list);
    }

}
