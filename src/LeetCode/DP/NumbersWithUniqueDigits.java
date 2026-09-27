package LeetCode.DP;
/*Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.



Example 1:

Input: n = 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
Example 2:

Input: n = 0
Output: 1


Constraints:

0 <= n <= 8*/
public class NumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int answer = 10;
        int current = 9;

        for (int digits = 2; digits <= n; digits++) {
            current *= (11 - digits);
            answer += current;
        }

        return answer;
    }

    public static void main(String[] args){
        // something
    }
}
