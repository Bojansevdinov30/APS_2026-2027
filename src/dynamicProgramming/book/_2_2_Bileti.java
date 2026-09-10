package dynamicProgramming.book;

import java.util.*;

/*
Пред благајната во театар стојат 𝑛 луѓе и чекаат да купат билети. На
𝑘 -тиот човек во редот му треба 𝑡𝑘 време за да купи билет, 𝑘 =
1, 𝑛̅̅̅̅̅, 𝑡𝑘 > 0. Секој човек може да се здружи со следниот во редот.
Времето потребно за да 𝑘 -тиот и 𝑘 + 1-от човек купат билет доколку
се здружат, изнесува 𝑝𝑘, 𝑘 = 1, 𝑛 − 1̅̅̅̅̅̅̅̅̅̅. Со тоа купувањето може, а и не
мора, да се забрза. Да се одреди таков начин на здружување на
луѓето во кој што вкупното време потребно сите 𝑛 луѓе да купат билет
да биде минимално.
Влезни податоци се бројот 𝑛 и низите 𝑡𝑘 и 𝑝𝑘 . Како излез
треба да се испишат редните броеви на оние луѓе кои се здружуваат
со следниот во редот.
*/
public class _2_2_Bileti {

    public static int MAX = 1001;

    public static long[] t = new long[MAX];
    public static long[] p = new long[MAX];
    public static long[] a = new long[MAX];
    public static long[] c = new long[MAX];

    public static int n;

    public static void print_pairs(int i) {
        if (i < 2)
            return;

        if (c[i] == 1) {
            print_pairs(i - 2);
            System.out.println("Treba da se spojat " + (i - 1) + " i " + i);
        } else {
            print_pairs(i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++)
            t[i] = sc.nextInt();
        for (int i = 1; i < n; i++)
            p[i] = sc.nextInt();

        a[0] = 0;
        a[1] = t[1];
        c[1] = 0;

        for (int i = 2; i <= n; i++) {

            if (a[i - 1] + t[i] > a[i - 2] + p[i - 1]) {
                a[i] = a[i - 2] + p[i - 1];
                c[i] = 1;
            } else {
                a[i] = a[i - 1] + t[i];
                c[i] = 0;
            }
        }

        System.out.println("Vkupno vreme " + a[n - 1]); // a[n] izgleda mislat
        print_pairs(n);
    }

}
