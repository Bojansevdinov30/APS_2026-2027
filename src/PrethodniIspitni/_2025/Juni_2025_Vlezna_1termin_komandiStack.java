package PrethodniIspitni._2025;

import java.util.Scanner;
import java.util.Stack;

/*
Se vnesuva n i potoa se vnesuvaat N komandi.Komandite se UNDO sto go brise posledniot element ,ako nema posleden
element se ignorira komandata.SHOW gi pecati vnesenite karakteri i TYPE X vesuva karakter x.

primer
4
TYPE H
TYPE S
UNDO
SHOW

output:H
*/
public class Juni_2025_Vlezna_1termin_komandiStack {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            String command = input.next();

            if (command.equals("TYPE")) {

                char c = input.next().charAt(0);
                stack.push(c);

            } else if (command.equals("UNDO")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else if (command.equals("SHOW")) {

                for (char c : stack) {
                    System.out.print(c);
                }

                System.out.println();
            }
        }
    }
}
