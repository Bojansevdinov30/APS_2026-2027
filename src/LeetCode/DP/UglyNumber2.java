package LeetCode.DP;
/*An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.



Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.


Constraints:

1 <= n <= 1690*/
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];

        dp[0] = 1;

        int pointer2 = 0;
        int pointer3 = 0;
        int pointer5 = 0;

        for (int i = 1; i < n; i++) {

            int next2 = dp[pointer2] * 2;
            int next3 = dp[pointer3] * 3;
            int next5 = dp[pointer5] * 5;

            dp[i] = Math.min(next2, Math.min(next3, next5));

            if (dp[i] == next2) {
                pointer2++;
            }

            if (dp[i] == next3) {
                pointer3++;
            }

            if (dp[i] == next5) {
                pointer5++;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args){
        // something
    }
}
