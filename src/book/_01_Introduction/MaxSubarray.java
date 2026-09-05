package book._01_Introduction;

public class MaxSubarray {

    // Finding max subarray using divide and conquer: O(n log n).
    public static int maxSubarrayDivideConquer(int[] arr, int left, int right) {
        // Base case: only one element.
        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;

        // Best subarray completely inside the left half.
        int leftMax = maxSubarrayDivideConquer(arr, left, mid);

        // Best subarray completely inside the right half.
        int rightMax = maxSubarrayDivideConquer(arr, mid + 1, right);

        // Best subarray that crosses the middle.
        int crossingMax = maxCrossingSum(arr, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossingMax);
    }

    private static int maxCrossingSum(int[] arr, int left, int mid, int right) {
        int sum = 0;
        int bestLeft = Integer.MIN_VALUE;

        // Go from the middle toward the left.
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            bestLeft = Math.max(bestLeft, sum);
        }

        sum = 0;
        int bestRight = Integer.MIN_VALUE;

        // Go from mid + 1 toward the right.
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            bestRight = Math.max(bestRight, sum);
        }

        return bestLeft + bestRight;
    }

    // Finding max subarray using Kadane's algorithm: O(n).
    public static int kadane(int[] arr) {
        int current = arr[0];
        int best = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            best = Math.max(best, current);
        }

        return best;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 3, -1, 5, -6, 2, 4, -3};

        System.out.println(maxSubarrayDivideConquer(arr, 0, arr.length - 1));
        System.out.println(kadane(arr));
    }
}
