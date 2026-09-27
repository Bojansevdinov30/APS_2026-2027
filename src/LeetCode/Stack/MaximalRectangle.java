package LeetCode.Stack;

import java.util.Stack;

/* !!!
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.



Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1


Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= rows, cols <= 200
matrix[i][j] is '0' or '1'.*/
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {

            // Build histogram
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Largest rectangle in histogram
            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
    }

    private int largestRectangle(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // something
    }
}
