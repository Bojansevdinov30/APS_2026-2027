package auds.auds6;
// Ω(n) najdobro, ako nizata e veke sortirana
// O(n^2) najloso
// O(1) space complexity
public class Zadaca2_BubbleSort {
    public static <T extends Comparable<? super T>> void
    bubbleSort(T[] array) {
        int begin = 0;
        int end = array.length - 1;
        T temp;
        boolean flipped = false;
        for (int i = end; i >= begin; i--) {
            flipped = false;
            for (int j = 1; j <= i; j++) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flipped = true;
                }
            }
            if (!flipped) break;
        }
    } // druga implementacija – najgolemiot se turka vo desno
}
