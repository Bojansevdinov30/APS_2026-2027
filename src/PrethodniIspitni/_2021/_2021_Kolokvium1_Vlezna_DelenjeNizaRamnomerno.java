package PrethodniIspitni._2021;

import dataStructures.SLL;

import java.util.Scanner;

/*
Дадена е единечно поврзана листа со N елементи (N>=10). Потребно е да се подели влезната листа на 10 други листи,
притоа распределбата на елементите да биде фер, односно резултатните листи да имаат слична големина. Во првиот ред е даден
бројот на елементи N, а во вториот се дадени елементите на влезната листа. Во дадениот пример, листата од 14 елементи е поделена
на 10 листи така што првите четири листи содржат по два елементи, а останатите шест по еден елемент.
For example: Input 14 1 5 2 3 0 6 4 3 7 9 1 4 6 8
Result [1 -> 5, 2 -> 3, 0 -> 6, 4 -> 3, 7, 9, 1, 4, 6, 8]
*/
public class _2021_Kolokvium1_Vlezna_DelenjeNizaRamnomerno {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(input.nextInt());
        }

        int base = n / 10;
        int remainder = n % 10;

        SLL<Integer>[] result = new SLL[10];

        for (int i = 0; i < 10; i++) {
            result[i] = new SLL<>();

            int elementsInThisList = base;

            if (i < remainder) {
                elementsInThisList++;
            }

            for (int j = 0; j < elementsInThisList; j++) {
                result[i].insertLast(list.deleteFirst());
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(result[i]);

            if (i < 9) {
                System.out.print(", ");
            }
        }
    }
}
