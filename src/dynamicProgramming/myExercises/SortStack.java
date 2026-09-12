package dynamicProgramming.myExercises;

import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();

        while (!s.isEmpty()) {

            int x = s.pop();

            while (!temp.isEmpty() && temp.peek() > x) {
                s.push(temp.pop());
            }

            temp.push(x);
        }

        // Move everything back into the original stack
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        s.push(3);
        s.push(1);
        s.push(4);
        s.push(2);

        sortStack(s);

        System.out.println(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}