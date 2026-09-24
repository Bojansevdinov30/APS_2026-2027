package labs.Lab4;

import java.util.Scanner;

// Najdi go najmaliot n-cifren broj so suma na cifri m
public class Zadaca5 {
    // Brute force solution
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int gornaGranica = najdiGornaGranica(n);
        int dolnaGranica = najdiDolnaGranica(n);

        najdiNajmalBroj(m, dolnaGranica, gornaGranica);
    }

    public static int najdiGornaGranica(int n) {
        int t = n;
        int gornaGranica = 0;

        while(t > 0) {
            gornaGranica = gornaGranica * 10 + 9;
            t--;
        }

        return gornaGranica;
    }

    public static int najdiDolnaGranica(int n) {
        int t = n - 1;
        int dolnaGranica = 0;

        while(t > 0) {
            dolnaGranica = dolnaGranica * 10 + 9;
            t--;
        }

        return dolnaGranica + 1;
    }

    public static int najdiSumaOdCifri(int x) {
        int suma = 0;
        int t = x;

        while(t > 0) {
            suma += t % 10;
            t = t / 10;
        }

        return suma;
    }

    public static void najdiNajmalBroj(int m, int dolnaGranica, int gornaGranica) {
        for (int i = dolnaGranica; i <= gornaGranica; i++) {
            int sumaNaCifri = najdiSumaOdCifri(i);

            if(sumaNaCifri == m) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("Ne postoi");
    }

    // Greedy Solution
    public static void smallestNumber(int n, int m) {

        // Maximum possible digit sum for n digits
        if (m > 9 * n || m <= 0) {
            System.out.println("Ne postoi");
            return;
        }

        int[] digits = new int[n];

        for (int i = 0; i < n; i++) {

            // First digit cannot be 0
            int minDigit = (i == 0) ? 1 : 0;

            // We need to leave enough sum for the remaining digits
            int remainingDigits = n - i - 1;

            for (int digit = minDigit; digit <= 9; digit++) {

                int remainingSum = m - digit;

                // Can the remaining digits hold remainingSum?
                if (remainingSum >= 0 &&
                        remainingSum <= 9 * remainingDigits) {

                    digits[i] = digit;
                    m = remainingSum;
                    break;
                }
            }
        }

        for (int digit : digits) {
            System.out.print(digit);
        }

        System.out.println();
    }

}
