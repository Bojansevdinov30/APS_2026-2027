package auds.auds6;
// O(nd) slozenost kade d e brojot na cifri, sto vo sekoj slucaj e ogranicen, taka da O(n) e ustvari
// O(n + k) space complexity generalno, ama za dekadni broevi e O(n)
public class Zadaca7_RadixSort {
    public static void radixSort(Integer[] A) {

        Integer[] pom = new Integer[A.length];

        int i;
        int max = A[0];
        int exp = 1;

        // Find maximum value
        for (i = 0; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }

        // Sort digit by digit
        while (max / exp > 0) {

            int[] bucket = new int[10];

            // Count occurrences of current digit
            for (i = 0; i < A.length; i++)
                bucket[(A[i] / exp) % 10]++;

            // Cumulative counts
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];

            // Build sorted array for current digit
            for (i = A.length - 1; i >= 0; i--)
                pom[--bucket[(A[i] / exp) % 10]] = A[i];

            // Copy back
            for (i = 0; i < A.length; i++)
                A[i] = pom[i];

            // Move to next digit
            exp *= 10;
        }
    }
}
