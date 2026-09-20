package dynamicProgramming.book;

import java.util.*;

/*Дадено е множество градови и најкраткото растојание помеѓу било
кои два града. Трговецот трга од еден од градовите и треба да ги
посети сите градови и пак да се врати на местото од каде тргнал, а
при тоа да помине најмал можен пат.*/
public class _8_3_TravellingSalesmanProblem {

    public static int[][] dist;
    public static int[][] dp;
    public static int N;
    public static final int INF = 1000000000;

    public static int getShortestPath(int mask, int visited) {

        if (visited == (1 << N) - 1)
            return dist[mask][1];

        if (dp[mask][visited] >= 0)
            return dp[mask][visited];

        int ret = INF;

        for (int i = 1; i <= N; i++) {

            if ((visited & (1 << (i - 1))) != 0)
                continue;

            if (dist[mask][i] == 0)
                continue;

            int temp = dist[mask][i] + getShortestPath(i, visited + (1 << (i - 1)));
            ret = Math.min(ret, temp);
        }

        return dp[mask][visited] = ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dist = new int[N + 1][N + 1];
        dp = new int[N + 1][1 << N];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(getShortestPath(1, 1));
    }
}
