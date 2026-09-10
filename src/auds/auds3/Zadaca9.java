package auds.auds3;

import java.util.Arrays;
import java.util.Scanner;

/*Problem najkratok pat - od eden grad (najzapadno) i treba da stigne do grad n (najistocno).
Nema vrakjanje nazad, samo zapad - istok nasoka. Postoi let od sekoj grad i do sekoj grad j.
Sekoj grad ima taksa koja se plakja vo toj grad, a i sekoj let plus toa se plakja. Najdi go
najeftiniot pat od i do j.
*/
public class Zadaca9 {
    public static int cheapestWay(int n, int[] tax, int[][] cost) {
        int[] min = new int[n];
        min[0] = tax[0];
        for (int i = 1; i < n; i++) {
            min[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                min[i] = Math.min(min[i], min[j] + cost[j][i] + tax[i]);
            }
        }
        return min[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tax = new int[n];
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            tax[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.println(cheapestWay(n, tax, cost));
    }
}
