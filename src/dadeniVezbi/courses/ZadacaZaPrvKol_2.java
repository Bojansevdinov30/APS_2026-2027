package dadeniVezbi.courses;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.io.IOException;
import java.util.Scanner;

public class ZadacaZaPrvKol_2 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> lista1 = new SLL<Integer>();
        n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            lista1.insertLast(scan.nextInt());
        }
        broj = scan.nextInt();
        int count = 0;
        SLLNode<Integer> pom = lista1.getHead();

        while (pom != null) {
            if (pom.getElement() == broj) {
                count++;
            }
            pom = pom.getSucc();
        }

        if (count > 0 && count % 2 != 0) {
            pom = lista1.getHead();
            while (pom != null) {
                if (pom.getElement() == broj) {
                    lista1.insertBefore(broj, pom);
                    break;
                }
                pom = pom.getSucc();
            }
        }

        System.out.println(lista1);
    }
}
