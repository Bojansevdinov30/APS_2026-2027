package book._04_OneDimensionalDataStructures.Stack;

import dataStructures.LinkedStack;

import java.util.*;
import java.io.*;

/*
Да се напише алгоритам со коj ´ке се имплементира играта “Поништување топчи-
ња”. Во оваа игра на располагање имате топчиња во три различни бои (R-црвена,
G-зелена и B-сина), обележани со знакот + или -. Поништување на топчиња мо-
же да настане само доколку тие се од иста боjа и со спротивен знак. На почеток
се генерира една случаjна листа со топчиња. Ваша задача е од тоj влез, како
доа´гаат топчињата да направите поништување и да кажете колку, од каков тип
(+ или -) и од коjа боjа фалат за да се поништат сите топчиња од влезот.
Влез: Во влезот е дадена листа од случаjни топчиња и тоа во облик: боjа,
знак.
Излез: На излез треба да се испечатат броjот на парови и паровите кои може
да се формираат.
Пример:
Влез: R+ G- G+ G+ R+ B- B+ R- G+ R- B- B+ B+ R+
Парови кои може да се формираат од овоj список се: (R+,R-); (B+, B-); (B-
B+); (R+, R-); (G-, G+); (R+, R-) Остануваат без партнер: G+, G+, B+, R+
Излез:
4
R- G- G- B+
*/
public class Zadaca4_RGBTopcinja {

    public static void topcinja(String expression) {
        String[] tokens = expression.split(" ");
        LinkedStack<Character> blue = new LinkedStack<>();
        LinkedStack<Character> red = new LinkedStack<>();
        LinkedStack<Character> green = new LinkedStack<>();
        for (String token : tokens) {
            if (token.charAt(0) == 'B') {
                if (blue.isEmpty() || token.charAt(1) == '+' && blue.peek().equals('+') || token.charAt(1) == '-' && blue.peek().equals('-')) {
                    blue.push(token.charAt(1));
                } else if (token.charAt(1) == '+' && blue.peek() == '-' || token.charAt(1) == '-' && blue.peek() == '+') {
                    blue.pop();
                }
            } else if (token.charAt(0) == 'R') {
                if (red.isEmpty() || token.charAt(1) == '+' && red.peek().equals('+') || token.charAt(1) == '-' && red.peek().equals('-')) {
                    red.push(token.charAt(1));
                } else if (token.charAt(1) == '+' && red.peek() == '-' || token.charAt(1) == '-' && red.peek() == '+') {
                    red.pop();
                }
            } else if (token.charAt(0) == 'G') {
                if (green.isEmpty() || token.charAt(1) == '+' && green.peek().equals('+') || token.charAt(1) == '-' && green.peek().equals('-')) {
                    green.push(token.charAt(1));
                } else if (token.charAt(1) == '+' && green.peek() == '-' || token.charAt(1) == '-' && green.peek() == '+') {
                    green.pop();
                }
            }
        }

        System.out.println(red.size() + green.size() + blue.size());
        StringBuilder result = new StringBuilder();
        while (!red.isEmpty()) {
            if (red.peek() == '-') {
                result.append("R+ ");
            } else if (red.peek() == '+') {
                result.append("R- ");
            }
            red.pop();
        }
        while (!green.isEmpty()) {
            if (green.peek() == '-') {
                result.append("G+ ");
            } else if (green.peek() == '+') {
                result.append("G- ");
            }
            green.pop();
        }
        while (!blue.isEmpty()) {
            if (blue.peek() == '-') {
                result.append("B+");
                blue.pop();
                if (!blue.isEmpty()) {
                    result.append(" ");
                }
            } else if (blue.peek() == '+') {
                result.append("B-");
                blue.pop();
                if (!blue.isEmpty()) {
                    result.append(" ");
                }
            }

        }
        System.out.println(result.toString());

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        topcinja(expression);

    }
}
