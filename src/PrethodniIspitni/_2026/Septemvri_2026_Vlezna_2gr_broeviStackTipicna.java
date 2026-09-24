package PrethodniIspitni._2026;

import java.util.Scanner;

/*Испит септември - влезна задача - втора група
Се составува број од цифри од 0 до 9. Прво се внесува N број кој означува број на команди и потоа N команди составени од наредба и цифра d.
 Наредбите се следни:
ADD <digit>: се додава цифра на бројот
REMOVE <digit>: се брише цифрата од бројот но само ако цифрата е иста како таа што е дадена во ADD. Ако не е иста, се печати INVALID COMMAND
 и завршува програмата
PRINT: се печатат две линии: прво се печати составениот број, а потоа се печати спротивниот број.
Доколку нема внесено цифри се печати EMPTY
ADD и REMOVE треба да се извршуваат со комплексност O(1) и PRINT со O(k) каде k е број на цифри.
Примери:
Влез:
9
ADD 5
ADD 2
PRINT
ADD 5
PRINT
REMOVE 5
REMOVE 2
ADD 9
PRINT

Излез:
52
25
525
525
59
95

Влез:
6
PRINT
ADD 7
REMOVE 7
PRINT
ADD 4
REMOVE 5

Излез:
EMPTY
EMPTY
INVALID COMMAND*/
public class Septemvri_2026_Vlezna_2gr_broeviStackTipicna {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // At most N digits can be added
        int[] stack = new int[n];

        // Points to the first empty position
        int top = 0;

        for (int i = 0; i < n; i++) {

            String command = sc.next();

            if (command.equals("ADD")) {

                int digit = sc.nextInt();

                stack[top] = digit;
                top++;

            } else if (command.equals("REMOVE")) {

                int digit = sc.nextInt();

                // Check whether there is a digit
                // and whether it is the same as the given digit
                if (top > 0 && stack[top - 1] == digit) {

                    top--;

                } else {

                    System.out.println("INVALID COMMAND");
                    return;
                }

            } else if (command.equals("PRINT")) {

                if (top == 0) {

                    System.out.println("EMPTY");

                } else {

                    // Print the number normally
                    for (int j = 0; j < top; j++) {
                        System.out.print(stack[j]);
                    }

                    System.out.println();

                    // Print the number backwards
                    for (int j = top - 1; j >= 0; j--) {
                        System.out.print(stack[j]);
                    }

                    System.out.println();
                }
            }
        }
    }
}
