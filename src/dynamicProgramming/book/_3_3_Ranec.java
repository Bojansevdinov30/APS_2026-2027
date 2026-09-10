package dynamicProgramming.book;

import java.util.Scanner;

/*
Крадецот влегува во просторија во која што се чуваат скапоцени
предмети. Тој носи ранец во кој има носивост 𝑛, односно во него
можат да сместат предмети ко имаат тежина најмногу 𝑛 единици Во
просторијата има вкупно 𝑚 типови на предмети и сметаме дека
предметите се повеќе отколку што може да се собере во ранецот, и
уште повеќе претпоставуваме дека од секој тип на предмети има
доволна количина, така да крадецот ако сака може да го наполни
ранецот само со еден тип на предмети. За секој тип на предмет
позната е неговата вредност 𝑣𝑘 и неговaта тежина 𝑡𝑘, 𝑘 = 1, 𝑚̅̅̅̅̅̅. Сите
големини се целобројни. Целта на крадецот е да украде што е
повредна стока и нашиот проблем е да се одредат предметите кои
треба да ги стави во ранецот и нивната вкупна вредност
*/
public class _3_3_Ranec {

    public static void KnapsackUnbounded() {
        Scanner inp = new Scanner(System.in);
        int m = inp.nextInt();
        int[] v = new int[m];
        int[] t = new int[m];

        for (int i = 0; i < m; i++)
            v[i] = inp.nextInt();
        for (int i = 0; i < m; i++)
            t[i] = inp.nextInt();

        int n = inp.nextInt();

        int[] A = new int[n];

        for (int i = 1; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if (t[k] <= i)
                    if (A[i - t[k]] + v[k] > A[i])
                        A[i] = A[i - t[k]] + v[k];
            }
        }

        System.out.println(A[n - 1]);
    }

    public static void Knapsack01() {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // number of items

        int[] value = new int[m];
        int[] weight = new int[m];

        for (int i = 0; i < m; i++) {
            value[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            weight[i] = sc.nextInt();
        }

        int W = sc.nextInt(); // capacity

        int[][] dp = new int[m + 1][W + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= W; j++) {

                // Don't take item i-1
                dp[i][j] = dp[i - 1][j];

                // Take item i-1 if it fits
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i - 1][j - weight[i - 1]] + value[i - 1]
                    );
                }
            }
        }

        System.out.println(dp[m][W]);
    }

    public static void main(String[] args){
        KnapsackUnbounded();
        Knapsack01();
    }

}
