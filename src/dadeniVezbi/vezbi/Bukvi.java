package dadeniVezbi.vezbi;

import java.util.Scanner;
import java.util.Stack;

/*Дадена е низа од големи букви, во која буквата S се појавува парен број пати. После секоја буква S буквата Т се појавува еднаш или
повеќе пати.Користејќи стек да се одреди дали после секоја буква S (до следната буква S), буквата Т се појавува ист број на пати.
На првиот ред од влезот се чита низа од карактери (стринг), на излез се печати 1 доколку буквата Т се појавува ист број на пати
после секоја S, и нула доколку овој услов не е исполнет.
 */
public class Bukvi {
    public static boolean checkAppearances(String s) {
        char[] charArray = s.toCharArray();

        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            charStack.push(charArray[i]);
        }

        int counter = 0;
        Stack<Integer> counters = new Stack<>();

        for (int i = 0; i < charStack.size(); i++) {
            Character c = charStack.peek();
            if (c == 'S' && charStack.size() - 1 > 0) {
                counter = 0;
                charStack.pop();
                c = charStack.peek();
                while (c != 'S') {
                    c = charStack.peek();
                    if (c == 'T') {
                        counter++;
                    }
                    if (c != 'S') {
                        c = charStack.pop();
                    } else {
                        counters.push(counter);
                    }
                }
            } else {
                charStack.pop();
            }
        }

        int p = counters.pop();

        for (int i = 0; i < counters.size(); i++) {
            int c = counters.peek();
            if (p != c) {
                return false;
            } else {
                p = c;
                counters.pop();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(checkAppearances(s));
    }

}
