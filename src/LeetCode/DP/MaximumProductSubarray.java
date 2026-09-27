package LeetCode.DP;
/*Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.*/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            int newMax = Math.max(
                    current,
                    Math.max(maxProduct * current, minProduct * current)
            );

            int newMin = Math.min(
                    current,
                    Math.min(maxProduct * current, minProduct * current)
            );

            maxProduct = newMax;
            minProduct = newMin;

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }

    public static void main(String[] args){
        // something
    }
}
