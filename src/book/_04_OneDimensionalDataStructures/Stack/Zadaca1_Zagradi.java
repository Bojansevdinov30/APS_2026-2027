package book._04_OneDimensionalDataStructures.Stack;


import dataStructures.ArrayStack;

/*Да се провери коректноста на заградите во еден израз. Еден израз има коректни
загради ако:
- За секоjа лева заграда, подоцна следува соодветна десна заграда - За секоjа
десна заграда претходно постои лева заграда
- Секоj под-израз ме´гу пар од две загради содржи коректен броj на загради.*/
public class Zadaca1_Zagradi {
    public static boolean matching(char left, char right) {
        if (left == '(' && right == ')') return true;
        if (left == '[' && right == ']') return true;
        if (left == '{' && right == '}') return true;
        return false;
    }

    public static boolean daliZagraditeSePravilni(String phrase) {
        ArrayStack<Character> brackets = new ArrayStack<>(phrase.length());

        for (int i = 0; i < phrase.length(); i++) {
            char curr = phrase.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                brackets.push(curr);
            } else if (curr == ')' || curr == ']' || curr == '}') {
                if (brackets.isEmpty()) {
                    return false;
                }
                char left = brackets.pop();
                if (!matching(left, curr)) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        String phrase = "s x (s - a) x (s - b) x (s - c)";
        // String phrase = "s x (s - a) x s - b) x (s - c)";
        System.out.println(phrase + " ima " + (daliZagraditeSePravilni(phrase) ? "korektni" :
                "nekorektni") + " zagradi.");
    }
}
