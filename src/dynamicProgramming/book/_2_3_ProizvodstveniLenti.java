package dynamicProgramming.book;

import java.util.*;

/*
Во овој дел ќе разгледаме оптимизационен проблем, кој што
главниот проблем повторно го намалува на два потпроблеми, но во
овој случај потпроблемите не се од сосема ист тип, како што беше
случај во претходниот проблем. Варијанта односно модификација на
овој проблем е познатиот скриен Марков модел [5] [6], кој е
статистички модел кој се користи на многу места, како финансиска
математика [7], препознавање и синтеза на говор [8], машински
превод, предикција на гени и на многу други места.
*/
public class _2_3_ProizvodstveniLenti {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // number of stations
        int x1, x2; // entry time into line 1 or line 2
        int y1, y2; // exit time from line 1 or line 2
        int B; // minimum final time
        int B1; // which line did we finish on
        int k; // used for reconstruction to tell which line we are currently on
        int[][] s = new int[2][n]; // processing time
        int[][] A = new int[2][n]; // minimum time needed to arrive at station i
        int[][] C = new int[2][n - 1]; // which line are we coming from
        int[][] t = new int[2][n - 1]; // transfer time

        x1 = scn.nextInt();
        x2 = scn.nextInt();
        y1 = scn.nextInt();
        y2 = scn.nextInt();

        for (int i = 0; i < n; i++)
            s[0][i] = scn.nextInt(); // processing time at station i on line 1

        for (int i = 0; i < n; i++)
            s[1][i] = scn.nextInt(); // processing time at station i on line 2

        for (int i = 0; i < n - 1; i++)
            t[0][i] = scn.nextInt(); // transfer time from line 1 at station i to line 2 at station i+1

        for (int i = 0; i < n - 1; i++)
            t[1][i] = scn.nextInt(); // transfer time from line 2 at station i to line 1 at station i+1

        A[0][0] = x1;
        A[1][0] = x2;

        for (int i = 1; i < n; i++) {
            if (A[0][i - 1] + s[0][i - 1] > A[1][i - 1] + s[1][i - 1] + t[1][i - 1]) {
                A[0][i] = A[1][i - 1] + s[1][i - 1] + t[1][i - 1];
                C[0][i - 1] = 2;
            } else {
                A[0][i] = A[0][i - 1] + s[0][i - 1];
                C[0][i - 1] = 1;
            }


            if (A[1][i - 1] + s[1][i - 1] > A[0][i - 1] + s[0][i - 1] + t[0][i - 1]) {
                A[1][i] = A[0][i - 1] + s[0][i - 1] + t[0][i - 1];
                C[1][i - 1] = 1;
            } else {
                A[1][i] = A[1][i - 1] + s[1][i - 1];
                C[1][i - 1] = 2;
            }
        }

        if (A[0][n - 1] + s[0][n - 1] + y1 > A[1][n - 1] + s[1][n - 1] + y2) {
            B = A[1][n - 1] + s[1][n - 1] + y2;
            B1 = 2;
        } else {
            B = A[0][n - 1] + s[0][n - 1] + y1;
            B1 = 1;
        }

        System.out.println(B);

        // Pechati pateka vo obraten redosled
        if (B1 == 1) {
            System.out.print("1 ");
            k = 0;
        } else {
            System.out.print("2 ");
            k = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (C[k][i] == 1) {
                System.out.print("1 ");
                k = 0;
            } else {
                System.out.print("2 ");
                k = 1;
            }
        }
    }

}
