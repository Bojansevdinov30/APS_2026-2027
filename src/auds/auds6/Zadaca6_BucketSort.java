package auds.auds6;
// O(n + k) slozenost, najloso i prosecno
// O(k) space complexity
public class Zadaca6_BucketSort {
    public static void bucketSort(Integer A[], int maxVal) {
        Integer[] bucket = new Integer[maxVal + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
            bucket[A[i]]++;
        }
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                A[outPos++] = i;
            }
        }
    }
}
