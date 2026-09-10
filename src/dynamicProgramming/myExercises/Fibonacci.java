package dynamicProgramming.myExercises;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

    public static long fibMemo(int n) {
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);

        return fibMemo(n, memo);
    }

    private static long fibMemo(int n, long[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n <= 1) {
            return n;
        }

        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }

    public static long fibTabu(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static long fibOptimized(int n) {
        if (n <= 1) {
            return n;
        }
        long prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            long current = prev2 + prev1;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(fibMemo(n));
        System.out.println();
        System.out.println(fibTabu(n));
        System.out.println();
        System.out.println(fibOptimized(n));

    }
}
