package LeetCode.Queue;

import java.util.*;

/*You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length*/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 1. Remove elements that are outside the window
            while (!deque.isEmpty() &&
                    deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            // 2. Remove elements smaller than nums[i]
            //    because they can never become maximum
            while (!deque.isEmpty() &&
                    nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }

            // 3. Add current index
            deque.addLast(i);

            // 4. Once we have a complete window,
            //    the front is the maximum
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // something
    }
}
