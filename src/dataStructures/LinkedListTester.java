package dataStructures;

import java.util.LinkedList;

public class LinkedListTester {

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.addLast(5);
        System.out.print("Listata po vmetnuvanje na 5 kako posleden element: ");
        System.out.println(lista.toString());

        lista.addFirst(3);
        System.out.print("Listata po vmetnuvanje na 3 kako prv element: ");
        System.out.println(lista.toString());

        lista.addLast(1);
        System.out.print("Listata po vmetnuvanje na 1 kako posleden element: ");
        System.out.println(lista.toString());

        lista.removeFirst();
        System.out.print("Listata po brishenje na prviot element: ");
        System.out.println(lista.toString());

        //DLLNode<Integer> pom = lista.find(5);
        int indeksNa5 = lista.indexOf(5);
        lista.add(indeksNa5, 2);
        System.out.print("Listata po vmetnuvanje na elementot 2 pred elementot 5: ");
        System.out.println(lista.toString());

        int indeksNa1 = lista.indexOf(1);
        lista.add(indeksNa1 + 1, 3);
        System.out.print("Listata po vmetnuvanje na elementot 3 posle elementot 1: ");
        System.out.println(lista.toString());

        int indeksNa3 = lista.indexOf(3);
        lista.remove(indeksNa3);
        System.out.print("Listata po brishenje na elementot 3: ");
        System.out.println(lista.toString());

        System.out.println("Momentalna dolzina na listata: " + lista.size());

        lista.clear();
        System.out.print("Pecatenje na listata po nejzino brishenje: ");
        System.out.println(lista.toString());
        System.out.println("Momentalna dolzina na listata: " + lista.size());
    }
}
