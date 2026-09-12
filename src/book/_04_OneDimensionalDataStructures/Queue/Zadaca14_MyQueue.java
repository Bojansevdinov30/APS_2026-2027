package book._04_OneDimensionalDataStructures.Queue;
/*Да се имплементира податочната структура редот MyQueue само со користење
на податочната структура стек.
Влез: Во првиот ред од влезот е даден броjот на елементи кои ´ке се внесуваат
во податочната структура, потоа дадени се елементите секоj во посебен ред. По-
натака се дадени редоследно акциите кои треба да се направат врз податочната
структура се додека не се внесе KRAJ. Акциите се следни:
1 - значи извади елемент од редот и испечати го
2 – додади елемент во редот. Во наредната линиjа се проследува и елементот
коj треба да се додаде.
Излез: На излез треба да се испечатат елементите според барањата над по-
даточната структура. На краj треба да се испечати големината на податочната
структура.
Забелешка: При реализациjа на задачата дозволено е да се користи само
податочната структура стек. Не е дозволено да се користат дополнителни низи
или листи. Да се коментираат сложеностите на методите со кои е имплементиран
редот.
Пример 1:
Влез: 5
1
2
3
4
5
1
1
1
1
1
KRAJ
Излез:
1
2
3
4
5
Goleminata na redicata e: 0
Пример 2:
Влез: 5
1
2
3
4
5
2
10
KRAJ
Излез:
Goleminata na redicata e: 6
*/

import dataStructures.ArrayStack;

import java.io.*;

public class Zadaca14_MyQueue {

    static class MyQueue<E> {

        private ArrayStack<E> s1;
        private ArrayStack<E> s2;

        private int size;

        public MyQueue() {
            s1 = new ArrayStack<E>(1000);
            s2 = new ArrayStack<E>(1000);
            size = 0;
        }

        // O(1)
        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // O(1)
        public E peek() {
            if (s1.isEmpty()) {
                return null;
            }

            return s1.peek();
        }

        // O(1)
        public int getSize() {
            return size;
        }

        // O(n)
        public void enqueue(E x) {

            size++;

            /*
             * Move all existing elements from s1 to s2.
             */
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            /*
             * Put the new element at the bottom
             * of the future s1.
             */
            s1.push(x);

            /*
             * Move the old elements back.
             */
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // O(1)
        public E dequeue() {

            if (s1.isEmpty()) {
                return null;
            }

            size--;

            return s1.pop();
        }

        // O(n)
        public void clear() {

            while (!s1.isEmpty()) {
                s1.pop();
            }

            while (!s2.isEmpty()) {
                s2.pop();
            }

            size = 0;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        MyQueue<Integer> queue = new MyQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            queue.enqueue(x);
        }

        String command = br.readLine();

        while (!command.equals("KRAJ")) {

            int action = Integer.parseInt(command);

            if (action == 1) {

                if (queue.isEmpty()) {
                    System.out.println("Prazna redica");
                } else {
                    System.out.println(queue.dequeue());
                }

            } else if (action == 2) {

                int x = Integer.parseInt(br.readLine());
                queue.enqueue(x);
            }

            command = br.readLine();
        }

        System.out.println(
                "Goleminata na redicata e: " + queue.getSize()
        );
    }
}
