package dadeniVezbi.courses;

import java.util.Arrays;
import java.util.Scanner;

public class Algoritmi_3 {
    public static class Task {
        int taskDuration;
        int taskProfit;

        Task(int taskDuration, int taskProfit) {
            this.taskDuration = taskDuration;
            this.taskProfit = taskProfit;
        }

        public double payPerHour() {
            return (double) taskProfit / taskDuration;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(sc.nextInt(), sc.nextInt());
        }

        System.out.println(getMaximumProfit(tasks));
    }

    private static int getMaximumProfit(Task[] tasks) {
        Arrays.sort(tasks, (a, b) -> Double.compare(b.payPerHour(), a.payPerHour()));

        int weeklyHours = 40;
        int totalProfit = 0;

        for (Task task : tasks) {
            if (weeklyHours == 0) {
                break;
            }
            if (weeklyHours >= task.taskDuration) {
                totalProfit += task.taskProfit;
                weeklyHours -= task.taskDuration;
            } else {
                totalProfit += (int) (task.payPerHour() * weeklyHours);
                weeklyHours = 0;
            }
        }

        return totalProfit;
    }

}
