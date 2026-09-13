package auds.auds6;
// O(n^2) najlos slucaj ama
// Θ(n logn) prosecen i najcest slucaj
// O(logn) space complexity because of recursion but worst case is O(n)
public class Zadaca4_QuickSort {
    public static <T extends Comparable<? super T>> int partition(T[] A, int left, int right) {
        int i = left, j = right;
        T pivot = A[(left + right) / 2];
        while (i <= j) {
            while (A[i].compareTo(pivot) < 0)
                i++;
            while (A[j].compareTo(pivot) > 0)
                j--;
            if (i <= j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    public static <T extends Comparable<? super T>> void swap(T[] A, int x, int y) {
        T temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] A, int left, int right) {
        int pivot_indeks = partition(A, left, right);
        if (left < pivot_indeks - 1)
            quickSort(A, left, pivot_indeks - 1);
        if (pivot_indeks < right)
            quickSort(A, pivot_indeks, right);
    }
}
