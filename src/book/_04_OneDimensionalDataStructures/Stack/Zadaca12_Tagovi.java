package book._04_OneDimensionalDataStructures.Stack;

// Во задачава се бара да видам дали валидни се таговите или не.
// Валидни тагови се ако за секој отворачки таг имам затворачки
// [tag1][/tag1]
// Невалидно е ако е вака: [tag1][/tag2]
// [tag1][tag2][/tag1][tag2]

// Задачата ја решавам со тоа што користам стек,
// секогаш кога ќе наидам на [ карактер, проверувам дали е отворачки или затворачки
// ако е отворачки го ставам во стекот ако е затворачки проверувам дали
// најгорниот елемент на стекот е соодветен на затворачкиот таг. Ако е соодветен, го тргнувам од стекот
// ако не е соодветен, го кршам форот, валид е 0 и го печатам валид


import java.util.Scanner;
import java.util.Stack;

public class Zadaca12_Tagovi {

    public static boolean validTags(String[] lines) {

        Stack<String> stack = new Stack<>();

        for (String token : lines) {

            // Ignore lines that aren't tags
            if (!token.startsWith("[")) {
                continue;
            }

            // Opening tag
            if (!token.startsWith("[/")) {
                stack.push(token);
            }

            // Closing tag
            else {

                // Closing tag but nothing is open
                if (stack.isEmpty()) {
                    return false;
                }

                String opening = stack.pop();

                // [tag1] -> tag1
                String openingName =
                        opening.substring(1, opening.length() - 1);

                // [/tag1] -> tag1
                String closingName =
                        token.substring(2, token.length() - 1);

                // The names must match
                if (!openingName.equals(closingName)) {
                    return false;
                }
            }
        }

        // If something is still open, expression isn't valid
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        String[] lines = new String[n];

        for (int i = 0; i < n; i++) {
            lines[i] = sc.nextLine();
        }

        if (validTags(lines)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}