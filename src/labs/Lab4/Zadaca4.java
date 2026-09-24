package labs.Lab4;

import java.util.ArrayList;
import java.util.Scanner;
// Zadacata so skorosortirana niza
public class Zadaca4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        findUnsortedNumbers(array);
    }

    private static void findUnsortedNumbers(int[] array) {
        int countUnsorted = 0;
        ArrayList<UnsortedNumber> unsortedNumbers = new ArrayList<>();

        for (int i = 1; i < array.length; i++) {
            int currValue = array[i];
            int j = i - 1;
            int shifts = 0;
            boolean isSorted = true;

            while (j >= 0 && array[j] > currValue) {
                array[j + 1] = array[j];
                j--;
                isSorted = false;
                shifts++;
            }

            if (!isSorted) {
                countUnsorted++;
                unsortedNumbers.add(new UnsortedNumber(currValue, shifts));
            }

            array[j + 1] = currValue;
        }

        System.out.println(countUnsorted);
        for (UnsortedNumber unsortedNumber : unsortedNumbers) {
            System.out.println(unsortedNumber);
        }
    }

    public static class UnsortedNumber {
        int number;
        int shiftCount;

        public UnsortedNumber(int num, int shiftFor) {
            this.number = num;
            this.shiftCount = shiftFor;
        }

        @Override
        public String toString() {
            return number + " " + shiftCount;
        }
    }
}
