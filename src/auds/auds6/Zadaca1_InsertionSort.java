package auds.auds6;

// Ω(n) najdobro, ako nizata e veke sortirana
// Θ(n^2) prosecno, ako i/2 pati vlezeme vo loopot
// O(n^2) najloso, ako e sortirana vo obraten redosled
// O(1) space complexity
public class Zadaca1_InsertionSort {
    public static <T extends Comparable<? super T>> void
    insertionSort(T[] array) {
        T key;
        int begin = 0;
        int end = array.length - 1;
        int i;
        for (int index = begin + 1; index <= end; index++) {
            key = array[index];
            i = index - 1;
            while (i >= begin && array[i].compareTo(key) > 0) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
    }
}
