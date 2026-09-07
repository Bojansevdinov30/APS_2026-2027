package book._03_LinkedLists.DLLLists;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.io.*;


/*
Дадена е двострано поврзана листа чии што jазли содржат по еден природен
броj. Листата треба да се подели на две резултантни листи, т.ш. во првата резул-
танта листа ´ке бидат бидат сместени jазли од влезната листа кои содржат парни
броеви, а во втората – непарните. Jазлите во резултантните листи се додаваат
наизменично почнуваj´ки од почетокот и краjот на влезната листа (т.е. прво се
разгледува првиот елемент од листата и се додава во соодветната резултантна
листа, па последниот, па вториот итн...).

Влез: Во првиот ред од влезот е даден броjот на jазли во листата, а во вториот
ред се дадени броевите од кои се составени jазлите по редослед во листата.

Излез: Во првиот ред од излезот треба да се испечатат jазлите по редос-
лед од првата резултантна листа (т.е. парните), во вториот ред од втората (т.е.
непарните).

Пример.
Влез:
5
1 2 3 4 5 Излез:
2 4
1 5 3
*/
public class Zadaca2 {
    public static void podeliParnost(DLL<Integer> lista, DLL<Integer> lparni, DLL<Integer> lneparni) {
        DLLNode<Integer> pom1 = lista.getFirst();
        DLLNode<Integer> pom2 = lista.getLast();

        while (pom1 != pom2 && pom2.getSucc() != pom1) {
            if (pom1.getElement() % 2 == 0)
                lparni.insertLast(pom1.getElement());
            else
                lneparni.insertLast(pom1.getElement());
            if (pom2.getElement() % 2 == 0)
                lparni.insertLast(pom2.getElement());
            else
                lneparni.insertLast(pom2.getElement());
            pom1 = pom1.getSucc();
            pom2 = pom2.getPred();
        }
        if (pom1 == pom2) {
            if (pom1.getElement() % 2 == 0)
                lparni.insertLast(pom1.getElement());
            else
                lneparni.insertLast(pom1.getElement());
            return;
        }
    }


    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>(), parni = new DLL<Integer>(),
                neparni = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        podeliParnost(lista, parni, neparni);

        // Pecatenje parni
        DLLNode<Integer> tmp = parni.getFirst();
        while (tmp != null) {
            System.out.print(tmp.getElement());
            if (tmp.getSucc() != null)
                System.out.print(" ");
            tmp = tmp.getSucc();

        }

        System.out.println();
        // Pecatenje neparni
        tmp = neparni.getFirst();
        while (tmp != null) {
            System.out.print(tmp.getElement());
            if (tmp.getSucc() != null)
                System.out.print(" ");
            tmp = tmp.getSucc();
        }
        System.out.println();
    }
}
