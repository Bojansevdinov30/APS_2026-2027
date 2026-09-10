package dynamicProgramming.myExercises;

import java.util.Arrays;
import java.util.Scanner;

public class Coins {

    public static int memoization(int value, int[] coins, int[] memo) {

        if (value == 0) {
            return 0;
        }

        if (value < 0) {
            return Integer.MAX_VALUE;
        }

        if (memo[value] != -1) {
            return memo[value];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = memoization(value - coin, coins, memo);

            if (result != Integer.MAX_VALUE) {
                min = Math.min(min, result);
            }
        }

        if (min == Integer.MAX_VALUE) {
            memo[value] = Integer.MAX_VALUE;
        } else {
            memo[value] = 1 + min;
        }

        return memo[value];
    }

    public static void main(String[] args) {

        // kakvi paricki imame
        int[] coins = {1, 5, 8, 10};

        // do koj broj sakame da odime
        Scanner sc = new Scanner(System.in);
        int SUMS = sc.nextInt();

        // za sekoj broj do brojot sto sakame, kolku paricki bi trebale
        int[] dp = new int[SUMS + 1];
        int[] memo = new int[SUMS + 1];

        for (int i = 1; i <= SUMS; i++) {
            dp[i] = Integer.MAX_VALUE;
            memo[i] = -1;
        }

        dp[0] = 0;
        memo[0] = 0;

        for (int i = 0; i <= SUMS; i++) {

            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int coin : coins) {

                if (i + coin <= SUMS) {
                    dp[i + coin] =
                            Math.min(dp[i + coin], dp[i] + 1);
                }
            }
        }

        System.out.println(memoization(SUMS, coins, memo));

        for (int x : dp) {
            System.out.print(x + " ");
        }
        // tehnicki ako ne interesira samo kolku paricki treba za SUMS, moze da odime do SUMS - min(coins)
    }
}