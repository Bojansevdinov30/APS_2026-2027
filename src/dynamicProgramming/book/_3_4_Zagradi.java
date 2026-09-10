package dynamicProgramming.book;

import java.util.*;

/*
За дадено 𝑛 да се најде броjoт на стрингови со должина 2𝑛, кои се
состојат од 𝑛 правилно распоредени парови на загради. Заградите се
правилно распоредени ако за секое 𝑘 од 1 до 𝑛 , 𝑘 -тата отворена
заграда стои пред 𝑘-тата затворена заграда ако имаме три пара на
загради, правилно можеме да ги распределиме на следниве начини:
((())), (())(), (()()), ()(()), ()()(), ()(()).
*/
public class _3_4_Zagradi {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] A = new int[n + 1][n + 1];

        for (int j = 0; j <= n; j++)
            A[0][j] = 1;

        for (int i = 1; i <= n; i++) {
            A[i][0] = A[i - 1][1];
            for (int j = 1; j < n; j++) {
                A[i][j] = A[i - 1][j + 1] + A[i][j - 1];
            }
        }

        System.out.println(A[n][0]);
    }
}
