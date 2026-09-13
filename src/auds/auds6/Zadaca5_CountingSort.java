package auds.auds6;

// O(n + k) kompleksnost najloso i prosecno, ama dosta ogranicen e
// O(n + k) space complexity
public class Zadaca5_CountingSort {
    public static void countingSort(Integer[] A, int k) {

        int i, j;

        Integer[] c = new Integer[k + 1];
        Integer[] b = new Integer[A.length];

        // 1. Initialize counters
        for (i = 0; i <= k; i++)
            c[i] = 0;

        // 2. Count occurrences
        for (j = 0; j < A.length; j++)
            c[A[j]] = c[A[j]] + 1;

        // 3. Calculate cumulative counts
        for (i = 1; i <= k; i++)
            c[i] = c[i] + c[i - 1];

        // 4. Put elements into their sorted positions
        for (j = A.length - 1; j >= 0; j--) {
            b[c[A[j]] - 1] = A[j];
            c[A[j]] = c[A[j]] - 1;
        }

        // 5. Copy result back into A
        for (j = 0; j < A.length; j++)
            A[j] = b[j];
    }
}
