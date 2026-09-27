package LeetCode.DP;

/*Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
Return a boolean indicating whether the matching covers the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".


Constraints:

1 <= s.length <= 20
1 <= p.length <= 20
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.*/
public class RegExMatching_PerfectProblemForExercise {

    // We defined: dp[i][j] as: Does the first i characters of s match the first j characters of p
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Empty string vs patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // Normal character or '.'
                if (p.charAt(j - 1) == '.' ||
                        p.charAt(j - 1) == s.charAt(i - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '*'
                else if (p.charAt(j - 1) == '*') {

                    // '*' matches zero occurrences
                    dp[i][j] = dp[i][j - 2];

                    // '*' matches one or more occurrences
                    if (p.charAt(j - 2) == '.' ||
                            p.charAt(j - 2) == s.charAt(i - 1)) {

                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        // something
    }
}
