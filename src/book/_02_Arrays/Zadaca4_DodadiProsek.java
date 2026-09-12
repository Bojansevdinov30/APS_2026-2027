package book._02_Arrays;

import java.util.ArrayList;
import java.util.Scanner;

// Za dadena niza od N prirodni broevi megju sekoi dva sosedi da se vnese
// nov element koj e prosek od dvata sosedi.
public class Zadaca4_DodadiProsek {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>(2 * n - 1);

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int i = 0;
        while (i < list.size() - 1) {
            int average = (int) Math.round(
                    (list.get(i) + list.get(i + 1)) / 2.0
            );
            list.add(i + 1, average);
            i += 2;
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
