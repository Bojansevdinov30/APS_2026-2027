package GreedyAlgorithms;

import java.util.Scanner;

/*You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if
n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false*/
public class FlowerBed {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int viablePos = 0, count = 0;

        if (flowerbed[0] == 1) {
            viablePos = 2;
        }

        for (int i = viablePos; i < flowerbed.length; i++) {
            if (count == n) {
                break;
            }
            if (i > 0) {
                if (i == flowerbed.length - 1) {
                    if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) count++;
                    break;
                }
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    count++;
                    i++;
                }
            }
            if (i < 1) {
                if (flowerbed.length == 1) {
                    if (flowerbed[i] == 0) {
                        count++;
                    }
                    break;
                }
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    count++;
                    i++;
                }
            }
        }

        return count == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] flowerbed = new int[n];

        for (int i = 0; i < n; i++) {
            flowerbed[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        System.out.println(canPlaceFlowers(flowerbed, m));
    }
}
