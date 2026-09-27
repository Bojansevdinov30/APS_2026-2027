package LeetCode.DP;

import java.util.Arrays;

/*You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].*/
public class JumpGame2 {
    // dp solution
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int counter = 1;
        dp[0] = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <= i + nums[i] && j < n; j++) {
                if (counter < dp[j]) {
                    dp[j] = counter;
                }
            }
            counter = dp[i+1] + 1;
        }
        return dp[n - 1];
    }

    // greedy solution
    public static int jump2(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1, 1, 1};
        //            {0, 1, 2, 2, 3}
        System.out.println(jump(nums1));
    }
}
