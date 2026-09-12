package book._04_OneDimensionalDataStructures.Stack;
/*Да се напише алгоритам со коj ´ке се имплементира играта за мобилен телефон
“Подреди топчиња според боjа”. Во оваа игра на располагање имате топчиња во
три различни бои (R-црвена, G-зелена и B-сина). На екран имате 3 кутии. Во
првата кутиjа се нао´гаат топчињата кои што ви ги доделува апликациjата на по-
четок на играта. Играта завршува кога ´ке се подредат топчињата според боjа (во
третата кутиjа) и тоа во следниот редослед RGB (односно прво ´ке бидат црвени-
те, па зелените и на краj сините топчиња), а другите кутии се празни. Втората
кутиjа може да jа користите како помошна при распределбата на топчињата.
Притоа треба да се води грижа дека во еден момент само едно топче може да
се вади или става од врвот на кутиjата. Исто така за оваа игра важи следново
правило: Доколку на влез доjдат последователно три топчиња од црвена боjа,
тоа значи “бомба”. Ова значи поништување на сите топчиња последователно што
се нао´гаат во таа кутиjа (што се црвена боjа), се додека не се доjде до топче од
различна боjа.
Влез: Во влезот е даден прво вкупниот броj на топчиња. Следно се дава во
секоj нареден ред соодветно секвенцата од топчиња коjа што треба да jа сместите
во првата кутиjа.
Излез: На излез треба да се испечати состоjбата на топчињата во третата
кутиjа.
Пример 1:
Влез:
4
R
R
R
G
Излез:
G
Пример 2:
Влез:
3
B
B
B
Излез:
B B B
*/
import dataStructures.LinkedStack;

import java.util.Scanner;

public class Zadaca11_TopcinjaBomba {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LinkedStack<Character> box1 = new LinkedStack<>();
        LinkedStack<Character> box2 = new LinkedStack<>();
        LinkedStack<Character> box3 = new LinkedStack<>();

        int consecutiveR = 0;

        // 1. Fill box1 and handle bombs
        for (int i = 0; i < n; i++) {

            char ball = sc.next().charAt(0);

            box1.push(ball);

            if (ball == 'R') {
                consecutiveR++;

                if (consecutiveR == 3) {

                    // Bomb: delete all consecutive R balls from the top
                    while (!box1.isEmpty() && box1.peek() == 'R') {
                        box1.pop();
                    }

                    consecutiveR = 0;
                }

            } else {
                consecutiveR = 0;
            }
        }

        // source and helper will change roles
        LinkedStack<Character> source = box1;
        LinkedStack<Character> helper = box2;

        char[] colors = {'R', 'G', 'B'};

        // 2. Move R, then G, then B into box3
        for (char color : colors) {

            while (!source.isEmpty()) {

                char ball = source.pop();

                if (ball == color) {
                    box3.push(ball);
                } else {
                    helper.push(ball);
                }
            }

            // swap source and helper
            LinkedStack<Character> temp = source;
            source = helper;
            helper = temp;
        }

        // box3 has RGB from bottom to top.
        // To print bottom -> top we need to reverse it once.
        while (!box3.isEmpty()) {
            box2.push(box3.pop());
        }

        while (!box2.isEmpty()) {
            System.out.print(box2.pop());

            if (!box2.isEmpty()) {
                System.out.print(" ");
            }
        }
    }
}
