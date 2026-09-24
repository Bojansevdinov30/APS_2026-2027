package PrethodniIspitni._2022;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.util.Scanner;

/*Hash tabela, dadeni krvni grupi skrati A2+ i A1+ vo A+ grupa (isto za B i O) i broj kolku ima od sekoja grupa*/
public class _2022_Kolokvium2_Vlezna_KrvniGrupi {
    public static String shorten(String bloodGroup) {
        // A1+ or A2+ -> A+
        if (bloodGroup.equals("A1+") || bloodGroup.equals("A2+")) {
            return "A+";
        }
        // A1- or A2- -> A-
        if (bloodGroup.equals("A1-") || bloodGroup.equals("A2-")) {
            return "A-";
        }
        // B1+ or B2+ -> B+
        if (bloodGroup.equals("B1+") || bloodGroup.equals("B2+")) {
            return "B+";
        }
        // B1- or B2- -> B-
        if (bloodGroup.equals("B1-") || bloodGroup.equals("B2-")) {
            return "B-";
        }
        // O+ and O- stay the same
        return bloodGroup;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        CBHT<String, Integer> table = new CBHT<>(2 * N + 1);
        for (int i = 0; i < N; i++) {
            String bloodGroup = input.next();
            bloodGroup = shorten(bloodGroup);
            SLLNode<MapEntry<String, Integer>> node = table.search(bloodGroup);
            if (node == null) {
                table.insert(bloodGroup, 1);
            } else {
                node.element.value++;
            }
        }
        String[] groups = {"A+", "A-", "B+", "B-", "O+", "O-"};
        for (String group : groups) {
            SLLNode<MapEntry<String, Integer>> node = table.search(group);
            if (node == null) {
                System.out.println(group + " 0");
            } else {
                System.out.println(group + " " + node.element.value);
            }
        }
    }
}
