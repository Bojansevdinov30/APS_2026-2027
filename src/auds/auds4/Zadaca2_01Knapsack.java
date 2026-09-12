package auds.auds4;

/* 0-1 Knapsack
 */
public class Zadaca2_01Knapsack {

    public static int knapsack(int[] weights, int[] profits, int C) {
        int n = weights.length;
        int[][] D = new int[n + 1][C + 1];
        for (int i = 0; i <= n; i++) {
            D[i][0] = 0;
        }

        for (int j = 0; j <= C; j++) {
            D[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) { // i e odnesuva na objektot
            for (int j = 1; j <= C; j++) {
                if (weights[i - 1] <= j) {
                    D[i][j] = Math.max(D[i - 1][j], D[i - 1][j - weights[i - 1]] + profits[i - 1]);
                }else{
                    D[i][j] = D[i - 1][j];
                }
            }
        }

        return D[n][C];
    }

    public static void main(String[] args) {
        int C = 50;
        int[] p = {60, 100, 120};
        int[] w = {10, 20, 30};

        System.out.println(knapsack(w, p, C));
    }
}
