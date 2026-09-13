package auds.auds6;
// O(n logn) time complexity
// O(n) space complexity because of the temp array
public class Zadaca3_MergeSort {
    public static <T extends Comparable<? super T>> void merge(T[] a, int l, int mid, int r) {
        int numel = r - l + 1;
        T[] temp = (T[]) new Comparable[a.length];
        int i = l, j = mid + 1, k = 0;
        while ((i <= mid) && (j <= r)) {
            if (a[i].compareTo(a[j]) < 0) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }
        while (j <= r) {
            temp[k] = a[j];
            temp[k] = a[j];
            j++;
            k++;
        }
        for (k = 0; k < numel; k++) {
            a[l + k] = temp[k];
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] a, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }
}
