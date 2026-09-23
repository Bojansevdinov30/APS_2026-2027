package PrethodniIspitni._2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Septemvri_2025_Vlezna_2gr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] parts =  s.split(" ");
            String kod = parts[0];
            String model = parts[1];
            String ime = parts[2];
            map.put(kod, model + " " + ime);
        }
        int t = Integer.parseInt(sc.nextLine());
        while (true) {
            String cmd = sc.nextLine();
            if (cmd.equals("-1 break")) {
                break;
            }
            String[] parts = cmd.split(" ");
            int tezhina =  Integer.parseInt(parts[0]);
            String model = parts[1];

            if (tezhina > t) {
                System.out.println(map.get(model));
            }
        }
    }
}
