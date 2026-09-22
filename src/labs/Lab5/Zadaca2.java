package labs.Lab5;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Zadaca2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        CBHT<String, String> agencija = new CBHT<>(2 * n);
        for (int i = 0; i < n; i++) {
            String vlez = input.nextLine();
            String[] deloviVlez = vlez.split(" ");
            String imeLice = deloviVlez[0];
            String zemja = deloviVlez[1];
            SLLNode<MapEntry<String, String>> tmp = agencija.search(imeLice);
            if (tmp == null) {
                agencija.insert(imeLice, zemja);
            } else {
                String staraZemja = tmp.getElement().getValue();
                String zaedno = staraZemja + " " + zemja;
                agencija.insert(imeLice, zaedno);
            }
        }
        int m = input.nextInt();
        input.nextLine();
        for (int i = 0; i < m; i++) {
            String vlez = input.nextLine();
            String[] deloviVlez = vlez.split(" ");
            String imeLice = deloviVlez[0];
            SLLNode<MapEntry<String, String>> tmp = agencija.search(imeLice);
            boolean test = true;
            if (tmp == null) {
                System.out.println("BLOCKED");
            } else {
                for (int j = 1; j < deloviVlez.length; j++) {
                    if (tmp.getElement().getValue().contains(deloviVlez[j])) {
                        test = false;
                        break;
                    }
                }
            }
            if (test) {
                System.out.println("ALLOWED");
            } else {
                System.out.println("BLOCKED");
            }
        }
    }
}
