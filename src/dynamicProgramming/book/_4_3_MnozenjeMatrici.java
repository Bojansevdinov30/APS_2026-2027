package dynamicProgramming.book;

import java.util.Scanner;

/*
Дадена е низа 𝑋1, 𝑋2, … , 𝑋𝑛, од 𝑛 матрици од ред 𝑝0 × 𝑝1, 𝑝1 × 𝑝2,…,
𝑝𝑛−1 × 𝑝𝑛 , кои треба да се помножат. Поточно, целта е да го
пресметаме производот 𝑋1 ∙ 𝑋2 ∙ … ∙ 𝑋𝑛 . Ова може да се пресмета
користејќи го стандардниот алгоритам за множење на две матрици,
како подрутина. Но, прво треба да се одлучи како да се групираат
матриците, односно како да се постават заградите при множењето.
Множењето матрици е асоцијативно, па сите распореди на заградите
даваат ист производ. На пример, ако се дадени четири матрици е
𝑋1, 𝑋2, 𝑋3, 𝑋4, има пет различни начини за целосно поставување
загради
*/
public class _4_3_MnozenjeMatrici {

    public static void pechatiZagradi(int[][] C, int i, int j) {
        if (i == j) {
            System.out.print("X" + (i + 1));
        } else {
            System.out.print("(");

            pechatiZagradi(C, i, C[i][j]);
            pechatiZagradi(C, C[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // broj na matrici

        int[] p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = scn.nextInt();
        }

        int[][] A = new int[n][n];
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++)
            A[i][i] = 0;

        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n - l - 1; i++) {
                int j = i + l + 1;
                A[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = A[i][k] + A[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < A[i][j]) {
                        A[i][j] = q;
                        C[i][j] = k;
                    }
                }
            }
        }
        System.out.println(A[0][n - 1]);
        pechatiZagradi(C, 0, n - 1);
    }

}
