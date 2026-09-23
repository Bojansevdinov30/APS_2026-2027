package PrethodniIspitni._2025;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Принтер

Во една компанија постои споделен принтер на кој се пуштаат документи за принтање од повеќе канцеларии. Ваша задача е да имплементирате решение кое ќе овозможи додавање
на нов документ за принтање во принтерот, извршување на печатење на одреден број на страници, како и приказ на состојбата на документите.

Влез: На влез прво е даден број N- број на команди кои стигнуваат до принтерот. Потоа во секој од редовите може да има една од три команди:

ADD document broj_strani - додава документ за печатење, со одреден број на сраници
PRINT broj_strani - команда до принтерот да испечати одреден број на страници
STATUS - приказ на статусот на секоја страница- дали чека за печатење или е веќе испечатена

Излез: Секоја наредба Status повикува приказ на состојбата на документите, како што е дадено на пример излезот

Пример:
Влез:

10
ADD Dogovor 3
STATUS
ADD Spisok 2
STATUS
PRINT 2
STATUS
PRINT 2
STATUS
PRINT 1
STATUS

Излез:

Current status:
Dogovor waiting
Dogovor waiting
Dogovor waiting

Current status:
Dogovor waiting
Dogovor waiting
Dogovor waiting
Spisok waiting
Spisok waiting

Current status:
Dogovor printed
Dogovor printed
Dogovor waiting
Spisok waiting
Spisok waiting

Current status:
Dogovor printed
Dogovor printed
Dogovor printed
Spisok printed
Spisok waiting

Current status:
Dogovor printed
Dogovor printed
Dogovor printed
Spisok printed
Spisok printed*/
public class Juni_2025_Vlezna_2termin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> waiting = new LinkedList<>();
        Queue<String> printed = new LinkedList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");

            switch (parts[0]) {
                case "ADD" -> {
                    for (int j = 0; j < Integer.parseInt(parts[2]); j++) {
                        waiting.add(parts[1]);
                    }
                }

                case "PRINT" -> {
                    for (int j = 0; j < Integer.parseInt(parts[1]) && !waiting.isEmpty(); j++) {
                        printed.add(waiting.poll());
                    }
                }

                case "STATUS" -> {
                    System.out.println("Current status:");

                    for (String p : printed) {
                        System.out.printf("%s printed\n", p);
                    }

                    for (String w : waiting) {
                        System.out.printf("%s waiting\n", w);
                    }

                    System.out.println();
                }
            }
        }
    }
}
