package dadeniVezbi.courses;

import java.util.Scanner;

public class Algoritmi_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] digits = new int[n];

        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        maximumNumber(digits);
    }

    private static void maximumNumber(int[] digits) {
        String maxNumber = "";

        for (int i = 0; i < digits.length; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < digits.length; j++) {
                if(digits[j] > digits[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = digits[maxIndex];
            digits[maxIndex] = digits[i];
            digits[i] = temp;
            maxNumber += digits[i];
        }

        System.out.println(maxNumber);
    }

}
