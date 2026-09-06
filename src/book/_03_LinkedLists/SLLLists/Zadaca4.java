package book._03_LinkedLists.SLLLists;

import dataStructures.SLL;

import java.util.Scanner;

public class Zadaca4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> lista = new SLL<Integer>();

        for (int i = 0; i < n; i++) {
            int el = sc.nextInt();
            lista.insertLast(el);
        }

        lista.rearrange();

        System.out.println(lista.toString());
    }

}
