package book._04_OneDimensionalDataStructures.Stack;

import dataStructures.ArrayStack;
import dataStructures.LinkedStack;

import java.util.Scanner;

/*Во една градина имаа одреден броj на растениjа. Секое од растениjата е третира-
но со одредена количина на пестициди. После секоj ден, ако некое растение има
пове´ке пестициди од растението што е лево од него (односно е послабо), истото
умира.
Со дадени инициjални вредности за количината на пестициди во секое рас-
тение, треба да се одреди после коj ден по ред (броjот на денот) нема ве´ке да
умира ни едно растение, односно после коj ден нема да има растениjа кои имаат
пове´ке пестициди од тие што се до нив од лева страна.
Влез: Во влезот во првиот ред е даден броjот на растениjа, а потоа за секое
растение е дадена количината на пестициди.
Излез: На излез треба да се испечати броjот на денот по коj ве´ке нема да
умира ни едно растение.
Пример 1:
Влез:
7
6 5 8 4 7 10 9
Излез:
2
*/
public class Zadaca8_OtrovniCvekinja {
    // O(n^2) complexity but easier to understand
    public static int calculateDays(ArrayStack<Integer> pesticides) {
        int days = 0;
        LinkedStack<Integer> living = new LinkedStack<>();
        do {
            int size = pesticides.size();
            while (!pesticides.isEmpty()) {
                int pesticide = pesticides.pop();
                if (pesticides.peek() != null && pesticide > pesticides.peek()) {
                    continue;
                } else {
                    living.push(pesticide);
                }
            }

            int size1 = living.size();
            while (!living.isEmpty()) {
                pesticides.push(living.pop());
            }
            if (size1 == size) {
                break;
            }
            days++;
        } while (true);

        return days;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        ArrayStack<Integer> pesticides = new ArrayStack<>(N);
        for (int i = 0; i < N; i++) {
            pesticides.push(input.nextInt());
        }
        System.out.println(calculateDays(pesticides));

    }
}
// O(n) complexity but harder to understand
/*
public static int solve(int[] plants) {


    Stack<Plant> stack = new Stack<>();

    int maxDays = 0;

    for (int pesticide : plants) {

        int days = 0;

        while (!stack.isEmpty()
                && pesticide <= stack.peek().pesticide) {

            days = Math.max(days, stack.pop().days);
        }

        if (stack.isEmpty()) {
            days = 0;
        } else {
            days++;
        }

        maxDays = Math.max(maxDays, days);

        stack.push(new Plant(pesticide, days));
    }

    return maxDays;
}*/