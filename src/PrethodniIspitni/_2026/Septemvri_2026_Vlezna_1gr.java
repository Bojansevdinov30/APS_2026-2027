package PrethodniIspitni._2026;

import java.util.Scanner;
import java.util.Stack;

/*Влезна задача: Текст едитор  - Прва група Септември
 Команди WRITE и UNDO да се О(1) а PRINT да е О(k) каде што k е должина на текстот кој е внесен. Се внесуваат N команди и
 требаше да биде 1<=N<=20000.
WRITE X - го пишува последниот внесен карактер
UNDO X - проверува дали е последниот внесен карактер и го брише само ако е тој карактер во спротивно ако се внесе друг карактер
или е празен се печати INVALID COMMAND,
PRINT во две линии каде прво ќе испечати онака како што било внесено а после обратно а ако е празен да печати EMPTY.
Објаснување : Пример ако повикаме PRINT на почеток е празен и печати EMPTY па прави WRITE X UNDO X и пак е празен.
Test Case : 10 WRITE K WRITE O WRITE D PRINT ... и така до 10 команди, знам дека имаше еден тест што враќаше EMPTY EMPTY INVALID COMMAND.
Вака нешто слично беше влезната...*/
public class Septemvri_2026_Vlezna_1gr {

    public static void idea2(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] stack = new String[n];
        int top = 0;

        for (int i = 0; i < n; i++) {

            String command = sc.next();

            if (command.equals("WRITE")) {

                String x = sc.next();

                stack[top] = x;
                top++;

            } else if (command.equals("UNDO")) {

                String x = sc.next();

                if (top > 0 && stack[top - 1].equals(x)) {
                    top--;
                } else {
                    System.out.println("INVALID COMMAND");
                }

            } else if (command.equals("PRINT")) {

                if (top == 0) {
                    System.out.println("EMPTY");
                } else {

                    // Original order
                    for (int j = 0; j < top; j++) {
                        System.out.print(stack[j]);
                    }

                    System.out.println();

                    // Reverse order
                    for (int j = top - 1; j >= 0; j--) {
                        System.out.print(stack[j]);
                    }

                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Stack<String> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            String command;
            String x;
            command = sc.next();

            if (command.equals("WRITE")) {
                x = sc.next();
                st.push(x);
            } else if (command.equals("UNDO")) {
                x = sc.next();
                if (!st.isEmpty() && st.peek().equals(x)) {
                    st.pop();
                } else {
                    System.out.println("INVALID COMMAND");
                }
            } else if (command.equals("PRINT")) {
                if (st.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    Stack<String> temp = new Stack<>();
                    while (!st.isEmpty()) {
                        temp.push(st.pop());
                    }
                    while (!temp.isEmpty()) {
                        System.out.println(temp.peek());
                        st.push(temp.pop());
                    }
                    while (!st.isEmpty()) {
                        System.out.println(st.peek());
                        temp.push(st.pop());
                    }

                    // ova ako sepak treba da se zacuvaat vrednostite i posle PRINT
                    while (!temp.isEmpty()) {
                        st.push(temp.pop());
                    }
                }
            }

        }
    }


}
