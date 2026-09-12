package book._04_OneDimensionalDataStructures.Stack;

import dataStructures.LinkedStack;

import java.io.IOException;
import java.util.Scanner;

/*Да се напише алгоритам со коj ´ке се изврши креирање на танцови парови по
соодветни танц-групи во една танцова школа. Танцов пар се формира од машко
и женско запишани на иста танцова група. Во школата за танци на располагање
има групи за основни танци О, стандардни танци S и латино танци L. Има уписен
рок така што заинтересираните кандидати може да се упишат. Со завршување на
уписниот рок се врши формирање на танцови двоjки. Ваша задача е од добиениот
список на сите запишани кандидати да направите соодветни парови и да кажете
колку, од каков тип на кандидати (машко или женско) и за коjа танцова група
фалат за да сите добиjат своj партнер.
Влез: Во влезот е дадена листа од упишаните кандидати по редослед: прв
доjден, прв запишан и тоа во облик: танцова група, пол.
Излез: На излез треба да се испечатат броjот на двоjките кои се формираат
и самите двоjки.
Пример:
Влез:
LM OZ OM OM LM SZ SM LZ OM LZ SZ SM SM LM
Парови кои може да се формираат од овоj список се: (LM,LZ); (SM, SZ); (SZ
SM); (LM, LZ); (OZ, OM); (LM, LZ)
Остануваат без партнер: OM, OM, SM, LM
Излез:
4
OZ OZ SZ LZ*/
public class Zadaca10_TancoviDvojki {

    public static void tanc(String expression) {
        String[] tokens = expression.split(" ");
        LinkedStack<Character> osnovni = new LinkedStack<>();
        LinkedStack<Character> standardni = new LinkedStack<>();
        LinkedStack<Character> latino = new LinkedStack<>();
        for (String token : tokens) {
            if (token.charAt(0) == 'O') {
                if (osnovni.isEmpty() || token.charAt(1) == 'M' && osnovni.peek().equals('M') || token.charAt(1) == 'Z' && osnovni.peek().equals('Z')) {
                    osnovni.push(token.charAt(1));
                } else if (token.charAt(1) == 'M' && osnovni.peek() == 'Z' || token.charAt(1) == 'Z' && osnovni.peek() == 'M') {
                    osnovni.pop();
                }
            } else if (token.charAt(0) == 'S') {
                if (standardni.isEmpty() || token.charAt(1) == 'M' && standardni.peek().equals('M') || token.charAt(1) == 'Z' && standardni.peek().equals('Z')) {
                    standardni.push(token.charAt(1));
                } else if (token.charAt(1) == 'M' && standardni.peek() == 'Z' || token.charAt(1) == 'Z' && standardni.peek() == 'M') {
                    standardni.pop();
                }
            } else if (token.charAt(0) == 'L') {
                if (latino.isEmpty() || token.charAt(1) == 'M' && latino.peek().equals('M') || token.charAt(1) == 'Z' && latino.peek().equals('Z')) {
                    latino.push(token.charAt(1));
                } else if (token.charAt(1) == 'M' && latino.peek() == 'Z' || token.charAt(1) == 'Z' && latino.peek() == 'M') {
                    latino.pop();
                }
            }
        }

        System.out.println(standardni.size() + latino.size() + osnovni.size());
        StringBuilder result = new StringBuilder();
        while (!osnovni.isEmpty()) {
            if (osnovni.peek() == 'Z') {
                result.append("OM ");
            } else if (osnovni.peek() == 'M') {
                result.append("OZ ");
            }
            osnovni.pop();
        }
        while (!standardni.isEmpty()) {
            if (standardni.peek() == 'Z') {
                result.append("SM ");
            } else if (standardni.peek() == 'M') {
                result.append("SZ ");
            }
            standardni.pop();
        }
        while (!latino.isEmpty()) {
            if (latino.peek() == 'Z') {
                result.append("LM");
                latino.pop();
                if (!latino.isEmpty()) {
                    result.append(" ");
                }
            } else if (latino.peek() == 'M') {
                result.append("LZ");
                latino.pop();
                if (!latino.isEmpty()) {
                    result.append(" ");
                }
            }

        }
        System.out.println(result.toString());

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        tanc(expression);

    }
}
