package PrethodniIspitni._2025;

import java.util.Scanner;
import java.util.Stack;

/*Stack

Најди ја фунцкијата што повикува највеќе фунцкии во неа. Секоја фунцкија има Call x - x е името на фунцкијата - и Return.

Input
12
Call a
Call b
Call c
Return
Call d
Return
Call e
Return
Return
Call f
Return
Return

Output
b 3

Објаснување: во b се повикани c d и e

---*/
public class PrvKolokvium_2025_DopolnitelenDel_2_StackCall {
    static class Function {
        String name;
        int calls;

        Function(String name) {
            this.name = name;
            this.calls = 0;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();

        Stack<Function> stack = new Stack<>();

        String maxFunction = "";
        int maxCalls = 0;

        for (int i = 0; i < n; i++) {

            String line = input.nextLine();

            if (line.startsWith("Call")) {

                String functionName = line.substring(5);

                // The function on top is the caller
                if (!stack.isEmpty()) {
                    stack.peek().calls++;
                }

                // Start the new function
                stack.push(new Function(functionName));

            } else if (line.equals("Return")) {

                Function finished = stack.pop();

                // Check whether this function has the maximum
                if (finished.calls > maxCalls) {
                    maxCalls = finished.calls;
                    maxFunction = finished.name;
                }
            }
        }

        System.out.println(maxFunction + " " + maxCalls);
    }
}
