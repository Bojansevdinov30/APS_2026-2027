package book._04_OneDimensionalDataStructures.Stack;

import dataStructures.LinkedStack;

/*
Да се напише алгоритам коj ´ке врши евалуациjа на израз во постфикс нотациjа.
Пример 5 9 + 2 * 6 5 * + изразот е во постфикс нотациjа, и го претставува
изразот (5 + 9) * 2 + 6 * 5, со што по евалуациjата резултатот треба да биде 14
* 2 + 30 = 58.
*/
public class Zadaca2_Postfix {
    // moze i so double ako sakas isto e samo sekade namesto Integer stavas Double
    public static int evaluiraj_postfix(String expression) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        String[] elements = expression.split(" ");

        for (String element : elements) {
            try {
                int num = Integer.parseInt(element);
                stack.push(num);

            } catch (NumberFormatException e) {

                int right = stack.pop();
                int left = stack.pop();

                if (element.equals("+")) {
                    stack.push(left + right);

                } else if (element.equals("-")) {
                    stack.push(left - right);

                } else if (element.equals("*")) {
                    stack.push(left * right);

                } else if (element.equals("/")) {
                    stack.push(left / right);
                }
            }
        }

        return stack.pop();
    }


    public static void main(String[] args) {
        String primer = "51 9 + 2 * 6 5 * +";
        System.out.println("Rezultatot e " + evaluiraj_postfix(primer));

    }
}
