package PrethodniIspitni._2025;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Queue - Влезна задача

Наредени луѓе со број на барања, им се извршува едно барање и се враќаат назад во редот. Печати редослед на завршување на луѓето.

Input
5
Nenad 3
Slave 1
Martin 2
Ana 1
Igor 2

Output
Slave
Ana
Martin
Igor
Nenad

-----

*/
public class PrvKolokvium_2025_Vlezna_1termin_redosledQueue {
    static class Person {
        String name;
        int requests;

        Person(String name, int requests) {
            this.name = name;
            this.requests = requests;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        Queue<Person> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String name = input.next();
            int requests = input.nextInt();

            queue.add(new Person(name, requests));
        }

        while (!queue.isEmpty()) {

            Person person = queue.remove();

            // Execute one request
            person.requests--;

            // If there are still requests,
            // put the person back in the queue
            if (person.requests > 0) {
                queue.add(person);
            } else {
                // Person has finished all requests
                System.out.println(person.name);
            }
        }
    }
}
