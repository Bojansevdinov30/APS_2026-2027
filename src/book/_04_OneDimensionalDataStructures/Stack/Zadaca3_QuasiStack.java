package book._04_OneDimensionalDataStructures.Stack;

import dataStructures.DLLNode;
import dataStructures.Stack;

import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Да се направи имплементациjа за нова податочна структура QuasiStack коjа што
´ке биде неограничена структура. Новата структура треба да може да ги задоволи
следните операции:
• вметнување елемент – Вметнувањето елемент секогаш е вметнување на
врвот на податочната структура. Оваа операциjа треба да се имплементира
со сложеност O(1).
• вадење елемент – Вадењето елемент од структурата може да биде вадење
на елемент од врвот на структурата или од дното. Треба секогаш да се
извади поголемиот елемент, при споредба на елементитe на врвот и дното.
Доколку се еднакви го вади елементот од дното. Оваа операциjа треба да
се имплементира со сложеност O(1).
• да се провери дали структурата е празна
• да се провери коj е елементот на врв на структурата
• да се провери коj е елементот на дното на структурата
Елементите се внесуваат во структурата во истиот редослед како што се чита-
ат од стандардниот влез. Имате право на користење на само една ваква структу-
ра. Немате право на користење други дополнителни структури. Ваша задача е да
го испечатите редоследот на вадење на сите елементи од структурата QuasiStack.
Влез: Во првиот ред од влезот е даден броjот на елементи кои ´ке се внесуваат,
а во секоj нов ред се дадени елементите кои се читаат.
Излез: Прво се печати елементот на врвот на структурата, а после оноj на
дното. Потоа во нов ред се печатат сите елементи од структурата QuasiStack во
редослед како што се вадат од неа, одделени со празно место.
Пример:
Влез:
8 (броj на елементи кои треба да се прочитаат, се ставаат на структурата
последователно онака како што се читаат)
6 (елемент 1)
5 (елемент 2 итн.)
4
1
0
5
2
9
Излез:
9 (елементот на врвот на структурата)
6 (елементот на дното на структурата)
9 6 5 4 2 5 1 0 (сите елементи од структурата QuasiStack)
*/
public class Zadaca3_QuasiStack {

    static class QuasiStack<E extends Comparable<E>> implements Stack<E> {
        //Stekot e pretstaven na sledniot nacin: top e link do prviot jazol
        // na ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
        private DLLNode<E> top, bottom;

        public QuasiStack() {
            // Konstrukcija na nov, prazen stek.
            top = null;
            bottom = null;
        }

        public boolean isEmpty() {
            // Vrakja true ako i samo ako stekot e prazen.
            return (top == null);
        }

        public E peek() {
            return null;
        }

        public E peekTop() {
            // Go vrakja elementot na vrvot od stekot.
            if (top == null)
                throw new NoSuchElementException();
            return top.getElement();

        }

        public E peekBottom() {
            // Go vrakja elementot na vrvot od stekot.
            if (bottom == null)
                throw new NoSuchElementException();
            return bottom.getElement();
        }

        public void clear() {
            // Go prazni stekot.
            top = null;
            bottom = null;
        }

        public void push(E x) {
            // Go dodava x na vrvot na stekot.
            DLLNode<E> ins = new DLLNode<E>(x, null, top);
            if (top == null)
                bottom = ins;
            else
                top.setPred(ins);
            top = ins;

        }


        public E pop() {
            // Go otstranuva i vrakja pogolemiot element shto e na vrvot i dnoto na stekot.
            if (top == null)
                throw new NoSuchElementException();
            E topElem = top.getElement();
            E bottomElem = bottom.getElement();

            if (top == bottom) {
                top = null;
                bottom = null;
                return topElem;
            }

            if (topElem.compareTo(bottomElem) > 0) {
                top = top.getSucc();
                top.setPred(null);
                return topElem;

            }
            else{
                bottom = bottom.getPred();
                bottom.setSucc(null);
                return bottomElem;
            }
        }
    }


        public static void main(String[] args) throws IOException {
            // TODO Auto-generated method stub
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            QuasiStack<Integer> qs = new QuasiStack<Integer>();

            int brElementi = Integer.parseInt(br.readLine());

            for (int i = 0; i < brElementi; i++) {
                int x = Integer.parseInt(br.readLine());
                qs.push(x);
            }

            System.out.println(qs.peekTop());
            System.out.println(qs.peekBottom());
            while (!qs.isEmpty()) {
                System.out.print(qs.pop() + " ");
            }
        }

}
