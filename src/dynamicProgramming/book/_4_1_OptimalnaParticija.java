package dynamicProgramming.book;

import java.util.Scanner;

/* Дадена е низа од 𝑛 броеви, и нека 𝑗 -тиот елемент од низата го
обележиме со 𝑥𝑗. Низата треба да се подели на точно 𝑚 делови, или
на 𝑚 партиции, така што сумата на елементите во партицијата со
најголема сума биде минимална. Проблемот е при дадена низа
𝑥𝑗, 𝑗 = 1, 𝑛̅̅̅̅̅ и даден број на партиции 𝑚 , да се најде сумата на
броевите во партицијата со најголема сума, како и една таква
оптимална партиција.
*/
public class _4_1_OptimalnaParticija {


    public static void pechatiTomovi(int[][] C, int m, int n) {
        if (m == 0) {
            System.out.println("1-viot tom pochnuva so glava 1");
        } else {
            int k = C[m][n];
            pechatiTomovi(C, m - 1, k - 1);
            System.out.println((m + 1) + "-tiot tom pochnuva so glava " + (k + 1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // broj na glavi
        int m = scanner.nextInt(); // broj na tomovi
        int[] x = new int[n]; // stranici po glava
        for (int i = 0; i < n; i++)
            x[i] = scanner.nextInt();

        int[][] A = new int[m][n]; // strani
        int[][] C = new int[m][n]; // tomovi

        // ako imame samo eden tom site glavi vleguvaat vo nego
        A[0][0] = x[0];
        C[0][0] = 1;
        for (int j = 1; j < n; j++) {
            A[0][j] = A[0][j - 1] + x[j];
            C[0][j] = 1;
        }


        for (int i = 1; i < m; i++)
            for (int j = i; j < n; j++) {
                int k = j;
                int suma = x[k];
                A[i][j] = Integer.MAX_VALUE;

                while (suma <= A[i - 1][k - 1]) {
                    A[i][j] = A[i - 1][k - 1];
                    C[i][j] = k;
                    k--;
                    suma += x[k];
                }

                if (suma <= A[i][j]) {
                    A[i][j] = suma;
                    C[i][j] = k;
                }
            }
        System.out.println(A[m - 1][n - 1]);
        pechatiTomovi(C, m - 1, n - 1);
    }

}
