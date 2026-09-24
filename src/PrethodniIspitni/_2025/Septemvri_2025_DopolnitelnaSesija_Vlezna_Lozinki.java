package PrethodniIspitni._2025;

import java.util.HashMap;
import java.util.Scanner;

/* Внесуваш број N и потоа N имиња заедно со лозинки. После тоа внесуваш имиња и лозинки се додека не внесеш КРАЈ. Треба да се провери дали
име и лозинка се поклопуваат со некои од претходните. Ако се поклопуваат печати Најавен, ако не - печати ненајавен.*/
public class Septemvri_2025_DopolnitelnaSesija_Vlezna_Lozinki {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        HashMap<String, String> users = new HashMap<>();

        // Read the registered users
        for (int i = 0; i < n; i++) {
            String username = input.next();
            String password = input.next();

            users.put(username, password);
        }

        // Read login attempts
        while (true) {

            String username = input.next();

            if (username.equals("KRAJ")) {
                break;
            }

            String password = input.next();

            // Check whether username exists
            // and whether the password matches
            if (users.containsKey(username) &&
                    users.get(username).equals(password)) {

                System.out.println("Najaven");

            } else {

                System.out.println("nenajaven");
            }
        }
    }
}
