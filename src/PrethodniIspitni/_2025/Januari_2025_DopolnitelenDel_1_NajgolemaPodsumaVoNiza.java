package PrethodniIspitni._2025;

import java.util.Scanner;

/*Да се напише низа од зборови и да се најде најголемата подсума од низата т.ш. вредноста на еден збор е еднаков на неговата должина. Ако зборот ја има буквата f да де додели негативна вредност. Да се реши задачата со комплексност од О(n*logn)
Пр.
hello
good
f
example
wonderful
->[5,4,-1,7,-9]
output: 15*/
public class Januari_2025_DopolnitelenDel_1_NajgolemaPodsumaVoNiza {
    public static int maxCrossingSum(int[] arr, int left, int mid, int right) {

        // Find the best sum going from mid towards the left
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= left; i--) {
            sum += arr[i];

            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        // Find the best sum going from mid + 1 towards the right
        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];

            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        // The best subarray crossing the middle
        return leftSum + rightSum;
    }

    public static int maxSubarraySum(int[] arr, int left, int right) {

        // Only one element
        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;

        // Best subarray completely in the left half
        int leftMax = maxSubarraySum(arr, left, mid);

        // Best subarray completely in the right half
        int rightMax = maxSubarraySum(arr, mid + 1, right);

        // Best subarray crossing the middle
        int crossingMax = maxCrossingSum(arr, left, mid, right);

        return Math.max(
                Math.max(leftMax, rightMax),
                crossingMax
        );
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            String word = input.next();

            int value = word.length();

            if (word.contains("f")) {
                value = -value;
            }

            arr[i] = value;
        }

        int result = maxSubarraySum(arr, 0, n - 1);

        System.out.println(result);
    }
}
/*O(n) solution using Kadane's algorithm
public class Zadaca6 {

    public static int maxSubarraySum(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            currentSum = Math.max(arr[i], currentSum + arr[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            String word = input.next();

            int value = word.length();

            if (word.contains("f")) {
                value = -value;
            }

            arr[i] = value;
        }

        System.out.println(maxSubarraySum(arr));
    }
}*/