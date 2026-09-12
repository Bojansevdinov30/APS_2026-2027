package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;
import dataStructures.ArrayStack;

import java.util.Scanner;

/*Дадена е влезна редица чии елементи се првите n природни броеви (генерирани
по случаен редослед). Ваша задача е да проверите дали елементите од влезната
редица може да се сортираат во растечки редослед во друга излезна редица,
притоа користеj´ки jа податочната структура стек.
Дозволени операции се само следниве:
1. Каj влезната редица може да се применуваат само операциите dequeue и
peek.
2. Каj магацинот може да се применуваат стандардните операции за магацин
(push, pop, peek).
3. Каj излезната редица може да се применуваат само операциите enqueue и
peek.
Влез: Во влезот во првиот ред е даден броjот n. Во вториот ред се дадени
елементите по редослед како што треба да се додадат во влезната редица.
Излез: На излез треба да се испечати “da” доколку е можно да се сортираат
броевите или “nе” доколку не е можно да се сортираат.
Забелешка: При реализациjа на задачата е дозволено да се користат само
две редици и еден стек. Не е дозволено да се користат дополнителни структури
како низи и листи.
Пример 1:
Влез:
5
5 1 2 3 4
Излез:
Да
160
Податочни структури
Пример 2:
Влез:
6
5 1 2 6 3 4
Излез:
Не
*/
public class Zadaca13_SortiranaRedica {

    public static boolean sort(ArrayQueue<Integer> input, int n) {

        ArrayQueue<Integer> output = new ArrayQueue<>(n);
        ArrayStack<Integer> stack = new ArrayStack<>(n);

        int expected = 1;

        while (!input.isEmpty()) {

            int current = input.dequeue();

            if (current == expected) {
                output.enqueue(current);
                expected++;

                while (!stack.isEmpty() && stack.peek() == expected) {
                    output.enqueue(stack.pop());
                    expected++;
                }

            } else {

                if (!stack.isEmpty() && stack.peek() < current) {
                    return false;
                }

                stack.push(current);
            }
        }

        while (!stack.isEmpty() && stack.peek() == expected) {
            output.enqueue(stack.pop());
            expected++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayQueue<Integer> queue = new ArrayQueue<>(n);
        for (int i = 0; i < n; i++) {
            queue.enqueue(sc.nextInt());
        }
        if (sort(queue, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(queue.dequeue());
//        }
    }
}
