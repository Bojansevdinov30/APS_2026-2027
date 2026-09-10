package dynamicProgramming.book;

import java.util.Scanner;

/*
За дадени природни броеви 𝑛 и 𝑚, 𝑛 > 𝑚, да се формираат битови
низи со должина n, кои имаат точно 𝑚 единици.
ПОТПРОБЛЕМ 1
За дадено 𝑘 ≤ ( 𝑛
𝑚), да се најде 𝑘-тиот елемент од оваа низа.
ПОТПРОБЛЕМ 2
За даден елемент од низата да се пресмета неговата позиција во
низата.
На пример, ако 𝑛 = 4, а 𝑚 = 2 низите кои се бараат се подредени по
лексикографски редослед се: 0011, 0101, 0110, 1001, 1010, 1100.
Значи ако ни се бара 3-тата низа, треба да се отпечати 0110, а ако ни
се бара која е позицијата на 1010, треба да се отпечати 5.
*/
public class _5_2_BitstringEdinici {
    public static int[][] Avalues;

    public static int A(int i, int j) {
        if (Avalues[i][j] > 0)
            return Avalues[i][j];

        if (j == 0 || i == j)
            Avalues[i][j] = 1;
        else
            Avalues[i][j] = A(i - 1, j - 1) + A(i - 1, j);

        return Avalues[i][j];
    }

    public static void B(int i, int j, int r) {
        if (i == j && j == r && r == 1)
            System.out.print("1");
        else if (i == r && r == 1 && j == 0)
            System.out.print("0");
        else if (r > A(i - 1, j)) {
            System.out.print("1");
            B(i - 1, j - 1, r - A(i - 1, j));
        } else {
            System.out.print("0");
            B(i - 1, j, r);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int k = scn.nextInt();

        Avalues = new int[n + 1][m + 1];
        B(n, m, k);
    }

    /*
    public static int[][] Avalues;

    public static int A(int i, int j) {
        if (Avalues[i][j] > 0)
            return Avalues[i][j];

        if (j == 0 || i == j)
            Avalues[i][j] = 1;
        else
            Avalues[i][j] = A(i - 1, j - 1) + A(i - 1, j);

        return Avalues[i][j];
    }

    public static int C(int i, int j, String niza) {
        if (i == j && j == 1 && niza.compareTo("0") == 0)
            return 0;
        else if (i == j && j == 1 && niza.compareTo("1") == 0)
            return 1;
        else if (niza.charAt(0) == '1')
            return A(i - 1, j) + C(i - 1, j - 1, niza.substring(1));
        else
            return C(i - 1, j, niza.substring(1));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        String bitniza = scn.next();

        Avalues = new int[n + 1][m + 1];

        System.out.println(C(n, m, bitniza));
    }
    */
}
