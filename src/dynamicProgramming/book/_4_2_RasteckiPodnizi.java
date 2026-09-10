package dynamicProgramming.book;

import java.util.Scanner;

/* За дадена е низа од n броеви, 𝑥1, 𝑥2, … , 𝑥𝑛 да 1се пресмета бројот на
растечки поднизи со должина k. Подниза на низа не е последователна
подниза, туку било која низа која се добива со бришење на дел од
елементите на првобитната низа.
*/
public class _4_2_RasteckiPodnizi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = scanner.nextInt();

        int[][] A = new int[n][k];

        for (int i = 0; i < n; i++)
            A[i][0] = 1;
        for (int r = 1; r < k; r++) {

            for (int i = 0; i < r; i++)
                A[i][r] = 0;
            for (int i = r; i < n; i++) {
                A[i][r] = 0;
                for (int j = r - 1; j < i; j++)
                    if (x[j] < x[i])
                        A[i][r] = A[i][r] + A[j][r - 1];
            }
        }

        System.out.println(A[n - 1][k - 1]);
    }

}
