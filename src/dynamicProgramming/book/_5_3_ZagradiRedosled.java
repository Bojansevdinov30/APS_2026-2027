package dynamicProgramming;

import java.util.Scanner;

/*
Стринговите од правилно поставени мали загради се состојат само од
два карактери: „(“ и „)“. Сметаме дека подредената азбука е ={(, )}.
Според тоа лексикографското подредување на 3 пара загради е
следново: ((())), (()()), (())(), ()(()), ()()().
ПОТПРОБЛЕМ 1
За дадени природни броеви 𝑛 и 𝑘, да се најде 𝑘-тата лексикографски
подредена пермутација од 𝑛 правилно поставени парови на загради.
ПОТПРОБЛЕМ 2
За дадена пермутација од 𝑛 правилно поствени парови загради, да
се определи која по ред е во лексикографското подредување.
*/
public class _5_3_ZagradiRedosled {
    public static int[][] A;

    public static void B(int i, int j, int r) {
        if (i == 0) {
            for (int k = 0; k < j; k++)
                System.out.print(")");
        } else if (j == 0) {
            System.out.print("(");
            B(i - 1, 1, r);
        } else if (r <= A[i - 1][j + 1]) {
            System.out.print("(");
            B(i - 1, j + 1, r);
        } else {
            System.out.print(")");
            B(i, j - 1, r - A[i - 1][j + 1]);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        A = new int[n + 1][n + 1];

        for (int j = 1; j <= n; j++)
            A[0][j] = 1;

        for (int i = 1; i < n; i++) {
            A[i][0] = A[i - 1][1];
            for (int j = 1; j < n; j++) {
                A[i][j] = A[i - 1][j + 1] + A[i][j - 1];
            }
        }

        B(n, 0, k);
    }

    /*
    public static int[][] Avalues;

    public static int A(int i, int j) {
        if (Avalues[i][j] > 0)
            return Avalues[i][j];

        if (i == 0 || i == j)
            Avalues[i][j] = 1;
        else
            Avalues[i][j] = A(i - 1, j - 1) + A(i - 1, j);

        return Avalues[i][j];
    }

    public static int C(int i, int j, String niza) {
        if (i == 0)
            return 1;
        if (niza.charAt(0) == ')')
            return A(i - 1, j + 1) + C(i, j - 1, niza.substring(1));
        else
            return C(i - 1, j + 1, niza.substring(1));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String bitniza = scn.succ();

        Avalues = new int[n + 1][n + 1];

        System.out.println(C(n, 0, bitniza) + 1);
    }
    */
}
