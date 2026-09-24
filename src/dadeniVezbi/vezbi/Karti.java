package dadeniVezbi.vezbi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*Перо прави трик со карти. Тој има шпил од 51-на карта (некој некогаш не му вратил една) од којшто ви дозволува да влечете карта.
Тој, за трикот да биде веродостоен, не ја знае картата, но знае на која позиција се наоѓа. Мааната на Перо е тоа што тој не знае
регуларно да измеша карти, туку ги зема првите седум карти, им им го превртува редоследот ( пр. од 1 2 3 4 5 6 7 ги реди во 7 6 5 4 3 2 1),
потоа зема една карта од превртените и една од врвот од шпилот и го става на крајот од шпилот, така се додека не ги потроши сите седум
карти. Со тоа остварува едно мешање на шпил. Ваша задача е, да изработите симулцаија на ваквото мешање, такашто за дадена N-та карта т.ш.
 1<=N<=51, вие ќе му изброите колку вакви мешања треба тој да направи за на врв на шпилот да дојде извлечената карта.

Input
15
Result
1

Input
12
Result
25

Input
49
Result
10*/
public class Karti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> cardDeck = new LinkedList<>();

        for (int i = 1; i <= 51; i++) {
            cardDeck.add(i);
        }

        Stack<Integer> sevenCards = new Stack<>();
        int counter = 0;

        while(cardDeck.peek() != n) {
            for (int i = 0; i < 7; i++) {
                sevenCards.push(cardDeck.poll());
            }

            for (int i = 0; i < 7; i++) {
                cardDeck.add(sevenCards.pop());
                cardDeck.add(cardDeck.poll());
            }

            counter++;
        }

        System.out.println(counter);
    }
}
