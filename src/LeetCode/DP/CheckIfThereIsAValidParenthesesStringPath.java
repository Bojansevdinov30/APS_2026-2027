package LeetCode.DP;
/*A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
You are given an m x n matrix of parentheses grid. A valid parentheses string path in the grid is a path satisfying all of the following conditions:

The path starts from the upper left cell (0, 0).
The path ends at the bottom-right cell (m - 1, n - 1).
The path only ever moves down or right.
The resulting parentheses string formed by the path is valid.
Return true if there exists a valid parentheses string path in the grid. Otherwise, return false.



Example 1:
Input: grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
Output: true
Explanation: The above diagram shows two possible paths that form valid parentheses strings.
The first path shown results in the valid parentheses string "()(())".
The second path shown results in the valid parentheses string "((()))".
Note that there may be other valid parentheses string paths.
Example 2:
Input: grid = [[")",")"],["(","("]]
Output: false
Explanation: The two possible paths form the parentheses strings "))(" and ")((". Since neither of them are valid parentheses strings, we return false.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
grid[i][j] is either '(' or ')'.*/
public class CheckIfThereIsAValidParenthesesStringPath {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // The path length is m + n - 1.
        // Therefore the maximum possible balance
        // cannot be greater than m + n.
        int maxBalance = m + n;

        boolean[][][] dp =
                new boolean[m][n][maxBalance + 1];

        // The first character must be '('
        if (grid[0][0] == ')') {
            return false;
        }

        // We start with balance 1
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                // We already initialized (0,0)
                if (i == 0 && j == 0) {
                    continue;
                }

                for (int balance = 0;
                     balance <= maxBalance;
                     balance++) {

                    // Calculate the balance after entering
                    // the current cell
                    int newBalance;

                    if (grid[i][j] == '(') {
                        newBalance = balance + 1;
                    } else {
                        newBalance = balance - 1;
                    }

                    // Negative balance is impossible
                    if (newBalance < 0 ||
                            newBalance > maxBalance) {
                        continue;
                    }

                    // Can we arrive from above?
                    if (i > 0 && dp[i - 1][j][balance]) {
                        dp[i][j][newBalance] = true;
                    }

                    // Can we arrive from the left?
                    if (j > 0 && dp[i][j - 1][balance]) {
                        dp[i][j][newBalance] = true;
                    }
                }
            }
        }

        // A valid parentheses string must end
        // with balance 0.
        return dp[m - 1][n - 1][0];
    }
    public static void main(String[] args) {
        // something
    }
}
