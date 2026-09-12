package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;

import java.io.*;

/*Треба да се организира испитот по еден предмет на ФИНКИ. Поради тоа што
полагањето се состои од теоретски дел (е-тест) и практичен дел (задачи на ком-
пjутер), а не сите студенти ги полагаат и двата дела, асистентите обjавиле анкета
на курсот за да се приjавуваат студентите за тоа што ´ке полагаат. На анкетата
ги имаат следните избори:
1. Полагам само е-тест
2. Полагам само задачи
3. Полагам и е-тест и задачи
Испитот се одржува во лаб. 3 каде што капацитетот на лабораториjата е 20
места. Студентите се примаат да полагаат според следниот редослед: прво се
полни лабораториjата според редоследот по коj се приjавиле студентите кои ´ке
полагаат само е-тест. Ако лабораториjата не се исполни од овие студенти се пуш-
таат студенти кои приjавиле и теориjа и писмено, ама овоj пат да полагаат само
е-тест. Откако овие студенти ´ке завршат со полагање jа напуштаат лабораториjа-
та и само оние кои ги приjавиле двата дела застануваат на краj на редицата коjа
чека за задачи. Потоа се почнува кон спроведување на полагањето на задачите и
тоа во оноj редослед како што се приjавиле студентите на анкетата. Коj ´ке биде
конечниот редослед на полагање на студентите за е-тест, а коj за задачи?
Влез: Во влезот е даден прво броjот на студенти кои се приjавиле само за
е-тест, а потоа се наведуваат студентите според редоследот на приjавување за
е-тест, потоа истото за студентите кои се приjавиле само за задачи, па на краj
студентите кои се приjавиле и за двете.
Излез: На излез треба да се испечатат студентите според редоследот по коj
влегле да полагаат прво за е-тест, потоа за задачи, соодветно по термини (еден
термин има 20 студенти).
Пример:
Влез:
5
РистовскаМоника
РистоваИвана
НиколчевИван
МановскаАдриjана
БуразерМариjан
5
СтоjменовскаЕмилиjа
ПановскиАнгелче
ТраjковскаЕлена
СрбиноскаИвана
БитирноваЛусиjана
5
МилошевскиДамjан
Павлови´кВуксан
ЛушиБеса
РаjчинМартин
ПоповскиАлександар
Излез:
Polagaat e-test:
termin 1
РистовскаМоника
РистоваИвана
НиколчевИван
МановскаАдриjана
БуразерМариjан
МилошевскиДамjан
Павлови´кВуксан
ЛушиБеса
РаjчинМартин
ПоповскиАлександар
Polagaat zadaci:
termin 1
СтоjменовскаЕмилиjа
ПановскиАнгелче
ТраjковскаЕлена
СрбиноскаИвана
БитирноваЛусиjана
МилошевскиДамjан
Павлови´кВуксан
ЛушиБеса
РаjчинМартин
ПоповскиАлександар*/
public class Zadaca6_OrganizacijaNaIspit {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vlez;

        ArrayQueue<String> redEtest = new ArrayQueue<String>(100);
        ArrayQueue<String> redZadaci = new ArrayQueue<String>(100);
        ArrayQueue<String> redEtestZadaci = new ArrayQueue<String>(100);
        int i;
        int brStudentiEtest, brStudentiZadaci, brStudentiEtestZadaci;

        brStudentiEtest = Integer.parseInt(br.readLine());
        for (i = 0; i < brStudentiEtest; i++) {
            vlez = br.readLine();
            redEtest.enqueue(vlez);
        }

        brStudentiZadaci = Integer.parseInt(br.readLine());
        for (i = 0; i < brStudentiZadaci; i++) {
            vlez = br.readLine();
            redZadaci.enqueue(vlez);
        }

        brStudentiEtestZadaci = Integer.parseInt(br.readLine());
        for (i = 0; i < brStudentiEtestZadaci; i++) {
            vlez = br.readLine();
            redEtestZadaci.enqueue(vlez);
        }

        String elem;
        int t = 1;
        System.out.println("Polagaat e-test:");
        while (!redEtest.isEmpty()) {
            System.out.println("termin " + t);
            for (i = 0; i < 20; ) {
                if (!redEtest.isEmpty()) {
                    //elem = redEtest.peek();
                    elem = redEtest.dequeue();
                    i++;
                    System.out.println(elem);
                } else if (!redEtestZadaci.isEmpty()) {
                    elem = redEtestZadaci.dequeue();
                    i++;
                    System.out.println(elem);
                    redZadaci.enqueue(elem);
                } else break;
            }
            t++;
            if (redEtest.isEmpty())
                break;
        }
        if (redEtest.isEmpty()) {
            while (!redEtestZadaci.isEmpty()) {
                System.out.println("termin " + t);
                for (i = 0; i < 20; ) {
                    if (!redEtestZadaci.isEmpty()) {
                        elem = redEtestZadaci.dequeue();
                        i++;
                        System.out.println(elem);
                        redZadaci.enqueue(elem);
                    } else break;
                }
                t++;
            }
        }
        t = 1;
        System.out.println("Polagaat zadaci:");
        if (redEtestZadaci.isEmpty())
            while (!redZadaci.isEmpty()) {
                System.out.println("termin " + t);
                for (i = 0; i < 20; ) {
                    if (!redZadaci.isEmpty()) {
                        elem = redZadaci.dequeue();
                        i++;
                        System.out.println(elem);
                    } else break;
                }
                t++;
            }
    }
}
