package dynamicProgramming.book;

import java.util.Scanner;

/*Имаме книга за која се дадени бројот на страници на секоја глава,
𝑥𝑗, 𝑗 = 1, 𝑛̅̅̅̅̅. Треба главите да ги наредиме во томови, така да секој том
има најмногу 𝑚 страници, при што главите не можат да се делат во
два тома*/
public class _6_1_RomanTomovi {

    public static int RekRoman2(int[] x, int i, int m) {
        int b = 0;

        for (int j = i; i >= 0 && b + x[i] <= m; i--)
            b += x[i];

        if (i == -1)
            return 1;

        return 1 + RekRoman2(x, i, m);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = scn.nextInt();
            if (x[i] > m)
                System.out.println("Brojot na strani vo " +
                        i + "-tata galva e pogolem od maksimalniot broj na strani vo tom.");
        }

        System.out.println(RekRoman2(x, n - 1, m));
    }

}
