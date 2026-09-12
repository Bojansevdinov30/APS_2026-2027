package dynamicProgramming.myExercises;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueue {

    public static void sortQueue(Queue<Integer> q) {
        Queue<Integer> sorted = new LinkedList<>();

        while (!q.isEmpty()) {
            int n = q.size();
            int min = Integer.MAX_VALUE;

            // Find minimum
            for (int i = 0; i < n; i++) {
                int x = q.poll();

                if (x < min) {
                    min = x;
                }

                q.offer(x);
            }

            // Remove ONE occurrence of minimum
            boolean removed = false;

            for (int i = 0; i < n; i++) {
                int x = q.poll();

                if (x == min && !removed) {
                    sorted.offer(x);
                    removed = true;
                } else {
                    q.offer(x);
                }
            }
        }

        // Put sorted elements back
        while (!sorted.isEmpty()) {
            q.offer(sorted.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(4);
        q.offer(1);
        q.offer(3);
        q.offer(2);

        sortQueue(q);

        System.out.println(q); // [1, 2, 3, 4]
    }
}
