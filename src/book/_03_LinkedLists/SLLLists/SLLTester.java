package book._03_LinkedLists.SLLLists;

import dataStructures.SLL;
import dataStructures.SLLNode;

public class SLLTester {

    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<Integer>();
        lista.insertLast(5);
        System.out.print("Listata po vmetnuvanje na 5 kako posleden element: ");
        System.out.println(lista);

        lista.insertFirst(3);
        System.out.print("Listata po vmetnuvanje na 3 kako prv element: ");
        System.out.println(lista);

        lista.insertLast(1);
        System.out.print("Listata po vmetnuvanje na 1 kako posleden element: ");
        System.out.println(lista);

        lista.deleteFirst();
        System.out.print("Listata po brishenje na prviot element: ");
        System.out.println(lista);

        SLLNode<Integer> pom = lista.find(5);
        lista.insertBefore(2, pom);
        System.out.print("Listata po vmetnuvanje na elementot 2 pred elementot 5: ");
        System.out.println(lista);

        pom = lista.find(1);
        lista.insertAfter(3, pom);
        System.out.print("Listata po vmetnuvanje na elementot 3 posle elementot 1: ");
        System.out.println(lista);
        System.out.println("Momentalna dolzina na listata: " + lista.size());

        pom = lista.find(2);
        lista.delete(pom);
        System.out.print("Listata po brishenje na elementot 2: ");
        System.out.println(lista);
        System.out.println("Momentalna dolzina na listata: " + lista.size());

        lista.deleteList();
        System.out.print("Pecatenje na listata po nejzino brishenje: ");
        System.out.println(lista);
        System.out.println("Momentalna dolzina na listata: " + lista.size());
    }
}
