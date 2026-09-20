package dynamicProgramming.book;
/*За дадена матрица 𝑋 од реални броеви, од ред 𝑛 × 𝑛 треба да се
избере точно по еден број од секоја редица и секоја колона,така да
нивниот збир биде минимален.*/

import java.util.*;

public class _8_1_IzborNaBrOdMatrica {
    public static int bitcount(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] X = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                X[i][j] = sc.nextInt();

        int[] A = new int[1 << n];
        Arrays.fill(A, Integer.MAX_VALUE);
        A[0] = 0;

        for (int mask = 0; mask < (1 << n) - 1; mask++) {
            int i = bitcount(mask);
            for (int j = 1; j <= n; j++)
                A[mask | (1 << (j - 1))] = Math.min(A[mask | (1 << (j - 1))], A[mask] + X[i][j - 1]);
        }

        System.out.println(A[(1 << n) - 1]);
    }
}