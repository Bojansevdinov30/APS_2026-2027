package labs.Lab5;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Zadaca1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        CBHT<String, String> stanica = new CBHT<>(2 * n);
        for (int i = 0; i < n; i++) {
            String vlez = input.nextLine();
            String[] deloviVlez = vlez.split(" ");
            String imeClen = deloviVlez[0];
            String oblast = deloviVlez[1];
            SLLNode<MapEntry<String, String>> tmp = stanica.search(imeClen);
            if (tmp == null) {
                stanica.insert(imeClen, oblast);
            } else {
                String staraOblast = tmp.getElement().getValue();
                String zaedno = staraOblast + " " + oblast;
                stanica.insert(imeClen, zaedno);
            }
        }

        int m = input.nextInt();
        input.nextLine();
        for (int i = 0; i < m; i++) {
            String vlez = input.nextLine();
            String[] deloviVlez = vlez.split(" ");
            String imeClen = deloviVlez[0];
            String oblast1 = deloviVlez[1];
            String oblast2 = deloviVlez[2];
            SLLNode<MapEntry<String, String>> tmp = stanica.search(imeClen);
            if (tmp == null) {
                System.out.println("DENIED");
            } else {
                if (tmp.getElement().getValue().contains(oblast1) && tmp.getElement().getValue().contains(oblast2)) {
                    System.out.println("GRANTED");
                } else {
                    System.out.println("DENIED");
                }
            }
        }
    }
}
