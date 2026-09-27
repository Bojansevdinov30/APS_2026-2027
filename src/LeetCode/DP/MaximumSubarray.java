package LeetCode.DP;
/*Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/
public class MaximumSubarray {
    // Kadane's O(n) solution
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maximum = -100000;
        int ultimateMax = -100000;
        for(int i=0; i< n; i++){
            maximum = Math.max(nums[i], nums[i] + maximum);
            ultimateMax = Math.max(maximum, ultimateMax);
        }
        return ultimateMax;
    }

    // divide and conquer's O(nlogn) solution
    public int conquer(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int left, int right) {

        // One element
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        // Best subarray completely on the left
        int leftMax = divide(nums, left, mid);

        // Best subarray completely on the right
        int rightMax = divide(nums, mid + 1, right);

        // Best subarray crossing the middle
        int leftSum = 0;
        int bestLeft = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            leftSum += nums[i];
            bestLeft = Math.max(bestLeft, leftSum);
        }

        int rightSum = 0;
        int bestRight = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            rightSum += nums[i];
            bestRight = Math.max(bestRight, rightSum);
        }

        int crossingMax = bestLeft + bestRight;

        return Math.max(
                Math.max(leftMax, rightMax),
                crossingMax
        );
    }

    public static void main(String[] args) {
        // something simple
    }
}
