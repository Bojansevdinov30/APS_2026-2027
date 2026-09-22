package PrethodniIspitni._2026;

import java.util.HashMap;
import java.util.Scanner;

/*Влезна испит  - Јануари 2026  - втор термин

Safe city проектот чува записи за доаѓањето и заминувањето на возила на четирите страни од една раскрсница во секој момент.
Страните се четирите кардинални насоки. Треба да се испечати максималниот број на автомобили кои биле присутни во даден момент од
секоја страна.

Има n записи, записите се во формат:
"Arrival west SK4000DD" - означува доаѓање на автомобил на одредена стана од раскрсницата
"Departure east SK3000AD" - означува заминување на автомобил од одредена страна на раскрсницата

Пример:

12
Arrival north SK1000AA
Arrival west SK1001AD
Departure north SK1000AA
Arrival north SK2000AB
Arrival north SK2003AA
Arrival south SK2001AB
Departure south SK2001AB
Arrival north SK3000AA
Departure north SK2000AB
Arrival east SK3001AA
Arrival east SK3002AB
Departure east SK3001AA

Output:

Max east: 2
Max west: 1
Max north: 3
Max south: 1*/
public class Januari_2026_Vlezna_2gr {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> current = new HashMap<>();
        HashMap<String, Integer> maximum = new HashMap<>();

        // Initialize all four directions
        current.put("north", 0);
        current.put("south", 0);
        current.put("east", 0);
        current.put("west", 0);

        maximum.put("north", 0);
        maximum.put("south", 0);
        maximum.put("east", 0);
        maximum.put("west", 0);

        for (int i = 0; i < n; i++) {

            String action = sc.next();
            String direction = sc.next();
            String car = sc.next();

            if (action.equals("Arrival")) {

                int newCount = current.get(direction) + 1;
                current.put(direction, newCount);

                if (newCount > maximum.get(direction)) {
                    maximum.put(direction, newCount);
                }

            } else { // Departure

                int newCount = current.get(direction) - 1;
                current.put(direction, newCount);
            }
        }

        System.out.println("Max east: " + maximum.get("east"));
        System.out.println("Max west: " + maximum.get("west"));
        System.out.println("Max north: " + maximum.get("north"));
        System.out.println("Max south: " + maximum.get("south"));
    }
}
