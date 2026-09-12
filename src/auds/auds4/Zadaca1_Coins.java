package auds.auds4;

/*Paricki 1, 2, 5, 8, 10 i brojot na site e neogranicen.
Opredeli najmal broj paricki za formiranje na dadena suma*/
public class Zadaca1_Coins {

    public static int MAX_SUM = 1000;

    public static int[] minNumCoinsForSum(int n, int[] coins) {
        int[] numCoinsForSum = new int[MAX_SUM + 1]; // +1 e za poz 0 da ni znaci i suma 0

        for (int i = 0; i <= MAX_SUM; i++) {
            numCoinsForSum[i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            numCoinsForSum[coins[i]] = 1;
        }

        for (int i = 0; i <= MAX_SUM; i++) {
            for (int j = 0; j < n; j++) {
                if (i + coins[j] <= MAX_SUM) {
                    if (numCoinsForSum[i + coins[j]] == 0 || numCoinsForSum[i + coins[j]] > numCoinsForSum[i] + 1) {
                        numCoinsForSum[i + coins[j]] = numCoinsForSum[i] + 1;
                    }
                }
            }
        }

        return numCoinsForSum;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] coins = {1, 2, 5, 8, 10};

        System.out.println(minNumCoinsForSum(n, coins)[13]);
    }
}
