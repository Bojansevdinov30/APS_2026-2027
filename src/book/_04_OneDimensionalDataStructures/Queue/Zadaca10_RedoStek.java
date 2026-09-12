package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;
import dataStructures.ArrayStack;

import java.util.*;
import java.io.*;

/*Да се направи имплементациjа за нова податочна структура RedoStek коjа што
´ке биде ограничена структура. Новата структура треба да може да ги задоволи
следните операции:
• вметнување елемент – Првиот елемент секогаш се става во редицата, а вто-
риот на стекот. За останатите елементи важи следното: вметнувањето еле-
мент треба да се прави со вметнување елемент во редицатата или стекот, во
зависнот од тоа каде има помал елемент на почетокот (врвот) во моментот
на вметнувањето. Доколку структурата во коjа треба да се вметне новиот
елемент е ве´ке полна, тогаш елементот се вметнува во другата структура
(Пр. Ако елементот треба да се вметне во редицата, а таа е полна, се вмет-
нува во стекот). Оваа операциjа треба да се имплементира со сложеност
O(1).
• вадење елемент – Вадењето елемент од структурата се врши на тоj начин
што прво се вадат елементите од редицата, па после тоа од стекот. Оваа
операциjа треба да се имплементира со сложеност O(1).
• да се провери дали структурата е празна
• да се провери коj е елементот на врв на структурата – Оваа операциjа дава
информациjа коj елемент е на ред за вадење.
За да се имплементираат соодветните операции може да се користат ве´ке
постоечките имплементации за операциите на стек и редица. Поради тоа што
структурата РедоСтек е ограничена, при неjзиното креирање треба да се наведе
големината на стекот и големината на редицата од кои ´ке биде креирана. Еле-
ментите се внесуваат во структурата во истиот редослед како што се читаат од
стандардниот влез. Имате право на користење на само една ваква структура.
Немате право на користење други дополнителни структури. Ваша задача е да го
испечатите редоследот на вадење на сите елементи од структурата РедоСтек.
Влез: Во влезот во првиот ред е дадена големината на редицата, во вториот
ред големината на стекот, во третиот ред броjот на карактери кои ´ке се внесуваат,
за потоа да се вчитаат карактерите.
Излез: На излез треба да се испечати прво елементот на врвот на структу-
рата РедоСтек, а после тоа во нов ред се печатат сите елементи од структурата
РедоСтек во редослед како што се вадат од неа, одделени со празно место.
Пример:
Влез:
5
3
8
abcfgehd
Излез:
a
a c f g e d h b
*/
public class Zadaca10_RedoStek {
    interface RedoStek {
        public boolean isEmpty();
        //Вра´ка true ако и само ако стекот е празен.

        public Character peek();
        //Го вра´ка елементот на врвот од структурата

        //Методи за трансформациjа:
        public void clear();
        //Jа празни структурата.

        public void push(Character x);
        //Го додава x на врвот на структурата.

        public Character pop();
        //Го отстранува и вра´ка елементот што е на ред за вадење.
    }


    static class ArrayRedoStek implements RedoStek {
        private ArrayQueue<Character> q;
        private ArrayStack<Character> s;
        private int lnRed, lnStek;

        public ArrayRedoStek(int maxRed, int maxStek) {
            s = new ArrayStack<Character>(maxStek);
            q = new ArrayQueue<Character>(maxRed);
            lnStek = maxStek;
            lnRed = maxRed;
        }


        @Override
        public boolean isEmpty() {
            if (q.isEmpty() && s.isEmpty())
                return true;
            return false;

        }


        @Override
        public Character peek() {
            if (q.isEmpty())
                return s.peek();
            return q.peek();

        }

        @Override
        public void clear() {


        }


        @Override
        public void push(Character x) {
            if (q.isEmpty())
                q.enqueue(x);
            else if (s.isEmpty())
                s.push(x);
            else {
                if (s.size() < lnStek && q.size() < lnRed) {
                    if (s.peek() < q.peek())
                        s.push(x);
                    else
                        q.enqueue(x);

                } else if (s.size() < lnStek)
                    s.push(x);
                else if (q.size() < lnRed)
                    q.enqueue(x);
                else
                    System.out.println("RedoStek is full");

            }

        }


        @Override
        public Character pop() {
            while (!q.isEmpty())
                return q.dequeue();
            while (!s.isEmpty())
                return s.pop();
            return null;

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxRed = Integer.parseInt(br.readLine());
        int maxStek = Integer.parseInt(br.readLine());

        //ArrayStack<Integer> s = new ArrayStack(maxStek);
        ArrayRedoStek sq = new ArrayRedoStek(maxRed, maxStek);

        int brElementi = Integer.parseInt(br.readLine());

        for (int i = 0; i < brElementi; i++) {
            char x = (char) br.read();
            sq.push(x);

        }

        System.out.println(sq.peek());

        while (!sq.isEmpty()) {
            System.out.print(sq.pop() + " ");

        }

    }

}
