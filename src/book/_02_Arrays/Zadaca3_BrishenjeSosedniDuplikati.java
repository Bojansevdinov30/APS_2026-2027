package book._02_Arrays;

import java.util.ArrayList;
import java.util.Scanner;

// Za dadena niza od N (1 <= N <= 50) prirodni broevi da se izbrisat
// duplikat vrednostite koi se javuvaat na sosedni pozicii.
public class Zadaca3_BrishenjeSosedniDuplikati {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int i = 1;
        while (i < list.size()) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            } else {
                i++;
            }
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
