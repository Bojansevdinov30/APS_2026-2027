package labs.Lab2;

import dataStructures.DLL;
import dataStructures.DLLNode;

/*sekoj element pocnuvajki od ktiot pomesti go k pozicii vo desno*/
public class Lab2_ex4 {
    //ova ti e za vo desno
    /*public static void transformList(DLL<Integer> lista, int k) {
    // Start at the first element that can be moved k positions right
    DLLNode<Integer> curr = lista.getFirst();

    while (curr != null) {
        DLLNode<Integer> next = curr.succ;

        // Find the node k positions to the right
        DLLNode<Integer> target = curr;

        for (int i = 0; i < k && target != null; i++) {
            target = target.succ;
        }

        // If there are k positions to the right,
        // move curr after target
        if (target != null) {
            lista.insertBefore(curr.element, target.succ);
            lista.delete(curr);
        }

        curr = next;
    }
}*/

    public static void transformList(DLL<Integer> lista, int k) {
        // Start at the (k+1)-th element
        DLLNode<Integer> curr = lista.getFirst();

        for (int i = 0; i < k; i++) {
            curr = curr.getSucc();
        }

        // Process every element from curr onward
        while (curr != null) {
            DLLNode<Integer> next = curr.getSucc();

            // Find the node k positions before curr
            DLLNode<Integer> target = curr;

            for (int i = 0; i < k; i++) {
                target = target.getPred();
            }

            // Move curr's value before target
            lista.insertBefore(curr.getElement(), target);
            lista.delete(curr);

            // Continue with the original next node
            curr = next;
        }
    }

    public static void main(String[] args){}
}
