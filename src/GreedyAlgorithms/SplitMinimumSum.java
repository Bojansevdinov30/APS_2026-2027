package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

/*Given a positive integer num, split it into two non-negative integers num1 and num2 such that:

The concatenation of num1 and num2 is a permutation of num.
In other words, the sum of the number of occurrences of each digit in num1 and num2 is equal to the number of occurrences of that digit in num.
num1 and num2 can contain leading zeros.
Return the minimum possible sum of num1 and num2.

Notes:

It is guaranteed that num does not contain any leading zeros.
The order of occurrence of the digits in num1 and num2 may differ from the order of occurrence of num.


Example 1:

Input: num = 4325
Output: 59
Explanation: We can split 4325 so that num1 is 24 and num2 is 35, giving a sum of 59. We can prove that 59 is indeed the minimal possible sum.

Example 2:

Input: num = 687
Output: 75
Explanation: We can split 687 so that num1 is 68 and num2 is 7, which would give an optimal sum of 75.*/
public class SplitMinimumSum {
    public static int splitNum(int num) {
        String[] numbers = String.valueOf(num).split("");

        Arrays.sort(numbers);

        String num1 = numbers[0];
        String num2 = numbers[1];

        for (int i = 2; i < numbers.length; i++) {
            if (i % 2 == 0) {
                num1 += numbers[i];
            } else {
                num2 += numbers[i];
            }
        }

        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(splitNum(num));
    }
}

