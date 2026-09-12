package book._04_OneDimensionalDataStructures.Stack;
/*Задача 1. Дупли загради
Со користење на податочна структура да се наjде дали еден израз има дупли
загради или не. Изразот е правилен и содржи само еден вид загради (). Докол-
ку има да се испечати соодветна порака. Задачата да се реши со временска и
мемориска сложеност од O(n).
Влез: Во влезот е даден аритметичкиот израз.
Излез: На излез треба да се испечати "Najdeni se dupli zagradi доколку се
наjдени дупли загради во изразот. Доколку нема се печати “/”.
Забелешка: Задачата се решава исклучиво со една податочна структура и
не е дозволено користење на дополнителни други структури.
Пример 1:
Влез:
(((a+(b)))+(c+d))
Излез:
Najdeni se dupli zagradi
Пример 2:
Влез:
((a)+(b))
Излез:
/
*/

import java.util.Stack;
import java.util.Scanner;

public class Zadaca7_DupliZagradi {

    public static boolean imaDupliZagradi(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            if (c == ')') {

                int count = 0;

                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    count++;
                }

                // ја тргаме '('
                stack.pop();

                // ако немало ништо меѓу ( и )
                if (count == 0) {
                    return true;
                }

            } else {
                stack.push(c);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        if (imaDupliZagradi(expression)) {
            System.out.println("Najdeni se dupli zagradi");
        } else {
            System.out.println("/");
        }
    }
}
