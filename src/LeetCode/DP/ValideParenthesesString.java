package LeetCode.DP;

/*Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
Example 4:

Input: s = "("
Output: false


Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.*/
public class ValideParenthesesString {
    // ap[i][j] - After processing the first i characters of s, is it possible to have exactly j unmatched '('?
    public static boolean checkValidString(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n + 1][n + 1];

        // Before processing anything,
        // we have 0 unmatched '('
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            for (int j = 0; j <= n; j++) {

                if (!dp[i][j]) {
                    continue;
                }

                // '('
                if (c == '(') {

                    dp[i + 1][j + 1] = true;
                }

                // ')'
                else if (c == ')') {

                    if (j > 0) {
                        dp[i + 1][j - 1] = true;
                    }
                }

                // '*'
                else {

                    // Treat '*' as '('
                    dp[i + 1][j + 1] = true;

                    // Treat '*' as empty
                    dp[i + 1][j] = true;

                    // Treat '*' as ')'
                    if (j > 0) {
                        dp[i + 1][j - 1] = true;
                    }
                }
            }
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        String s = "()";
        String s1 = "(*)";
        String s2 = "(*))";
        String s3 = "(";

        System.out.println(checkValidString(s));
        System.out.println(checkValidString(s1));
        System.out.println(checkValidString(s2));
        System.out.println(checkValidString(s3));
    }
}
