package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;
import dataStructures.ArrayStack;

import java.io.*;

/*Да се направи имплементациjа за нова податочна структура StekoRed коjа што
´ке биде ограничена структура. Новата структура треба да може да ги задоволи
следните операции:
• вметнување елемент – Вметнувањето елемент треба да се прави со вметну-
вање елемент во стек. Доколку стекот е полн и нема пове´ке место, се про-
должува со вметнување на елементите во редицата. Оваа операциjа треба
да се имплементира со сложеност O(1).
• вадење елемент – Вадењето елемент од структурата може да биде вадење
на елемент од стек или од редица. Треба да се извади поголемиот елемент,
при споредба на елементитe на врвот на стекот и почетокот на редицата.
Доколку една од структурите се испразни, вадењето продолжува по ре-
дослед на елементите од другата структура. Оваа операциjа треба да се
имплементира со сложеност O(1).
• да се провери дали структурата е празна
• да се провери коj е елементот на врв на структурата – Оваа операциjа дава
информациjа коj елемент е на ред за вадење.
За да се имплементираат соодветните операции може да се користат ве´ке
постоечките имплементации за операциите на стек и редица. Поради тоа што
структурата СтекоРед е ограничена, при неjзиното креирање треба да се наведе
големината на стекот и големината на редицата од кои ´ке биде креирана. Еле-
ментите се внесуваат во структурата во истиот редослед како што се читаат од
стандардниот влез. Имате право на користење на само една ваква структура.
Немате право на користење други дополнителни структури. Ваша задача е да го
испечатите редоследот на вадење на сите елементи од структурата СтекоРед.
Влез: Во првиот ред од влезот е дадена големината на стекот, во вториот ред
големината на редицата, во третиот ред броjот на елементи кои ´ке се внесуваат,
за потоа во секоj нов ред да се елементите кои се читаат.
Излез: На излез треба да се испечати елементот на врвот на структурата
СтекоРед, а после тоа во нов ред се печатат сите елементи од структурата Сте-
коРед во редослед како што се вадат од неа, одделени со празно место.
Пример:
Влез:
3 (големина на стекот )
5 (големина на редицата)
8 (броj на елементи кои треба да се прочитаат)
0 (елемент 0)
2 (елемент 1) итн.
4
1
3
5
7
9
Излез:
4 (елементот на врвот на структурата)
4 2 1 3 5 7 9 0 (сите елементи од структурата СтекоРед)
*/
public class Zadaca12_StekoRed {

    interface StekoRed {

        boolean isEmpty();

        Integer peek();

        void clear();

        void push(Integer x);

        Integer pop();
    }


    static class ArrayStekoRed implements StekoRed {

        private ArrayQueue<Integer> queue;
        private ArrayStack<Integer> stack;

        private int maxQueue;
        private int maxStack;

        public ArrayStekoRed(int maxStack, int maxQueue) {
            stack = new ArrayStack<>(maxStack);
            queue = new ArrayQueue<>(maxQueue);

            this.maxStack = maxStack;
            this.maxQueue = maxQueue;
        }


        @Override
        public boolean isEmpty() {
            return stack.isEmpty() && queue.isEmpty();
        }


        @Override
        public Integer peek() {

            // Only queue has elements
            if (stack.isEmpty()) {
                return queue.peek();
            }

            // Only stack has elements
            if (queue.isEmpty()) {
                return stack.peek();
            }

            // Both have elements -> return the larger one
            if (stack.peek() >= queue.peek()) {
                return stack.peek();
            } else {
                return queue.peek();
            }
        }


        @Override
        public void clear() {

            while (!stack.isEmpty()) {
                stack.pop();
            }

            while (!queue.isEmpty()) {
                queue.dequeue();
            }
        }


        @Override
        public void push(Integer x) {

            // First fill the stack
            if (stack.size() < maxStack) {
                stack.push(x);
            }

            // When stack is full, fill the queue
            else if (queue.size() < maxQueue) {
                queue.enqueue(x);
            }

            // Both are full
            else {
                System.out.println("RedoStek is full");
            }
        }


        @Override
        public Integer pop() {

            if (isEmpty()) {
                return null;
            }

            // Stack empty -> take from queue
            if (stack.isEmpty()) {
                return queue.dequeue();
            }

            // Queue empty -> take from stack
            if (queue.isEmpty()) {
                return stack.pop();
            }

            // Both contain elements -> remove larger one
            if (stack.peek() >= queue.peek()) {
                return stack.pop();
            } else {
                return queue.dequeue();
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxStack = Integer.parseInt(br.readLine());
        int maxQueue = Integer.parseInt(br.readLine());

        int numberOfElements = Integer.parseInt(br.readLine());

        ArrayStekoRed stekoRed =
                new ArrayStekoRed(maxStack, maxQueue);

        for (int i = 0; i < numberOfElements; i++) {
            int x = Integer.parseInt(br.readLine());
            stekoRed.push(x);
        }

        // Element currently next for removal
        System.out.println(stekoRed.peek());

        // Removal order
        while (!stekoRed.isEmpty()) {
            System.out.print(stekoRed.pop());

            if (!stekoRed.isEmpty()) {
                System.out.print(" ");
            }
        }
    }
}
