package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.Queue;

import java.io.*;
import java.util.*;

/*
Да се направи имплементациjа за нова податочна структура QuasiQueue коjа што
´ке биде ограничена структура. Новата структура треба да може да ги задоволи
следните операции:
• вметнување елемент – Вметнувањето елемент секогаш е вметнување на краj
на податочната структура. Доколку при вметнување елемент структурата
е полна, треба да се овозможи новиот елемент да се вметне. Тоj секогаш се
поставува на почетна позициjа на структурата. Оваа операциjа треба да се
имплементира со сложеност O(1).
• вадење елемент – Вадењето елемент од структурата може да биде вадење
на елемент од почеток или краj на структурата. Треба секогаш да се извади
помалиот елемент, при споредба на елементитe на почеток и краj. Доколку
се еднакви, се вади елементот од почеток на структурата. Оваа операциjа
треба да се имплементира со сложеност O(1).
• да се провери дали структурата е празна
• да се провери коj е елементот на почеток на структурата
• да се провери коj е елементот на краj на структурата
Елементите се внесуваат во структурата во истиот редослед како што се чита-
ат од стандардниот влез. При имплементациjа на структурата QuasiQueue имате
право на користење на само една основна структура. Немате право на користење
други дополнителни структури. Ваша задача е да го испечатите редоследот на
вадење на сите елементи од структурата QuasiQueue.
Влез: Во влезот е дадена во првиот ред големината на структурата. Во вто-
риот ред од влезот е даден броjот на елементи кои ´ке се внесуваат, а потоа во
секоj нов се нао´гаат елементите кои треба да се внесат.
Излез: На излез треба да се испечати прво елементот на почеток на струк-
турата, а после оноj на краjот. Потоа во нов ред се печатат сите елементи од
структурата QuasiQueue во редослед како што се вадат од неа, одделени со праз-
но место.
Пример:
Влез:
6 (големина на структурата)
8 (броj на елементи кои треба да се прочитаат)
9
5
4
10
0
5
2
6
Излез:
6 (елементот на почеток на структурата)
5 (елементот на краj на структурата)
5 0 6 5 4 10 (сите елементи од структурата QuasiQueue)
*/
public class Zadaca2_QuasiQueue {
    static class QuasiQueue<E extends Comparable<E>> implements Queue<E> {
        //Редицата е претставена на следниот начин:
        //length го содржи броjот на елементи.
        //Ако length > 0, тогаш елементите на редицата се зачувани во elems[front...rear-1]
        //Ако rear > front, тогаш во elems[front...maxlength-1] и elems[0...rear-1]
        E[] elems;
        int length, front, rear, maxlength;

        @SuppressWarnings("unchecked")
        public QuasiQueue(int maxlength) {
            elems = (E[]) new Comparable[maxlength];
            this.maxlength = maxlength;
            clear();
        }

        public boolean isEmpty() {
            //Вра´ка true ако и само ако редицата е празна.
            return (length == 0);
        }

        public int size() {
            //Jа вра´ка должината на редицата.
            return length;
        }

        public E peekFirst() {
            //Го вра´ка елементот од почетокот на редицата.
            if (length > 0)
                return elems[front];
            else
                throw new NoSuchElementException();
        }

        public E peekLast() {
            //Го вра´ка елементот од краjот на редицата.
            if (length > 0)
                return elems[rear - 1];
            else
                throw new NoSuchElementException();
        }

        public void clear() {
            //Jа празни редицата.
            length = 0;
            front = rear = 0; //произволно
        }

        public void enqueue(E x) {
            //Го додава x на краj од редицата.
            //elems[rear++] = x;
            if (rear == maxlength)
                elems[0] = x;
            else {
                elems[rear++] = x;
                length++;

            }

        }


        public E dequeue() {
            //Го отстранува и вра´ка помалиот од почетниот и краjниот елемент на редицата.
            if (length > 0) {
                E frontmost = elems[front];
                E rearmost = elems[rear - 1];
                if (front == rear) {
                    front = 0;
                    rear = 0;
                    elems[front] = null;
                    length--;
                    return frontmost;

                }

                if (frontmost.compareTo(rearmost) < 0 || frontmost.compareTo(rearmost) == 0) {
                    elems[front++] = null;
                    length--;
                    return frontmost;

                } else {
                    elems[rear - 1] = null;
                    rear--;
                    length--;
                    return rearmost;

                }

            } else
                throw new NoSuchElementException();

        }

        public E peek() {
            // Го пра´ка елементот на почетокот на редицата.
            // O(1) complexity
            if (length > 0)
                return elems[front];
            else
                throw new NoSuchElementException();
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxElementi = Integer.parseInt(br.readLine());
        //System.out.println(maxElementi);

        QuasiQueue<Integer> qq = new QuasiQueue<Integer>(maxElementi);
        int brElementi = Integer.parseInt(br.readLine());

        for (int i = 0; i < brElementi; i++) {
            int x = Integer.parseInt(br.readLine());
            qq.enqueue(x);
            //System.out.println(qq.peekFirst());

        }

        System.out.println(qq.peekFirst());
        System.out.println(qq.peekLast());

        while (!qq.isEmpty()) {
            System.out.print(qq.dequeue() + " ");

        }

    }

}
