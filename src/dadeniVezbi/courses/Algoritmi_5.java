package dadeniVezbi.courses;

import java.util.Scanner;

public class Algoritmi_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] taskDuration = new int[n];

        for (int i = 0; i < n; i++) {
            taskDuration[i] = sc.nextInt();
        }

        workingDaysRequired(taskDuration, m);
    }

    private static void workingDaysRequired(int[] taskDuration, int m) {
        int workingDays = 1;
        int workingHours = m * 8;
        int freeHours = 0;

        for (int i = 0; i < taskDuration.length; i++) {
            if(workingHours >= taskDuration[i]) {
                workingHours -= taskDuration[i];
            } else {
                workingDays++;
                i--;
                freeHours += workingHours;
                workingHours = m * 8;
            }
        }

        freeHours += workingHours;

        System.out.println(workingDays + " " + freeHours);
    }

}
