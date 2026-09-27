package LeetCode.DP;

/*Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.



Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.*/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        int answer = 0;

        for (int i = 1; i < n; i++) {

            if (s.charAt(i) == ')') {

                // Case 1: "()"
                if (s.charAt(i - 1) == '(') {

                    dp[i] = 2;

                    if (i >= 2) {
                        dp[i] += dp[i - 2];
                    }
                }

                // Case 2: "))"
                else {
                    int previousLength = dp[i - 1];
                    int matchingOpen = i - previousLength - 1;

                    if (matchingOpen >= 0 &&
                            s.charAt(matchingOpen) == '(') {

                        dp[i] = previousLength + 2;

                        if (matchingOpen >= 1) {
                            dp[i] += dp[matchingOpen - 1];
                        }
                    }
                }

                answer = Math.max(answer, dp[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        //something
    }
}
