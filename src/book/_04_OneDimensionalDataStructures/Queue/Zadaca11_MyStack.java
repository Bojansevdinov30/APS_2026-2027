package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;
import dataStructures.Stack;

import java.io.*;

/*Да се имплементира податочната структура стек MyStack само со користење на
податочната структура ред.
Влез: Во првиот ред од влезот е даден броjот на елементи кои ´ке се внесуваат
во податочната структура, потоа дадени се елементите секоj во посебен ред. По-
натаму се дадени редоследно акциите кои треба да се направат врз податочната
структура се додека не се внесе KRAJ. Акциите се следни:
1 - значи извади елемент од стекот и испечати го
2 – додади елемент на стекот. Во наредната линиjа се проследува и елементот
коj треба да се додаде.
Излез: На излез треба да се испечатат елементите според барањата над по-
даточната структура. На краj треба да се испечати големината на податочната
структура.
Забелешка: При реализациjа на задачата дозволено е да се користи само
податочната структура ред. Не е дозволено да се користат дополнителни низи
или листи. Да се коментираат сложеностите на методите со кои е имплементиран
стекот.
Пример:
Влез:
5
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
5
4
3
2
1
Goleminata na stekot e: 0*/
public class Zadaca11_MyStack {
    static class MyStack<E> implements Stack<E> {
        ArrayQueue<E> q1, q2;
        int size;

        public MyStack() {
            q1 = new ArrayQueue<E>(1000);
            q2 = new ArrayQueue<E>(1000);
            size = 0;
        }

        @Override
        public boolean isEmpty() {
            if (q1.isEmpty() && q2.isEmpty())
                return true;
            else
                return false;
        }


        @Override
        public E peek() {
            if (q1.isEmpty())
                return null;
            return q1.peek();

        }

        public int getSize() {
            return size;

        }


        @Override
        public void clear() {


        }


        @Override
        public void push(E x) {
            size++;
            //Push x прво во празната q2
            q2.enqueue(x);
            //Push на сите останати
            //елементи од q1 во q2.
            while (!q1.isEmpty()) {
                q2.enqueue(q1.peek());
                q1.dequeue();

            }

            //промена на двете редици
            ArrayQueue<E> q = q1;
            q1 = q2;
            q2 = q;

        }


        @Override
        public E pop() {
            //ако нема елементи во q1
            if (q1.isEmpty())
                return null;
            E tmp = q1.dequeue();
            size--;
            return tmp;

        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyStack ob = new MyStack();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            ob.push(x);
        }
        //System.out.println(ob.toString());
        String str = br.readLine();
        while (!str.equals("KRAJ")) {
            int x = Integer.parseInt(str);
            if (x == 1) {
                if (ob.peek() == null)
                    System.out.println("Prazen stek");
                else
                    System.out.println(ob.pop());

            }
            if (x == 2) {
                str = br.readLine();
                x = Integer.parseInt(str);
                ob.push(x);

            }
            str = br.readLine();

        }
        System.out.println("Goleminata na stekot e: " + ob.getSize());

    }

}
