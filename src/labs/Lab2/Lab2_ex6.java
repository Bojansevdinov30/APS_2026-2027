package labs.Lab2;

import dataStructures.Array;

import java.util.Scanner;

public class Lab2_ex6 {
    public static int brojDoProsek(Array<Integer> arr) {
        int sum = 0;
        int prosek = 0;
        int result = 0;
        int min = 999999;
        for (int i = 0; i < arr.getSize(); i++) {
            sum += arr.get(i);
        }
        prosek = sum / arr.getSize();

        for (int i = 0; i < arr.getSize(); i++) {
            if (Math.abs(prosek - arr.get(i)) < min) {
                min = Math.abs(prosek - arr.get(i));
                result = i;
            }
            if (Math.abs(prosek - arr.get(i)) == min) {
                if (arr.get(i) < arr.get(result)) {
                    min = Math.abs(prosek - arr.get(i));
                    result = i;
                }
            }
        }


        return arr.get(result);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        Array<Integer> arr = new Array<>(N);

        for (int i = 0; i < N; i++) {
            arr.insertLast(input.nextInt());
        }

        System.out.println(brojDoProsek(arr));
    }
}
