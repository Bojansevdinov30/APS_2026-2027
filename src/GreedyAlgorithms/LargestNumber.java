package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/*Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"

Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"*/
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] array = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));
        if (Objects.equals(array[0], "0")) return "0";

        StringBuilder result = new StringBuilder();

        for (String s : array) {
            result.append(s);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(largestNumber(nums));
    }
}
