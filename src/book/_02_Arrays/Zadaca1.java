package book._02_Arrays;

import dataStructures.Array;

import java.util.Scanner;

// Element najblisku do prosekot na nizata.
public class Zadaca1 {

    public static int elementClosestToMean(Array<Integer> a) {
        int sum = 0;
        for (int i = 0; i < a.getSize(); i++) {
            sum += a.get(i);
        }

        int average = sum / a.getSize();
        int minDiff = Math.abs(a.get(0) - average);
        int index = 0;

        for (int i = 1; i < a.getSize(); i++) {
            int difference = Math.abs(a.get(i) - average);
            if (difference < minDiff) {
                minDiff = difference;
                index = i;
            } else if (difference == minDiff && a.get(i) < a.get(index)) {
                index = i;
            }
        }

        return a.get(index);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Array<Integer> a = new Array<Integer>(n);

        for (int i = 0; i < n; i++) {
            a.insertLast(input.nextInt());
        }

        System.out.println(elementClosestToMean(a));
    }
}
