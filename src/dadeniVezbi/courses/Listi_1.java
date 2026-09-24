package dadeniVezbi.courses;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

public class Listi_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> lista = new DLL<>();

        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }

        int m = sc.nextInt();

        int k = sc.nextInt();

        System.out.println(lista);

        DLLNode<Integer> curr = lista.find(m);
        if(curr == null) {
            System.out.println(lista);
            return;
        }
        DLLNode<Integer> tmp = curr;

        boolean prekuRed = false;

        while (k-- > 0) {
            if (tmp.getPred() == null) {
                tmp = lista.getLast();
                prekuRed = true;
                continue;
            }
            tmp = tmp.getPred();
        }

        if(!prekuRed) {
            lista.insertBefore(curr.getElement(), tmp);
            lista.delete(curr);
        } else {
            lista.insertAfter(curr.getElement(), tmp);
            lista.delete(curr);
        }

        System.out.println(lista);
    }
}
