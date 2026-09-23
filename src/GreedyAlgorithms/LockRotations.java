package GreedyAlgorithms;

import java.util.Scanner;
/*Minimum rotations to unlock a circular lock

Given a lock made up of N different circular rings. Each ring has 0-9 digit printed on it. There is only one particular code which can open the lock. You can rotate each ring any number of times in either direction. Given the random sequence R and the desired sequence D, find the minimum number of rotations required to open the lock.



Example 1:

Input: R = 222, D = 333
Output: 3
Explaination: Optimal number of rotations for
getting 3 from 2 is 1. There are three 2 to 3
transformations. So answer is 1+1+1 = 3.


Example 2:

Input: R = 2345, D = 5432
Output: 8
Explaination: The optimal shifts for pairs are:
(2, 5) = 3, (3, 4) = 1, (4,3) = 1, (5,2) = 3.
So total shifts = 3+1+1+3 = 8.*/
public class LockRotations {
    public static int rotationCount(long r, long d) {
        int result = 0;
        while (r > 0) {
            long abs = Math.abs(r % 10 - d % 10);
            if (abs > 5) {
                result += (int) (10 - (Math.max(r % 10, d % 10)) + (Math.min(r % 10, d % 10)));
            } else {
                result += (int) abs;
            }
            r /= 10;
            d /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long r = sc.nextLong();
        long d = sc.nextLong();

        System.out.println(rotationCount(r, d));
    }
}
