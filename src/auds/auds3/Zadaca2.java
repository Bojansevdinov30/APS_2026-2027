package auds.auds3;

import java.util.Scanner;

/*
Имаме N колачиња кои треба да ги
поделиме на М деца. Секое од колачињата
е со дадена големина. Секое од децата има
желба за колаче со минимум посакувана
големина.
Наша задача е да ги распределиме
колачињата така што најголем дел од
децата ќе бидат задоволни
*/
public class Zadaca2 {
    private static void sortirajRastecki(int[] arr, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int findContentChildren(int[] wishes, int[] cookies) {
        int w = wishes.length; // Total number of children
        int c = cookies.length; // Total number of cookies available
        //Sort the two arrays in ascending order
        sortirajRastecki(wishes, w);
        sortirajRastecki(cookies, c);
        // Initialize the count for content children
        int contentChildrenCount = 0;
        int j = 0; //counter for the cookies
        // Loop through each child's wishes
        for (int i = 0; i < w; i++) {
            // Find the first cookie that satisfies the current child's wish, until there are cookies
            while (j < c) {
                if (cookies[j] > wishes[i]) {
                    //we found a cookie for this child's wish
                    contentChildrenCount++;
                    j++;
                    break;
                } else {
                    // go to the succ larger cookie
                    j++;
                }
            }
        }
        // Return the final count of content children
        return contentChildrenCount;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] wishes = new int[n];
        for (int i = 0; i < n; i++) {
            wishes[i] = in.nextInt();
        }
        int m = in.nextInt();
        int cookies[] = new int[n];
        for (int i = 0; i < n; i++) {
            cookies[i] = in.nextInt();
        }
        System.out.println("Maksimalniot broj na zadovolni deca e " + findContentChildren(wishes, cookies));
    }
}
