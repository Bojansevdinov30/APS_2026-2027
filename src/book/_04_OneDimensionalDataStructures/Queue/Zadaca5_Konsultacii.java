package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;

import java.io.*;

/*Каj асистентот Игор се одржуваат консултации по два предмети АСП и ММС
во еден термин. Бидеj´ки по АПС колоквиумот е следниот ден, Игор им рекол на
студентите кои што чекаат дека прво ´ке ги услужи студентите по АПС, а после
студентите по ММС. Студентите се подготвиле со прашања и прашањата за АПС
можат да бидат од тип А, B, C или D. Асистентот им напоменал на студентите
по АПС, ако доjде некоj студент и праша прашање од тип X (X e A,B,C или
D) и веднаш после него доjде студент со прашање од тип X (т.е. со прашање
од ист тип), вториот студент ´ке биде ставен на краjот од редот и истовремено
´ке биде пуштен еден студент од другата редица за ММС (ако таа редица не е
празна). Генерално, ако последното одговорено прашање по АПС е од тип X, и
доjде студент со прашање од тип X, тоj се преместува на краjот од редот и се
пушта еден студент од другата редица за ММС (ако таа редица не е празна). Коj
´ке биде конечниот распоред за влегување?
Влез: Во влезот е даден прво броjот на студенти кои се приjавиле за консул-
тации АПС, а потоа се наведуваат студентите според редоследот на приjавување
и се дава за коj тип прашање се приjавиле (A, B, C или D). Следно се дава бро-
jот на студенти кои се приjавиле за консултации ММС, а потоа се наведуваат
студентите според редоследот на приjавување.
Излез: На излез треба да се испечатат студентите според редоследот по коj
влегле на консултации.
Пример:
Влез:
3
IlinkaIvanoska A
MagdalenaKostoska A
HristinaMihajloska B
1
IgorKulev
Излез:
IlinkaIvanoska
IgorKulev
HristinaMihajloska
MagdalenaKostoska*/
public class Zadaca5_Konsultacii {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vlez;
        ArrayQueue<String> redAPS = new ArrayQueue<String>(100);
        ArrayQueue<String> redTip = new ArrayQueue<String>(100);
        ArrayQueue<String> redMMS = new ArrayQueue<String>(100);

        int i;
        int brStudentiAPS, brStudentiMMS;

        brStudentiAPS = Integer.parseInt(br.readLine());
        for (i = 0; i < brStudentiAPS; i++) {
            vlez = br.readLine();
            String[] pom = vlez.split(" ");
            redAPS.enqueue(pom[0]);
            redTip.enqueue(pom[1]);
        }

        brStudentiMMS = Integer.parseInt(br.readLine());
        for (i = 0; i < brStudentiMMS; i++) {
            vlez = br.readLine();
            redMMS.enqueue(vlez);
        }

        String pom, pomTip, tip = "";
        if (!redAPS.isEmpty()) {
            pom = redAPS.dequeue();
            System.out.println(pom);
            tip = redTip.dequeue();
            i++;
        }
        while (!redAPS.isEmpty()) {
            pom = redAPS.dequeue();
            pomTip = redTip.dequeue();
            if (tip.equals(pomTip)) {
                redAPS.enqueue(pom);
                redTip.enqueue(pomTip);
                if (!redMMS.isEmpty()) {
                    pom = redMMS.dequeue();
                    System.out.println(pom);
                }
            } else {
                System.out.println(pom);
                tip = pomTip;
            }

        }
        while (!redMMS.isEmpty()) {
            pom = redMMS.dequeue();
            System.out.println(pom);
        }
    }
}
