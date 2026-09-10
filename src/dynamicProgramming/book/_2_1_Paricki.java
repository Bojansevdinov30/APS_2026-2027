package dynamicProgramming.book;

import java.util.Scanner;

/*
Пијалоците кои се порачуваат од автоматот за пијалоци, можат да се
платат со железни парички, но само со монети од еден и два денари.
Монетите се пуштаат во автоматот една по една. Ако цената на
пијалокот кој го порачувате е 𝑛 денари, на колку начини можете да ја
платите точната сума, за дадено 𝑛?
*/
public class _2_1_Paricki {

    public static int[] A;

    public static int getA(int n) {
        if (A[n] < 0)
            A[n] = getA(n - 1) + getA(n - 2);
        return A[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if (n == 1)
            System.out.println("1");
        if (n == 2)
            System.out.println("2");
        if (n > 2) {
            A = new int[n];
            A[0] = 1;
            A[1] = 2;
            for (int i = 2; i < n; i++) {
                A[i] = -1;
            }
        }
        System.out.println(getA(n - 1));
    }

}
