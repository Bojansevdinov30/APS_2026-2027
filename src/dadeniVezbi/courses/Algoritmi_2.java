package dadeniVezbi.courses;

import java.util.Arrays;
import java.util.Scanner;

public class Algoritmi_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arrivals = new int[n];
        int[] departures = new int[n];

        for (int i = 0; i < n; i++) {
            arrivals[i] = sc.nextInt();
            departures[i] = sc.nextInt();
        }

        System.out.println(countPlatforms(arrivals, departures));
    }

    private static int countPlatforms(int[] arrivals, int[] departures) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int platforms = 0;

        for (int i = 0, j = 0; i < arrivals.length; i++) {
            if (arrivals[i] <= departures[j]) {
                platforms++;
            } else {
                j++;
            }
        }

        return platforms;
    }

}
