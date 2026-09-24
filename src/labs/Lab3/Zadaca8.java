package labs.Lab3;

import java.util.Arrays;
import java.util.Scanner;

/*Given n trains, each with an arrival time and a departure time, determine the minimum number of platforms required at a railway
station so that no train has to wait.
A platform is occupied from the train's arrival until its departure. If a train arrives before the previous train has departed,
another platform is required.
The input contains n trains, followed by the arrival and departure time of each train.
Return the minimum number of platforms needed.*/
public class Zadaca8 {
    public static int minPlatformi(int[] pristiganje, int[] trgnuvanje,  int n) {
        int platformi = 0;

        Arrays.sort(pristiganje);
        Arrays.sort(trgnuvanje);

        int j = 0;
        for (int i = 0; i < n; i++) {
            if(pristiganje[i] <= trgnuvanje[j]) {
                platformi++;
            } else {
                j++;
            }
        }

        return platformi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] pristiganje = new int[n];
        int[] trgnuvanje = new int[n];

        for (int i = 0; i < n; i++) {
            pristiganje[i] = sc.nextInt();
            trgnuvanje[i] = sc.nextInt();
        }

        System.out.println(minPlatformi(pristiganje, trgnuvanje, n));
    }
}
