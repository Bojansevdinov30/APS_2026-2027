package dadeniVezbi.courses;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Listi_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<String> lista = new SLL<>();

        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.next());
        }

        int l = sc.nextInt();

        System.out.println(lista);

        SLLNode<String> curr = lista.getHead();

        SLLNode<String> baran = curr;

        while(curr != null) {
            if(curr.getElement().length() == l) {
                baran = curr;
            }
            curr = curr.getSucc();
        }

        lista.insertFirst(baran.getElement());
        lista.delete(baran);

        System.out.println(lista);
    }

}
