package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8*/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result, String current,
                           int open, int close, int n) {

        // We have used all parentheses
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // We can still add an opening parenthesis
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // We can add ')' only if it won't make the string invalid
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }

    public static void main(){
        // something simple
    }
}
