package PrethodniIspitni._2021;

import java.io.*;

/*
За дадена низа од броеви да се најде максималниот производ кој се формира со множење на броевите од некоја растечка подниза на таа низа.
Влез: На влез во првиот ред е даден бројот на броеви во низата, а во вториот ред е дадена низата од броеви.
Излез: На излез треба да се испечати максималниот производ кој се бара во задачата.
Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.
Забелешка: Само еден број е растечка подниза со должина 1. Да се коментира сложеноста на вашето решение.
Име на класа (Јава): MaxProduct
Пример:
Влез:
6
3 100 4 5 150 6
Излез: 45000
Максималниот производ се формира од растечката подниза 3, 100, 150. Да се забележи дека најдолгата растечка подниза е друга, 3, 4, 5, 6.
 33 min. */
public class RandomZadaca2_MaksimalenProizvod {
    public static void main(String[] args) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        int[] arr = new int[N];
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(pomniza[i]);
        }
        // Vasiot kod tuka
        System.out.println(product(arr));
    }

    // Kompleksnosta na resenieto e O(n^2), zatoa sto site elementi od dadenata niza se izminuvaat so pomos na 2 for ciklusi
    // Resenieto koristi dinamicko programiranje
    public static int product(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        int[] dp = new int[array.length];

        // O(n)
        for (int i = 0; i < dp.length; i++) {
            dp[i] = array[i];
        }

        // O(n^2)
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && dp[j] * array[i] > dp[i]) {
                    dp[i] = dp[j] * array[i];
                }
            }
        }

        int max = 0;

        // O(n)
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }
}
