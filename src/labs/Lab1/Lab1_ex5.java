package labs.Lab1;

import java.util.Scanner;

public class Lab1_ex5 {
    static void pushZerosToEnd(int[] arr, int n) {
        System.out.println("Transformiranata niza e:");

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + " ");
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                System.out.print(arr[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        int n;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        pushZerosToEnd(arr, n);

    }
}
