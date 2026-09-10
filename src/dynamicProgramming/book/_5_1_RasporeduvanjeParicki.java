package dynamicProgramming.book;

import java.util.Scanner;

/*
Пијалоците кои се порачуваат од автоматот за пијалоци, можат да се
платат со железни парички, но само со монети од еден и два денари.
Монетите се пуштаат во автоматот една по една. Начините на
плаќање на сума од 𝑛 денари ги подредувме следејќи го следново
правило:
o Од две низи со ист префикс кои прв пат се разликуваат во 𝑖-
тиот број, низата на која 𝑖-тиот број е 2 е пред низата на која 𝑖-
тиот број е 1. Под префикс се подразбира и празeн стринг
На пример за сума од 𝑛 = 5 денари редоследот на низите е
следен: 221, 212, 2111, 122, 1211, 1121, 1112, 11111.
ПОТПРОБЛЕМ 1
За дадена пермутација од парички од еден и два денари на кои
сумата им е 𝑛, да се пресмета нејзината позиција во подредената
низа од сите пермутации од монети од еден и два денари со сума 𝑛.
ПОТПРОБЛЕМ 2
За дадени 𝑛 и 𝑘, да се најде 𝑘-тата пермутација од парички од еден и
два денари на кои сумата им е 𝑛.
*/
public class _5_1_RasporeduvanjeParicki {

    public static int[] A;

    public static int C(int i, String niza) {
        if (i == 0 || i == 1)
            return 1;

        if (niza.charAt(0) == '1') {
            int p = C(i - 1, niza.substring(1));
            return A[i - 2] + p;
        } else {
            int p = C(i - 2, niza.substring(1));
            return p;
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String niza = scn.next();

        A = new int[n + 1];
        A[0] = A[1] = 1;
        for (int i = 2; i <= n; i++) {
            A[i] = A[i - 1] + A[i - 2];
        }

        System.out.println(C(n, niza));
    }

}

/* import java.util .*;

public class Main {
    public static int[] A;

    public static void B(int i, int j) {
        if (j == 1) {
            if (i == 1)
                System.out.print("1");
            else
                System.out.print("2");
        } else {
            if (j <= A[i - 2]) {
                System.out.print("2");
                B(i - 2, j);
            } else {
                System.out.print("1");
                B(i - 1, j - A[i - 2]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        A = new int[n + 1];
        A[0] = A[1] = 1;
        for (int i = 2; i <= n; i++) {

            A[i] = A[i - 1] + A[i - 2];
        }

        B(n, k);
    }
}*/
