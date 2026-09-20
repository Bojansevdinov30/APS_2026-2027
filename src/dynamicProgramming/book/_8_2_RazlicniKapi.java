package dynamicProgramming.book;

import java.util.*;

/*Нека има 𝑛 различни видови на капи и 𝑚 луѓе. Секој човек поседува
дел од видовите на капи, и секој има барем еден тип на капи, но не
мора да има од сите видови. Тие сакаат да отидат на забава, но за да
забавата биде интересна решиле секој од нив да носи различна капа.
На колку начини може да се направи тоа, ако за секој човек е дадена
листата од капи кои тој ја има во својата колекција.
Јасно е во проблемот дека бројот на различни видови на капи мора
да биде поголем од бројот на луѓе, и во задачата бројот на капи може
да биде многу голем, но за да точно се избројат сите можности бројот
на луѓе мора да е мал, најмногу до 30.*/
public class _8_2_RazlicniKapi {

    public static int n;
    public static int m;
    public static int[][] B;
    public static int[] broj_el;
    public static ArrayList<Integer>[] kapa;

    public static int A(int mask, int j) {
        if (mask < 0 || j < 0)
            return 0;
        if (B[mask][j] != -1) {
            return B[mask][j];
        }
        if (broj_el[mask] > j + 1) {
            B[mask][j] = 0;
        } else {
            B[mask][j] = A(mask, j - 1);
            for (int i : kapa[j]) {
                if ((mask & (1 << (i - 1))) > 0) {
                    int mask1 = mask & ~(1 << (i - 1));
                    broj_el[mask1] = broj_el[mask] - 1;
                    B[mask][j] = B[mask][j] + A(mask1, j - 1);
                }
            }
        }
        return B[mask][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        B = new int[1 << m][n];
        broj_el = new int[(1 << m)];
        kapa = new ArrayList[n];
        for (int[] row : B)
            Arrays.fill(row, -1);

        for (int i = 1; i < B.length; i++)
            broj_el[i] = Integer.bitCount(i);

        for (int j = 0; j < n; j++) {
            ArrayList k = new ArrayList();
            int iii = sc.nextInt();
            for (int ii = 0; ii < iii; ii++) {
                int kk = sc.nextInt();
                k.add(kk);
                for (int jj = j; jj < n; jj++) {
                    if (B[1 << (kk - 1)][jj] == -1)
                        B[1 << (kk - 1)][jj] = 0;
                    B[1 << (kk - 1)][jj]++;
                }
            }
            kapa[j] = k;
        }
        broj_el[(1 << m) - 1] = m;
        System.out.println(A((1 << m) - 1, n - 1));
    }

}
