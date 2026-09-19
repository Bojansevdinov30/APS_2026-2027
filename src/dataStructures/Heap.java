package dataStructures;

import java.util.Comparator;

public class Heap<E extends Comparable<E>> {
    private E[] elements;
    private Comparator<? super E> comparator;

    private int compare(E k1, E k2) {
        return (comparator == null ? k1.compareTo(k2) : comparator.compare(k1, k2));
    }

    int getParent(int i) {
        return (i - 1) / 2;
    }

    int getLeft(int i) {
        return i * 2 + 1;
    }

    int getRight(int i) {
        return i * 2 + 2;
    }

    public E getAt(int i) {
        return elements[i];
    }

    void setElement(int index, E elem) {
        elements[index] = elem;
    }

    void swap(int i, int j) {
        E tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

    void adjust(int i, int n) {
        // O(logn) complexity
        while (i < n) {
            int left = getLeft(i);
            int right = getRight(i);
            int largest = i;
            if ((left < n) && (elements[left].compareTo(elements[largest]) > 0))
                largest = left;
            if ((right < n) && (elements[right].compareTo(elements[largest]) > 0))
                largest = right;
            if (largest == i)
                break;
            swap(i, largest);
            i = largest;
        }
    }

    void buildHeap() {
        // O(n) complexity, technically O(nlogn)
        int i;
        for (i = getParent(elements.length - 1); i >= 0; i--)
            adjust(i, elements.length);
    }

    public void heapSort() {
        // O(nlogn) complexity
        int i;
        buildHeap();
        for (i=elements.length;i>1;i--) {
            swap(0, i-1);
            adjust(0, i-1);
        }
    }
}
