package dynamicProgramming.book;

import java.util.Scanner;

/*
Дадена матрица од ред 𝑛 × 𝑚 во која има препреки и може да се
движите само надолу или надесно за еден чекор, од едно поле на
соседното. Движењето почнува од горниот лев агол, за кој сметаме
дека се наоѓа на полето (1, 1) а завршува во долниот десен агол.
Дадени се димензиите на матрицата, и позициите на секое поле во
матрицата на која не може да се настапне.
a. Да се пресмета бројот на можни патишта!
b. Нека на секое поле (𝑖, 𝑗) во матрицата има позитивен број на
поени, 𝑠𝑖𝑗, кои се освојуваат ако се помине низ тоа поле. Да
се најде патот по кој ќе се соберат највеќе поени!
*/
public class _3_1_PatNizMatrica {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] A = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                A[i][j] = scn.nextInt();

        if (A[0][0] != 0)
            A[0][0] = 1;

        for (int j = 1; j < m; j++)
            if (A[0][j] != 0)
                A[0][j] = A[0][j - 1];

        for (int i = 1; i < n; i++)
            if (A[i][0] != 0)
                A[i][0] = A[i - 1][0];

        for (int j = 2; j < m; j++)
            for (int i = 2; i < n; i++)
                if (A[i][j] != 0)
                    A[i][j] = A[i][j - 1] + A[i - 1][j];

        System.out.println(A[n - 1][m - 1]);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void main2(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] s = new int[n][m];
        int[][] A = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                s[i][j] = scn.nextInt();
            }

        if (s[0][0] != 0) {
            A[0][0] = s[0][0];
        }

        for (int j = 1; j < m; j++) {
            if (s[0][j] != 0 && A[0][j - 1] != 0) {
                A[0][j] = A[0][j - 1] + s[0][j];
            }
        }

        for (int i = 1; i < n; i++) {
            if (s[i][0] != 0 && A[i - 1][0] != 0) {
                A[i][0] = A[i - 1][0] + s[i][0];
            }
        }
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (s[i][j] != 0) {
                    if (A[i][j - 1] > A[i - 1][j]) {
                        if (A[i][j - 1] != 0) {
                            A[i][j] = A[i][j - 1] + s[i][j];
                        }
                    } else {
                        if (A[i - 1][j] != 0) {
                            A[i][j] = A[i - 1][j] + s[i][j];
                        }
                    }
                }
            }
        }
        System.out.println(A[n - 1][m - 1]);
        printMatrix(A);

        //pechati pateka
        int i = n - 1;
        int j = m - 1;
        System.out.println(i + " " + j);
        while (i > 0 || j > 0) {
            if (j > 0 && A[i][j] - s[i][j] == A[i][j - 1]) {
                System.out.println(i + " " + (j - 1));
                j--;
            } else {
                System.out.println((i - 1) + " " + j);
                i--;
            }
        }
    }
}
