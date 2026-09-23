package GreedyAlgorithms;

import java.util.Scanner;

/*Given an array, arr[]. You need to reduce size of array to one. You are allowed to select a pair of integers and remove the
larger one of these two. This decreases the array size by 1. Cost of this operation is equal to value of smaller one.
Find out minimum sum of costs of operations needed to convert the array into a single element.

Examples:

Input: arr[] = [4, 3, 2]
Output: 4
Explanation: Choose (4, 2) so 4 is removed, new array = {2, 3}. Now choose (2, 3) so 3 is removed. So total cost = 2 + 2 = 4
Input: arr[] = [3, 4]
Output: 3
Explanation: Choose 3, 4, so cost is 3.
Input: arr[] = [1]
Output: 0
Explanation: The array is already of size one, so no operations are needed.*/
public class ReduceArrayCost {
    public static int cost(int[] arr) {
        int lowest = arr[0];
        for(int i =1; i < arr.length; i++) {
            if (arr[i] < lowest) {
                lowest = arr[i];
            }
        }
        return (arr.length - 1) * lowest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(cost(arr));
    }
}
