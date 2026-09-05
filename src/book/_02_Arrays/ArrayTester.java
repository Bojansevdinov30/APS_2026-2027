package book._02_Arrays;

import dataStructures.Array;

public class ArrayTester {

    public static void main(String[] args) {
        Array<Integer> a = new Array<Integer>(5);
        for (int i = 0; i < 4; i++) {
            a.insertLast(i);
        }

        a.insert(0, 5);
        for (int i = 0; i < 5; i++) {
            System.out.println(a.get(i));
        }
    }
}
