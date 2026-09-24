package labs.Lab3;

import java.util.Scanner;

/*Istiot problem kako pred toa samo ova e 0/1 Knapsack i mora so DP*/
public class Zadaca7 {
    public static class Zadaca {
        public int vremetraenje;
        public int zarabotka;

        public Zadaca(int vremetraenje, int zarabotka) {
            this.vremetraenje = vremetraenje;
            this.zarabotka = zarabotka;
        }

        public double pariPoCas() {
            return (double) zarabotka / vremetraenje;
        }
    }

    public static void sort(Zadaca[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[i].pariPoCas() < lista[j].pariPoCas()) {
                    Zadaca temp = lista[i];
                    lista[i] = lista[j];
                    lista[j] = temp;
                }
            }
        }
    }

    public static int maxZarabotka(Zadaca[] zadaci, int n) {
        int maxVreme = 40;

        int[][] dp = new int[n + 1][maxVreme + 1];

        for (int i = 1; i <= n; i++) {
            int vreme = zadaci[i - 1].vremetraenje;
            int zarabotka = zadaci[i - 1].zarabotka;

            for (int j = 0; j <= maxVreme; j++) {

                // Don't take the job
                dp[i][j] = dp[i - 1][j];

                // Take the job, if it fits
                if (vreme <= j) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i - 1][j - vreme] + zarabotka
                    );
                }
            }
        }

        return dp[n][maxVreme];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Zadaca[] zadaci = new Zadaca[n];

        for (int i = 0; i < n; i++) {
            zadaci[i] = new Zadaca(sc.nextInt(), sc.nextInt());
        }

        System.out.println(maxZarabotka(zadaci, n));
    }
}
