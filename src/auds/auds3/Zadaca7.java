package auds.auds3;

/*paskalov triagolnik*/
public class Zadaca7 {
    // n e dimenzija, k e koj clen
    public static int binomial(int n, int k) {
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 0; i <= n; i++) {
            matrix[i][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1];
            }
        }
        return matrix[n][k];
    }

    public static void main(String[] args) {
        System.out.println(binomial(4, 2));
    }
}
