package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;

import java.util.Scanner;

/*Пред да започне колоквиумската недела на ФИНКИ се организираат консулта-
ции по предметот Алгоритми и структури на податоци. Бидеj´ки има голем броj
на заинтересирани студенти за консултации се обjавува анкета на курсот за да
се приjават студентите и тоа има два избора на анкетата (може да се изберат и
двата):
1) Имам кратки прашања
2) Ми треба обjаснување за некои задачи
3) И кратки прашања и обjаснување за задачи
Асистентката Магдалена ги држи консултациите. Студентите се примаат на
консултации според следниот редослед: прво се примаат по еден студент од оние
кои имаат кратки прашања според редоследот по коj се приjавиле. Ако нема еден
од овие се пушта студенти кои кои имаат прашања и за задачи за да се исполни
квотата од 1 студент, ама овоj прашува само кратки прашања. Ако се пуштил
студент коj има и прашања за задачи тоj се преместува на краj на редицата за
задачи. Откако ´ке се заврши овоj студент со кратки прашања, се продолжува со
оние кои имаат неjасни задачи. Од овие студенти се прима 1. Ако нема еден од
овие се пушта студент коj има прашања и за задачи за да се исполни квотата
од 1 студент за задачи, ама овоj прашува само за задачи, и потоа се преместува
на краjот на редицата за кратки прашања. Понатаму се продолжува на истиот
начин со тоа што за студентите кои се приjавиле и за задачи и за прашања
влегуваат откако ´ке се испразни редот со само кратки прашања или само со
задачи. Студентите кои се приjавиле и за прашања и задачи, откако ´ке завршат
со прашањата се преместуваат на краj на редицата за задачи, и обратно. Коj ´ке
биде конечниот редослед на влегување?

Влез: Во влезот е даден прво броjот на студенти кои се приjавиле за кратки
прашања, а потоа се наведуваат студентите според редоследот на приjавување
за кратки прашања, потоа истото за студентите кои се приjавиле само за задачи,
па на краj студентите кои се приjавиле и за двете.

Излез: На излез треба да се испечатат студентите според редоследот по коj
влегле на консултации.

Пример:
Влез:
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
2
AnastasMishev
VladimirTrajkovik
1
SlobodanKalajdziski
Излез:
IlinkaIvanoska
AnastasMishev
IgorKulev
VladimirTrajkovik
MagdalenaKostoska
SlobodanKalajdziski
HristinaMihajloska
SlobodanKalajdziski
*/

public class Zadaca8_Konsultacii2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayQueue<String> kratkiPrasanja = new ArrayQueue<>(n);

        for (int i = 0; i < n; i++) {
            kratkiPrasanja.enqueue(sc.next());
        }

        int m = sc.nextInt();
        ArrayQueue<String> zadaci = new ArrayQueue<>(m);

        for (int i = 0; i < m; i++) {
            zadaci.enqueue(sc.next());
        }

        int o = sc.nextInt();

        // Important:
        // these students can later be moved into the other queues
        ArrayQueue<String> prasanjaZadaci = new ArrayQueue<>(o);

        for (int i = 0; i < o; i++) {
            prasanjaZadaci.enqueue(sc.next());
        }

        while (!kratkiPrasanja.isEmpty()
                || !zadaci.isEmpty()
                || !prasanjaZadaci.isEmpty()) {

            // One student for short questions
            if (!kratkiPrasanja.isEmpty()) {

                System.out.println(kratkiPrasanja.dequeue());

            } else if (!prasanjaZadaci.isEmpty()) {

                String student = prasanjaZadaci.dequeue();

                System.out.println(student);

                // Still needs task explanations
                zadaci.enqueue(student);
            }


            // One student for tasks
            if (!zadaci.isEmpty()) {

                System.out.println(zadaci.dequeue());

            } else if (!prasanjaZadaci.isEmpty()) {

                String student = prasanjaZadaci.dequeue();

                System.out.println(student);

                // Still needs short questions
                kratkiPrasanja.enqueue(student);
            }
        }
    }
}
