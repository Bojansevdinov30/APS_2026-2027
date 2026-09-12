package book._03_LinkedLists.DLLLists;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.io.*;

/*
Дадена е двострано поврзана листа чии што jазли содржат по еден природен
броj. Листата треба да се преврти т.ш. прво се превртуваат jазлите кои содржат
парни броеви, а потоа jазлите со непарни броеви. Листата се разгледува од назад.
Право на користење имате само една дополнителна помошна двострано поврзана
листа.
Влез: Во првиот ред од влезот е даден броjот на jазли во листа, потоа во вто-
риот ред се дадени броевите од кои се составени jазлите по редослед во листата.
Излез: На излез треба да се испечатат jазлите по редослед во превртената
листа
Пример.
Влез:
5
1 2 3 4 5
Излез:
4 2 5 3 1
*/
public class Zadaca5_PrevrtiLista {

    public static void prevrtiLista(DLL<Integer> lista, DLL<Integer> pomosna) {

        DLLNode<Integer> pom = lista.getLast();

        while (pom != null) {
            if (pom.getElement() % 2 == 0) {
                pomosna.insertLast(pom.getElement());
                if (pom == lista.getFirst()) {
                    lista.deleteFirst();
                } else if (pom == lista.getLast()) {
                    lista.deleteLast();
                } else {
                    (pom.getPred()).setSucc(pom.getSucc());
                    (pom.getSucc()).setPred(pom.getPred());
                }
            }

            pom = pom.getPred();
        }

        pom = lista.getLast();
        while (pom != null) {
            pomosna.insertLast(pom.getElement());
            pom = pom.getPred();
        }

    }

    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>(), pomosna = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        prevrtiLista(lista, pomosna);


        // Pecatenje nova lista
        DLLNode<Integer> tmp1 = pomosna.getFirst();
        while (tmp1 != null) {
            System.out.print(tmp1.getElement());
            if (tmp1.getSucc() != null)
                System.out.print(" ");
            tmp1 = tmp1.getSucc();
        }
        System.out.println();
    }

}
