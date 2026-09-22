package labs.Lab3;

import java.util.Scanner;
// Given an array, find an increasing subsequence whose product of elements is as large as possible. (works only with positive numbers)
public class Zadaca3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();           // number of elements
        long[] arr = new long[n];       // input array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long[] dp = new long[n];        // dp[i] = max product of increasing subsequence ending at i
        long maxProduct = arr[0];       // keeps the global maximum

        // initialize dp
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];             // each element alone is a subsequence
        }

        // fill dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] * arr[i]);
                }
            }
            maxProduct = Math.max(maxProduct, dp[i]); // update global max
        }

        System.out.println(maxProduct);
    }

}
