package dadeniVezbi.courses;

import java.util.Arrays;
import java.util.Scanner;

public class Algoritmi_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] startTime = new int[n];
        int[] endTime = new int[n];

        for (int i = 0; i < n; i++) {
            startTime[i] = sc.nextInt();
            endTime[i] = sc.nextInt();
        }

        System.out.println(findMinimumRooms(startTime, endTime));
    }

    private static int findMinimumRooms(int[] startTime, int[] endTime) {
        int rooms = 0;

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        for (int i = 0, j = 0; i < startTime.length; i++) {
            if (startTime[i] <= endTime[j]) {
                rooms++;
            } else {
                j++;
            }
        }

        return rooms;
    }

}
