package LeetCode.DP;

/*Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.*/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLength = 1;

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // length = length of the substring we're checking
        for (int length = 2; length <= n; length++) {

            for (int i = 0; i <= n - length; i++) {

                int j = i + length - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    if (length == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        if (length > maxLength) {
                            maxLength = length;
                            start = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        // something simple
    }
}
