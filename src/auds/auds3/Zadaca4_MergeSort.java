package auds.auds3;

/*
"Раздели и владеј" алгоритамот во три
чекори за mergesort сортирањето на некоја
низа а[0 … n] е следниот:
– Подели: низата a[0..n] се дели на половина на
две поднизи
– Владеј: секоја половина a[0 .. (n/2)] и a[(n/2) +1 ..
n] се сортира рекурзивно
– Слеј: двете сортирани половини се спојуваат во
една целина
*/
public class Zadaca4_MergeSort {
    // O(nlogn) complexity
    public static class MergeSort {

        private void merge(int[] array, int l, int mid, int r) {
            int[] temp = new int[100];
            int k = 0, i = l, j = mid + 1;
            int numElems = r - l + 1;
            while (i <= mid && j <= r) {
                if (array[i] < array[j]) {
                    temp[k] = array[i];
                    i++;
                } else {
                    temp[k] = array[j];
                    j++;
                }
                k++;
            }
            while (i <= mid) {
                temp[k] = array[i];
                i++;
                k++;
            }
            while (j <= r) {
                temp[k] = array[j];
                j++;
                k++;
            }

            for (k = 0; k < numElems; k++) {
                array[l + k] = temp[k];
            }
        }


        private void mergeSort(int[] array, int l, int r) {
            if (l == r) {
                return;
            }
            int mid = (l + r) / 2;
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, r);
            merge(array, l, mid, r);
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 7, 8, 4, 5, 6, 2, 2, 0, -6, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array, 0, 10);

        for (int i : array) {
            System.out.println(i + " ");
        }
    }
}
